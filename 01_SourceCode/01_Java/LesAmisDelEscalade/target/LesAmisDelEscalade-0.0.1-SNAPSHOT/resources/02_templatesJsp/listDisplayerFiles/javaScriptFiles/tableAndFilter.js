/**
 *
 */
var anchor = null;
var formAction = null;
var formMethod = null;
var storedFilterArrayName = null;
var model = null;
var columnsFieldAndIname = [];
var operatorSignAndIname = [];
var dataToSend = {};
var filterSettedFromBackEnd = {};
var anchorId = null;
var loaderLocId = null;
var objectToHideId = null;
var criteria = null;
var splitter = null;
var orderLink = null;
var editHandler = null;



function setEditHandlerName(editHandlerName){
	editHandler = editHandlerName;
}

function getEditHandlerName(){
	return editHandler;
}

function getOrderLink(){
	return orderLink;
}

function setOrderLink(getOrderLink){
	orderLinlk = getOrderLink;
}


function getSplitter() {
	return splitter;
}

/**
 *
 * @param separatorSign
 *            is the sign wich separe the element of a string i.e. <br>
 *            in a string composed of 3 elements like<br>
 *            string str = "element1/element2/element3"<br>
 *            the separator(splitter) is "/".<br>
 *            this separator is to be used in string.split(separator) in order
 *            to create an Array containing each elements separated by separator
 *            in our example if <br>
 *            with str.split("/")<br>
 *            this will return an Array with at<br>
 *            index 0 "element1"<br>
 *            index 1 "element2" <br>
 *            etc...
 *
 */
function setSplitter(separatorSign) {
	splitter = separatorSign;

}

function setCriteria(criteriaToSend) {
	criteria = criteriaToSend;
}

function getCriteria() {
	return criteria;
}

function setLoaderLocId(loaderLocationId) {
	loaderLocId = loaderLocationId;
}

function getLoaderLocId() {
	return loaderLocId;
}

function setObjectToHideId(objectToHideLocation) {
	objectToHideId = objectToHideLocation;
}

function getObjectToHideId() {
	return objectToHideId;
}

function setAnchorId(anchorLocationID) {
	anchorId = anchorLocationID;
}

function getAnchorId() {
	return anchorId;
}

function anchorage() {
	anchor = document.getElementById(getAnchorId());
	return anchor;
}

function setNewTable() {
	return this;
}

function setFormAction(action) {
	formAction = action;

}

function getFormAction() {
	return formAction;
}

function setFormMethod(method) {
	formMethod = method;
}

function getFormMethod() {
	return formMethod;
}

function setStoredFilterArrayName(filterArrayName) {
	storedFilterArrayName = filterArrayName;
}

function getStoredFilterArrayName() {
	return storedFilterArrayName;
}

function getDataTosend() {
	return dataToSend;
}

function addFilterArrayToDataToSend(storedFilterArrayName) {
	storedFilterArrayName = [];
	dataToSend.push(storedFilterArrayName);
}

function setFilterSettedFromBackEnd(filterSettedAttribute) {
	filterSettedFromBackEnd = filterSettedAttribute;
}
function getFilterSettedFromBackEnd() {
	return filterSettedFromBackEnd;
}

/**
 * <p>
 *
 * @Note this function will iterate througth the infoArray, each string will be
 *       splitted based on the separator, and function will set an array
 *       containing the data at: string split array[dataIndex1] + separator +
 *       and string split array[dataIndex2], will also avoid any duplicates
 *       present in the infoarray.
 *       </p>
 *
 * <p>
 * @param infoArray
 *            array containing elements of interest in a string.<br>
 * @param dataIndex1
 *            is the index of the first data of interest issue of an array
 *            create from a string split <br>
 * @param dataIndex2
 *            is the index of the second data of interest issue of an array
 *            create from a string split<br>
 *            </p>
 * @returns an array(extractedInfoArray) whithout duplicates composed of string
 *          containing dataIndex1 + separator + dataIndex2 from an iteration on
 *          infoArray<br>
 *          (the new string create in the new array(extractedInfoArray) returned
 *          will use the same separator as the one use in info array)
 */

function extractInfo(infoArray, dataIndex1, dataIndex2, separator) {
	var transientArray = [];
	var infoExtractedArray = [];
	var fieldName = null;
	for (i = 0; i < infoArray.length; i++) {
		filterSplit = infoArray[i].split(separator);
		if(filterSplit[dataIndex1].includes("notAFilter")){
			var fieldSplit = filterSplit[dataIndex1].split(".");
			fieldName = fieldSplit[0];
		}else{
			fieldName = filterSplit[dataIndex1];
		}
		transientArray.push(fieldName + separator
				+ filterSplit[dataIndex2]);
	}
	for (j = 0; j < transientArray.length; j++) {
		bool = infoExtractedArray.includes(transientArray[j]);
		if (!bool) {
			infoExtractedArray.push(transientArray[j]);
		}
	}
	return infoExtractedArray;
}


function createTable(tableId) {
	var table = document.createElement("table");
	table.id = tableId;
	return table;
}

/**
 *
 * @param infoArray
 *            array containing column info containing strings composed of field
 *            names and Internationalized names to display in frontend from
 *            backend.
 *
 * @returns an array containing strings composed of field names /
 *          Internationalized names to display without duplicates.
 */

/**
 *
 * @param infoArray
 *            array containing column info containing strings composed of field
 *            names and Internationalized names to display in frontend from
 *            backend.
 * @param dataIndex1
 *            for a string in infoArray as "country/France/=/equals to", Column
 *            Field Name "country" ColumnFieldNameIndex = 0
 *
 * @param dataIndex2
 *            dataIndex1 for a string in infoArray as "country/France/=/equals
 *            to", Column I18N Name "France" dataIndex 2 = 1
 * @param separator
 * @returns an array containing strings composed of field names /
 *          Internationalized names to display without duplicates.
 */
function setColumnsFieldAndIname(infoArray, columnFieldNameIndex,
		columnI18NNameIndex, splitter) {
	columnsFieldAndIname = extractInfo(infoArray, columnFieldNameIndex,
			columnI18NNameIndex, splitter);
}

function getColumnsFieldAndIname() {
	return this.columnsFieldAndIname;
}

/**
 *
 * @param infoArray
 *            array containing column info containing strings composed of field
 *            names and Internationalized names to display in frontend from
 *            backend.
 * @param dataIndex1
 *            for a string in infoArray as "country/France/=/equals to",
 *            Operator "=" operatorIndex 1 = 2
 *
 * @param dataIndex2
 *            dataIndex1 for a string in infoArray as "country/France/=/equals
 *            to", Operator I18N Name "equals to" operatorI18NNameIndex = 3
 * @param separator
 * @returns an array containing strings composed of field names /
 *          Internationalized names to display without duplicates.
 */
function setOperatorSignAndIname(infoArray, operatorIndex,
		operatorI18NNameIndex, splitter) {
	operatorSignAndIname = extractInfo(infoArray, operatorIndex,
			operatorI18NNameIndex, splitter);
}

function getOperatorSignAndIname() {
	return this.operatorSignAndIname;
}

function addInputColumnNames(columnName, idNb) {
	var input = document.createElement("input");
	input.type = "hidden";
	input.id = "columnName" + idNb;
	input.name = "orderBy";
	input.setAttribute("value", columnName)
	return input;

}

function addSortButton(sortWay, idNb, columnValue) {
	var a = document.createElement("a");
	a.name = "sortWay";
	var link =  getOrderLink() + "?column=" + columnValue + "&orderWay=";
	if (sortWay === "asc") {
		a.id = "sortButtonAsc" + idNb;
		a.innerHTML = "\u25b2";
		a.setAttribute("href", link + "asc");
	} else if (sortWay === "desc") {
		a.id = "sortButtonDesc" + idNb;
		a.innerHTML = "\u25bc";
		a.setAttribute("href", link + "desc");
	} else {
		throw "function accept only \"asc\" or \"desc\"";
	}
	return a;
}

function addSortButtonOld(sortWay, idNb, columnNameId) {
	var button = document.createElement("button");
	button.name = "sortWay";
	if (sortWay === "asc") {
		var column = columnNameId;
		var id = button.id = "sortButtonAsc" + idNb;
		button.innerHTML = "\u25b2";
		button.setAttribute("value", "asc");
	} else if (sortWay === "desc") {
		var id = button.id = "sortButtonDesc" + idNb;
		button.innerHTML = "\u25bc";
		button.setAttribute("value", "desc");
	} else {
		throw "function accept only \"asc\" or \"desc\"";
	}
	button.setAttribute("onclick", "submitSortingAndtblFilterArray('"
			+ getFormAction() + "','" + formMethod + "','" + id + "','"
			+ columnNameId + "')");
	return button;
}

function submitSortingAndtblFilterArray(action, method, buttonId, columnNameId) {
	var form = document.createElement("form");
	var sortWay = document.createElement("input");
	var columnSort = document.createElement("input");
	var filters = document.createElement("input");
	sortWay.name = document.getElementById(buttonId).name;
	sortWay.setAttribute("value", document.getElementById(buttonId).value)
	columnSort.name = document.getElementById(columnNameId).name;
	columnSort.setAttribute("value",
			document.getElementById(columnNameId).value);
	filters.name = getStoredFilterArrayName();
	filters.setAttribute("value", JSON.stringify(getFilterSettedFromBackEnd()));
	form.appendChild(sortWay);
	form.appendChild(columnSort);
	form.appendChild(filters);
	form.action = action;
	form.method = method;
	anchorage().appendChild(form);
	setObjectToHideId(null);
	loader();
	form.submit();
}

function createTableHead(table) {
	var tableHead = table.createTHead();// not in auto completion this html 5
	tableHead.id = "tableHead";
	var tableHeadRow = tableHead.insertRow();// not in auto completion this
	// html 5
	for (i = 0; i < getColumnsFieldAndIname().length; i++) {
		var tableHeadRowCell = document.createElement("th");// not in auto
		// completion this
		// html 5
		var infoSplit = getColumnsFieldAndIname()[i].split(getSplitter());
			var column = addInputColumnNames(infoSplit[0], i)
			tableHeadRowCell.innerHTML = infoSplit[1];
			tableHeadRowCell.appendChild(column);
			tableHeadRowCell.appendChild(addSortButton("asc", i, column.value));
			tableHeadRowCell.appendChild(addSortButton("desc", i, column.value));
			tableHeadRow.appendChild(tableHeadRowCell);
	}
}

function getRowObjectId(id) {

	if(getEditHandlerName()!="none"){
	sendRowIdToBacKEnd(id);
	}
}

function sendRowIdToBacKEnd(id){
	var form = document.createElement("form");
	form.action = getEditHandlerName()+"/"+id;
	form.method = getFormMethod();
	anchorage().appendChild(form);
	form.submit();
}

function createTableBody(table, data, idName) {
	var dataUsed = null;
	dataUsed = data;
	var tableBody = table.createTBody();
	var i = 0;
	for (i = 0; i < dataUsed.length; i++) {
		var row = tableBody.insertRow();
		row.id = "trSendId" + dataUsed[i][idName];
		row.setAttribute("onclick", "getRowObjectId(" + dataUsed[i][idName] + ")");
		for (j = 0; j < getColumnsFieldAndIname().length; j++) {
			var infoSplit = getColumnsFieldAndIname()[j].split(getSplitter());
			var arrayName = infoSplit[0];// arrayName is used to call the
											// array contained in data JSONArray
											// from backend
			var cell = tableBody.rows[i].insertCell();
			cell.innerHTML = dataUsed[i][arrayName];
		}
	}

}

// * = DOM HTML5 not in autocompletion

function generateTable(LocToSetTableId, tableID, data, cssStyle, idName) {
	var dataToLoad = null;
	dataToLoad = data;
	bool = dataToLoad.includes("empty")
	if (!bool) {
		var table = createTable(tableID);
		createTableHead(table)
		createTableBody(table, dataToLoad, idName);
		table.setAttribute("class", cssStyle)
		document.getElementById(LocToSetTableId).innerHTML = "";
		// erase message
		// when table is
		// created
		return document.getElementById(LocToSetTableId).appendChild(table);
	}
}


/**
 *
 * @param dipslayLocation
 * @param infotable
 * @param style
 * @returns
 */
function displayFilterSetted(dipslayLocation, infotable, style) {
	var obj = this.filterSettedFromBackEnd;
	for (var i = 0; i < obj.length; i++) {
		var str = obj[i];
		if (str === "empty") {
			str = null;
		}
		if (str !== null) {
			createFilterAppliedList(str, infotable, getSplitter(),
					dipslayLocation, "a", style);
		}
	}
}

function createFilterAppliedList(str, infoArray, separator, locationId,
		tagName, displayClass) {
	var filterAppliedListLoc = document.getElementById(locationId);
	var categoryList = filterAppliedListLoc.getElementsByTagName(tagName);
	var categoryListIdArray = [];
	for (let n = 0; n < categoryList.length; n++) {
		categoryListIdArray.push(categoryList[n].id);
	}
	var displayName = null;
	var operator = getOperatorSignAndIname();
	var strSplitArray = str.split(separator);
	var filterAppliedListLoc = document.getElementById(locationId);
	var category = createCategory(tagName, strSplitArray, displayClass);
	if (categoryListIdArray.length == 0) {
		displayName = filterIname(infoArray, separator, strSplitArray) + " "
				+ operatorIname(operator, separator, strSplitArray);
		category.innerHTML = displayName;
		filterAppliedListLoc.appendChild(category);
		addFilterButton(str, categoryList, separator);
	} else {
		for (let i = 0; i < categoryListIdArray.length; i++) {
			var stringbuild = strSplitArray[0] + strSplitArray[1];
			let bool = categoryListIdArray[i].valueOf() === stringbuild
					.valueOf();
			if (bool) {
				var filter = createFilterButton(str);
				var add = document.getElementById(categoryListIdArray[i]);
				add.appendChild(filter)
			} else {
				let bool1 = categoryListIdArray.includes(stringbuild.valueOf());
				if (!bool1) {
					displayName = filterIname(infoArray, separator,
							strSplitArray)
							+ " "
							+ operatorIname(operator, separator, strSplitArray);
					category.innerHTML = displayName;
					filterAppliedListLoc.appendChild(category);
					addFilterButton(str, categoryList, separator);

				}

			}
		}
	}
}

function createCategory(tagName, strSplitArray, displayClass) {
	var category = document.createElement(tagName);
	category.id = strSplitArray[0] + strSplitArray[1];
	category.setAttribute("class", displayClass);
	return category;
}

function operatorIname(operatorSignAndIname, separator, strSplitArray) {
	for (let i = 0; i < operatorSignAndIname.length; i++) {
		operatorSplit = operatorSignAndIname[i].split(separator);
		let bool = strSplitArray[1].valueOf() === operatorSplit[0].valueOf();
		if (bool) {
			var operatorName = operatorSplit[1];
		}
	}
	return operatorName;

}

function filterIname(infoArray, separator, strSplitArray) {
	for (let j = 0; j < infoArray.length; j++) {
		var infoArraySplit = infoArray[j].split(separator);
		var stringbuild1 = strSplitArray[0] + strSplitArray[1];
		var stringbuild2 = infoArraySplit[0] + infoArraySplit[2];
		var bool = stringbuild1.valueOf() === stringbuild2.valueOf();
		if (bool) {
			var filterName = infoArraySplit[1];
		}
	}
	return filterName;
}

function addFilterButton(str, categoryList, separator) {
	var strSplit = str.split(separator);
	for (let i = 0; i < categoryList.length; i++) {
		var stringbuild = strSplit[0] + strSplit[1];
		let bool = categoryList[i].id.valueOf() === stringbuild.valueOf();
		if (bool) {
			var filter = createFilterButton(str);
			var add = document.getElementById(categoryList[i].id);
			add.appendChild(filter);
		}
	}
}

function createFilterButton(str) {
	var info = getColumnsFieldAndIname();
	var strSplit = str.split(getSplitter());
	for (var j = 0; j < info.length; j++) {
		infoSplit = info[j].split(getSplitter());
		bool = strSplit[0].valueOf() === infoSplit[0].valueOf();
		if (bool) {
			var newStr = strSplit[2];
		}
	}
	var filter = document.createElement("button");
	filter.setAttribute("onclick", "deleteSettedFilter('" + strSplit[2] + "')")
	filter.innerHTML = newStr;
	return filter;
}

function createFilterList(filterArray, setLocId, elmt) {
	var listing = document.getElementById(setLocId);
	for (let i = 0; i < filterArray.length; i++) {
		filterElement = filterArray[i].split(getSplitter());
		if(!filterElement[0].includes("notAFilter")){
		var divgeneral = document.createElement("div")
		divgeneral.setAttribute("class", "dropdown");
		var divId = filterElement[0] + "-Elmnt-" + i;
		var div = setElmtList(divId, "dropdownList");
		var search = searchBar(divId, i);
		div.appendChild(search)
		divgeneral.appendChild(div);
		var button = filterButton(filterElement[0], filterElement[1],
				filterElement[2], filterElement[3], i);
		divgeneral.insertBefore(button, divgeneral.childNodes[0])
		listing.appendChild(divgeneral);
		var array = setListOfElement(elmt, filterElement[0]);
		for (let l = 0; l < array.length; l++) {
			var a = document.createElement("a");
			a.innerHTML = array[l];
			a.setAttribute("onclick", "setFilterValue('" + button.id + "','"
					+ array[l] + "')");
			div.appendChild(a);
		}
		}

	}

}

function setListOfElement(elmt, fieldName) {
	var list = [];

	for (let i = 0; i < elmt.length; i++) {
		var d = elmt[i][fieldName];
		if (d !== undefined) {
			var index = i;
		}
	}
	for (let j = 0; j < elmt[index][fieldName].length; j++) {
		list.push(elmt[index][fieldName][j]);
	}

	return list;

}

function searchBar(divId, nb) {
	var search = document.createElement("input");
	search.setAttribute("placeHolder", "...");
	var searchId = "search" + nb;
	search.id = searchId;
	search.type = "text";
	search.setAttribute("onkeyup", "listfilter('" + divId + "','" + searchId
			+ "')");
	return search;
}

function filterButton(fieldName, nameToDisplay, operator, operatorName, nb) {
	var button = document.createElement("button");
	var buttonDisplay = nameToDisplay + " " + operatorName;
	button.innerHTML = buttonDisplay;
	var buttonId = fieldName + "Btn" + nb;
	button.id = buttonId;
	button.name = buttonDisplay;
	button.value = fieldName + getSplitter() + operator;
	button.setAttribute("class", "button");
	return button;
}
function setElmtList(divId, dropdownClass) {
	var div = document.createElement("div");
	div.id = divId;
	div.setAttribute("class", dropdownClass)
	return div;
}

function setFilterValue(buttonId, dataValue) {
	var array = [];
	var obj = getFilterSettedFromBackEnd();
	var criterion = document.getElementById(buttonId).value;
	var filter = criterion + getSplitter() + dataValue;
	if (obj.length > 0) {
		for (let i = 0; i < obj.length; i++) {
			var bool1 = obj[i] === null;
			if (!bool1) {
				objStrSplit = obj[i].split(getSplitter());
				array.push(objStrSplit[2]);
			}
		}
	}
	var bool = array.includes(dataValue);
	if (!bool) {
		obj.push(filter);
		submitFilter(obj, getFormAction(), getFormMethod());
	}
}
/**
 *
 * @param criteriaSendFromBackEnd
 *            the criteria send from back in order to kept criteria historic and
 *            append or delete a criterion, set to "null" in order to display
 *            all data
 * @returns
 */
function sendCriteriaToBackEnd(criteriaSendFromBackEnd) {
	var tosend = [];
	if (criteriaSendFromBackEnd !== null) {
		var obj = criteriaSendFromBackEnd;
		for (let i = 0; i < obj.length; i++) {
			let bool = obj[i] === null || obj[i] === "empty";
			if (!bool) {
				tosend.push(obj[i]);
			}
		}
	} else {
		tosend.push("all");
	}
	setCriteria(JSON.stringify(tosend));
}


function submitFilter(criteriaSendFromBackEnd, action, method) {
	sendCriteriaToBackEnd(criteriaSendFromBackEnd)
	var filter = getCriteria();
	var form = document.createElement("form");
	var paramObj = document.createElement("input");
	var modelUsed = document.createElement("input");
	var rowsperpage = document.createElement("input");
	form.type = "hidden";
	form.action = action;// "array";
	form.method = method;// "get";
	paramObj.name = getStoredFilterArrayName();
	paramObj.setAttribute("value", filter);
	paramObj.type = "hidden";
	form.appendChild(paramObj);
	loader();
	anchorage().appendChild(form);
	form.submit();
}

function deleteSettedFilter(dataSeeked) {
	var obj = getFilterSettedFromBackEnd();
	for (let i = 0; i < obj.length; i++) {
		if (obj[i] !== null) {
			var objSplit = obj[i].split(getSplitter());
			var dataToCompare = objSplit[2];
			if (dataSeeked.valueOf() == dataToCompare.valueOf()) {
				obj[i] = null;
			}
		}
	}
	submitFilter(obj, getFormAction(), getFormMethod())

}

function clearFilter(location, messageLoc, buttonSetLoc, jspName) {
	var filterLoc = document.getElementById(location);
	var filter = filterLoc.getElementsByTagName("a");
	var buttonSetLocation = document.getElementById(buttonSetLoc);
	if (filter.length > 0) {
		var button = document.createElement("button");
		button
				.setAttribute("onclick", "deleteSessionFilter('" + jspName
						+ "')")
		button.innerHTML = document.getElementById(messageLoc).textContent;
		buttonSetLocation.appendChild(button);
	}

}

function loader() {
	if (getObjectToHideId() !== null) {
		document.getElementById(getObjectToHideId()).style.display = "none";
	}
	if (getLoaderLocId() !== null) {
		document.getElementById(getLoaderLocId()).style.display = "block";
	}
}

// TODO CheckJAVASCRIPT HERE
function deleteSessionFilter(jspName) {
	loader();
	location.href = jspName;
}

function getAllData(action, method) {
	submitFilter(null, action, method);
}

function addGetAllDataToButton(locationId,action,method){
	var button = document.getElementById(locationId);
	if(button!=null){
	button.setAttribute("onclick", "getAllData('"+action+"','"+method+"')");
	}
}


function updateSessionStockage(filterSetted) {
	var bool = filterSetted.includes("empty");
	table = sessionStorage.getItem(getStoredFilterArrayName());
	obj = JSON.parse(table);
	if (!bool) {
		sessionStorage.removeItem(getStoredFilterArrayName());
		obj = [];
		for (let i = 0; i < filterSetted.length; i++) {
			obj.push(filterSetted[i]);
		}
		sendjson = JSON.stringify(obj);
		sessionStorage.setItem(getStoredFilterArrayName(), sendjson);

	}

}

var askPageFormAction = null;

function setAskPageFormAction(action) {
	askPageFormAction = action;
}

function getAskPageFormAction() {
	return askPageFormAction;
}

function askPage(pageNumber) {
	var form = document.createElement("form");
	var page = document.createElement("input");
	page.name = "page"
	page.value = pageNumber;
	form.action = getAskPageFormAction();
	form.method = getFormMethod();
	form.appendChild(page);
	anchorage().appendChild(form);
	form.submit();
}

function pageNavigationOld(locationId, navArray) {
	var loc = document.getElementById(locationId);
	var bool = navArray.includes("empty");
	if (!bool) {
		for (let i = 0; i < navArray.length; i++) {
			var num = Number(navArray[i]);
			var label = document.createElement("label");
			if (!isNaN(num) && navArray.length > 1) {
				label.id = "goToPage" + navArray[i];
				label.setAttribute("onclick", "askPage(" + navArray[i] + ")");
				label.innerHTML = " " + navArray[i] + " ";
				loc.appendChild(label);
			} else {

				label.innerHTML = " " + navArray[i] + " ";
				loc.appendChild(label);
			}
		}
	}
}


function listfilter(divId,searchId){
	input = document.getElementById(searchId);
	  filter = input.value.toUpperCase();
	  div = document.getElementById(divId);
	  a = div.getElementsByTagName('a');
	  for (i = 0; i < a.length; i++) {
		  if(filter.length>=2){
		    txtValue = a[i].textContent || a[i].innerText;
		    if (txtValue.toUpperCase().indexOf(filter) > -1) {
		      a[i].style.display = "";
		    } else {
		      a[i].style.display = "none";
		    }
		  }if(filter.length<2){
			  a[i].style.display = ""; }

	  }}




function messagealert() {
	window.alert(" value");

}
