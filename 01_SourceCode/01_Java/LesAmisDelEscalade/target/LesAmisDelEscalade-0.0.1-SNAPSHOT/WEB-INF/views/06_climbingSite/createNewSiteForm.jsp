<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "createNewSiteForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/06_CSSFiles/pages/modalPage.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div class="createNewSiteFormPageTitle" >
	<springTags:message code = "createNewSiteForm.title"/>
</div>
<br>
<div>
	<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/createNewSiteTmplt.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/formFieldDisplayer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	var loadModal = newLoadModal();
	loadModal.addButtonOnclickParentModalToggle("siteFullInfoFormularButton");
	var onclick = newLink();
	var siteRoutesController = ${siteRoutesController};
	onclick.addOnclicksubmitFormIntermediateController("siteRoutes","siteFullInfoFormular", siteRoutesController.concat("#up"));
	var displayOfficial = ${displayOfficial};
	var displayer = newFormFieldDisplayer();
	displayer.display(displayOfficial, "official.formLabel", "official.select");
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	disableLoadModal();
</script>