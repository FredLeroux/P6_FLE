/**
 *
 */

function newLink() {
	return this;
}

/**
 *
 * @param newURL
 *            the URL to apply for subframe parent
 * @returns change the subframe location on click
 */
function addOnclickChangeParentLocation(elementId, newURL) {
	var element = document.getElementById(elementId);
	element.setAttribute("onclick", "changeParentLocation('" + newURL + "')")

}

function addOnclickChangeLocation(elementId, newUrl) {
	var element = document.getElementById(elementId);
	element.setAttribute("onclick", "changeLocation('" + newUrl + "')");
}

function navBack(backUrl){
	changeLocation(backUrl);
}

function navTo(toUrl){
	changeLocation(toUrl);
}

function parentNavTo(toUrl){
	changeParentLocation(toUrl);
}

function changeLocation(url){
	location.href=url;
}

function changeParentLocation(url){
	window.parent.location.href=url;
}

/**
 *
 * @param elementId
 * @param formName
 * @param formAction
 * @returns change the form (formName) action by the form action allow to send
 *          to another controller than final on element onclick event
 */
function addOnclicksubmitFormIntermediateController(elementId, formName,
		formAction) {
	var element = document.getElementById(elementId);
	element.setAttribute("onclick", "submitForm('" + formName + "','"
			+ formAction + "')");
}

function addOnclickPostRequest(elementID,postUrl){
	var element = document.getElementById(elementID);
	element.type ="submit";
	element.value = postUrl;
}

function changeParentLocation(newURL) {
	window.parent.location.href = newURL;
}

function changeLocation(newUrl) {
	window.location.href = newUrl;
}

function submitForm(formName, formAction) {
	var form = document.getElementById(formName);
	form.action = formAction;
	form.submit();
}
