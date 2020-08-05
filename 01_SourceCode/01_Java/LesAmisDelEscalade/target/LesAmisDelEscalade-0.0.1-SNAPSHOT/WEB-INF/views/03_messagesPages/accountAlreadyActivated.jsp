<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
<title><springTags:message code ="accountAlreadyActivated.title"></springTags:message></title>
</head>
<div class = "messageContainer">
<div class = "messageTitleMitaMita"><springTags:message code ="accountAlreadyActivatedTitle.message"></springTags:message></div><br>
<div class = "messageBodyLeftAlign">
<springTags:message code ="accountAlreadyActivatedListIntro.message"></springTags:message>
<ol>
<li><springTags:message code ="accountAlreadyActivatedLi1.message"></springTags:message></li>
<li><springTags:message code ="accountAlreadyActivatedLi2.message"></springTags:message></li>
</ol>
</div><br>
<div class = "linkContainer">
<label class = "link"   onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="backHome.message"></springTags:message></label>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
		<script type="text/javascript">
		var loadModal = newLoadModal();
		loadModal.disableLoadModal();
</script>
</html>