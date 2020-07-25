<%@taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/modalPage.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/siteCommentModalCss.css" />
</head>
<body>
	<div id="siteCommentNotAllowedModal" class ="formModal" style="display: none;">
		<div id="commentFormContainer" class = "commentNotAllowedModal-content" >
			<div class="commentNotAllowedModalGrid">
				<div class = "commentNotAllowed1">
					<i id="closeNotAllowedModal" class="fas fa-window-close"></i>
				</div>
				<div class = "commentNotAllowed2">				
					<springTags:message code ="commentNotAllowed.title"></springTags:message><br>				
				</div>
				<div class = "commentNotAllowed3">
					<div><springTags:message code= "commentNotAllowed.message"/></div>
				</div>
				<div class = "commentNotAllowed4">
					<button  onclick="location.href='<springTag:message code ='createAccount.href'/>'">
						<springTags:message code="createAccount.name" />
					</button>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/modalTools.js"></script>
<script type="text/javascript">
hideOnclick("closeNotAllowedModal", "siteCommentNotAllowedModal");

</script>
</body>


