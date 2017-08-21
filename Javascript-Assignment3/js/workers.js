function timedCount() {
    var timer = setTimeout(function(){
    	postMessage(new Date());
    },120000);
	
}

timedCount();