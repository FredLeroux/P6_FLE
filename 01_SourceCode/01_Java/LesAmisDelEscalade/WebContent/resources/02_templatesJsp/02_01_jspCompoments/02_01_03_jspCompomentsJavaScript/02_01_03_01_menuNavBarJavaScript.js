function toggleDisplay(elementId) {
	var element = document.getElementById(elementId);
	if (element.style.display === "none") {
		element.style.display = "block";
	} else {
		element.style.display = "none";
	}
}

function addToggleDisplayOnclick(elementId,elementToToggleId){
	var element = document.getElementById(elementId);
	element.setAttribute("onclick", "toggleDisplay('"+elementToToggleId+"')");
}