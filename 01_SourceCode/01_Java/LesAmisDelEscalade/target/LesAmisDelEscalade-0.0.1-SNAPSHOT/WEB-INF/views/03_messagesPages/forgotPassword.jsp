<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	
<title><springTags:message code="forgotPassword.title"></springTags:message></title>
</head>
<body>
	<div class="messageContainer">
	<div class = "messageTitleGood">
		<springTags:message code="forgotPasswordTitle.message"></springTags:message>
		</div><br>
		
	<div class = "messageBodyLeftAlign">
	<div class ="errorMessage">${errorNoCheckBox}</div><br>
	<springTags:message code="forgotPasswordBody.message"></springTags:message><br>	
	<input type="checkbox" name = "login" value ="login" form = "forgotPasswordFormular"><label for ="login"><springTags:message code = "forgotPasswordLogin.message"></springTags:message></label><br>
	<input type="checkbox" name = "pass" value ="pass" form = "forgotPasswordFormular"><label for ="pass"><springTags:message code = "forgotPasswordPass.message"></springTags:message></label>		
			<div id="formular">
				<%@ include	file="/resources/02_templatesJsp/formJsp/formFiles/forgotPasswordFormTmplt.jsp"%></div>			
		</div>
		<div class = linkContainer>
		<label class="link"	onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')"><springTags:message
				code="backHome.message"></springTags:message></label></div><br><br>
	</div>
	<br>

	

	<script type="text/javascript"	src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
		<script type="text/javascript">
		var loadModal = newLoadModal();
		loadModal.addButtonOnclickParentModalToggle("forgotPasswordFormularButton");		
		</script>
		



	
	
		
</body>
</html>