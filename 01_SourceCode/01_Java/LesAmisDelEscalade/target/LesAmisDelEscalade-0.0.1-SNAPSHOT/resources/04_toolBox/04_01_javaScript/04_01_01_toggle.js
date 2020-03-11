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
