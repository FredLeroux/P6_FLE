<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@ include file = "/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/updateMemberStatusTmplt.jsp" %>
<div id ="href" style="display: none;">
<springTags:message code = "option5.href"></springTags:message>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/addOnclickFunction.js"></script>
<script type="text/javascript">
window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("budy").style.visibility= "visible";	  
	}
var onclick = onclickFunction();//"updateMemberStatusFormButton"
onclick.changePage("updateMemberStatusFormButton","${pageContext.request.contextPath}/callList?listType=members");

</script>
</body>
</html>