<%@ page import="pl.grx.archapp.controller.CounterDataDisplay" %>
<%@ page import="pl.grx.archapp.controller.RangeDisplay" %>
<%@ page import="pl.grx.archapp.model.SeriesArrows" %>
<%@ page import="pl.grx.archapp.model.SeriesSequence" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RangeDisplay rangeDisplay = new RangeDisplay(request, rangeNr);
    CounterDataDisplay counterDisplay = new CounterDataDisplay(rangeDisplay);
%>
<tr>
    <th><%=rangeNr%>
    </th>
    <td><input class="cell" type="text" name="<%=rangeNr%>:date" value="<%=rangeDisplay.getDate()%>"/></td>
    <td><input class="cell" type="text" name="<%=rangeNr%>:rangeDescription"
               value="<%=rangeDisplay.getDescription()%>"/></td>
    <td><input class="cell" type="number" name="<%=rangeNr%>:seriesCount" value="<%=rangeDisplay.getSeriesCount()%>">
    </td>
    <td>
        <select name="<%=rangeNr%>:seriesArrows">
            <% for (SeriesArrows seriesArrows : SeriesArrows.values()) { %>
            <option value="<%=seriesArrows.getValue()%>" <%=rangeDisplay.isSelectedSeriesArrows(seriesArrows)%>>
                <%=seriesArrows.getDescription()%>
            </option>
            <% } %>
        </select>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:seriesTimeMinutes"
                   value="<%=counterDisplay.getSeriesTimeMinutes()%>" min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:seriesTimeSeconds"
                   value="<%=counterDisplay.getSeriesTimeSeconds()%>" min="0" max="59"
                   onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:prepareTimeMinutes"
                   value="<%=counterDisplay.getPrepareTimeMinutes()%>"
                   min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:prepareTimeSeconds"
                   value="<%=counterDisplay.getPrepareTimeSeconds()%>"
                   min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:yellowTimeMinutes"
                   value="<%=counterDisplay.getYellowTimeMinutes()%>"
                   min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:yellowTimeSeconds"
                   value="<%=counterDisplay.getYellowTimeSeconds()%>"
                   min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <div class="time">
            <input class="cell" type="number" name="<%=rangeNr%>:redTimeMinutes"
                   value="<%=counterDisplay.getRedTimeMinutes()%>"
                   min="0">
            <span>:</span>
            <input class="cell" type="number" name="<%=rangeNr%>:redTimeSeconds"
                   value="<%=counterDisplay.getRedTimeSeconds()%>"
                   min="0" max="59" onblur="addTrailingZeroes(this, 2)">
        </div>
    </td>
    <td>
        <select name="<%=rangeNr%>:seriesSequence">
            <% for (SeriesSequence seriesSequence : SeriesSequence.values()) { %>
            <option value="<%=seriesSequence.name()%>" <%=counterDisplay.isSelectedSeriesSequence(seriesSequence)%>>
                <%=seriesSequence.getDescription()%>
            </option>
            <% } %>
        </select>
    </td>
</tr>