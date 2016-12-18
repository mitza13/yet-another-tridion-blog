<%@ page import="com.mitza.toolkit.dynamic.LinkFactory" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: mihai
  Date: 23.02.2016
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

Now is: <%= new Date() %><br/>
<br/>
Component link tcm:6-52: <%= LinkFactory.INSTANCE.getComponentLink(6, 52) %>

</body>
</html>
