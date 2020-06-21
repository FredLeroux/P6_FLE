<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<button id="deletion" onclick="deletionConfirm('${deleteURL}','${confirmMessage}')"><springTags:message code ="deleteSite.name"/></button>
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/updateSiteTmplt.jsp" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/formFieldDisplayer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/confirmAction.js"></script>
<script type="text/javascript">

var onclick = newLink();
var siteRoutesController = ${siteRoutesController}
onclick.addOnclicksubmitFormIntermediateController("siteRoutes","siteFullInfoUpdateFormular", siteRoutesController);

function confirmDelete(){
	if(confirm("test")){
		location.href = "deleteSite"};
}

</script>
</body>
</html>