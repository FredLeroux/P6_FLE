var cssRouteDesignation = null;
var cssRouteName = null;
var cssPitchDesignation = null;
var cssPitchNumber = null;
var cssCotationDesignation = null;
var cssCotationName = null;
var changePageLink = null;
var routeDesignation = null;
var pitchDesignation = null;
var cotationDesignation = null;

function newRoutesAndPitchsList() {
	return this;
}

function getCssRouteDesignation() {
	return cssRouteDesignation;
}

function setCssRouteDesignation(cssClassName) {
	cssRouteDesignation = cssClassName;
}

function getCssRouteName() {
	return cssRouteName;
}

function setCssRouteName(cssClassName) {
	cssRouteName = cssClassName;
}

function getCssPitchDesignation() {
	return cssPitchDesignation;
}

function setCssPitchDesignation(cssClassName) {
	cssPitchDesignation = cssClassName;
}

function getCssPitchNumber() {
	return cssPitchNumber;
}

function setCssPitchNumber(cssClassName) {
	cssPitchNumber = cssClassName;
}

function getCssCotationDesignation() {
	return cssCotationDesignation;
}

function setCssCotationDesignation(cssClassName) {
	cssCotationDesignation = cssClassName;
}

function getCssCotationName() {
	return cssCotationName;
}

function setCssCotationName(cssClassName) {
	cssCotationName = cssClassName;
}

function getChangePageLink() {
	return changePageLink
}

function setChangePageLink(controllerURL) {
	changePageLink = controllerURL;
}

function getRouteDesignation() {
	return routeDesignation;
}

function setRouteDesignation(designation) {
	routeDesignation = designation;
}

function getPitchDesignation() {
	return pitchDesignation;
}

function setPitchDesignation(designation) {
	pitchDesignation = designation;
}

function getCotationDesignation() {
	return cotationDesignation;
}

function setCotationDesignation(designation) {
	cotationDesignation = designation;
}

/**
 * 
 * @param elementId
 *            elementId the element Id wher to set the value
 * @param totalPagesNb
 *            the total pages number Integer|String
 * 
 */
function setTotalPages(elementId, totalPagesNb) {
	addTextToElement(elementId, totalPagesNb);
}
/**
 * 
 * @param elementId
 *            the element Id where to set the value
 * @param currentPageNb
 *            the current page Integer|String
 * 
 */
function setCurrentPage(elementId, currentPageNb) {
	addTextToElement(elementId, currentPageNb);
}

function getCurrentPage(elementID) {
	return getElementById(elementID).textContent;
}

function addTextToElement(id, text) {
	getElementById(id).innerHTML = text;
}

function getElementById(id) {
	return document.getElementById(id);
}
/**
 * 
 * @param prevButtonId
 * @param nextButtonId
 * @param isNext
 * @param currentPageId
 * @param totalPages
 * @param tableId
 * @needs setRouteDesignation(designation), setPitchDesignation(designation),
 *        setCotationDesignation(designation), setChangePageLink(controllerURL)
 *        implemented in jsp
 */
function setPageChangeActionElements(prevButtonId, nextButtonId, currentPageId,
		totalPages, tableId) {
	displayNextButton(nextButtonId, currentPageId, totalPages);
	displayPrevButton(prevButtonId, currentPageId);
	var route = getRouteDesignation();
	var pitch = getPitchDesignation();
	var cot = getCotationDesignation();

	var nextButton = getElementById(nextButtonId);
	nextButton.setAttribute("onclick", "changePage('" + tableId + "','" + route
			+ "','" + pitch + "','" + cot + "','" + currentPageId + "','"
			+ prevButtonId + "','" + nextButtonId + "','" + totalPages
			+ "', 'next')");
	var prevButton = getElementById(prevButtonId);
	prevButton.setAttribute("onclick", "changePage('" + tableId + "','" + route
			+ "','" + pitch + "','" + cot + "','" + currentPageId + "','"
			+ prevButtonId + "','" + nextButtonId + "','" + totalPages
			+ "', 'prev')");
	

}

function displayPrevButton(prevButtonId, currentPageId) {
	var button = getElementById(prevButtonId);
	if (getCurrentPage(currentPageId) == 1) {
		button.style.display = "none";
	} else {
		button.style.display = "block";
	}
}

function displayNextButton(nextButtonId, currentPageId, totalPages) {
	var button = getElementById(nextButtonId);
	if (getCurrentPage(currentPageId) == totalPages) {
		button.style.display = "none";
	} else {
		button.style.display = "block";
	}
}
/**
 * 
 * @param tableId
 * @param routeDesignation
 * @param pitchDesignation
 * @param cotationDesignation
 * @param currentPageID
 * @param nextOrPrev
 * @needs setChangePageLink(controllerURL) implemented in jsp
 */
function changePage(tableId, routeDesignation, pitchDesignation,
		cotationDesignation, currentPageId, prevButtonId, nextButtonId,
		totalPages, nextOrPrev) {
	
	var link = setControllerLink(currentPageId, nextOrPrev);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var obj = JSON.parse(this.responseText);
			removeBody(tableId);
			setCurrentPage(currentPageId, obj.page);
			displayNextButton(nextButtonId, currentPageId, totalPages);
			displayPrevButton(prevButtonId, currentPageId);
			setTable(obj.list, tableId, routeDesignation, pitchDesignation,
					cotationDesignation)
			
		}
	};
	xhttp.open("GET", link, true);
	xhttp.send();
}
/**
 * 
 * @param currentPageId
 * @param nextOrPrev
 * @use setChangePageLink(controllerURL)
 */
function setControllerLink(currentPageId, nextOrPrev) {
	return getChangePageLink().concat("?page=").concat(
			getCurrentPage(currentPageId)).concat("&to=").concat(nextOrPrev);

}

function removeBody(tableId) {
	var table = getTable(tableId);
	var body = getElementById("tableBody");
	table.removeChild(body);
}

function setTable(jsonArray, tableId, routeDesignation, pitchDesignation,
		cotationDesignation) {
	let table = getTable(tableId);
	var tBody = createTBody()
	let i = 0;
	for (i; i < jsonArray.length; i++) {
		var obj = jsonArray[i];
		appendRouteName(obj, tBody, routeDesignation, pitchDesignation,
				cotationDesignation);
		table.appendChild(tBody);
	}
}

function createTBody() {
	var tBody = document.createElement("tbody");
	tBody.id = "tableBody";
	return tBody;
}

function getTable(tableId) {
	return getElementById(tableId);
}

function appendRouteName(routeAndPitchsList, tBody, routeDesignation,
		pitchDesignation, cotationDesignation) {
	var tr = createTr();
	routeDesignationTd(tr, routeDesignation);
	routeNameTd(tr, routeAndPitchsList);
	tBody.appendChild(tr);
	appendPitchsListToRoute(routeAndPitchsList, tBody, pitchDesignation,
			cotationDesignation);

}

function routeDesignationTd(tr, routeDesignation) {
	var tdRD = createTd();
	addCss(getCssRouteDesignation(), tdRD);
	tdRD.innerHTML = routeDesignation;
	tr.appendChild(tdRD);
}

function routeNameTd(tr, routeAndPitchsList) {
	var tdRN = createTd();
	addCss(getCssRouteName(), tdRN)
	tdRN.innerHTML = routeAndPitchsList.routeName;
	tr.appendChild(tdRN);
}

function appendPitchsListToRoute(routeAndPitchsList, tBody, pitchDesignation,
		cotationDesignation) {
	var array = routeAndPitchsList.pitchsList;
	let i = 0;
	for (i; i < array.length; i++) {
		var trP = createTr();
		tdEmpty(trP);
		tdEmpty(trP);
		pitchDesignationTd(trP, pitchDesignation);
		pitchNumberTd(trP, array, i);
		cotationDesignationTd(trP, cotationDesignation);
		cotationTd(trP, array, i);
		tBody.appendChild(trP);
	}
}

function tdEmpty(tr) {
	var tdEmpty = createTd();
	tr.appendChild(tdEmpty)
}

function pitchDesignationTd(tr, pitchDesignation) {
	var tdPD = createTd();
	addCss(getCssPitchDesignation(), tdPD);
	tdPD.innerHTML = pitchDesignation;
	tr.appendChild(tdPD);
}

function pitchNumberTd(tr, array, i) {
	var tdPNb = createTd();
	addCss(getCssPitchNumber(), tdPNb);
	tdPNb.innerHTML = array[i].pitchNumber;
	tr.appendChild(tdPNb);

}

function cotationDesignationTd(tr, cotationDesignation) {
	var tdCD = createTd();
	addCss(getCssCotationDesignation(), tdCD);
	tdCD.innerHTML = cotationDesignation;
	tr.appendChild(tdCD);
}

function cotationTd(tr, array, i) {
	var tdPCo = createTd();
	addCss(getCssCotationName(), tdPCo);
	tdPCo.innerHTML = array[i].pitchClimbingLevels;
	tr.appendChild(tdPCo);
}

function createTr() {
	return document.createElement("tr");
}

function createTd() {
	return document.createElement("td");
}

function addCss(cssClass, td) {
	if (cssClass !== null) {
		td.setAttribute("class", cssClass);
	}
}
