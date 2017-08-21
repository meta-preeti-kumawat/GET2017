function Stack() {
    this.stackItems = [];
    this.top = -1;
}

Stack.prototype.push = function(element){
    if (element.trim() != "") {
        // this.stackItems.push(element);
        this.top++;
        this.stackItems[this.top] = element;
    }
}

Stack.prototype.pop = function(){
    if(this.top != -1){
        this.stackItems.pop();
        this.top--;
    }
    else{
        document.getElementById('onPopPrintMessage').innerHTML = "No Element available to Pop";
        document.querySelector('#stack .warning').style.display = "inline-block";
    }
    
}

Stack.prototype.display = function(){
    var index = 0;
    var data = "";
    if(this.top == -1){
        data = "";
    }
    else{
        while(index <= this.top){
            data = this.stackItems[index++] + "<br/>" + data;
        }
    }
    return data;
}

var stack = new Stack();

function displayItems(stack) {
    var stackData = stack.display();
    var displayLocation = document.getElementById('displayStack');
     
    if(stackData == ""){
        displayLocation.innerHTML = "STACK IS EMPTY";
    }
    else{
        displayLocation.innerHTML = stackData;
    }
}
function pushItem(){
    var data = document.getElementById('dataStack').value;
    document.getElementById('dataStack').value = "";
    stack.push(data);
    displayItems(stack);
}

function popItem(){
    stack.pop();
    displayItems(stack);
}