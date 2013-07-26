using System.Collections.Generic;
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
	/// </summary>
	[TcmTemplateTitle("Generate Structure Group Navigation Recursive TBB")]
	public class GenerateStructureGroupNavigationRecursive : TemplateBase {

		private const string ATTRIBUTE_ID = "ID";
		private const string ATTRIBUTE_URL = "Url";
		private const string ATTRIBUTE_DISPLAY_TITLE = "DisplayTitle";
		private readonly Regex navigationItemRegex = new Regex("^\\d{3}[_ ]"); // starts with 3 digits followed by underscore or space

		private OrganizationalItemItemsFilter filter;

		/// <summary>
		/// Overrides the TemplateBase method Transform. Implements actual logic -- identifies Root Structure Group 
		/// of current Publication and kicks off recursive building of navigation XML.
		/// The generated XmlDocument is added to the Package as element "Output".
		/// </summary>
		/// <param name="engine">Engine for current transformation</param>
		/// <param name="package">The current Package object</param>
		public override void Transform(Engine engine, Package package) {
			Initialize(engine, package);

			Publication publication = GetPublication();
			StructureGroup rootSG = publication.RootStructureGroup;

			filter = new OrganizationalItemItemsFilter(rootSG.Session) {
				BaseColumns = ListBaseColumns.IdAndTitle,
				ItemTypes = new ItemType[] { ItemType.Page, ItemType.StructureGroup }
			};

			XmlElement navigationXml = BuildNavigation(rootSG);
			package.PushItem("Output", package.CreateXmlDocumentItem(ContentType.Xml, navigationXml.OwnerDocument));
		}

		/// <summary>
		/// Builds the XmlElement containing the navigation XML for the Pages and Structure Groups directly under the given Structure Group.
		/// For sub Structure Groups, the method calls itself recursively to generate the nested level navigation XML.
		/// On exiting the recursion, the identified XmlElement nodes are added to the parent node as children.
		/// Only active navigation items are considered (i.e. items whose title conform to a regular expression).
		/// SG and Page nodes are enhanced with additional information such as URL, Display Title, etc.
		/// 
		/// Execution time: 43 seconds for 221 SGs and 2173 Pages
		/// </summary>
		/// <param name="structureGroup">Structure Group to generate navigation for</param>
		/// <returns>Navigation XmlElement for the given SG</returns>
		private XmlElement BuildNavigation(StructureGroup structureGroup) {
			List<XmlNode> toRemove = new List<XmlNode>();
			XmlElement navigationXml = structureGroup.GetListItems(filter);

			foreach (XmlElement item in navigationXml.ChildNodes) {
				string itemTitle = item.Attributes["Title"].Value;
				if (IsNavigable(itemTitle)) {
					// enhance node
					TcmUri itemId = new TcmUri(item.Attributes[ATTRIBUTE_ID].Value);
					ItemType itemType = itemId.ItemType;
					if (itemType == ItemType.StructureGroup) {
						StructureGroup childSG = m_Engine.GetObject(itemId) as StructureGroup;
						EnhanceNode(item, childSG);

						// recursive step
						XmlElement childNavigation = BuildNavigation(childSG);
						foreach (XmlElement childItem in childNavigation.ChildNodes) {
							XmlNode importedNode = item.OwnerDocument.ImportNode(childItem, true);
							item.AppendChild(importedNode);
						}
					} else if (itemType == ItemType.Page) {
						Page childPage = m_Engine.GetObject(itemId) as Page;
						EnhanceNode(item, childPage);
					}
				} else {
					toRemove.Add(item);
				}
			}

			// remove non-navigation items
			foreach (XmlNode node in toRemove) {
				navigationXml.RemoveChild(node);
			}

			return navigationXml;
		}

		/// <summary>
		/// Enhance the XmlElement corresponding to a Page with information such as DisplayTitle, URL, etc.
		/// </summary>
		/// <param name="item">XmlElement to be enhanced</param>
		/// <param name="page">Page object to enhance from</param>
		private void EnhanceNode(XmlElement item, Page page) {
			string displayTitle = navigationItemRegex.Replace(page.Title, string.Empty);
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
			string displayTitle = navigationItemRegex.Replace(structureGroup.Title, string.Empty);
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
