using System;
using System.Web;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using Tridion.ContentManager;
using Tridion.ContentManager.CommunicationManagement;
using Tridion.ContentManager.ContentManagement;
using Tridion.ContentManager.ContentManagement.Fields;
using Tridion.ContentManager.Templating;
using Tridion.ContentManager.Templating.Assembly;
using Tridion.ContentManager.Publishing.Rendering;
using System.Configuration;
using Tridion.ContentManager.Publishing;
using CP = Tridion.ContentManager.Templating.ComponentPresentation;
using ComponentPresentation = Tridion.ContentManager.CommunicationManagement.ComponentPresentation;

namespace YATB.Templates.Util {

	public class Utilities {

		private const string ATTR_REG_EXP = "{0}=\"([^\"]*)\"";
		TemplatingLogger log = TemplatingLogger.GetLogger(typeof(Utilities));

		public String constructRegionTag(IList<CP> regionList, String regionName, Engine engine) {
			// Temptag for the Regions
			String region = "<div><!-- Start Region: { title: \\\"{0}\\\", allowedComponentTypes: [ {1} ], minOccurs: 0  } -->";
			String componentType = "{ schema: \\\"{0}\\\", template: \\\"{1}\\\" }";
			int counter = 0;
			String tempType = "";
			String tempTypes = "";
			foreach (CP cp in regionList) {
				Component c = engine.GetObject(cp.ComponentUri) as Component;
				Schema schema = c.Schema;
				tempType = componentType.Replace("{0}", schema.Id).Replace("{1}", cp.TemplateUri);

				if (counter > 0) {
					tempTypes += "," + tempType;
				} else {
					tempTypes += tempType;
				}
				counter++;
			}
			return region.Replace("{0}", regionName).Replace("{1}", tempTypes);

		}

		public string GetMultimediaComponentUrl(Component component, string ROOT_WEBDAV_URL, string Start_SG_Images, Publication pub, Engine engine) {
			string sgLocation = "";
			if (component.ComponentType.Equals(ComponentType.Multimedia)) {
				sgLocation = getStructureGroupLocation(component.WebDavUrl, ROOT_WEBDAV_URL);
				StructureGroup publishSG = GetSG(sgLocation, Start_SG_Images, pub, engine);
				if (publishSG != null) {
					if (!sgLocation.StartsWith("/")) {
						sgLocation = "/images/" + sgLocation;
					} else {
						sgLocation = "/images" + sgLocation;
					}
					sgLocation = sgLocation.Replace(" ", "");
					sgLocation = sgLocation + "/" + component.BinaryContent.Filename; // Add Filename of SG
				}
			}
			return sgLocation;
		}

		private StructureGroup GetSG(string sgWebDav, string Start_SG_Images, Publication pub, Engine engine) {
			String rootSGwebdav = pub.RootStructureGroup.WebDavUrl + "/" + Start_SG_Images + "/" + sgWebDav;
			StructureGroup result = engine.GetObject(rootSGwebdav) as StructureGroup;

			if (result == null) // SG not found, creating it
			{
				FindOrCreateSG(engine, rootSGwebdav);
				result = engine.GetObject(rootSGwebdav) as StructureGroup;
			} else {
				log.Debug(string.Format("SG '{0}' exists", rootSGwebdav));
			}
			return result;
		}

		private StructureGroup FindOrCreateSG(Engine engine, string sgWebDav) {
			log.Debug(string.Format("Find or Create SG '{0}'", sgWebDav));

			StructureGroup sg = engine.GetObject(sgWebDav) as StructureGroup;
			if (sg == null) {
				int lastSlash = sgWebDav.LastIndexOf("/");
				string parentSGWebDav = sgWebDav.Substring(0, lastSlash);
				StructureGroup parentSG = FindOrCreateSG(engine, parentSGWebDav);
				Session newSession = new Session(engine.GetSession().User.Title);
				sg = new StructureGroup(newSession, parentSG.Id);

				string title = sgWebDav.Substring(lastSlash + 1);
				sg.Title = MakeSafeSGTitle(title);
				sg.Directory = MakeSafeDirectory(title);
				sg.Save();
				newSession.Dispose();

				log.Debug(string.Format("Created SG '{0}'", sgWebDav));
			} else {
				log.Debug(string.Format("Found SG '{0}'", sgWebDav));
			}

			return sg;
		}


		/// <summary>
		/// Makes the given string parameter a safe Structure Group title.
		/// It URL decodes the name.
		/// </summary>
		/// <param name="name">string representing the SG title to make safe</param>
		/// <returns>string representing the safe SG title</returns>
		private string MakeSafeSGTitle(string name) {
			name = HttpUtility.UrlDecode(name);

			return name;
		}

		/// <summary>
		/// Makes the given string parameter a safe directory name.
		/// It removes spaces and other characters from the name.
		/// </summary>
		/// <param name="name">string representing the directory name to make safe</param>
		/// <returns>string representing the safe directory name</returns>
		private string MakeSafeDirectory(string name) {
			name = HttpUtility.UrlDecode(name);
			name = name.Replace(" ", "");

			return name;
		}

		public Binary PublishBinary(Component mComponent, Session session, Package package, Engine engine, TemplatingLogger logger,
			string strFileName) {
			string rootFolderId = package.GetValue("RootFolder");
			string rootSGId = package.GetValue("RootStructureGroup");

			logger.Debug(string.Format("Using root Structure Group with Webdav Url: {0}", rootFolderId));

			Folder rootFolder = session.GetObject(rootFolderId) as Folder;
			StructureGroup parentSG = session.GetObject(rootSGId) as StructureGroup;

			Stack<string> sgNames = new Stack<string>();
			GetStructureGroupToBeCreated(mComponent.OrganizationalItem, rootFolder.Id, sgNames);

			OrganizationalItemItemsFilter sgFilter = new OrganizationalItemItemsFilter(session);
			sgFilter.Recursive = false;
			sgFilter.ItemTypes = new Tridion.ContentManager.ItemType[] { Tridion.ContentManager.ItemType.StructureGroup };

			//string strCoreServicesUrl = package.GetValue("CoreServicesUrl");

			while (sgNames.Count > 0) {
				string sgName = sgNames.Pop();
				IEnumerable<StructureGroup> list = parentSG.GetItems(sgFilter).
					Where(w => w.Title.Equals(sgName)).Select(s => (StructureGroup)s);

				if (list.Count() == 0) {
					/*
					 * TO DO: Enable tha auto creation of the Structure Group
					StructureGroupData newSG = SaveStructureGroup(sgName, parentSG.Id.ToString(), session.User.Title, strCoreServicesUrl);
					parentSG = new StructureGroup(new TcmUri(newSG.Id), session);
					 
					logger.Debug(string.Format("New Structure Group needs {0} created at: {1}", newSG.Title, parentSG.Path));
					 * */
					logger.Info(string.Format("Utilities.PublishBinary New Structure Group needs {0} created at: {1}", parentSG.Title, parentSG.Path));
				} else {
					StructureGroup existingSG = list.First<StructureGroup>();
					logger.Info(string.Format("Utilities.PublishBinary Existing Structure Group {0} found at: {1}", existingSG.Title, existingSG.Path));
					parentSG = existingSG;
				}
			}

			Binary binary = null;
			if (strFileName == null) {
				binary = engine.PublishingContext.RenderedItem.AddBinary(mComponent, parentSG, mComponent.BinaryContent.Filename);
			} else {
				MemoryStream msStream = new MemoryStream();
				mComponent.BinaryContent.WriteToStream(msStream);
				msStream.Seek(0, SeekOrigin.Begin);

				binary = engine.PublishingContext.RenderedItem.AddBinary(msStream, strFileName, parentSG, strFileName.Replace(" ", string.Empty), "text/xml");
			}

			logger.Debug(string.Format("Binary {0} being published to {1}", mComponent.BinaryContent.Filename, parentSG.PublishLocationUrl));
			return binary;
		}
		private void GetStructureGroupToBeCreated(OrganizationalItem folder, TcmUri rootFolderId, Stack<string> sgNames) {
			if (folder != null && folder.Id != rootFolderId) {
				sgNames.Push(folder.Title);
				GetStructureGroupToBeCreated(folder.OrganizationalItem, rootFolderId, sgNames);
			}
		}

		private string getStructureGroupLocation(string webdav, string ROOT_WEBDAV_URL) {
			String sgLocation = String.Empty;
			int startSG = 0;
			int lastSlash = 0;
			try {
				startSG = webdav.IndexOf(ROOT_WEBDAV_URL) + ROOT_WEBDAV_URL.Length + 1;
				sgLocation = "/" + webdav.Substring(startSG).Replace("%20", " ");
				sgLocation = sgLocation.Substring(1);
				lastSlash = sgLocation.LastIndexOf("/");
			} catch (Exception ex) {
				log.Error("Error performing Get Structure Group Location. Full message: " + ex.Message + " \nStack Trace: " + ex.StackTrace);
			}

			return sgLocation.Remove(lastSlash);
		}


	}
}