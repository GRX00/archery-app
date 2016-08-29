<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tr>
    <td>
        <%=rowNr%>
    </td>
    <td colspan="2"></td>
</tr>
<tr>
    <td></td>
    <td>A</td>
    <%--<label for="A1.A">A</label><input id="A1.A" type="radio" disabled checked>--%>
    <%--<input id="B1.A" type="radio" disabled><label for="B1.A">B</label>--%>
    <%--<br>--%>
    <%--<label for="C1.A">C</label><input id="C1.A" type="radio" disabled>--%>
    <%--<input id="D1.A" type="radio" disabled><label for="D1.A">D</label>--%>
    <td class="positionNameCell">
        <div class="cellContainer">
            <input class="cell" type="text" name="<%=rowNr%>:nameA" 
                   value="<%=adminDisplayHelper.getParticipantName(rowNr, 0)%>"
                   ondblclick="toggleList(this)">
            <ul class="dropdown" hidden>
                <% for(String participantName : adminDisplayHelper.getParticipantsNames()) { %>
                <li onclick="selectItemOnList(this)"><%=participantName%></li>
                <% } %>
            </ul>
        </div>
    </td>
</tr>
<tr>
    <td></td>
    <td>B</td>
    <td class="positionNameCell">
        <div class="cellContainer">
            <input class="cell" type="text" name="<%=rowNr%>:nameB"
                   value="<%=adminDisplayHelper.getParticipantName(rowNr, 1)%>"
                   ondblclick="toggleList(this)">
            <ul class="dropdown" hidden>
                <% for(String participantName : adminDisplayHelper.getParticipantsNames()) { %>
                <li onclick="selectItemOnList(this)"><%=participantName%></li>
                <% } %>
            </ul>
        </div>
    </td>
</tr>
<tr>
    <td></td>
    <td>C</td>
    <td class="positionNameCell">
        <div class="cellContainer">
            <input class="cell" type="text" name="<%=rowNr%>:nameC"
                   value="<%=adminDisplayHelper.getParticipantName(rowNr, 2)%>"
                   ondblclick="toggleList(this)">
            <ul class="dropdown" hidden>
                <% for(String participantName : adminDisplayHelper.getParticipantsNames()) { %>
                <li onclick="selectItemOnList(this)"><%=participantName%></li>
                <% } %>
            </ul>
        </div>
    </td>
</tr>
<tr>
    <td></td>
    <td>D</td>
    <td class="positionNameCell">
        <div class="cellContainer">
            <input class="cell" type="text" name="<%=rowNr%>:nameD"
                   value="<%=adminDisplayHelper.getParticipantName(rowNr, 3)%>"
                   ondblclick="toggleList(this)">
            <ul class="dropdown" hidden>
                <% for(String participantName : adminDisplayHelper.getParticipantsNames()) { %>
                <li onclick="selectItemOnList(this)"><%=participantName%></li>
                <% } %>
            </ul>
        </div>
    </td>
</tr>