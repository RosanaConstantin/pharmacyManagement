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

function sendFileToParse(string){
    jQuery.ajax({
  		url: "http://localhost:8080/parsed?filename=" + string.innerHTML,
  		method: "GET"
  	}).done(function(data) {
  		jQuery('body').empty();
        jQuery('body').append(data);
  	});
}
