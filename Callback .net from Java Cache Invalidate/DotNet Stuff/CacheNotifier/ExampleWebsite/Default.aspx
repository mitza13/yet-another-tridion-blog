<%@ Page Language="C#" %>

<%@ Import Namespace="Tridion.ContentDelivery.Meta" %>
<%
    string color = "white";
    PageMetaFactory factory = new PageMetaFactory(10);
    IPageMeta meta = factory.GetMeta(1660);
    if (meta != null)
    {
        color = meta.CustomMeta.GetFirstValue("color") as string ?? "white";
    }
%>

<html>
<head>
    <title>Home Page</title>
    <style>
        p {
            background-color: <%=color%>;
            border: 1px solid black;
            font-family: sans-serif;
            margin: 5px;
            padding: 10px;
            width: 33%;
        }
    </style>
</head>
<body>
    <%
        if (meta == null)
        {
    %>
    <p style="background-color: red; color: white;">
        <b>No page found</b>
    </p>
    <% }
        else
        { %>
    <p>
        Name: <b><%=meta.Title %></b>
    </p>
    <p>
        Url: <b><%=meta.UrlPath %></b>
    </p>
    <p>
        Publish: <b><%=meta.LastPublicationDate %></b>
    </p>
    <% } %>
</body>
</html>
