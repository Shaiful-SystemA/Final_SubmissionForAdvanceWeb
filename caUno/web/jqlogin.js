$(function() {

	$("#loginBtn").on("click", function() {
		$.get("authenticate", {
			username: $("#username").val(),
			password: $("#password").val()
		}).done(function() {
			$("#status").text("Login successful");
		}).fail(function() {
			$("#status").text("Incorrect login");
		})
	});

	$("#logoutBtn").on("click", function() {
		$.post("logout")
			.done(function() {
				$("#status").text("Logout successful");
			}).fail(function() {
				$("#status").text("Logout failed");
			})
	})
});
