<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code = "userFormUpdate.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div class="userFormUpdatePageTitle" >
	<springTags:message code = "userFormUpdate.title"/>
</div>
<div class="editAccountButtonGrid">
	<div class= "passModifButtonPositioning">
		<button class="pageButtonMitaMita"  id="deletion" onclick="window.location.href='passwordModification'">
			<springTags:message code="passwordModification.name"/>
		</button>
	</div>
	<div class= "deleteAccountButtonPositioning">
		<button class="pageButtonWarning"  id="deletion" 
		onclick="deletionConfirmAndAppReload('${pageContext.request.contextPath}','${deleteURL}','${confirmMessage}')">
			<springTags:message code = "deleteAccount.name"/>
		</button>
	</div>
</div>
<br>
<div id = "updateFormular">
	<%@ include file = "/resources/02_templatesJsp/formJsp/formFiles/userUpdateForm.jsp" %>
</div> 
<br>
<a href="testError">testError</a>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/confirmAction.js"></script>
<script type="text/javascript">	
	function reInitApp(contextPath,url) {
		var xhttp1 = new XMLHttpRequest();
		xhttp1.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				window.parent.location.href= contextPath;
			}
		};
		xhttp1.open("GET", url, true);
		xhttp1.send();
	}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	disableLoadModal();
	addButtonOnclickParentModalToggle("userUpdateFormularButton");
</script>
