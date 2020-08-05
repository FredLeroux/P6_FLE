<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="jspCompomentsCss/02_01_01_02_headerCSS.css" >
<link rel="stylesheet" type="text/css" href="jspCompomentsCss/02_01_01_01_menuNavBarCSS.css" />
<div class="fullHeader" >
<div class="fullHeaderRow1">
<div  class="headerBackground"></div>	
		<div class="headBox">
			<springTags:message code = "header.title"></springTags:message>			
	</div>	
  </div>
  <div class="fullHeaderRow2">
 <%@ include file ="/resources/02_templatesJsp/jspCompoments/jspCompomentsFiles/02_01_02_01_menuNavBarJSPDynamic.jsp" %>
</div>
</div>