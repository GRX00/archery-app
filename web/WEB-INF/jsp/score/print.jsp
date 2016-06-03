<%@ page import="pl.grx.archapp.score.ScoreTable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Print</title>
    <link href="css/print.css" rel="stylesheet" type="text/css">
</head>

<body>

<table class="container">
    <tr class="container">
        <td class="container">
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
        <td class="container">
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
    </tr>
    <tr class="container">
        <td class="container">
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
        <td class="container">
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
        </td>
    </tr>
</table>
</body>
</html>
