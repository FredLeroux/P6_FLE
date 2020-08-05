<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title><springTags:message code = "userFormUpdate.title"></springTags:message></title>
<style>
body{
visibility: hidden;
}
</style>
</head>
<body id="budy">
<button id="deletion" onclick="deletionConfirmApplyURLToParent('${deleteURL}','${confirmMessage}')"><springTags:message code ="deleteAccount.name"/></button>
<a class="formBecarefull"  href = "passwordModification"><springTags:message code="passwordModification.name"></springTags:message></a>
<div id = "updateFormular">
<%@ include file = "/resources/02_templatesJsp/formJsp/formFiles/userUpdateForm.jsp" %>
</div> 
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/confirmAction.js"></script>
<script type="text/javascript">
window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("budy").style.visibility= "visible";
	}
	var loadModal = newLoadModal();
	loadModal.addButtonOnclickParentModalToggle("userUpdateFormularButton");		
	</script>
</body>
</html>