<%@ page import="pl.grx.archapp.controller.CompetitionDisplay" %>
<%@ page import="pl.grx.archapp.CompetitionSingleton" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Administration</title>
    <link href="css/administration.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
    CompetitionSingleton competition = CompetitionSingleton.getInstance();
    CompetitionDisplay competitionDisplay = new CompetitionDisplay();
%>
<div>
    <form action="admin" method="POST">
        <fieldset>
            <div>
                <label for="rangesNr">Liczba Odległości:</label>
                <input type="number" name="rangesNr" id="rangesNr" value="<%=competitionDisplay.getRangesCount()%>"><br>
            </div>

            <table>
                <thead>
                <tr>
                    <th class="A1"></th>
                    <th>Data<br><span class="noBrake">(dd-mm-rrrr)</span></th>
                    <th>Odległość</th>
                    <th>Liczba serii</th>
                    <th>Strzał w serii</th>
                    <th>Czas na serię</th>
                    <th>Czas na przygotowanie<br>(na czerwono)</th>
                    <th>Czas na żółto</th>
                    <th>Czas na czerwono</th>
                    <th>Kolejność</th>
                </tr>
                </thead>

                <tbody>
                <%
                    for (int rangeNr = 1; rangeNr <= competition.getRangesSize(); rangeNr++) {
                %>
                <%@include file="/WEB-INF/jsp/admin/include/range-row.jsp" %>
                <%
                    }
                %>
                </tbody>
            </table>
            <div class="buttonHolder">
                <button type="submit">Zapisz</button>
            </div>
        </fieldset>

        <fieldset>
            <div>
                <label for="matsNr">Liczba Mat:</label>
                <input type="number" name="matsNr" id="matsNr" value="<%=competitionDisplay.getMatsCount()%>"><br>
            </div>

            <table>
                <thead>
                <tr>
                    <th>Mata</th>
                    <th>Pozycja</th>
                    <th class="stretch">Imię Nazwisko</th>
                </tr>
                </thead>

                <tbody>
                <%
                    for (int rowIndex = 1; rowIndex <= competition.getMatsSize(); rowIndex++) {
                %>
                <%@include file="/WEB-INF/jsp/admin/include/mats-row.jsp" %>
                <%
                    }
                %>
                </tbody>
            </table>

            <div class="buttonHolder">
                <button type="submit">Zapisz</button>
            </div>
        </fieldset>
    </form>
</div>

<script src="js/administration.js"></script>
</body>
</html>
