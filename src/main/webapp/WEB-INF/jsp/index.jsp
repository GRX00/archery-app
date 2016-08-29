<%@ page import="pl.grx.archapp.Index" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Welcome</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    Index index = (Index) request.getServletContext().getAttribute("index");

    for (int i = 1; i <= index.getMatsCount(); i++) {
%>
<form action="score" method="GET">
    <div class="alignCenter">
        <input type="hidden" name="m" value="<%=i%>"/>
        <button type="submit">Metryczki - Mata <%=i%></button>
    </div>
</form>

<%}%>

</body>
</html>
