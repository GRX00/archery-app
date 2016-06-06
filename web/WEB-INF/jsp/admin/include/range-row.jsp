<%@ page import="pl.grx.archapp.controller.RangeDisplay" %>
<%@ page import="pl.grx.archapp.model.ArrowsInSeries" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RangeDisplay rangeDisplay = new RangeDisplay(rangeNr);
%>
<tr>
    <th><%=rangeNr%></th>
    <td><input class="cell" type="text" name="<%=rangeNr%>:date" value="<%=rangeDisplay.getDate()%>"/></td>
    <td><input class="cell" type="text" name="<%=rangeNr%>:rangeDescription" value="<%=rangeDisplay.getDescription()%>"/></td>
    <td><input class="cell" type="number" name="<%=rangeNr%>:seriesCount" value="<%=rangeDisplay.getSeriesCount()%>"></td>
    <td>
        <select name="<%=rangeNr%>:arrowsPerSeries">
            <% for (ArrowsInSeries arrowsInSeries : ArrowsInSeries.values()) { %>
            <option value="<%=arrowsInSeries.getValue()%>" <%=rangeDisplay.isSelectedArrowsInSeries(arrowsInSeries)%>>
                <%=arrowsInSeries.getDescription()%></option>
            <% } %>
        </select>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:seriesTimeMinutes"
                   value="4" min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:seriesTimeSeconds"
                   value="00" min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:beforeSeriesTimeMinutes" value="0"
                   min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:beforeSeriesTimeSeconds" value="10"
                   min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:yellowTimeMinutes" value="1"
                   min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:yellowTimeSeconds" value="30"
                   min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:redTimeMinutes" value="0"
                   min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:redTimeSeconds" value="30"
                   min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <select name="<%=rangeNr%>:sequence">
            <option value="A">A</option>
            <option value="AB/AB" selected>AB/AB</option>
            <option value="AB/BA">AB/BA</option>
            <option value="ABC">ABC</option>
        </select>
    </td>
</tr>