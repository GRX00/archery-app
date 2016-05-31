<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArcheryApp - Welcome</title>
    <link href="/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>


<form action="/ScoreTable" method="GET">
    <div class="alignCenter">
        <input type="hidden" name="m" value="1"/>
        <button type="submit">Metryczki - Mata 1</button>
    </div>
</form>

<form action="/ScoreTable" method="GET">
    <div class="alignCenter">
        <input type="hidden" name="m" value="2"/>
        <button type="submit">Metryczki - Mata 2</button>
    </div>
</form>

<form action="/ScoreTable" method="GET">
    <div class="alignCenter">
        <input type="hidden" name="m" value="3"/>
        <button type="submit">Metryczki - Mata 3</button>
    </div>
</form>

<form action="/ScoreTable" method="GET">
    <div class="alignCenter">
        <input type="hidden" name="m" value="4"/>
        <button type="submit">Metryczki - Mata 4</button>
    </div>
</form>


</body>
</html>
