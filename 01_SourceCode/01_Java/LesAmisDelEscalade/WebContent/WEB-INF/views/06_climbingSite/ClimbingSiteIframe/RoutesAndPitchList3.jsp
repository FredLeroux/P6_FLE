<!-- AJAX USE -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/routesAndPitchListCss.css"/>


<div id ="pageNav" class="pageSelectionGrid"  ><!-- style="display:flex; justify-content: center;" -->
	<div class="prevPage">
		<i class="fas fa-arrow-alt-circle-left" id="prevButton" style="display:none;"></i>
	</div>
<div id = "currentPage" class = "currentPage">
</div>
<div class="separator">
	/
</div>
<div id = "totalPages" class="totalPages">
</div>
	<div class="nextPage">
		<i class="fas fa-arrow-alt-circle-right" id="nextButton" style="display:none;" class="nextPage">
		</i>
	</div>
</div>
<br>
<table id = "tableRoutesAndList">
</table>
<div id= "test">
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/routesAndPitchsList.js">
</script>
<script type="text/javascript">
var changePageController =${changePageController};
var totalPages = ${totalPages};
var currentPage = ${currentPage};
var routesAndListPages = ${routesAndListPages}
var routeDesignation="<springTags:message code = 'route.name'/>";
var pitchDesignation= "<springTags:message code = 'pitch.name'/>";
var cotationDesignation = "<springTags:message code = 'cotation.name'/>";
var manager = newRoutesAndPitchsList();
manager.setTotalPages("totalPages", totalPages)
manager.setCurrentPage("currentPage", currentPage)
manager.setTable(routesAndListPages,"tableRoutesAndList",routeDesignation,pitchDesignation,cotationDesignation,"thumbnail");
manager.setChangePageLink(changePageController);
manager.setRouteDesignation(routeDesignation);
manager.setPitchDesignation(pitchDesignation);
manager.setCotationDesignation(cotationDesignation);
manager.setPageChangeActionElements("prevButton", "nextButton", "currentPage", totalPages, "test")
</script>

