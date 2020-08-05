<%@ taglib prefix="springTag" uri="http://www.springframework.org/tags"%>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jspCompomentsCss/loadModalCSS.css" />
</head>
<div  id="loading" style = "display: none">
	<div class="loader" >
	<div class= "modalDisplayer">
	</div>
	<div class= "box">
	</div>
	<div class="hill">
	</div>
	<div class="legend">
		<springTag:message code="load.message"/>
	</div>
	</div>
</div>