<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "displayTopoForm.title"/>
	</title>
</head>
<div>
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/displayTopoTmplt.jsp" %>
</div>
<a href="../../callListBack" target="_parent">back</a>