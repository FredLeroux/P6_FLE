<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/climbingSiteDetailsCss.css" />
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<div class = "climbingDetailsContainer">
	<div id ="site" class="zone1">
	<div class="zoneTitle"><springTags:message code ="climbingSiteDetails.title"/></div>
		<br>
		<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/displaySiteTmplt.jsp" %>			
	</div>	
	<div class="zone2" id="route" >
<div class="zoneTitle" id= "title">
	<springTags:message code ="routesAndPitchsList.title"/>
</div>
<br>		
		<jsp:include page="/WEB-INF/views/06_climbingSite/ClimbingSiteIframe/RoutesAndPitchList3.jsp"/>
			<br>
				
	</div>	
	<div class="zone3" >
	<div class="zoneTitle"><springTags:message code ="commentsZone.title"/></div>
	<div id="commentsList" ></div>
	<br>
</div>
</div>
<br>
<br>
<input id ="src" type="hidden" value ="${pageContext.request.contextPath}${listCommentSrc}">
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_iFrameJavaScript.js"></script>
<script type="text/javascript">
var iSrc = document.getElementById("src")
var iframe = newIframe("commentsList");
iframe.loadIframe("${pageContext.request.contextPath}${listCommentSrc}");


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