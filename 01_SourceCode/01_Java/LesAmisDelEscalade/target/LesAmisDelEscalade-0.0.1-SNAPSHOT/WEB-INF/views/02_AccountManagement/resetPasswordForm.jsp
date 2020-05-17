<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_02_messagesCSS.css" />
<style>
body{
visibility: hidden;
}
</style>
<meta charset="UTF-8">
<title><springTags:message code = "resetPass.title"></springTags:message></title>
<style>
body{
visibility: hidden;
}
</style>
</head>
<body id="budy">
<div class = "messageContainer">
<div class = "messageTitleMitaMita"><springTags:message code ="modifcationPasswordTitle.message"></springTags:message></div><br><br>
<div id="passForm" class = "messageBodyCenterAlign"><%@ include file = "/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/resetPassFormTmplt.jsp" %></div><br><br>
<div class = "linkContainer">
<label class = "link" onclick="changeParentLocation('${pageContext.request.contextPath}/index.html')" ><springTags:message code ="backHome.message"></springTags:message></label>
</div><br><br>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript">
		window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	 	 document.getElementById("budy").style.visibility= "visible";
		}
		var loadModal = newLoadModal();
		loadModal.addButtonOnclickParentModalToggle("passForm");
</script>
</body>
</html>