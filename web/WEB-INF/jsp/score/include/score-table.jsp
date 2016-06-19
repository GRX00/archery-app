<%@ page import="pl.grx.archapp.controller.ParticipantScoreDisplay" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ParticipantScoreDisplay participantScoreDisplay = new ParticipantScoreDisplay(participantName);
%>
<h1>Nagroda RobinHooda</h1>
<h3>Data: <%=participantScoreDisplay.getDate()%>
</h3>
<table>
    <thead>
    <tr>
        <td colspan="2" class="smallLabel">
            imię nazwisko
        </td>
        <td colspan="5">
            <%=participantName%>
        </td>
    </tr>
    <tr>
        <th scope="row" class="A1"/>
        <th scope="col">1</th>
        <th scope="col">2</th>
        <th scope="col">3</th>
        <th scope="col">Suma</th>
        <th colspan="2" scope="col">Razem</th>
    </tr>
    </thead>

    <tbody>
    <%
        for (int i = 1; i <= participantScoreDisplay.getCurrentSeriesNr(); i++) {
    %>
    <tr>
        <th scope="row" rowspan="2"><%=i%>
        </th>
        <td><input name="score%1:<%=participantName%>"
                   value="<%=participantScoreDisplay.getScoreForSeriesForPosition(i, 1)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>1/></td>
        <td><input name="score%2:<%=participantName%>"
                   value="<%=participantScoreDisplay.getScoreForSeriesForPosition(i, 2)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>2/></td>
        <td><input name="score%3:<%=participantName%>"
                   value="<%=participantScoreDisplay.getScoreForSeriesForPosition(i, 3)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>3/></td>
        <td><%=participantScoreDisplay.getFirstRowSumForSeries(i)%>
        </td>
        <td colspan="2">
            <input type="hidden" name="m" value="<%=matNr%>">
            <button type="submit" tabindex=<%=metricNumber%>7>Zapisz</button>
        </td>
    </tr>
    <tr>
        <td><input name="score%4:<%=participantName%>"
                   value="<%=participantScoreDisplay.getScoreForSeriesForPosition(i, 4)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>4/></td>
        <td><input name="score%5:<%=participantName%>"
                   value="<%=participantScoreDisplay.getScoreForSeriesForPosition(i, 5)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>5/></td>
        <td><input name="score%6:<%=participantName%>"
                   value="<%=participantScoreDisplay.getScoreForSeriesForPosition(i, 6)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>6/></td>
        <td><%=participantScoreDisplay.getSecondRowSumForSeries(i)%>
        </td>
        <td><%=participantScoreDisplay.getSumForSeries(i)%>
        </td>
        <td><%=participantScoreDisplay.getAccumulatedSumForSeries(i)%>
        </td>
    </tr>
    <%
        }

        for (int i = (participantScoreDisplay.getCurrentSeriesNr() + 1); i <= participantScoreDisplay.getSeriesCount(); i++) {
    %>
    <tr>
        <th scope="row" rowspan="2"><%=i%></th>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td colspan="2" class="crossed"/>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="4" class="A1"/>
        <th colspan="2">Razem</th>
        <td><%=participantScoreDisplay.getAccumulatedSumForSeries(participantScoreDisplay.getSeriesCount())%></td>
    </tr>

    </tbody>
</table>

<table>
    <tbody>
    <tr>
        <td class="signature signatureBreak"></td>
        <td class="signature"></td>
        <td class="signature signatureBreak"></td>
        <td class="signature"></td>
        <td class="signature signatureBreak"></td>
    </tr>
    <tr>
        <td class="signature signatureBreak"></td>
        <td class="signature signatureLabel">Zawodnik</td>
        <td class="signature signatureBreak"></td>
        <td class="signature signatureLabel">Sędzia</td>
        <td class="signature signatureBreak"></td>
    </tr>
    </tbody>
</table>
