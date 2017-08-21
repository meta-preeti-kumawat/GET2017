if(localStorage.getItem("userInfo") !== null){
	var userInformation = localStorage.getItem("userInfo");
	userInformation = JSON.parse(userInformation);
	for(key in userInformation){
		document.getElementById(key).value = userInformation[key];
	}
}

function saveToLocalStorage(userInformation) {
	localStorage.setItem("userInfo" , JSON.stringify(userInformation));
}

function clearLocalStorage() {
	if (localStorage.getItem("userInfo") !== null) {
		localStorage.removeItem("userInfo");
	}
}