
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
function changePage(locId, routeDesignation, pitchDesignation,
		cotationDesignation, currentPageId, prevButtonId, nextButtonId,
		totalPages, nextOrPrev) {

	var link = setControllerLink(currentPageId, nextOrPrev);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var obj = JSON.parse(this.responseText);
			removeThumbnail(locId);
			setCurrentPage(currentPageId, obj.page);
			displayNextButton(nextButtonId, currentPageId, totalPages);
			displayPrevButton(prevButtonId, currentPageId);
			setTable(obj.list, locId, routeDesignation, pitchDesignation,
					cotationDesignation)
			var div = document.getElementById(locId);
			var tables = div.getElementsByTagName("table");
			let i = 0;
			for(i;i<tables.length;i++){
				let obj = tables[i];
				obj.setAttribute("class", "thumbnail");
			}

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


function removeThumbnail(locId){
	var loc = getElementById(locId)

	while(loc.firstChild){
		loc.removeChild(loc.firstChild);
	}
}

function setTable(jsonArray, locId, routeDesignation, pitchDesignation,
		cotationDesignation,cssClass) {
		addThumbnail(locId, jsonArray, routeDesignation, pitchDesignation, cotationDesignation,cssClass);
}

function addThumbnail(locId,jsonArray,routeDesignation, pitchDesignation,
		cotationDesignation,cssClass){
	var thumbnailLoc = getElementById(locId);
	let i = 0;
	for (i; i < jsonArray.length; i++) {
		var obj = jsonArray[i];
		var table = createTable(cssClass);
		createThumbnail(table,obj,routeDesignation,pitchDesignation,cotationDesignation);
		thumbnailLoc.appendChild(table);
		thumbnailLoc.appendChild(document.createElement("br"));
	}

}

function createThumbnail(table,routesAndPitchsListArray,routeDesignation,pitchDesignation,cotationDesignation){
	createRouteNameTable(table, routeDesignation, routesAndPitchsListArray);
	createPitchsAndCotationList(table, pitchDesignation, cotationDesignation,routesAndPitchsListArray);
}

function createRouteNameTable(table,routeDesignation,routesAndPitchsListArray){
	let thead = createTHead();
	let tbody = createTBody();
	let trHead = createTr();
	let trBody = createTr();
	let tdHead = createTh(routeDesignation);
	let tdBody = createTd(routesAndPitchsListArray.routeName);
	tdHead.id="routeTdHead";
	tdBody.id="routeTdBody";
	trHead.appendChild(tdHead);
	thead.appendChild(trHead);
	table.appendChild(thead);
	trBody.appendChild(tdBody);
	tbody.appendChild(trBody);
	table.appendChild(tbody);
}

function createPitchsAndCotationList(table,pitchDesignation, cotationDesignation,routesAndPitchsListArray){
	createPitchsAndCotationListHead(table,pitchDesignation, cotationDesignation);
	createPitchsAndCotationListBody(table, routesAndPitchsListArray);
}

function createPitchsAndCotationListHead(table,pitchDesignation, cotationDesignation){
	let thead = createTHead();
	let trHead = createTr();
	trHead.appendChild(createTh(pitchDesignation))
	trHead.appendChild(createTh(cotationDesignation))
	thead.appendChild(trHead);
	table.appendChild(thead);
}

function createPitchsAndCotationListBody(table,routesAndPitchsListArray){
	let array = routesAndPitchsListArray.pitchsList;
	let tbody = createTBody();
	let i = 0;
	for (i; i < array.length; i++) {
		let trBody = createTr();
		trBody.appendChild(createTd(array[i].pitchNumber));
		trBody.appendChild(createTd(array[i].pitchClimbingLevels));
		tbody.appendChild(trBody);
	}
	table.appendChild(tbody);
}

function createTable(cssClass){
	var table = document.createElement("table");
	table.setAttribute("class", cssClass);
	return table;
}

function createTHead(){
	var tHead = document.createElement("thead");
	return tHead;
}


function createTBody() {
	var tBody = document.createElement("tbody");
	return tBody;
}

function createTr(){
	var row = document.createElement("tr");
	return row;
}

function createTh(cellValue){
	var th = document.createElement("th");
	th.innerHTML= cellValue;
	return th;
}

function createTd(tdcellValue){
	var td = document.createElement("td");
	td.innerHTML= tdcellValue;
	return td;
}


