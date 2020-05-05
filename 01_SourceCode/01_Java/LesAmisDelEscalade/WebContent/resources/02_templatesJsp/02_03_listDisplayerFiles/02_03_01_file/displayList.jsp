<%@ taglib uri ="http://www.springframework.org/tags" prefix="springTag" %>

	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/00_centralisation/00_01_cssFiles/library.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_03_cssFiles/table.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_03_cssFiles/dropdownFilter.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_03_cssFiles/button1.css" />

	
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_04_javaScriptFiles/tableAndFilter.js" charset="UTF-8"></script>



<div id = "filterAppliedList" class ="divDisplay"></div><br><br><br>
<div id="clearBtn" class ="filterButton">
<div id="clearFilter" class="hidden"><springTag:message code="clearFilter.message"></springTag:message></div>
</div>
<div id="filterList" class = "filterDisplay"></div>
<button id="allData" ><springTag:message code="displayAll.message"/></button><br>
<%@ include file="/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_02_components/pagination.jsp" %>
<div id="dataTable" ><springTag:message code="selectFilter.message"></springTag:message></div>
<div>
</div>
<div id="anchorage" style = "display: none"></div>
<br><br><br>
<script type="text/javascript">


var jspName = ${jspName};
var sortListHandlerName = ${sortListHandlerName};
var formMethod =${formMethod};
var editHandlerName = ${editHandlerName}
var dataBaseData = null;
dataBaseData=${dataBaseData};
var tableElementsList = ${tableElementsList};
var filterHead = ${filterHead};
var filterSetted = ${filterSetted};
var storedFilterArrayName = ${storedFilterArrayName};
var orderLink = ${orderLink};
var dataTable = setNewTable();
var splitter = "/";
var columnFieldNameIndex = 0;
var columnI18NNameIndex = 1;
var operatorIndex = 2;
var operatorI18NNameIndex =3;

dataTable.setAnchorId("anchorage");
dataTable.setFormAction(sortListHandlerName);
dataTable.setEditHandlerName(editHandlerName);
dataTable.setFormMethod(formMethod);
dataTable.setColumnsFieldAndIname(filterHead, columnFieldNameIndex, columnI18NNameIndex, splitter);
dataTable.setOperatorSignAndIname(filterHead, operatorIndex, operatorI18NNameIndex, splitter);
dataTable.setStoredFilterArrayName(storedFilterArrayName);
dataTable.setFilterSettedFromBackEnd(filterSetted);
dataTable.setOrderLink(orderLink);
dataTable.generateTable("dataTable","dataTable",dataBaseData,"style1","id");
dataTable.createFilterList(filterHead, "filterList", tableElementsList);
dataTable.displayFilterSetted("filterAppliedList", filterHead , "aDisplay")
dataTable.addGetAllDataToButton("allData",sortListHandlerName,formMethod);
dataTable.clearFilter("filterAppliedList","clearFilter","clearBtn",jspName);
dataTable.setObjectToHideId("dataTable");	
</script>	
	