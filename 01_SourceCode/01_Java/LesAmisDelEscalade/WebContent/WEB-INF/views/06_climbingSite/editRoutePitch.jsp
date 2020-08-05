<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "editRoutePitch.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<div id="upEditPitch"></div>
<br>
<div class="routePitchEditFormPageTitle" >
	<springTags:message code = "editRoutePitch.title"/>
</div>
<div>
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/editRoutePitchTmplt.jsp" %>
</div>
<div class="routeFormEndingButtonPositioning">
	<button class="pageButtonNormal"  onclick="window.location.href='${cancelEditPitch}'">
		<springTags:message code = "cancelEdition.name"/>
	</button>
</div>
<br>
