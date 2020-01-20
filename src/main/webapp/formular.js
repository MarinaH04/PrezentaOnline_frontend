$(document).ready(function() {
	$("#editare").click(function() {
		$(".formular_edit").css("display", "inline-block");
		$(".formular_logout").css("display", "none");
		$(".formular_delete").css("display", "none");
	});

	$("#logout").click(function() {
		$(".formular_edit").css("display", "none");
		$(".formular_logout").css("display", "block");
		$(".formular_delete").css("display", "none");
	});
	
	$("#delete").click(function() {
		$(".formular_edit").css("display", "none");
		$(".formular_logout").css("display", "none");
		$(".formular_delete").css("display", "block");
	});

});