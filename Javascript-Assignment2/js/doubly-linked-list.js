function Node(data) {
    this.previous = null;
    this.data = data;
    this.next = null;
}

function DoublyLinkedList() {
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
                node.previous = pointer;
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
                nodeData += " <=> " + pointer.data;
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
                    pointer.next.previous = null;
                    this.length--;
                    break;
                }
                else if (position == count) {
                    if(pointer.next != null){
                        pointer.previous.next = pointer.next;
                        pointer.next.previous = pointer.previous;
                    }
                    else{
                        pointer.previous.next = null;
                    }

                    this.length--;
                    break;
                }

                
                pointer = pointer.next;
            }
        }
        else{
            document.getElementById('onRemovePrintMessageDLL').innerHTML = "Enter a valid Position.";
            document.querySelector('#doublyLinkedList .warning').style.display = "inline-block";
        }
        return this.head;
    }
}

var listDLL = new DoublyLinkedList();
function displayItemsDLL(list){
    var listData = list.displayNodes();
    var displayLocation = document.getElementById('listDLL');
    if(listData == ""){
        displayLocation.innerHTML = "LIST IS EMPTY";
    }
    else{
        displayLocation.innerHTML = listData;    
    }
}

function addItemDLL() {
    var data = document.getElementById('dataDLL').value;
    document.getElementById('dataDLL').value = "";
    listDLL.head = listDLL.addNode(data);
    displayItemsDLL(listDLL);
}

function removeItemDLL() {
    var position = document.getElementById('positionDLL').value;
    document.getElementById('positionDLL').value = "";
    listDLL.head = listDLL.removeNode(position);
    displayItemsDLL(listDLL);
}
