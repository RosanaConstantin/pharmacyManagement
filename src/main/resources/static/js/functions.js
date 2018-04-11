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
    document.getElementById("parseButton").style.display = "block";
    document.getElementById("viewButton").style.display = "block";
    document.getElementById("uploadButton").style.marginTop = "0px";

	jQuery.ajax({
		url: "http://localhost:8080/selectForView",
		method: "GET"
	}).done(function(data) {
		jQuery("body").append(data);
	});
}
