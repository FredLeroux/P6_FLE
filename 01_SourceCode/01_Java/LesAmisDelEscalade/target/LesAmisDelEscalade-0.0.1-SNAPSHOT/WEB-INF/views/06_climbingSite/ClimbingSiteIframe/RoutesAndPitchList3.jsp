<!-- AJAX USE -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<div id= "title">
<springTags:message code ="routesAndPitchsList.title"></springTags:message>
</div>
<div id ="pageNav" style="display:flex; justify-content: center;">
<button id="prevButton" style="display:none;"><i class="fas fa-arrow-alt-circle-left"></i></button>
<div id = "currentPage"></div>/<div id = "totalPages"></div>
<button id="nextButton" style="display:none;"><i class="fas fa-arrow-alt-circle-right"></i></button>
</div>
<table id = "tableRoutesAndList"></table>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/routesAndPitchsList.js"></script>
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
manager.setTable(routesAndListPages,"tableRoutesAndList",routeDesignation,pitchDesignation,cotationDesignation);
manager.setChangePageLink(changePageController);
manager.setRouteDesignation(routeDesignation);
manager.setPitchDesignation(pitchDesignation);
manager.setCotationDesignation(cotationDesignation);
manager.setPageChangeActionElements("prevButton", "nextButton", "currentPage", totalPages, "tableRoutesAndList")
//TODO set cssClass
/*
manager.setCssRouteDesignation(cssClassName)
manager.setCssRouteName(cssClassName);
manager.setCssPitchDesignation(cssClassName);
manager.setCssPitchNumber(cssClassName);
manager.setCssCotationDesignation(cssClassName);
manager.setCssCotationName(cssClassName;)
*/

</script>

