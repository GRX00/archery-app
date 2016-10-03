<%@ page import="pl.grx.archapp.CompetitionSingleton" %>
<%@ page import="pl.grx.archapp.controller.ControlDisplay" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Control</title>
    <link href="css/control.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    ControlDisplay controlDisplay = new ControlDisplay();
%>

<div class="alignCenter">
    <fieldset>
        <form action="control" method="POST">
            <input type="hidden" name="command" value="start">
            <button type="submit">Start</button>
        </form>
        <form action="control" method="POST">
            <input type="hidden" name="command" value="stop">
            <button type="submit">Stop</button>
        </form>
        <form action="control" method="POST">
            <input type="hidden" name="command" value="reset">
            <button type="submit">Reset + ></button>
        </form>
        <br>
        <span>Seria:</span>
        <br>
        <div class="inline">
            <form action="control" method="POST">
                <input type="hidden" name="command" value="seriesPrevious">
                <button type="submit">&nbsp;<&nbsp;</button>
            </form>
            <span><%=controlDisplay.getCurrentSeries()%></span>
            <form action="control" method="POST">
                <input type="hidden" name="command" value="seriesNext">
                <button type="submit">&nbsp;>&nbsp;</button>
            </form>
        </div>
        <br>
        <span>Odległość:</span>
        <br>
        <div class="inline">
            <form action="control" method="POST">
                <input type="hidden" name="command" value="rangePrevious">
                <button type="submit">&nbsp;<&nbsp;</button>
            </form>
            <span><%=controlDisplay.getCurrentRange()%></span>
            <form action="control" method="POST">
                <input type="hidden" name="command" value="rangeNext">
                <button type="submit">&nbsp;>&nbsp;</button>
            </form>
        </div>
    </fieldset>
</div>

</body>
</html>
