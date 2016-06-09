<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tr>
    <td>
        <%=rowIndex%>
    </td>
    <td colspan="2"></td>
</tr>
<tr>
    <td></td>
    <td>
        A
        <%--<label for="A1.A">A</label><input id="A1.A" type="radio" disabled checked>--%>
        <%--<input id="B1.A" type="radio" disabled><label for="B1.A">B</label>--%>
        <%--<br>--%>
        <%--<label for="C1.A">C</label><input id="C1.A" type="radio" disabled>--%>
        <%--<input id="D1.A" type="radio" disabled><label for="D1.A">D</label>--%>
    </td>
    <td class="positionNameCell">
        <select class="cell positionNameDropdown" onchange="setSelectedToInput(this)">
            <option value=" "></option>
            <option value="Test Test">Test Test</option>
        </select>
        <input class="cell positionName" type="text" name="<%=rowIndex%>:nameA" value="">
    </td>
</tr>
<tr>
    <td></td>
    <td>B</td>
    <td class="positionNameCell">
        <select class="cell positionNameDropdown" onchange="setSelectedToInput(this)">
            <option value=" "></option>
            <option value="Test Test">Test Test</option>
        </select>
        <input class="cell positionName" type="text" name="<%=rowIndex%>:nameB" value="">
    </td>
</tr>
<tr>
    <td></td>
    <td>C</td>
    <td class="positionNameCell">
        <select class="cell positionNameDropdown" onchange="setSelectedToInput(this)">
            <option value=" "></option>
            <option value="Test Test">Test Test</option>
        </select>
        <input class="cell positionName" type="text" name="<%=rowIndex%>:nameC" value="">
    </td>
</tr>
<tr>
    <td></td>
    <td>D</td>
    <td class="positionNameCell">
        <select class="cell positionNameDropdown" onchange="setSelectedToInput(this)">
            <option value=" "></option>
            <option value="Test Test">Test Test</option>
        </select>
        <input class="cell positionName" type="text" name="<%=rowIndex%>:nameD" value="">
    </td>
</tr>