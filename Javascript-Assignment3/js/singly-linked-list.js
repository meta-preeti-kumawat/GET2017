function Node(data) {
    this.data = data;
    this.next = null;
}

function SinglyLinkedList() {
    this.head = null;
    this.length = 0;

    this.addNode = function(data) {
        if(data.trim() != ""){
            var node = new Node(data);
            if (this.head == null) {
                this.head = node;
                this.length++;
            }
            else{
                var pointer = this.head;
                while(pointer.next != null){
                    pointer = pointer.next;
                }
                pointer.next = node;
                this.length++;
            }
        }
        return this.head;
    }

    this.displayNodes = function(){
        var nodeData = "";
        var pointer = this.head;
        var count = 0;
        while(pointer != null){
            if(count == 0){
                nodeData += pointer.data;
                count = 1;
            }
            else{
                nodeData += " => " + pointer.data;
            }
            pointer = pointer.next;
        }
        return nodeData;
    }

    this.removeNode = function(position){
        var count = 0;
        if(position > 0 && position <= this.length){
            var pointer = this.head;
            while(pointer != null){
                count++;
                if(position == 1){
                    this.head = pointer.next;
                    this.length--;
                    break;
                }
                else if (position - 1 == count) {
                    if(pointer.next != null){
                        if (pointer.next.next != null) {
                            pointer.next = pointer.next.next;
                        }
                        else{
                            pointer.next = null;
                        }
                    }
                    this.length--;
                    break;
                }

                
                pointer = pointer.next;
            }
        }
        else{
            document.getElementById('onRemovePrintMessage').innerHTML = "Enter a valid Position.";
            document.getElementById('onRemovePrintMessage').style.display = "inline-block";
        }
        return this.head;
    }

    this.searchNodeByPosition = function(position){
       var count = 0;
       var result = "";
       if(position > 0 && position <= this.length){
            var pointer = this.head;
            while(pointer != null){
                count++;
                if (position == count) {
                    result = pointer.data;
                }
                pointer = pointer.next;
            }
        }
        else{
            result = "Position not available.";
        }
        return result;
    }

    this.searchNodeByValue = function(element){
        var count = 0;
        var checkAvailability = false;
        var pointer = this.head;
        var result = "";
        while(pointer != null){
            count++;
            if (pointer.data == element) {
                result = "First instance found at "+count;
                checkAvailability = true;
                break;
            }
            pointer = pointer.next;
        }
        if (checkAvailability === false) {
             result = "Element not found";
        }
        return result;
    }
}

var list = new SinglyLinkedList();
function displayItems(list){
    var listData = list.displayNodes();
    var displayLocation = document.getElementById('list');
    if(listData == ""){
        displayLocation.innerHTML = "LIST IS EMPTY";
    }
    else{
        displayLocation.innerHTML = listData;    
    }
}

function addItem(fieldId) {
    var data = document.getElementById(fieldId).value;
    document.getElementById(fieldId).value = "";
    list.head = list.addNode(data);
    displayItems(list);
}

function removeItem(fieldId) {
    var position = document.getElementById(fieldId).value;
    document.getElementById(fieldId).value = "";
    list.head = list.removeNode(position);
    displayItems(list);
}

function searchItemByPosition(fieldId, messageId) {
    var position = document.getElementById(fieldId).value;
    document.getElementById(fieldId).value = "";
    document.getElementById(messageId).innerHTML = list.searchNodeByPosition(position);
    document.getElementById(messageId).style.display = "inline-block";
}

function searchItemByValue(fieldId, messageId) {
    var element = document.getElementById(fieldId).value;
    document.getElementById(fieldId).value = "";
    document.getElementById(messageId).innerHTML = list.searchNodeByValue(element);
    document.getElementById(messageId).style.display = "inline-block";
}

function clearMessage(id) {
    var element = document.getElementById(id);
    element.innerHTML = "";
}