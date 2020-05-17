
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
<<<<<<< HEAD
<!--
body{
visibility: hidden;}
-->
=======
body{
visibility: hidden;
}
>>>>>>> refs/heads/AccountAndCreation
</style>



<title>Les Amis de l'escalade</title>

</head>
<body id="budy" >


<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_02_headerJSP.jsp" %> 
<<<<<<< HEAD

<div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_01_menuNavBarJSP.jsp" %>

<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_03_iFrameJSP.jsp" %>
</div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_04_loginModal.jsp" %>
=======
>>>>>>> refs/heads/AccountAndCreation

<<<<<<< HEAD
<script type="text/javascript">
function hide(){
	document.getElementById("budy").style.visibility= "hidden";
	window.alert("brr");
}

window.onload = function myFunction() {
	  document.getElementById("budy").style.visibility= "visible";
	}

=======
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_01_menuNavBarJSPDynamic.jsp" %>
<br>
<br>
<div id="pagesViewer">
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_04_loginModal.jsp" %>
</div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_05_loadModal.jsp" %>

<script type="text/javascript">
window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("budy").style.visibility= "visible";
	}

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_iFrameJavaScript.js"></script>
<script type="text/javascript">
var src= ${iFrameSource};
var loc =${iFrameLoc};
var iframe = newIframe(loc);
iframe.loadIframe(src);
>>>>>>> refs/heads/AccountAndCreation
</script>

</body>
</html>