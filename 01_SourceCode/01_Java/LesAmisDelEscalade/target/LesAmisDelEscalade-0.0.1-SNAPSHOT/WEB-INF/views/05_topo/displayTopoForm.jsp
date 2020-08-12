<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "displayTopoForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<button onclick= "navBack('../../callListBack')" class="pageButtonNormal">
	<springTags:message code ="back.name"/>
</button>
<div class="displayTopoFormPageTitle" >
	<springTags:message code = "displayTopoForm.title"/>
</div>
<div>
	<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/displayTopoTmplt.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	disableLoadModal();	
	addButtonOnclickParentModalToggle("displayTopoFormularButton");	
</script>