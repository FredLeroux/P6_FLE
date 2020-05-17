/**
 * 
 */


function newLink(){
	return this;
}


/**
 * 
 * @param newURL the URL to apply for subframe parent
 * @returns change the subframe location on click
 */
function addOnclickChangeParentLocation(elementId, newURL){
	var element = document.getElementById(elementId);
	element.setAttribute( "onclick", "changeParentLocation('"+newURL+"')")
	
}

function changeParentLocation(newURL){
	window.parent.location.href = newURL;
}


