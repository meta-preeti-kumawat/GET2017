function performAddWithTwoParameters() {
	var number1 = parseInt(document.getElementById('number1').value);
	var number2 = parseInt(document.getElementById('number2').value);
	var displayResult = document.getElementById('addWithTwoParameters');
	
	var result = add( number1, number2);
	if (typeof result == "number") {
		displayResult.innerHTML = result;
	}
	
}

function performAddWithOneParameter() {
	var number1 = parseInt(document.getElementById('number1').value);
	var number2 = parseInt(document.getElementById('number2').value);
	var displayResult = document.getElementById('addWithOneParameter');

	var result = add( number1)( number2);
	if (typeof result == "number") {
		displayResult.innerHTML = result;
	}
}

function add(number1, number2) {
	if (typeof number1 == "number") {
		var add = function(number2){
			return number1 + number2;
		};
		if (typeof number2 == "undefined") {
				return add;
		}
		else{
			if (typeof number2 == "number") {
				return add(number2);
			}
			else{
				return "Input 2 seems to be invalid. Only Numbers are accepted";
			}
		}
	}
	else{
		return "Input 1 seems to be invalid. Only Numbers are accepted";
	}
}