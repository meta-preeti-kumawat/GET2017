var w;
document.getElementById('start').removeAttribute("disabled");

function startTimer(){
    document.getElementById('start').setAttribute("disabled", "disabled");
    document.getElementById('startTime').innerHTML = "";
    document.getElementById('endTime').innerHTML = ""; 
    
    var currentDate = new Date();
    document.getElementById('startTime').innerHTML = currentDate;
    var setMinutes = 0;
    
    var interval = setInterval(function(){

        var minutes = document.getElementById('minutes');
        var seconds = document.getElementById('seconds');

       
        var setSeconds = +seconds.innerHTML + 1;

        if (setSeconds == 60) {
            setSeconds = "0";
            setMinutes += 1;
        }

        minutes.innerHTML = setMinutes;
        seconds.innerHTML = setSeconds < 10 ? "0"+setSeconds: setSeconds;
        if (setMinutes == 2) {
            clearInterval(interval);
            document.getElementById('start').removeAttribute("disabled");
        }
    },1000);
}
function startWorker() {
    startTimer();
    if(typeof(Worker) !== "undefined") {
        if(typeof(w) == "undefined") {
            w = new Worker("js/workers.js");
        }
        w.onmessage = function(event) {
            document.getElementById("endTime").innerHTML = event.data;
            stopWorker();
        };
      
    } else {
        document.getElementById("endTime").innerHTML = "Sorry, your browser does not support Web Workers...";
    }
}

function stopWorker() { 
    w.terminate();
    w = undefined;
}