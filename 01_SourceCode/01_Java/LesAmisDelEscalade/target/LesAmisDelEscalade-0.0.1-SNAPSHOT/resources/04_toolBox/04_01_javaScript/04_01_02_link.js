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
	elment.setAttribute( "onclick", "changeParentLocation('"+newURL+"')")
	
}

function ChangeParentLocation(newURL){
	window.parent.location.href = newURL;
}


