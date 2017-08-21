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
            document.getElementById('onRemovePrintMessageSLL').innerHTML = "Enter a valid Position.";
            document.querySelector('#singlyLinkedList .warning').style.display = "inline-block";
        }
        return this.head;
    }
}

var listSLL = new SinglyLinkedList();
function displayItemsSLL(list){
    var listData = list.displayNodes();
    var displayLocation = document.getElementById('listSLL');
    if(listData == ""){
        displayLocation.innerHTML = "LIST IS EMPTY";
    }
    else{
        displayLocation.innerHTML = listData;    
    }
}

function addItemSLL() {
    var data = document.getElementById('dataSLL').value;
    document.getElementById('dataSLL').value = "";
    listSLL.head = listSLL.addNode(data);
    displayItemsSLL(listSLL);
}

function removeItemSLL() {
    var position = document.getElementById('positionSLL').value;
    document.getElementById('positionSLL').value = "";
    listSLL.head = listSLL.removeNode(position);
    displayItemsSLL(listSLL);
}

function clearMessage(main, id) {
    var element = document.getElementById(id);
    element.innerHTML = "";
    var warning = "#"+main+" .warning";
    document.querySelector(warning).style.display = "none";
}