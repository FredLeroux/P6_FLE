var pageSelected = null;
var pageLink = null;
var resultsMaxFormAction = null;
var selectedPageCssClass = null;
var previousCssClass = null;
var nextCssClass = null;

function getPageSelected() {
	return pageSelected;
}

function setPageSelected(page) {
	pageSelected = page;
}

function getPageLink() {
	return pageLink;
}

/**
 * 
 * @param link 
 * @param parameter 
 * @example: link = 'pageSelected', parameter = '?page=' give pageSelected?page=' as final link 
 */
function setPageLink(link, parameter) {
	pageLink = link.concat(parameter);
}

function getResultsMaxFormAction() {
	return resultsMaxFormAction;
}

function setResultsMaxFormAction(formAction) {
	resultsMaxFormAction = formAction;
}

function getSelectedPageCssClass() {
	return selectedPageCssClass;
}

function setSelectedPageCssClass(cssClass) {
	selectedPageCssClass = cssClass;
}

function getPreviousCssClass() {
	return previousCssClass;
}

function setPreviousCssClass(cssClass) {
	previousCssClass = cssClass;
}

function getNextCssClass() {
	return nextCssClass;
}

function setNextCssClass(cssClass) {
	nextCssClass = cssClass;
}

function setpageAndResultsMax() {
	return this;
}

function setResultsPerPagesList(locationId, resultsPerPagesList,
		resultsPerPagesSelected) {
	var loc = document.getElementById(locationId);
	var br = document.createElement("br");
	for (i = 0; i < resultsPerPagesList.length; i++) {
		var checkmark = document.createElement("span");
		var inputRadio = document.createElement("input");
		var label = document.createElement("label");
		var rowsPerpageValue = resultsPerPagesList[i];
		label.setAttribute("class", "container");
		checkmark.setAttribute("class", "checkmark");
		inputRadio.type = "radio";
		inputRadio.value = rowsPerpageValue;
		label.innerHTML = rowsPerpageValue;
		inputRadio.setAttribute("onclick", "sendResultsPerPages("
				+ rowsPerpageValue + ",'" + getResultsMaxFormAction() + "')");
		label.appendChild(inputRadio);
		label.appendChild(checkmark);
		loc.appendChild(label);
		bool = resultsPerPagesSelected == rowsPerpageValue
		if (bool) {
			inputRadio.checked = true;
		}
	}
}

/**
 * @Note method using getFormACtion wich allow to custom action via
 *       setFormAction idem method
 * @param rowsPerPagesNb
 * @returns
 */
function sendResultsPerPages(rowsPerPagesNb, action) {
	var rowsPerPages = document.createElement("input");
	var form = document.createElement("form");
	form.type = "hidden";
	form.action = action;
	form.method = getFormMethod();
	rowsPerPages.type = "hidden";
	rowsPerPages.name = "rowsPerPages";
	rowsPerPages.value = rowsPerPagesNb;
	form.appendChild(rowsPerPages);
	anchorage().appendChild(form);
	form.submit();

}

function pageNavigation(locationId, prevLocationId, nextLocationId, navArray) {
	var loc = document.getElementById(locationId);
	var bool = navArray.includes("empty");
	var prevLoc = document.getElementById(prevLocationId);
	var nextLoc = document.getElementById(nextLocationId);
	if (!bool) {
		for (let i = 0; i < navArray.length; i++) {
			var num = Number(navArray[i]);
			var link = document.createElement("a");
			link.id = "goToPage" + navArray[i];
			link.setAttribute("href", getPageLink() + navArray[i]);
			link.innerHTML = " " + navArray[i] + " ";
			if (getPageSelected() == navArray[i]) {
				link.setAttribute("class", getSelectedPageCssClass());
			}
			loc.appendChild(link);
		}

	}

}

function setPageJump(LocationId, pageJump) {
	bool = pageJump.includes("empty");
	var pageNav = document.getElementById(LocationId);
	if (!bool) {
		for (let i = 0; i < pageJump.length; i++) {
			split = pageJump[i].split("=");
			var jump = document.getElementById(split[0]);
			if (parseInt(split[1]) != 0) {
				jump.style.display = "block";
				jump.href = getPageLink()
						+ (getPageSelected() + parseInt(split[1]));

			} else {
				jump.style.display = "none";
			}
		}
	}
}


