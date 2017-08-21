function Queue() {
    this.queueItems = [];
    this.front = -1;
    this.rear = -1;
}

Queue.prototype.enQueue = function(element){
    if (element.trim() != "") {
        this.queueItems[++this.rear] = element;
        this.front = 0;
    }
}

Queue.prototype.deQueue = function(){
    if(this.front != -1){
        if(this.front == this.rear){
            this.front = -1;   
        }
        this.queueItems.shift();
        this.rear--;
    }
    else{
        document.getElementById('onDeQueuePrintMessage').innerHTML = "No Element available in Queue";
        document.querySelector('#queue .warning').style.display = "inline-block";
    }
}

Queue.prototype.display = function(){
    var index = 0;
    var data = "";
    if(this.front == -1){
        data = "";
    }
    else{
        while(index <= this.rear){
            data += this.queueItems[index++] + "&nbsp;";
        }
    }
    return data;
}

var queue = new Queue();

function displayItemsQueue(queue) {
    var queueData = queue.display();
    var displayLocation = document.getElementById('displayQueue');
     
    if(queueData == ""){
        displayLocation.innerHTML = "QUEUE IS EMPTY";
    }
    else{
        displayLocation.innerHTML = queueData;
    }
}
function enQueueItem(){
    var data = document.getElementById('dataQ').value;
    document.getElementById('dataQ').value = "";
    queue.enQueue(data);
    displayItemsQueue(queue);
}

function deQueueItem(){
    queue.deQueue();
    displayItemsQueue(queue);
}