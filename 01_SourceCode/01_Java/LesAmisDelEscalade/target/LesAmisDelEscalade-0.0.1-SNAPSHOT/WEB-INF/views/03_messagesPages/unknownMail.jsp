<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
<title><springTags:message code ="unknownMail.title"></springTags:message></title>
</head>
<body>
<div class = "messageContainer">
<div class = "messageTitleBad"><springTags:message code ="unknownTitle.message"></springTags:message></div><br>

<div class = "messageBodyCenterAlign"><span class="mailUnknown" >${mail}</span></div><br><br>
<div class = "centerDiv">
<div class = "messageBodyLeftAlign"><springTags:message code ="unknownBody.message"></springTags:message>
<a href="${backToCallPageHref}"><springTags:message code ="unknownReTryLink.message"></springTags:message></a></div><br><br>
</div>
<div class = "linkContainer">
<label class = "link"   onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="backHome.message"></springTags:message></label><br><br>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
		<script type="text/javascript">
		var loadModal = newLoadModal();
		loadModal.disableLoadModal();
</script>
</body>
</html>