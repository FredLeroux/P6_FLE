<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_02_messagesCSS.css" />
	
<title><springTags:message code="accountActivatedError.title"></springTags:message></title>
</head>
<body>
	<div class="messageContainer">
	<div class = "messageTitleBad">
		<springTags:message code="activationErrorTitle.message"></springTags:message>
		</div><br><br>	
		
	<div class = "messageBodyLeftAlign">
	<springTags:message code="alreadyActivatedListIntro.message"></springTags:message>		
		<ol>
			<li><springTags:message code="activationErrorAlreadyActivated.message"></springTags:message></li>
			<li><springTags:message code="activationErrorGetNewCode.message"></springTags:message><br> 
			<span id="formular" class="formLi">
				<%@ include	file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/askMail.jsp"%></span>
			</li>
			<li><springTags:message code="activationErrorBadMan.message"></springTags:message></li>
		</ol>
		</div><br>
		<div class = linkContainer>
		<label class="link"	onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')"><springTags:message
				code="backHome.message"></springTags:message></label></div><br><br>
	</div>
	

	<script type="text/javascript"	src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
		<script type="text/javascript">
		var loadModal = newLoadModal();
		loadModal.addButtonOnclickParentModalToggle("formular");		
		</script>
		



	
	
		
</body>
</html>