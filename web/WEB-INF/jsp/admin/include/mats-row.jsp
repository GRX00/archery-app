<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tr>
    <td>
        1
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
        <input class="cell positionName" type="text" name="1A-name" value="">
    </td>
</tr>
<tr>
    <td></td>
    <td>B</td>
    <td>
        <input class="cell" type="text" name="1B-name" value="">
    </td>
</tr>
<tr>
    <td></td>
    <td>C</td>
    <td>
        <input class="cell" type="text" name="1C-name" value="">
    </td>
</tr>
<tr>
    <td></td>
    <td>D</td>
    <td>
        <input class="cell" type="text" name="1D-name" value="">
    </td>
</tr>