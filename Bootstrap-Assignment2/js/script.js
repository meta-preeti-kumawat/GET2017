$(document).ready(function(){
	
	$(".message .btn").tooltip({
		placement: get_popover_placement, title: get_popover_placement_title
	});

	function get_popover_placement() {
		var width = window.innerWidth;
		if (width<787){ 
			return 'right';
		}
		else{
			return 'top';
		}
	}
	function get_popover_placement_title() {
		var width = window.innerWidth;
		if (width<787){ 
			return 'Tooltip at the right';
		}
		else{
			return 'Tooltip at the top';
		}
	}
	$(".collapse").on("hide.bs.collapse", function(){
		$(this).closest(".panel").find("a .panel-heading span.change-sign").removeClass('glyphicon-minus');
		$(this).closest(".panel").find("a .panel-heading span.change-sign").addClass('glyphicon-plus');
	});
	$(".collapse").on("show.bs.collapse", function(){
		$(this).closest(".panel").find("a .panel-heading span.change-sign").removeClass('glyphicon-plus');
		$(this).closest(".panel").find("a .panel-heading span.change-sign").addClass('glyphicon-minus');
	});

});