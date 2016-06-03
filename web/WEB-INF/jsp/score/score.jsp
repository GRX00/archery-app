<%@ page import="pl.grx.archapp.score.ScoreTable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>ArcheryApp - Score Table</title>
    <link href="css/score.css" rel="stylesheet" type="text/css">
</head>

<body>

<%
    ScoreTable scoreTable;
%>
<table class="container">
    <tr>
        <td class="container">
            <% scoreTable = (ScoreTable) request.getAttribute("scoreTable"); %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
        <td class="container">
            <% scoreTable = (ScoreTable) request.getAttribute("scoreTable"); %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
    </tr>
    <tr>
        <td class="container">
            <% scoreTable = (ScoreTable) request.getAttribute("scoreTable"); %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
        <td class="container">
            <% scoreTable = (ScoreTable) request.getAttribute("scoreTable"); %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
    </tr>
</table>
</body>
</html>