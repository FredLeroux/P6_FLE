<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
<title><springTags:message code ="confirmationNewCodeSent.title"></springTags:message></title>
</head>
<body>
<div class = "messageContainer">
<div class = "messageTitleGood"><springTags:message code ="newCodeSentTitle.message"></springTags:message></div><br><br>
<div class = "messageBodyCenterAlign">${confirmationMessage}</div><br><br>
<div class = "linkContainer">
<label class = "link"   onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="backHome.message"></springTags:message></label>
</div><br><br>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/toggle.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
		<script type="text/javascript">
		var loadModal = newLoadModal();
		loadModal.disableLoadModal();
</script>
</body>

</html>
