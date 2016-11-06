<%@ Application Language="C#" %>
<%@ Import Namespace="Com.MihaiConsulting.Cache" %>
<%@ Import Namespace="MyCacheInvalidator.Example" %>
<%@ Import Namespace="Tridion.ContentDelivery.Meta" %>

<script RunAt="server">

    void Application_Start(object sender, EventArgs e)
    {
    }

    void Session_Start(object sender, EventArgs e)
    {
        //Initialize JuggerNET
        //new PageMetaFactory(0);

        //Set MyCacheInvalidator as invalidator
        CacheNotifier.Instance.Invalidator = new MyCacheInvalidator();
    }

</script>
