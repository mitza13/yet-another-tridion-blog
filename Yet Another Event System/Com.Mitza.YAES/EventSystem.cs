using System;
using System.IO;
using Tridion.ContentManager.CommunicationManagement;
using Tridion.ContentManager.ContentManagement;
using Tridion.ContentManager.Extensibility;
using Tridion.ContentManager.Extensibility.Events;

namespace Com.Mitza.YAES {

    [TcmExtension("Yet Another Event System")]
    public class EventSystem : TcmExtension {

        private ConfigurationManager configManager;

        public EventSystem() {
            File.AppendAllText("C:\\Temp\\EventSystem.log", "Executed " + DateTime.Now);
            EventSystem.Subscribe<Component, CheckInEventArgs>(OnComponentCheckIn, EventPhases.Initiated);
            //if (configManager.IsEventEnabled("OnTBBCheckIn")) {
            EventSystem.Subscribe<TemplateBuildingBlock, CheckInEventArgs>(OnTBBSavePre, EventPhases.TransactionCommitted);
            //}
        }

        private void OnComponentCheckIn(Component component, CheckInEventArgs args, EventPhases phase) {
            configManager = ConfigurationManager.GetInstance(component);
        }

        private void OnTBBSavePre(TemplateBuildingBlock tbb, CheckInEventArgs args, EventPhases phase) {
            configManager = ConfigurationManager.GetInstance(tbb);
        }
    }
}
