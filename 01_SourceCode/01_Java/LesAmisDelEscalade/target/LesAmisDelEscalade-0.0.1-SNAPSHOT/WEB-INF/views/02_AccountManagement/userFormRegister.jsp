<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code = "userFormRegister.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div id ="userRegisterUpPage">
</div>
<br>
<div class="userFormRegisterPageTitle" >
	<springTags:message code = "userFormRegister.title"/>
</div>
<br>
<div>
<%@ include file = "/resources/02_templatesJsp/formJsp/formFiles/userForm.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">	
	addButtonOnclickParentModalToggle("userRegisterFormularButton");
	disableLoadModal();	
</script>
<script type="text/javascript">
window.onload = function(){
		window.location="#userRegisterUpPage"}
</script>