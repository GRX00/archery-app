<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Print</title>
    <link href="css/print.css" rel="stylesheet" type="text/css">
</head>

<body>

<table class="timerContainer">
    <tr class="timerContainer">
        <td class="timerContainer">
            <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
        </td>
        <td class="timerContainer">
            <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
        </td>
    </tr>
    <tr class="timerContainer">
        <td class="timerContainer">
            <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
        </td>
        <td class="timerContainer">
            <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
        </td>
    </tr>
</table>
</body>
</html>
