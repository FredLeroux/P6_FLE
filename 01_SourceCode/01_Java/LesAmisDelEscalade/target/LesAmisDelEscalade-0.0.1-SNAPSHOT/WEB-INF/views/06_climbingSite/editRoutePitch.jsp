<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "editRoutePitch.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div id="upEditPitch"></div>
<br>
<div class="routePitchEditFormPageTitle" >
	<springTags:message code = "editRoutePitch.title"/>
</div>
<div>
	<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/editRoutePitchTmplt.jsp" %>
</div>
<div class="routeFormEndingButtonPositioning">
	<button class="pageButtonNormal"  onclick="navBack('${cancelEditPitch}')">
		<springTags:message code = "cancelEdition.name"/>
	</button>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
