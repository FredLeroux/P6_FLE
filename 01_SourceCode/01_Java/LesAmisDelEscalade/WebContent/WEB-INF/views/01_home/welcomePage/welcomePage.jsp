<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<head>
	
	<title>
		<springTags:message code = "welcome.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/07_01_01_welcomeCss.css" />
</head>
<br>
<br>
<div id="welcome" class="welcomeFormatting">
<springTags:message  code = "welcome.locale"></springTags:message>
</div>
<br>
<br>
