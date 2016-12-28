<%@ page import="com.mitza.toolkit.domain.ComponentMeta" %>
<%@ page import="com.mitza.toolkit.dynamic.LinkFactory" %>
<%@ page import="com.mitza.toolkit.query.Criterion" %>
<%@ page import="com.mitza.toolkit.query.CustomMetaCriterion" %>
<%@ page import="com.mitza.toolkit.query.Query" %>
<%@ page import="com.mitza.toolkit.query.SortColumn" %>
<%@ page import="com.mitza.toolkit.query.SortDirection" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: mihai
  Date: 23.02.2016
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    long queryDuration = System.currentTimeMillis();
    String p = request.getParameter("pageNumber");
    int pageNumber = p == null ? 1 : Math.max(1, Integer.valueOf(p));
    int pageSize = 10;

    Criterion criterion = new CustomMetaCriterion("String", "LOLEK2");
    Query query = new Query(criterion);
    query.addSort(SortColumn.TITLE, SortDirection.ASCENDING);
    query.setPage(pageNumber);
    query.setPageSize(pageSize);
    List<ComponentMeta> componentMetas = query.executeComponentQuery();
    int totalItems = query.getTotalItemCount();
    int numberOfPages = Math.round((float) totalItems / pageSize);
    int indexStart = (pageNumber - 1) * pageSize + 1;
    int indexEnd = indexStart + componentMetas.size() - 1;
    queryDuration = System.currentTimeMillis() - queryDuration;
%>
<html>
<head>
    <title>Index</title>
</head>
<body>

<div>Now is: <%= new Date() %>
</div>

<br/>

<fieldset>
    <legend>Dynamic Query
        <%= (pageNumber == 1 ? "&lt;&lt;" : "<a href=\"?pageNumber=" + (pageNumber - 1) + "\">&lt;&lt;</a>")%>&nbsp;&nbsp;
        <%= (pageNumber == numberOfPages ? "&gt;&gt;" : "<a href=\"?pageNumber=" + (pageNumber + 1) + "\">&gt;&gt;</a>") %>
        &nbsp;|&nbsp; Page <%= pageNumber %> of <%= numberOfPages %> &nbsp;|&nbsp;
        Items <%=indexStart%>-<%=indexEnd%> of <%= query.getTotalItemCount()%>&nbsp;
    </legend>

    <% if (componentMetas.size() == 0) {
        out.println("No results");
    } else {
        out.println("<ul>");
        for (ComponentMeta componentMeta : componentMetas) {
            out.println("<li>" + componentMeta.getTitle() + " (" + componentMeta.getTcmUri() + ")</li>");
        }
        out.println("</ul>");
    }%>
    <%=String.format("%.2fs", queryDuration / 1000.0)%>
</fieldset>

<br/>

<fieldset>
    <legend>Component Link</legend>
    Link to tcm:6-52: <%= LinkFactory.INSTANCE.getComponentLink(6, 52) %>
</fieldset>

</body>
</html>
