<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<head>
	<title>
		<springTags:message code = "${listName}"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<div id="listUpPage"></div>
<br>
<jstl:set var="listNamed" value="${listName}"></jstl:set>
<jstl:if test="${!empty(listNamed)}">
	<div class="listPageTitle" >
		<springTags:message code = "${listName}"/>
	</div>
</jstl:if>
<%@ include file="/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_01_file/displayList.jsp" %>
<br>
<script type="text/javascript">
	window.onload = function(){
		window.location = "#listUpPage"}
</script>



