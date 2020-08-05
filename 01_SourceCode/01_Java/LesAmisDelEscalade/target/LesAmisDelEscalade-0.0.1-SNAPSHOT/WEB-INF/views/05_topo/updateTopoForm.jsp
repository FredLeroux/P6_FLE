<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix = "springTags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button id="deletion" onclick="deletionConfirm('${deleteURL}','${confirmMessage}')"><springTags:message code ="deleteSite.name"/></button>
<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/updateTopoTmplt.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/confirmAction.js"></script>
</body>
</html>