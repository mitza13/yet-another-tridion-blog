<%@ Application Language="C#" %>
<%@ Import Namespace="Com.MihaiConsulting.Cache" %>
<%@ Import Namespace="MyCacheInvalidator.Example" %>
<%@ Import Namespace="Tridion.ContentDelivery.Meta" %>

<script RunAt="server">

    void Session_Start(object sender, EventArgs e)
    {
        //Set MyCacheInvalidator as invalidator
        CacheNotifier.Instance.Invalidator = new MyCacheInvalidator();
    }

</script>
