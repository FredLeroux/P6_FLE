<%@taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/modalPage.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/siteCommentModalCss.css" />
<style type="text/css">


</style>
</head>

<div id="siteCommentModal" class ="formModal" style="display: none;">
	<div id="commentFormContainer" class = "commentModal-content" >
		<form class = "commentModalGrid" action="06_climbingSite/postComment" method = "Post">
			<div class="charCounter">
				<span id="count" >${commentMaxChar}</span>
			</div>
			<div class= "close">
				<i class="fas fa-window-close"></i>
			</div>
			<div class="textAreaZone">
				<textarea id="comment" name="comment" rows="10" cols="50" maxlength="${commentMaxChar}" ></textarea>
			</div>
			<div class="submitBtn">
				<input id="postCommentBtn" type="submit"  value="<springTags:message code="sendComment.message"/>"/>
			</div>
		</form>		
	</div>
</div>
<input id="charLimit" type="hidden" value="${sessionScope.commentMaxChar}">
<input id="errorMessage" type ="hidden" value="<springTags:message code="starNotAccepted.message"/>">
<input id="sendMessage" type ="hidden" value="<springTags:message code="sendComment.message"/>">
<input id="errorLimitMessage" type ="hidden" value="<springTags:message code="charLimitReached.message"/>">
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/modalTools.js"></script>
<script type="text/javascript">
countAndCheckLimitCharOnKeyPress("comment", "postCommentBtn", "count", "charLimit", "*", "sendMessage", "errorMessage","normalCSS","badCSS");

</script>