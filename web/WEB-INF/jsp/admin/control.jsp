<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Control</title>
    <link href="css/control.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <fieldset>
        <form action="control" method="POST">
            <input type="hidden" name="series" value="start">
            <button type="submit">Start</button>
        </form>
        <form action="control" method="POST">
            <input type="hidden" name="series" value="stop">
            <button type="submit">Stop</button>
        </form>
        <form action="control" method="POST">
            <input type="hidden" name="series" value="reset">
            <button type="submit">Reset</button>
        </form>
    </fieldset>
</div>

</body>
</html>
