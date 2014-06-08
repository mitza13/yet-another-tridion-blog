using Com.Mitza.YAES;
using System.Collections.Generic;
using Tridion.ContentManager.CommunicationManagement;
using Tridion.ContentManager.ContentManagement;
using Tridion.ContentManager.Extensibility;
using Tridion.ContentManager.Extensibility.Events;

namespace Com.MihaiConsulting
{
    [TcmExtension("Yet Another Event System")]
    public class EventSystem : TcmExtension
    {
        private ConfigurationManager configManager;

        public EventSystem()
        {
            EventSystem.Subscribe<Component, CheckInEventArgs>(OnComponentCheckIn, EventPhases.Initiated);
            EventSystem.Subscribe<TemplateBuildingBlock, CheckInEventArgs>(OnTBBSavePre, EventPhases.TransactionCommitted);
        }

        private void OnComponentCheckIn(Component component, CheckInEventArgs args, EventPhases phase)
        {
            configManager = ConfigurationManager.GetInstance(component);

            string value = configManager["Publication"];

            Dictionary<string, string> configs = configManager.Configurations;
            string value2 = configs["Publication"];
        }

        private void OnTBBSavePre(TemplateBuildingBlock tbb, CheckInEventArgs args, EventPhases phase)
        {
            configManager = ConfigurationManager.GetInstance(tbb);
        }
    }
}
