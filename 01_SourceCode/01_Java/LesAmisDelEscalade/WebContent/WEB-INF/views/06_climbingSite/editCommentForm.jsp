<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code ="editCommentForm.title"/>
	</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div id="editComentUpPage">
</div>
<div class="commentIframe">
	<div class= cancelAndSupressGrid>
		<div class="supressComment">
			<button class="pageButtonWarning" onclick = "navTo('deleteComment')">
				<springTags:message code ="deleteComment.name"/>
			</button>
		</div>
		<div class = "cancelComment">
			<button class="pageButtonNormal" onclick = "navBack('../${commentListBackUrl}')">
				<springTags:message code ="cancelComment.name"/>
			</button>
		</div>
	</div>
	<br>
	<div>
		<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/editCommentTmplt.jsp" %>
	</div>	
	<br>
	<div class="commnentLog">
		<div class="commentLogTitle">	
			<springTags:message code ="commentLogTitle.name"/>
		</div>
		<br>
		<table>
			<jstl:forEach items="${log}" var="entry">
				<tr>
					<td>
						<span class="commentLogPreviousMessage">
							${entry}
						</span>					
					</td>			
				</tr>
			</jstl:forEach>
		</table>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/iFrameJavaScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
<script type="text/javascript">
window.onload = function(){
		window.location="#editComentUpPage"}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/loadModalJavaScript.js"></script>
<script type="text/javascript">
	disableLoadModal();
	addButtonOnclickParentModalToggle("updateTopoFormularButton");
</script>
