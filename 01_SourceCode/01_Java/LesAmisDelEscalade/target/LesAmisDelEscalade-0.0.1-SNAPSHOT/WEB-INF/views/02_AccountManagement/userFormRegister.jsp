<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<%@ include file = "/resources/02_templatesJsp/formJsp/formFiles/userForm.jsp" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
/*window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("userFormRegisterBody").style.visibility= "visible";
	}*/
var loadModal = newLoadModal();
loadModal.addButtonOnclickParentModalToggle("userRegisterFormularButton");	
</script>
</body>
</html>