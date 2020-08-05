<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix = "springTags" %>
<head>
	<title>
		<springTags:message code ="createTopoForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<div class="createTopoFormPageTitle" >
	<springTags:message code = "createTopoForm.title"/>
</div>
<div>
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewTopoTmplt.jsp" %>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript">
	var loadModal = newLoadModal();
	loadModal.addButtonOnclickParentModalToggle("createNewTopoFormularButton");
</script>
