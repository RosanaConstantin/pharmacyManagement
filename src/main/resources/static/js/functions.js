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
     jQuery("#modal_select").remove();
    jQuery("#modal-background").remove();
}


function selectFile() {
	jQuery.ajax({
		url: "http://localhost:8080/selectForView",
		method: "GET"
	}).done(function(data) {
		jQuery("body").append(data);
	});
}
