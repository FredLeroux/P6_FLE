<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<head>
	<title>
		<springTags:message code = "updateSiteForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<button onclick= "window.parent.location ='../callListBack?listType=climbingSitesShow'" class="pageButtonNormal">
	<springTags:message code ="back.name"/>
</button>
<div class="updateSiteFormPageTitle" >
	<springTags:message code = "updateSiteForm.title"/>
</div>
<br>
<div class="deleteSiteButtonPositioning">
	<button class="pageButtonWarning"  id="deletion" onclick="deletionConfirm('${deleteURL}','${confirmMessage}')">
		<springTags:message code = "deleteSite.name"/>
	</button>
</div>
<br>
<div>
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/updateSiteTmplt.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/confirmAction.js"></script>
<script type="text/javascript">
	var onclick = newLink();
	var siteRoutesController = ${siteRoutesController}
	onclick.addOnclicksubmitFormIntermediateController("siteRoutes","siteFullInfoUpdateFormular", siteRoutesController.concat("#up"));
</script>
