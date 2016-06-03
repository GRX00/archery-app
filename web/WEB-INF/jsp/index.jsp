<%@ page import="pl.grx.archapp.Mat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Welcome</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    Integer matsNr = (Integer) request.getAttribute("matsNr");

    for (int i = 1; i <= matsNr; i++) {
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
