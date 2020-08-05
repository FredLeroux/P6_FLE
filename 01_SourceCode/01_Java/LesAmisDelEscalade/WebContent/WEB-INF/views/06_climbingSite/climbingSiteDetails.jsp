
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code ="climbingSiteDetails.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/climbingSiteDetailsCss.css" />	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/iframeSetCss.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/commentScrollBarCss.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<button onclick= "window.parent.location ='../callListBack?listType=climbingSitesShow'" class="pageButtonNormal">
	<springTags:message code ="back.name"/>
</button>
<div class = "climbingDetailsContainer">	
	<div id ="site" class="zone1">	
		<div class="zoneTitle">
			<springTags:message code ="climbingSiteDetails.title"/>
		</div>
		<br>
		<div>
			<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/displaySiteTmplt.jsp" %>			
		</div>
	</div>	
	<div class="zone2" id="route" >
		<div class="zoneTitle" id= "title">
			<springTags:message code ="routesAndPitchsList.title"/>
		</div>
		<br>		
		<jsp:include page="/WEB-INF/views/06_climbingSite/ClimbingSiteIframe/RoutesAndPitchList3.jsp"/>
		<br>				
	</div>	
	<div class="titleZ3" >
		<div class="zoneTitle">
			<springTags:message code ="commentsZone.title"/>
		</div>
		<br>
	</div>
	<div class="zone3" >			
		<div class="commentListContainer">
			<div id="commentsList">
			</div>	
		</div>	
		<br>
	</div>
</div>
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
	var toggleComment = toggle();
		toggleComment.addToElementToggleParentElementDisplayOnClick("commentSite", comment);
	var modal = newLoadModal();
		modal.killParentModalOnHashChange("siteCommentModal");
		modal.killParentModalOnHashChange("siteCommentNotAllowedModal");
		modal.killParentModalOnHashChange("loginModal");
</script>
