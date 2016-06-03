<%@ page import="pl.grx.archapp.score.ParticipantScoreDisplay" %>
<%
    ParticipantScoreDisplay participantScoreDisplay = new ParticipantScoreDisplay(participantId);
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
            <%=participantScoreDisplay.getName()%>
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
    <form action="/score" method="POST">

        <tr>
            <th scope="row" rowspan="2">1</th>
            <td><input name="Score1" value="<%=participantScoreDisplay.getScoreForSeriesForPosition(1, 1)%>"
                       type="number" class="cellInput"/></td>
            <td><input name="Score2" value="<%=participantScoreDisplay.getScoreForSeriesForPosition(1, 2)%>"
                       type="number"
                       class="cellInput"/></td>
            <td><input name="Score3" value="<%=participantScoreDisplay.getScoreForSeriesForPosition(1, 3)%>"
                       type="number" class="cellInput"/></td>
            <td><%=participantScoreDisplay.getFirstRowSumForSeries(1)%></td>
            <td colspan="2" class="crossed"/>
        </tr>
        <tr>
            <td><input name="Score4" value="<%=participantScoreDisplay.getScoreForSeriesForPosition(1, 4)%>"
                       type="number" class="cellInput"/></td>
            <td><input name="Score5" value="<%=participantScoreDisplay.getScoreForSeriesForPosition(1, 5)%>"
                       type="number" class="cellInput"/></td>
            <td><input name="Score6" value="<%=participantScoreDisplay.getScoreForSeriesForPosition(1, 6)%>"
                       type="number" class="cellInput"/></td>
            <td><%=participantScoreDisplay.getSecondRowSumForSeries(1)%></td
            <td><%=participantScoreDisplay.getSumForSeries(1)%></td>
            <td><%=participantScoreDisplay.getAccumulatedSumForSeries(1)%></td>
            <td>
                <button type="submit">Zapisz</button>
            </td>
        </tr>

    </form>
    <tr>
        <th scope="row" rowspan="2">2</th>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <th scope="row" rowspan="2">3</th>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <th scope="row" rowspan="2">4</th>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <th scope="row" rowspan="2">5</th>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <th scope="row" rowspan="2">6</th>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td colspan="4" class="A1"/>
        <th colspan="2">Razem</th>
        <td/>
    </tr>

    </tbody>
</table>

<table>
    <tbody>
    <tr>
        <td/>
        <td/>
    </tr>
    <tr>
        <td>Zawodnik</td>
        <td>Sędzia</td>
    </tr>
    </tbody>
</table>
