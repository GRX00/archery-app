<H1>Nagroda RobinHooda</H1>
<h3>Data: </h3>
<table>

    <thead>
    <tr>
        <td colspan="2" class="smallLabel">
            imię nazwisko
        </td>
        <td colspan="5">
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
    <form action="/ScoreTable" method="POST">
        <tr>
            <th scope="row" rowspan="2">1</th>
            <td><input name="Score1" value="<%=scoreTable.getCurrentSeries().getScore(1)%>" type="number"
                       class="cellInput"/></td>
            <td><input name="Score2" value="<%=scoreTable.getCurrentSeries().getScore(2)%>" type="number"
                       class="cellInput"/></td>
            <td><input name="Score3" value="<%=scoreTable.getCurrentSeries().getScore(3)%>" type="number"
                       class="cellInput"/></td>
            <td><%=scoreTable.getCurrentSeries().getFirstRowSum()%>
            </td>
            <td colspan="2" class="crossed"/>
        </tr>
        <tr>
            <td><input name="Score4" value="<%=scoreTable.getCurrentSeries().getScore(4)%>" type="number"
                       class="cellInput"/></td>
            <td><input name="Score5" value="<%=scoreTable.getCurrentSeries().getScore(5)%>" type="number"
                       class="cellInput"/></td>
            <td><input name="Score6" value="<%=scoreTable.getCurrentSeries().getScore(6)%>" type="number"
                       class="cellInput"/></td>
            <td><%=scoreTable.getCurrentSeries().getSecondRowSum()%>
            </td>
            <td><%=scoreTable.getCurrentSeries().getSeriesSum()%>
            </td>
            <td><%=scoreTable.getAccumulatedSeriesSum(1)%>
            </td>
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
