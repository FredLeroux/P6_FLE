<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "editRoutesSite.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div id="upEditRouteName"></div>
<br>
<div class="editRoutesSiteFormPageTitle" >
	<springTags:message code = "editRoutesSite.title"/>
</div>
<div>
	<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/editSiteRouteTmplt.jsp" %>	
</div>
<div class="routeFormEndingButtonPositioning">
	<button class="pageButtonNormal"  onclick="navBack('${cancelRouteNameEdit}')">
		<springTags:message code = "cancelEdition.name"/>
	</button>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>