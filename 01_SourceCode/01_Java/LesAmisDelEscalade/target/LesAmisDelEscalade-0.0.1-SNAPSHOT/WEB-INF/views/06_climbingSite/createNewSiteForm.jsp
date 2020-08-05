<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "createNewSiteForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/modalPage.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<div class="createNewSiteFormPageTitle" >
	<springTags:message code = "createNewSiteForm.title"/>
</div>
<br>
<div>
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewSiteTmplt.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/formFieldDisplayer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
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
