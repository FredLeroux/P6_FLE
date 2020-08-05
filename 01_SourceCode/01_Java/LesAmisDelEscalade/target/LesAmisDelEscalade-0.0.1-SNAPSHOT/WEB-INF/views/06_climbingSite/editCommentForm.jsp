<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code ="editCommentForm.title"/>
	</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div class="commentIframe">
	<div class= cancelAndSupressGrid>
		<div class="supressComment">
			<button class="pageButtonWarning" onclick = "location.href = 'deleteComment'">
				<springTags:message code ="deleteComment.name"/>
			</button>
		</div>
		<div class = "cancelComment">
			<button class="pageButtonNormal" onclick = "window.parent.location.reload()">
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