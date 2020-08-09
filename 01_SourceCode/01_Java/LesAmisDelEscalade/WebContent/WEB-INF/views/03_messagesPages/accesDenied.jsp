<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "messageBodyCenterAlign">
<springTags:message code ="activationConfirmationBody.message"></springTags:message><br>
</div><br><br>
<!-- important keep the following -->
<script type="text/javascript">
	disableLoadModal();
	addButtonOnclickParentModalToggle("userUpdateFormularButton");
</script>
</body>
</html>

