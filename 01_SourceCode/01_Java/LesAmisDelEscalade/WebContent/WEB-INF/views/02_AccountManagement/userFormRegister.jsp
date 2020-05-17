<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
visibility: hidden;
}
</style>
<meta charset="UTF-8">
<title><springTags:message code= "userFormRegister.title"></springTags:message></title>
<style>
body{
visibility: hidden;
}
</style>
</head>
<body id="userFormRegisterBody">
<div id="registerFormularPlace">
<%@ include file = "/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/userForm.jsp" %>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript">
window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("userFormRegisterBody").style.visibility= "visible";
	}
var loadModal = newLoadModal();
loadModal.addButtonOnclickParentModalToggle("userRegisterFormularButton");	
</script>
</body>
</html>