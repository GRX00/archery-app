<%@ page import="pl.grx.archapp.displayhelper.ScoreDisplayHelper" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ScoreDisplayHelper scoreDisplayHelper = score.getScoreDisplayHelper(participant);
%>
<h1>Nagroda RobinHooda</h1>
<h3>Data: <%=scoreDisplayHelper.getDate()%>
</h3>
<table>
    <thead>
    <tr>
        <td colspan="2" class="smallLabel">
            Imię Nazwisko
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
        for (int i = 1; i <= scoreDisplayHelper.getSeriesCount(); i++) {
            if (scoreDisplayHelper.isCurrentSeriesProcessed(i)) {
    %>
    <tr>
        <th scope="row" rowspan="2"><%=i%>
        </th>
        <td><input name="score%1:<%=participant%>"
                   value="<%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 1)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>1/></td>
        <td><input name="score%2:<%=participant%>"
                   value="<%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 2)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>2/></td>
        <td><input name="score%3:<%=participant%>"
                   value="<%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 3)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>3/></td>
        <td><%=scoreDisplayHelper.getFirstRowSumForSeries(i)%>
        </td>
        <td colspan="2">
            <input type="hidden" name="m" value="<%=matNumber%>">
            <button type="submit" tabindex=<%=metricNumber%>7>Zapisz</button>
        </td>
    </tr>
    <tr>
        <td><input name="score%4:<%=participant%>"
                   value="<%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 4)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>4/></td>
        <td><input name="score%5:<%=participant%>"
                   value="<%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 5)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>5/></td>
        <td><input name="score%6:<%=participant%>"
                   value="<%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 6)%>"
                   type="number" class="cell" min="0" max="11" tabindex=<%=metricNumber%>6/></td>
        <td><%=scoreDisplayHelper.getSecondRowSumForSeries(i)%>
        </td>
        <td><%=scoreDisplayHelper.getSumForSeries(i)%>
        </td>
        <td><%=scoreDisplayHelper.getAccumulatedSumForSeries(i)%>
        </td>
    </tr>
    <%
    } else {
    %>
    <tr>
        <th scope="row" rowspan="2"><%=i%>
        </th>
        <td><%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 1)%>
        </td>
        <td><%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 2)%>
        </td>
        <td><%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 3)%>
        </td>
        <td><%=scoreDisplayHelper.getFirstRowSumForSeries(i)%>
        </td>
        <td colspan="2" class="crossed"/>
    </tr>
    <tr>
        <td><%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 4)%>
        </td>
        <td><%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 5)%>
        </td>
        <td><%=scoreDisplayHelper.getScoreForSeriesForPosition(i, 6)%>
        </td>
        <td><%=scoreDisplayHelper.getSecondRowSumForSeries(i)%>
        </td>
        <td><%=scoreDisplayHelper.getSumForSeries(i)%>
        </td>
        <td><%=scoreDisplayHelper.getAccumulatedSumForSeries(i)%>
        </td>
    </tr>
    <%
            }
        }
    %>
    <tr>
        <td colspan="4" class="A1"/>
        <th colspan="2">Razem</th>
        <td><%=scoreDisplayHelper.getAccumulatedSum()%>
        </td>
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
