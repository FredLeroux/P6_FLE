/**
 * 
 */
var isDisplayed = false;

function toggle() {
	return this;
}

function toggleDisplay(elementId) {
	var element = document.getElementById(elementId);
	if (element.style.display === "none") {
		element.style.display = "block";
	} else {
		element.style.display = "none";
	}
}

/**
 * 
 * @param elementId
 * @allows to display or hide an element plus set the boolean "isDisplayed" to
 *         true if displayed , false if not
 */
function toggleDisplaySetBoolean(elementId) {
	var element = document.getElementById(elementId);
	if (element.style.display === "none") {
		element.style.display = "block";
		isDisplayed = true;
	} else {
		element.style.display = "none";
		isDisplayed = false;
	}

}

function togglecolor(elementId, basis, invert) {
	var element = document.getElementById(elementId);
	if (isDisplayed === true) {
		element.setAttribute("class", invert);
	} else {
		element.setAttribute("class", basis);
	}
}

function addToggleDisplayOnClick(ownerId, elementToToggleId) {
	var element = document.getElementById(ownerId);	
	element.setAttribute("onclick", "toggleDisplay('" + elementToToggleId
			+ "')");
}



function addToggleDisplayOnClickAndClearError(ownerId, elementToToggleId,errorLoc) {
	var element = document.getElementById(ownerId);	
	element.setAttribute("onclick", "toggleDisplay('" + elementToToggleId
			+ "'),clearError('"+errorLoc+"')");
}

function clearError(errorLoc){
	var errro = document.getElementById(errorLoc);
	error.innerHTML="";
}


/**
 * 
 * @param statusId is the status to check in order to switch the onclick command
 * @param ownerId is the owner div
 * @param elementToToggleId is the element to toggle display
 * @param switchValue is the other value to swith on function of status
 * @returns for example if status is false display modal , if status is true display another page via href
 */
function addSwitchAndToggleDisplayOnClick(statusId,ownerId, elementToToggleId,switchValue) {
	var element = document.getElementById(ownerId);
	var status = document.getElementById(statusId);	
	if(status.textContent === "true"){
		element.setAttribute("onclick", "href('"+switchValue+"')")
	}else{
	element.setAttribute("onclick", "toggleDisplay('" + elementToToggleId
			+ "')");}
}

function href(loc){
	return location.href = loc;
}

/**
 * 
 * @param onclickOwnerElementId
 *            the element onclick function owner
 * @param toggleDisplayElementId
 *            the element to toggle display
 * @param toggleColorElementId
 *            the element to toggle colorSet (i.e color, color:hover)
 * @param basisColorSet
 *            the basis colorSet
 * @param invertColorSet
 *            the invert (or another) colorSet
 * @allows display on click in elementId to display/hide a particular element(
 *         as well as change toggle
 */
function addToggleDisplayAndColorOnclick(onclickOwnerElementId,
		toggleDisplayElementId, toggleColorElementId, basisColorSet,
		invertColorSet) {
	var element = document.getElementById(onclickOwnerElementId);

	element.setAttribute("onclick", "toggleDisplaySetBoolean('"
			+ toggleDisplayElementId + "'),togglecolor('"
			+ toggleColorElementId + "','" + basisColorSet + "','"
			+ invertColorSet + "')");
}
/**
 * 
 * @param elementToCheckEmptyness
 * @param elementToToggleDisplay
 * @returns check if the elementToCheckEmptyness is empty if false the display element to toggle display
 */
function displayOnError(elementToCheckEmptyness, elementToToggleDisplay){
	var error =document.getElementById(elementToCheckEmptyness);
	bool = error.textContent.length === 0;	
	if(bool === false){
	var modal = document.getElementById(elementToToggleDisplay);
	modal.style.display = "block";
		}
}	
