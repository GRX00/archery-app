<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>ArcheryApp - Counter</title>
    <link href="css/counter.css" rel="stylesheet" type="text/css">
</head>

<body>

<audio id="singleSound">
    <source src="sounds/whistleSingle.ogg" type="audio/ogg">
    <source src="sounds/whistleSingle.mp3" type="audio/mpeg">
    Your browser does not support the audio.
</audio>

<audio id="doubleSound">
    <source src="sounds/whistleDouble.ogg" type="audio/ogg">
    <source src="sounds/whistleDouble.mp3" type="audio/mpeg">
</audio>

<div id="timerContainer" class="timerContainer red-background">
    <div class="centered">
        <div id="timer" class="timer">0:00</div>
    </div>
</div>

<script src="js/counter.js"></script>
</body>
</html>
