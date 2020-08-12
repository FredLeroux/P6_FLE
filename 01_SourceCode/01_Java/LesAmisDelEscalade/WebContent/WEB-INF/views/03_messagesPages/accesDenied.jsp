<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	<title>
		<springTags:message code ="deniedPage.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/messagesCSS.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div id ="deniedPageUp">
</div>
<div class = "messageContainer">
	<br>
	<div class = "messageTitleBad">
		<springTags:message code ="deniedPageTitle.message"/>
	</div>
	<br>
	<div class = "messageBodyCenterAlign">
		<springTags:message code ="deniedPageBody.message"/>		
	</div>	
	<br>
	<div class = "linkContainer">
		<button class="pageButtonBigAndRound"  onclick="parentNavTo('${pageContext.request.contextPath}')">
		<springTags:message code ="deniedPageBack.message"/>
		</button>				
	</div>
	<br>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript">
window.location = "#deniedPageUp";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	disableLoadModal();
</script>

