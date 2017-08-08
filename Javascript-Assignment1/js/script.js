function formCheck() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var city = document.getElementById('city').value;
    var orgName = document.getElementById('orgName').value;
    var number = document.getElementById('number').value;
    var message = document.getElementById('message').value;

    var validationPass = true;
    if(!(validateNotEmpty("name", name) && validateCharsOnly("name", name) && validateLength("name", name, 20)) ){
        validationPass = false;
    }
    if(!(validateNotEmpty("email", email) && validateEmail("email", email)) ){
        validationPass = false;
    }
    if(!placeSelectedCity(city)){
        validationPass = false;
    }
    if(!(validateNotEmpty("org-name", orgName) && validateCharsOnly("org-name", orgName)) ){
        validationPass = false;
    }
    if(!(validateNotEmpty("number", number) && validatePhoneNumber("number", number)) ){
        validationPass = false;
    }
    if(!(validateNotEmpty("message", message) && validateLength("message", message, 250))){
        validationPass = false;
    }
    return validationPass;
}

function placeSelectedCity(city){
    if (city != "") {
        document.getElementById('city-value').setAttribute("class", "");
        document.getElementById('city-statement').innerHTML = "You have selected this city:";
        document.getElementById('city-value').innerHTML = "<input type='text' disabled='disabled' value=' " +city+"'>";
        return true;
    }
    else{
        document.getElementById('city-value').setAttribute("class", "cityError");
        document.getElementById('city-value').innerHTML = "Please select a city";
        return false;
    }
    
}

function validateNotEmpty(field, value) {
    console.log(field);
    var id = field+'-error';
    var errorSpan = document.getElementById(id);
    
    if(value == ""){
        errorSpan.style.display = 'inline-block';
        errorSpan.innerHTML = "This Field is required";
        return false;
    }
    else{
       errorSpan.innerHTML = "";    
    }
    return true;
}

function validateCharsOnly(field, value) {
    var pattern = /^[A-Za-z ]*$/;
    var id = field+'-error';
    var errorSpan = document.getElementById(id);
    
    if(!pattern.test(value)){
        errorSpan.innerHTML = "Only characters and white spaces allowed";
        return false;
    }
    else{
        errorSpan.innerHTML = "";    
    }
    return true;
}

function validateEmail(field, value) {
    var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var id = field+'-error';
    var errorSpan = document.getElementById(id);
        
    if(!pattern.test(value)){
        errorSpan.innerHTML = "Email is invalid";
        return false;
    }
    else{
        errorSpan.innerHTML = "";
    }
    return true;
}

function validateLength(field, value, length) {
    var id = field+'-error';
    var errorSpan = document.getElementById(id);
    
    if(!(value.length <= length)){
        errorSpan.innerHTML = "Length should not exceed "+length+" characters";
        return false;
    }
    else{
        errorSpan.innerHTML = "";
    }
    return true;
}

function validatePhoneNumber(field, number){
    pattern = /^[0-9]{7,13}$/;
    var id = field+'-error';
    var errorSpan = document.getElementById(id);
    
    if(!pattern.test(number)){
       errorSpan.innerHTML = "Invalid Number";
        return false;
    }
    else{
       errorSpan.innerHTML = "";
    }
    return true;
}