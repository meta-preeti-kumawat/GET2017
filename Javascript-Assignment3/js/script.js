
function bringToFront(id) {
   first(id);
}

function setOthers(number){
    switch(number){
        case 1:   
            first("question1");
            second("question2");
            third("question3");
            fourth("question4");
            break;
        case 2:
            first("question2");
            second("question3");
            third("question4");
            fourth("question1");
            break;
        case 3:
            first("question3");
            second("question4");
            third("question1");
            fourth("question2");
            break;
        case 4:
            first("question4");
            second("question1");
            third("question2");
            fourth("question3");
            break;
    }
}

function startUp(){
    for (var i = 1; i < 5; i++) {
        var id = "question"+i;
        var block = document.getElementById(id);

        switch(i){
            case 1: first(id);
                    break;

            case 2: second(id);
                    break;

            case 3: third(id);
                    break;

            case 4: fourth(id);
                    break;

        }
        (function(){
            var blockId = id;
            var count = i;
            block.onclick = function(){
                bringToFront(blockId);
                setOthers(count);
            } 
        })();   
    }
}

function first(id){
    var block = document.getElementById(id);
    block.style.zIndex = 4;
    block.style.height = "auto";
    block.style.top = "240px";
    block.style.left = "0px";
}
function second(id){
    var block = document.getElementById(id);
    block.style.zIndex = 3;
    block.style.height = "auto";
    block.style.top = "160px";
    block.style.left = "40px";
    block.style.height = "500px";
    block.style.overflow = "hidden";
}
function third(id){
    var block = document.getElementById(id);
    block.style.zIndex = 2;
    block.style.height = "auto";
    block.style.top = "80px";
    block.style.left = "80px";
    block.style.height = "500px";
    block.style.overflow = "hidden";
}
function fourth(id){
    var block = document.getElementById(id);
    block.style.zIndex = 1;
    block.style.height = "auto";
    block.style.top = "0px";
    block.style.left = "120px";
    block.style.height = "500px";
    block.style.overflow = "hidden";
}


startUp();

