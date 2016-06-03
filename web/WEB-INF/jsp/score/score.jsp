<%@ page import="pl.grx.archapp.Participant" %>
<%@ page import="pl.grx.archapp.CompetitionSingleton" %>
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
    String participantId;
    CompetitionSingleton competition = CompetitionSingleton.getInstance();
%>
<table class="container">
    <tr>
        <td class="container">
            <%
                participantId = (String) request.getAttribute("participantId1");
                if (participantId != null) {
            %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
            <%
                }
            %>
        </td>
        <td class="container">
            <%
                participantId = (String) request.getAttribute("participantId2");
                if (participantId != null) {
            %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
            <%
                }
            %>
        </td>
    </tr>
    <tr>
        <td class="container">
            <%
                participantId = (String) request.getAttribute("participantId3");
                if (participantId != null) {
            %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
            <%
                }
            %>
        </td>
        <td class="container">
            <%
                participantId = (String) request.getAttribute("participantId4");
                if (participantId != null) {
            %>
            <%@include file="/WEB-INF/jsp/score/inlcude/score-table.jsp" %>
            <%
                }
            %>
        </td>
    </tr>
</table>
</body>
</html>
