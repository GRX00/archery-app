<%@ page import="pl.grx.archapp.CompetitionSingleton" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Welcome</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    CompetitionSingleton competition = (CompetitionSingleton) request.getAttribute("competition");

    for (int i = 1; i <= competition.getMats(); i++) {
%>
<form action="scoreTable" method="GET">
    <div class="alignCenter">
        <input type="hidden" name="m" value="<%=i%>"/>
        <button type="submit">Metryczki - Mata <%=i%></button>
    </div>
</form>

<%}%>

</body>
</html>
