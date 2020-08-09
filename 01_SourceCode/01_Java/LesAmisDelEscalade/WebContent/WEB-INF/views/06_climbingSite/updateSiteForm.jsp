<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<head>
	<title>
		<springTags:message code = "updateSiteForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<button onclick= "navBack('../callListBack')" class="pageButtonNormal">
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
	<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/updateSiteTmplt.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/confirmAction.js"></script>
<script type="text/javascript">
	var onclick = newLink();
	var siteRoutesController = ${siteRoutesController}
	onclick.addOnclicksubmitFormIntermediateController("siteRoutes","siteFullInfoUpdateFormular", siteRoutesController.concat("#up"));
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	disableLoadModal();
	addButtonOnclickParentModalToggle("siteFullInfoUpdateFormularButton");
</script>
