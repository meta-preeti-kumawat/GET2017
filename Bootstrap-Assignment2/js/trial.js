$(".message .btn").tooltip({
	title: get_popover_placement,
	placement: get_popover_placement
});
$('.tooltip-inner').html("Tooltip at the "+get_popover_placement);

function get_popover_placement() {
	var width = window.innerWidth;
	if (width<787){ 
		return 'right';
	}
	else{
		return 'top';
	}
}