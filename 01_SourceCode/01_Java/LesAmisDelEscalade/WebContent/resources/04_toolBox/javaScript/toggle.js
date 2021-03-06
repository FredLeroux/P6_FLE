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

function addToggleDisplayOnClickAndClearError(ownerId, elementToToggleId,
		errorLoc,passElmtId,visibilityElemtId) {
	var element = document.getElementById(ownerId);
	element.setAttribute("onclick", "toggleDisplay('" + elementToToggleId
			+ "'),clearError('" + errorLoc + "'),hidePass('"+passElmtId+"','"+visibilityElemtId+"')");
}

function clearError(errorLoc) {
	var errro = document.getElementById(errorLoc);
	error.innerHTML = "";
}

/**
 *
 * @param statusId
 *            is the status to check in order to switch the onclick command
 * @param ownerId
 *            is the owner div
 * @param elementToToggleId
 *            is the element to toggle display
 * @param newHrefValue
 *            is the new href value to swith on function of status
 * @returns for example if status is false onclick will display modal , if status is true
 *         onclick will follow newHrefValue
 */
function addSwitchAndToggleDisplayOnClick(statusId, ownerId, elementToToggleId,
		newHrefValue) {
	var element = document.getElementById(ownerId);
	var status = document.getElementById(statusId);
		if (status.value=="true") {
		element.setAttribute("onclick", "href('" + newHrefValue + "')")
	} else {
		element.setAttribute("onclick", "toggleDisplay('" + elementToToggleId
				+ "')");
	}
}

function href(loc) {
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
 * @returns check if the elementToCheckEmptyness is empty if false the display
 *          element to toggle display
 */
function displayOnError(elementToCheckEmptyness, elementToToggleDisplay) {
	var error = document.getElementById(elementToCheckEmptyness);
	bool = error.textContent.length === 0;
	if (bool === false) {
		var modal = document.getElementById(elementToToggleDisplay);
		modal.style.display = "block";
	}
}

/**
 *
 * @param elementId iframe parent element to toggle display
 * @apiNote allow to toggle display an iframe parent element
 */
function parentElementToggleDisplay(elementId) {
	var element = window.parent.document.getElementById(elementId);
	if (element.style.display === "none") {
		element.style.display = "block";
	} else {
		element.style.display = "none";
	}

}

function addToElementToggleParentElementDisplayOnClick(elementToAddOnclick,
		elementToToggleId) {
	var element =document.getElementById(elementToAddOnclick);
	element.setAttribute("onclick", "parentElementToggleDisplay('"
			+ elementToToggleId + "')");

}

function addOnclickTogglePassVisibility(passElmtId,visibilityElemtId){
	visibilityElmt(visibilityElemtId).setAttribute("onclick","togglePassVisibility('"+passElmtId+"','"+visibilityElemtId+"')");
}

function passElmt(passElmtId) {
	return document.getElementById(passElmtId);
}
function visibilityElmt(visibilityElemtId) {
	return document.getElementById(visibilityElemtId);
}
function togglePassVisibility(passElmtId,visibilityElemtId) {
	if (passElmt(passElmtId).type == "password") {
		passElmt(passElmtId).type = "text";
		visibilityElmt(visibilityElemtId).className = "fas fa-eye-slash";
	} else {
		passElmt(passElmtId).type = "password";
		visibilityElmt(visibilityElemtId).className = "fas fa-eye";
	}
}

function hidePass(passElmtId,visibilityElemtId){
	if (passElmt(passElmtId).type == "text") {
		passElmt(passElmtId).type = "password";
		visibilityElmt(visibilityElemtId).className = "fas fa-eye";
	}
}

/**
 *
 * @param elemtToToggleClassLoc
 * @param classCss1
 * @param classCss2
 * @returns if elemtToToggleClassLoc class = classCss2 toggle to classCss1
 */
function toggleClassCss(elemtToToggleClassLoc,classCss1,classCss2){
	var toToggleClass = document.getElementById(elemtToToggleClassLoc);
	if(toToggleClass.getAttribute("class").includes(classCss2)){
		toToggleClass.setAttribute("class", classCss1);
	}
}


