
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/indexCss.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/iframeSetCss.css" />
<title>Les Amis de l'escalade</title>
</head>
<body  id="budy" class="ladeIndex"  >
	<div class="indexHeader">
		<%@ include file ="/resources/02_templatesJsp/jspCompoments/jspCompomentsFiles/02_01_02_02_headerJSP.jsp"%>
	</div>
	<div class="indexIframe">
		<div  id="pagesViewer">
		<br>
		</div>				
	</div>
	<br>	
	<div>
		<%@ include file ="/resources/02_templatesJsp/jspCompoments/jspCompomentsFiles/02_01_02_04_loginModal.jsp" %>
		<%@ include file ="/resources/02_templatesJsp/jspCompoments/jspCompomentsFiles/02_01_02_05_loadModal.jsp" %>
		<%@ include file ="/WEB-INF/views/06_climbingSite/climbingSiteCommentsModalForm.jsp" %>
		<%@ include file ="/WEB-INF/views/06_climbingSite/climbingSiteCommentsNotAllowedModal.jsp" %>
	</div>
	<script type="text/javascript">
		window.onload = function displayWhenReady() {
		//Allow to display page only when all elements are ready needs style body visibility="hidden"
	 	 document.getElementById("budy").style.visibility= "visible";
		}
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/iFrameJavaScript.js"></script>
	<script type="text/javascript">
		var src= ${iFrameSource};
		var loc =${iFrameLoc};
		var iframe = newIframe(loc);
		iframe.loadIframe(src);	
	</script>
</body>
</html>