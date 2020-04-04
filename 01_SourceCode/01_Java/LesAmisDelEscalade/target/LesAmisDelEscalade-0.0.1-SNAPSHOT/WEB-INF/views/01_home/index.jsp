
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body{
visibility: hidden;
}
</style>



<title>Les Amis de l'escalade</title>

</head>
<body id="budy" >


<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_02_headerJSP.jsp" %> 

<div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_01_menuNavBarJSPDynamic.jsp" %>

<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_03_iFrameJSP.jsp" %>

</div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_04_loginModal.jsp" %>



<script type="text/javascript">
window.onload = function displayWhenReady() {
	//Allow to display page only when all elements are ready needs style body visibility="hidden"
	  document.getElementById("budy").style.visibility= "visible";
	}
</script>

</body>
</html>