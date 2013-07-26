using System;
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
	/// See: http://yatb.mitza.net/2013/07/structure-group-navigation-getitems.html
	/// </summary>
	[TcmTemplateTitle("Generate Structure Group Navigation GetItems TBB")]
	public class GenerateStructureGroupNavigationGetItems : TemplateBase {

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

			XmlElement navigationXml = BuildNavigationGetItems(rootSG);

			//record build navigation time
			string message = string.Format("Execution took {0:0.##}s", DateTime.Now.Subtract(t).TotalSeconds);
			navigationXml.AppendChild(navigationXml.OwnerDocument.CreateComment(message));

			package.PushItem("Output", package.CreateXmlDocumentItem(ContentType.Xml, navigationXml.OwnerDocument));
		}

		/// <summary>
		/// Build navigation XML using rootSG.GetItems(). This gets the real TOM objects for all SGs and Pages under RootSG.
		/// SGs and Pages that are not active navigation items are discarded. The rest are placed in an XML as tcm:Item nodes
		/// and the hierarchical structure is created based on item.OrganizationalItem information.
		/// 
		/// Execution time: 45 seconds for 221 SGs and 2173 Pages
		/// </summary>
		/// <param name="structureGroup">Structure Group to generate navigation for</param>
		/// <returns>Navigation XML root element</returns>
		private XmlElement BuildNavigationGetItems(StructureGroup structureGroup) {
			XmlDocument dom = new XmlDocument();
			dom.AppendChild(dom.CreateXmlDeclaration("1.0", "UTF-8", null));
			namespaceManager = new XmlNamespaceManager(dom.NameTable);
			namespaceManager.AddNamespace("tcm", TCM_NAMESPACE_URI);

			XmlElement navigationXml = dom.CreateElement("tcm:ListItems", TCM_NAMESPACE_URI);
			EnhanceNode(navigationXml, (RepositoryLocalObject)structureGroup);
			dom.AppendChild(navigationXml);

			foreach (RepositoryLocalObject item in structureGroup.GetItems(filter)) {
				if (IsNavigable(item.Title)) {
					XmlElement itemElement = dom.CreateElement("tcm:Item", TCM_NAMESPACE_URI);
					EnhanceNode(itemElement, item);

					// enhance item node
					TcmUri itemId = item.Id;
					ItemType itemType = itemId.ItemType;
					if (itemType == ItemType.StructureGroup) {
						EnhanceNode(itemElement, (StructureGroup)item);
					} else if (itemType == ItemType.Page) {
						EnhanceNode(itemElement, (Page)item);
					}

					// build hierarchy
					TcmUri parentId = item.OrganizationalItem.Id;
					XmlNode parent = dom.SelectSingleNode(String.Format("//tcm:Item[@{0}='{1}']", ATTRIBUTE_ID, parentId), namespaceManager);
					if (parent == null) {
						if (parentId != structureGroup.Id) {
							itemElement.SetAttribute(ATTRIBUTE_PARENT, parentId);
						}
						navigationXml.AppendChild(itemElement);
					} else {
						parent.AppendChild(itemElement);
					}
				}
			}

			// fix orphan items
			foreach (XmlNode item in dom.SelectNodes(string.Format("/tcm:ListItems/tcm:Item[@{0}]", ATTRIBUTE_PARENT), namespaceManager)) {
				string parentId = item.Attributes[ATTRIBUTE_PARENT].Value;
				item.Attributes.RemoveNamedItem(ATTRIBUTE_PARENT);
				XmlNode parent = dom.SelectSingleNode(String.Format("//tcm:Item[@{0}='{1}']", ATTRIBUTE_ID, parentId), namespaceManager);
				parent.AppendChild(item);
			}

			return navigationXml;
		}

		/// <summary>
		/// Enhance the XmlElement corresponding to a SG or Page with information such as ID and Title.
		/// </summary>
		/// <param name="item">XmlElement to be enhanced</param>
		/// <param name="rlo">RepositoryLocalObject representing either SG or Page to enhance from</param>
		private void EnhanceNode(XmlElement item, RepositoryLocalObject rlo) {
			item.SetAttribute(ATTRIBUTE_ID, rlo.Id);
			item.SetAttribute(ATTRIBUTE_TITLE, rlo.Title);
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
