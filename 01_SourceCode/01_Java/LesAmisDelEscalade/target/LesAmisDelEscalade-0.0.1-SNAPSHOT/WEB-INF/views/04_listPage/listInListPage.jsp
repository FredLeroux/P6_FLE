<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<head>
	<title>
		<springTags:message code = "${listName}"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<br>
<%@ include file="/resources/02_templatesJsp/listDisplayerFiles/file/displayList.jsp" %>
<br>



