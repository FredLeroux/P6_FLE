<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_02_messagesCSS.css" />	
<title><springTags:message code="accountActivatedError.title"/></title>
</head>
	<div class="messageContainer">
		<div class = "messageTitleBad">
			<springTags:message code="activationErrorTitle.message"/>
		</div>	
		<div class = "messageBodyLeftAlign">
			<springTags:message code="alreadyActivatedListIntro.message"></springTags:message>		
			<ol>
				<li>
					<springTags:message code="activationErrorAlreadyActivated.message"/>
					<br>	
					<br>				
				</li>				
				<li>
					<springTags:message code="activationErrorGetNewCode.message"/>
					<span id="formular" class="formLi">
						<%@ include	file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/askMail.jsp"%>
					</span>
				</li>
				<li>
					<springTags:message code="activationErrorBadMan.message"/>
				</li>
			</ol>
		</div>
		<div class = linkContainer>
			<label class="link"	onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')">
				<springTags:message	code="backHome.message"/>				
			</label>			
		</div>
		<br>
	</div>	
<script type="text/javascript"	src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript">
	var loadModal = newLoadModal();
	loadModal.addButtonOnclickParentModalToggle("userMailFormularButton");		
</script>
