function uploadFile() {
	jQuery.ajax({
		url: "http://localhost:8080/uploadForm",
		method: "GET"
	}).done(function(data) {
		jQuery("body").append(data);
	});
}

function destroy() {
    jQuery("#modal").remove();
    jQuery("#modal-background").remove();
}