<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Score Table</title>
    <link href="css/score.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
    String participantName;
    String matNr = (String) request.getAttribute("m");
    int metricNumber = 0;
%>
<form action="/score" method="POST">
    <table>
        <tr>
            <td class="A1">
                <%
                    participantName = (String) request.getAttribute("participantNameA");
                    metricNumber = 1;
                    if (participantName != null) {
                %>
                <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
                <%
                    }
                %>
            </td>
            <td class="A1">
                <%
                    participantName = (String) request.getAttribute("participantNameB");
                    metricNumber = 2;
                    if (participantName != null) {
                %>
                <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
                <%
                    }
                %>
            </td>
        </tr>
        <tr>
            <td class="A1">
                <%
                    participantName = (String) request.getAttribute("participantNameC");
                    metricNumber = 3;
                    if (participantName != null) {
                %>
                <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
                <%
                    }
                %>
            </td>
            <td class="A1">
                <%
                    participantName = (String) request.getAttribute("participantNameD");
                    metricNumber = 4;
                    if (participantName != null) {
                %>
                <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
                <%
                    }
                %>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
