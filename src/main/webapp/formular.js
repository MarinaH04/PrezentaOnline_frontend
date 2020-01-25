$(document).ready(function() {
	$("#editare").click(function() {
		$(".formular_edit").css("display", "inline-block");
		$(".formular_delete").css("display", "none");
		$(".formular_insert").css("display", "none");
	});

	$("#logout").click(function() {
		$(".formular_edit").css("display", "none");
		$(".formular_delete").css("display", "inline-block");
		$(".formular_insert").css("display", "none");
	});
	
	$("#delete").click(function() {
		$(".formular_edit").css("display", "none");
		$(".formular_delete").css("display", "none");
		$(".formular_insert").css("display", "inline-block");
	});

});