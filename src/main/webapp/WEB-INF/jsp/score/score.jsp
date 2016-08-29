<%@ page import="pl.grx.archapp.Score" %>
<%@ page import="pl.grx.archapp.model.Participant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Score Table</title>
    <link href="css/score.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
    Score score = (Score) request.getServletContext().getAttribute("score");

    int matNumber = (int) request.getAttribute("m");
%>
<form action="/score" method="POST">
    <table>
        <tr>
            <%
                Participant participant;
                String participantName;
                int metricNumber;

                for (int i = 0; i < 4; i++) {
            %>
            <td class="A1">
                <%
                    participant = score.getParticipant(matNumber - 1, i);
                    participantName = participant.getName();
                    metricNumber = i+1;
                    if (participantName != null) {
                %>
                <%@include file="/WEB-INF/jsp/score/include/score-table.jsp" %>
                <%
                    }
                %>
            </td>
            <%
                }
            %>
        </tr>
    </table>
</form>
</body>
</html>
