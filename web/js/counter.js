/**
 * Created by Grzegorz.Zebrowski on 2016-06-05.
 */
var COUNTER_SERVLET_URL = "counter";

var timerValues;

var counter;
var timerCounting = false;
var timerReady = true;

// start each 1 second  checking process
setInterval(process, 1000);

resetTimer();

function resetTimer() {
    stopTimer();

    ajaxPostCall(COUNTER_SERVLET_URL, "getTimerValues=1", function (response) {
        timerValues = JSON.parse(response);

        counter = timerValues.seriesTimeSec + timerValues.prepareTimeSec;
        timerReady = true;
        process();
    });
}

function startTimer() {
    // play sound
    console.log("timer started");
    timerCounting = true;
}

function stopTimer() {
    timerCounting = false;
    // play sound
    console.log("timer stopped");
    counter = 0;
    process();
}

function process() {
    checkControl();

    if (timerValues instanceof Object) {
        var minutes, seconds, time;
        time = counter;
        if (counter > timerValues.seriesTimeSec) {
            // prepare time
            time -= timerValues.seriesTimeSec;
        }

        minutes = ~~(time / 60);
        seconds = time % 60;

        updateDisplay(minutes, seconds);

        if (timerCounting === true) {
            if (time === 0) {
                // make sound
                console.log("prepare time finished");
            }

            if (counter === 0) {
                ajaxPostCall(COUNTER_SERVLET_URL, "finished=1");
            }

            counter--;
        }
    }
}

function checkControl() {
    var params = "checkControl=1";
    if (timerCounting===true) {
        params += "&counting=1";
    }
    if (timerReady===true) {
        params += "&ready=1"
    }
    ajaxPostCall(COUNTER_SERVLET_URL, params, function (response) {
        if (response === "start") {
            startTimer();
        } else if (response === "stop") {
            stopTimer();
        } else if (response === "reset") {
            resetTimer();
        }
    });
}

function updateDisplay(minutes, seconds) {
    var secondsDisplay = seconds.toString();
    while (secondsDisplay.length < 2) {
        secondsDisplay = "0" + secondsDisplay;
    }
    document.getElementById("timer").innerHTML = minutes + ":" + secondsDisplay;

    var colorClass;
    if (counter <= timerValues.redTimeSec) {
        colorClass = "red-background";
    } else if (counter <= timerValues.yellowTimeSec) {
        colorClass = "yellow-background";
    } else if (counter > timerValues.seriesTimeSec) {
        colorClass = "red-background";
    } else {
        colorClass = "green-background";
    }
    document.getElementById("timerContainer").className = "timerContainer " + colorClass;
}

function ajaxPostCall(url, params, callback) {
    var xhttp = new XMLHttpRequest();
    if (callback) {
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                callback(xhttp.responseText);
            }
        }
    }
    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(params); //in format "fname=Henry&lname=Ford"
}