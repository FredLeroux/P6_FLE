<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags" %>
<head>
	<title>
		<springTags:message code = "memberStatusForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<button onclick= "window.parent.location ='../../callListBack?listType=toposMine'" class="pageButtonNormal">
		<springTags:message code ="back.name"/>
</button>
<div class="memberStatusFormPageTitle" >
	<springTags:message code = "memberStatusForm.title"/>
</div>
<div>
	<%@ include file = "/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/updateMemberStatusTmplt.jsp" %>
</div>

