<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="jspCompomentsCss/headerCSS.css" >
	<link rel="stylesheet" type="text/css" href="jspCompomentsCss/menuNavBarCSS.css" />
</head>
<div class="fullHeader" >
	<div class="fullHeaderRow1">
		<div  class="headerBackground">
		</div>	
		<div class="headBox">
			<springTags:message code = "header.title"/>			
		</div>	
  	</div>
 	 <div class="fullHeaderRow2">
 		<%@ include file ="/resources/02_templatesJsp/jspCompoments/jspCompomentsFiles/menuNavBarJSPDynamic.jsp" %>
	</div>
</div>