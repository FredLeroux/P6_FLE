<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title><springTags:message code = "userFormUpdate.title"></springTags:message></title>
<style>
body{
visibility: hidden;
}
</style>
</head>
<body id="budy">
<a class="formBecarefull"  href = "passwordModification"><springTags:message code="passwordModification.name"></springTags:message></a>
<%@ include file = "/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/userUpdateForm.jsp" %>
<script type="text/javascript">
window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("budy").style.visibility= "visible";
	}
</script>
</body>
</html>