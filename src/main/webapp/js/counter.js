/**
 * Created by Grzegorz.Zebrowski on 2016-06-05.
 */
var COUNTER_SERVLET_URL = "counter";

var timerValues;
var timer;

var counter;
var timerCounting = false;
var timerReady = false;

var singleSound = document.getElementById("singleSound");
var doubleSound = document.getElementById("doubleSound");

setupTimer();

function setupTimer() {
    resetTimer(false);

    // start each 1 second  checking process
    timer = setInterval(process, 1000);
}

function resetTimer(resetState) {
    ajaxPostCall(COUNTER_SERVLET_URL, "getTimerValues=1", function (response) {
        stopTimer(false);
        timerValues = JSON.parse(response);

        counter = timerValues.currentCounter;
        if (resetState) {
            timerReady = true;
        }
        process();
    });
}

function startTimer() {
    doubleSound.play();
    console.log("timer started");
    timerCounting = true;
    timerReady = false;
}

function stopTimer(makeSound) {
    timerCounting = false;
    timerReady = false;
    if (makeSound === true) {
        singleSound.play();
    }
    console.log("timer stopped");
    counter = 0;
}

function process() {
    if (timerValues instanceof Object) {
        var minutes, seconds, time;
        if (timerCounting === true) {
            counter--;
        }

        time = counter;
        if (counter >= timerValues.seriesTimeSec) {
            // prepare time
            time -= timerValues.seriesTimeSec;
        }
        minutes = ~~(time / 60);

        seconds = time % 60;

        if (timerCounting === true) {
            if (time === 0 && counter !== 0) {
                singleSound.play();
                console.log("prepare time finished");
            }

            if (counter === 0) {
                stopTimer(true);
                ajaxPostCall(COUNTER_SERVLET_URL, "finished=1");
                console.log("time finished");
            }
        }

        updateDisplay(minutes, seconds);
    }

    checkControl();
}

function checkControl() {
    var params = "checkControl=1&counter=" + counter;
    ajaxPostCall(COUNTER_SERVLET_URL, params, function (response) {
        if (response === "start" && timerCounting === false && counter !== 0) {
            console.log("startTimer response");
            startTimer();
        } else if (response === "stop" && timerCounting === true) {
            console.log("stopTimer response");
            stopTimer(true);
        } else if (response === "ready" && timerReady === false) {
            console.log("ready response");
            resetTimer(true);
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
    } else if (counter >= timerValues.seriesTimeSec) {
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