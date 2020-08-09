<%@taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/06_CSSFiles/pages/modalPage.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/06_CSSFiles/pages/siteCommentModalCss.css" />
</head>
<div id="siteCommentModal" class ="formModal" style="display: none;">
	<div id="commentFormContainer" class = "commentModal-content" >
		<div class = "commentModalGrid" action="06_climbingSite/postComment" method = "Post">
			<div  class="charCounter">
				<span id="count" class="charLimitNormalCss">${commentMaxChar}</span>
			</div>
			<div class= "closeComment">
				<i id="closeComment" class="fas fa-window-close"></i>
			</div>
			<div class="textAreaZone">
				<textarea id="comment" name="comment" rows="10" cols="50" maxlength="${commentMaxChar}" ></textarea>
			</div>
			<div class="submitBtn">
				<button id="postCommentBtn" onclick="AJAXSubmitAndRedirectIframe('siteCommentModal','06_climbingSite/postComment','POST','iframeHome','url')" class="sendButton"><springTags:message code="sendComment.message"/></button>
			</div>
		</div>		
	</div>
</div>
<input id="charLimit" type="hidden" value="${sessionScope.commentMaxChar}">
<input id="errorMessage" type ="hidden" value="<springTags:message code="charNotAccepted.message"/>">
<input id="sendMessage" type ="hidden" value="<springTags:message code="sendComment.message"/>">
<input id="errorLimitMessage" type ="hidden" value="<springTags:message code="charLimitReached.message"/>">
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/modalTools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/AJAXSubmitForm.js"></script>
<script type="text/javascript">
countAndCheckLimitCharOnKeyPress("comment", "postCommentBtn", "count", "charLimit", "*", "sendMessage", "errorMessage","commentNormalCSS","charLimitNormalCss", "commentBadCSS","charLimitBadCSS");
hideOnclick("closeComment", "siteCommentModal");
</script>