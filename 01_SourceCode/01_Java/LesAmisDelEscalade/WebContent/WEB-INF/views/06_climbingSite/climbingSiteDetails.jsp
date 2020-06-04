<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.container{
display: grid;
grid-gap: 10px;
background-color: #2196F3;
grid-template-columns: 60% auto;
grid-template-rows: auto 30vw;
grid-template-areas: 
'zone1 zone2'
'zone3 zone3';
}

.container>div{
background-color: white;

}

iframe{
width: 100%;
height: 100%;


}


.zone1{
grid-area: zone1;
border: solid 2px blue;
overflow: auto;
}
.zone2{
font-size: 1vw;
overflow: auto;
grid-area: zone2;
border: solid 2px red;
}
.zone3{
font-size: 1vw;
overflow: auto;
grid-area: zone3;
border: solid 2px green;}

</style>
</head>
<body>

<div class = "container">
	<div id ="site"class="zone1">ZONE 1
		<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/displaySiteTmplt.jsp" %>			
	</div>	
	<div class="zone2" id="route" >ZONE 2			
		<jsp:include page="/WEB-INF/views/06_climbingSite/ClimbingSiteIframe/RoutesAndPitchList3.jsp"/>
			<br>
				
	</div>	
	<div class="zone3">ZONE 3
	<iframe src="${pageContext.request.contextPath}${listCommentSrc}"></iframe>
</div>
</div>
<br>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript">


var comment = ${commentModal};
//addOnClicksendIdtoController();
function getSiteId(){
	var imput = document.getElementById("id");
	return imput.value;
}

function addOnClicksendIdtoController(){
	var button = document.getElementById("commentSite");
	button.setAttribute("onclick", "window.alert("+getSiteId()+")");
}
var toggleComment = toggle();
toggleComment.addToElementToggleParentElementDisplayOnClick("commentSite", comment);

/*window.alert(document.getElementById("site").scrollHeight)
document.getElementById("route").style.height = document.getElementById("site").scrollHeight +"px";*/


var modal = newLoadModal();
modal.killParentModalOnHashChange("siteCommentModal");
modal.killParentModalOnHashChange("siteCommentNotAllowedModal");
modal.killParentModalOnHashChange("loginModal");




</script>




</body>
</html>