<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewTopoTmplt.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript">
var loadModal = newLoadModal();
loadModal.addButtonOnclickParentModalToggle("createNewTopoFormularButton");		
</script>
</body>
</html>