function onclickFunction(){
	return this;
}


function changePage(elementId, newURL) {
	var element = document.getElementById(elementId);	
	addOnclickChangeParentLocation(element, newURL);	
}



function reload(elementId) {
	var element = document.getElementById(elementId);
	element.setAttribute( "onclick", "window.parent.location.reload()");	
}


function addOnclickChangeParentLocation(element, newURL){	
	//element.setAttribute( "onclick", "changeParentLocation('"+newURL+"')")
	
}

function changeParentLocation(newURL){
	window.parent.location.href = newURL;
}

function href(codeKeyContainerId){
	var hrefCodeKey = document.getElementById(codeKeyContainerId);
	return hrefCodeKey.textContent;
}