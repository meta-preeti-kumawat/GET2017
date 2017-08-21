function removeConsecutiveRepeatingString(){
    var inputString = document.getElementById('inputString').value;
    if(inputString.trim() != ""){
        inputString = inputString.toLowerCase();
        
        var strArray = inputString.split("");
        var count = 1;
        while(count < strArray.length){
            
            if(strArray[ count ] === strArray[ count - 1 ])
            {    
                var sequence = 2;
                while(strArray[count] === strArray[count+1]){
                    sequence++;
                    count++;    
                }
                strArray.splice(count -  sequence + 1, sequence);
                count = count - sequence + 1;
            }
            else{
                count++;
            }
            
        }

        if (strArray.length == 0) {
            document.getElementById('outputString').innerHTML = " ---EMPTY---";
        }
        else{
            document.getElementById('outputString').innerHTML = strArray.join("");
        }
    }
    else{
        document.querySelector('#repeatingString .error').innerHTML = "Enter a valid string";
        document.querySelector('#repeatingString .warning').style.display = "inline-block";
    }
   
}