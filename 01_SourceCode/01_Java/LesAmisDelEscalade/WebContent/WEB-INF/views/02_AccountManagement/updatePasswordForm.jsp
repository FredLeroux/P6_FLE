<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code = "resetPass.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div>
	<button onclick= "window.location.href='userFormUpdate'" class="pageButtonNormal">
		<springTags:message code ="back.name"/>
	</button>
</div>
<br>
<div class = "messageContainer">
	<div class = "messageTitleMitaMita">
		<springTags:message code ="modifcationPasswordTitle.message"/>
	</div>
	<div id="passForm" class = "messageBodyCenterAlign">
		<div class = "errorMessage">
			${wrongPass}
		</div>
		<br>
		<div>
			<%@ include file = "/resources/02_templatesJsp/formJsp/formFiles/updatePassFormTmplt.jsp" %>
		</div>
	</div>
	<br>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/toggle.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	addButtonOnclickParentModalToggle("updatePassFormularButton");
</script>
