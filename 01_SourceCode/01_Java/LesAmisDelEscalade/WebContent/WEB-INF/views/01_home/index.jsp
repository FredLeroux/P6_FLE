
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
<!--
body{
visibility: hidden;}
-->
</style>

<title>Insert title here</title>
</head>
<body id="budy" >


<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_02_headerJSP.jsp" %> 

<div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_01_menuNavBarJSP.jsp" %>

<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_03_iFrameJSP.jsp" %>
</div>
<%@ include file ="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_04_loginModal.jsp" %>

<script type="text/javascript">
function hide(){
	document.getElementById("budy").style.visibility= "hidden";
	window.alert("brr");
}

window.onload = function myFunction() {
	  document.getElementById("budy").style.visibility= "visible";
	}

</script>

</body>
</html>