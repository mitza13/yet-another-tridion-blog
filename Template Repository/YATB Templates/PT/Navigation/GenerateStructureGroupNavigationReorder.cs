using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Xml;
using Tridion.ContentManager;
using Tridion.ContentManager.CommunicationManagement;
using Tridion.ContentManager.ContentManagement;
using Tridion.ContentManager.Templating;
using Tridion.ContentManager.Templating.Assembly;
using YATB.Templates.Util;

namespace YATB.Templates.PT.TBB {

	/// <summary>
	/// Generates an XML containing all Structure Groups and Pages whose title abides to a naming convention,
	/// in hierarchical structure. The naming convention is given by regular expression (e.g. title starts with 
	/// 3 digits followed by underscore or space).
	/// 
	/// See: http://yatb.mitza.net/2013/07/structure-group-navigation-reorder.html
	/// </summary>
	[TcmTemplateTitle("Generate Structure Group Navigation Reorder TBB")]
	public class GenerateStructureGroupNavigationReorder : TemplateBase {

		private const string TCM_NAMESPACE_URI = "http://www.tridion.com/ContentManager/5.0";
		private const string ATTRIBUTE_DISPLAY_TITLE = "DisplayTitle";
		private const string ATTRIBUTE_ID = "ID";
		private const string ATTRIBUTE_PARENT = "Parent";
		private const string ATTRIBUTE_TITLE = "Title";
		private const string ATTRIBUTE_URL = "Url";
		private readonly Regex navigationItemRegex = new Regex("^\\d{3}[_ ]"); // starts with 3 digits followed by underscore or space

		private OrganizationalItemItemsFilter filter;
		private XmlNamespaceManager namespaceManager;

		/// <summary>
		/// Overrides the TemplateBase method Transform. Implements actual logic -- identifies Root Structure Group 
		/// of current Publication and kicks off recursive building of navigation XML.
		/// The generated XmlDocument is added to the Package as element "Output".
		/// </summary>
		/// <param name="engine"></param>
		/// <param name="package"></param>
		public override void Transform(Engine engine, Package package) {
			DateTime t = DateTime.Now;
			Initialize(engine, package);

			Publication publication = GetPublication();
			StructureGroup rootSG = publication.RootStructureGroup;

			filter = new OrganizationalItemItemsFilter(rootSG.Session) {
				BaseColumns = ListBaseColumns.IdAndTitle,
				ItemTypes = new ItemType[] { ItemType.Page, ItemType.StructureGroup },
				Recursive = true
			};

			XmlElement navigationXml = BuildNavigationReorder(rootSG);

			//record build navigation time
			string message = string.Format("Execution took {0:0.##}s", DateTime.Now.Subtract(t).TotalSeconds);
			navigationXml.AppendChild(navigationXml.OwnerDocument.CreateComment(message));

			package.PushItem("Output", package.CreateXmlDocumentItem(ContentType.Xml, navigationXml.OwnerDocument));
		}

		/// <summary>
		/// Build navigaton XML using rootSG.GetListItems() recursively to retrieve an XML list of nodes for all SGs and Pages.
		/// The flat list is iterated and each node is appended to its parent based on .OrganizationalItem information.
		/// Nodes that are not active navigation items are removed from XML.
		/// 
		/// Execution time: 45 seconds for 221 SGs and 2173 Pages
		/// </summary>
		/// <param name="structureGroup">Structure Group to generate navigation for</param>
		/// <returns>Navigation XML root element</returns>
		private XmlElement BuildNavigationReorder(StructureGroup structureGroup) {
			XmlElement navigationXml = structureGroup.GetListItems(filter);
			List<XmlElement> itemList = new List<XmlElement>(navigationXml.ChildNodes.Cast<XmlElement>());
			namespaceManager = new XmlNamespaceManager(navigationXml.OwnerDocument.NameTable);
			namespaceManager.AddNamespace("tcm", TCM_NAMESPACE_URI);

			foreach (XmlElement item in itemList) {
				string itemTitle = item.Attributes[ATTRIBUTE_TITLE].Value;
				if (IsNavigable(itemTitle)) {
					TcmUri itemId = new TcmUri(item.Attributes[ATTRIBUTE_ID].Value);
					ItemType itemType = itemId.ItemType;
					TcmUri parentId = null;

					// enhance item node
					if (itemType == ItemType.StructureGroup) {
						StructureGroup childSG = m_Engine.GetObject(itemId) as StructureGroup;
						parentId = childSG.OrganizationalItem.Id;
						EnhanceNode(item, childSG);
					} else if (itemType == ItemType.Page) {
						Page childPage = m_Engine.GetObject(itemId) as Page;
						parentId = childPage.OrganizationalItem.Id;
						EnhanceNode(item, childPage);
					}

					// reorder - apply hierarchy
					XmlNode parent = navigationXml.SelectSingleNode(String.Format("//tcm:Item[@ID='{0}']", parentId), namespaceManager);
					if (parent == null) {
						if (parentId != structureGroup.Id) {
							navigationXml.RemoveChild(item);
						}
					} else {
						parent.AppendChild(item);
					}
				} else {
					navigationXml.RemoveChild(item);
				}
			}

			return navigationXml;
		}

		/// <summary>
		/// Enhance the XmlElement corresponding to a Page with information such as DisplayTitle, URL, etc.
		/// </summary>
		/// <param name="item">XmlElement to be enhanced</param>
		/// <param name="page">Page object to enhance from</param>
		private void EnhanceNode(XmlElement item, Page page) {
			string displayTitle = navigationItemRegex.Replace(page.Title, "");
			item.SetAttribute(ATTRIBUTE_DISPLAY_TITLE, displayTitle);

			string url = page.PublishLocationUrl;
			item.SetAttribute(ATTRIBUTE_URL, url);
		}

		/// <summary>
		/// Enhance the XmlElement corresponding to a Structure Group with information such as DisplayTitle, URL, etc.
		/// </summary>
		/// <param name="item">XmlElement to be enhanced</param>
		/// <param name="structureGroup">StructureGroup to enhance from</param>
		private void EnhanceNode(XmlElement item, StructureGroup structureGroup) {
			string displayTitle = navigationItemRegex.Replace(structureGroup.Title, "");
			item.SetAttribute(ATTRIBUTE_DISPLAY_TITLE, displayTitle);

			string url = structureGroup.PublishLocationUrl;
			item.SetAttribute(ATTRIBUTE_URL, url);
		}

		/// <summary>
		/// Returns boolean true if the given 'title' represents an active navigation item (i.e. matches the active item Regular Expression)
		/// </summary>
		/// <param name="title">Item title to check if active navigation item</param>
		/// <returns>Boolean true, if active navigation item</returns>
		private bool IsNavigable(string title) {
			return navigationItemRegex.IsMatch(title);
		}
	}
}
