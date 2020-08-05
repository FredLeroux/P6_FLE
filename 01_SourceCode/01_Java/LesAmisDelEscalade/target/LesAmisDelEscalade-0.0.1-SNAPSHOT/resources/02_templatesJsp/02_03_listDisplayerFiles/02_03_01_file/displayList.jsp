<%@ taglib uri ="http://www.springframework.org/tags" prefix="springTag" %>

	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/00_centralisation/00_01_cssFiles/library.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/listDisplayerFiles/02_03_03_cssFiles/table.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/listDisplayerFiles/02_03_03_cssFiles/dropdownFilter.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/listDisplayerFiles/02_03_03_cssFiles/button1.css" />

	




<div id = "filterAppliedList" class ="divDisplay"></div>
<div id="clearBtn" class ="filterButton">
<div id="clearFilter" class="hidden"><springTag:message code="clearFilter.message"></springTag:message></div>

</div>
<br>
<div >
<div id="filterList" class = "filterDisplay"></div>
</div>

<%@ include file="/resources/02_templatesJsp/listDisplayerFiles/02_03_02_components/pagination.jsp" %>
<div id="dataTable" class="selectFilterMessage" ><springTag:message code="selectFilter.message"></springTag:message>
<br>
<button id="allData" class="allDataBtn"><springTag:message code="displayAll.message"/></button><br>
</div>
<div>
</div>
<div id="anchorage" style = "display: none"></div>
<input type="hidden" id="refreshed" value="no">
<br><br>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/02_templatesJsp/listDisplayerFiles/02_03_04_javaScriptFiles/tableAndFilter.js" charset="UTF-8"></script>
<script type="text/javascript">

var reload = ${reload};
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
//TODO Investigate on performance.navigation
//TODO This auto list method is not optimal
/*issue on back button when using list twice in the same iframe i.e siteDetails list -> comment list -> back button
*on siteDetails list gives the comments list instead od sitedetails create new based on sprinFormStringBuilder
*solved using PerformanceNavigation but not really clean 
*/
/*https://developer.mozilla.org/en-US/docs/Web/API/PerformanceNavigation
https://stackoverflow.com/questions/9046184/reload-the-site-when-reached-via-browsers-back-button/42155738#42155738*/
if(!!window.performance && window.performance.navigation.type == 2)
{
    window.parent.location.reload();
};


onload=function(){
var e=document.getElementById("refreshed");
if(e.value=="no")e.value="yes";
else{e.value="no";window.parent.location.reload();}
}

</script>	
	