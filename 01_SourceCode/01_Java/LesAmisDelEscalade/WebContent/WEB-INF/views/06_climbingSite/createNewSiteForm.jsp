<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/modalPage.css" />
<body>
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewSiteTmplt.jsp" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_02_link.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/formFieldDisplayer.js"></script>
<script type="text/javascript">

var onclick = newLink();
var siteRoutesController = ${siteRoutesController}
onclick.addOnclicksubmitFormIntermediateController("siteRoutes","siteFullInfoFormular", siteRoutesController);
var displayOfficial = ${displayOfficial};
var displayer = newFormFieldDisplayer();
displayer.display(displayOfficial, "official.formLabel", "official.select");
</script>
</body>
</html>