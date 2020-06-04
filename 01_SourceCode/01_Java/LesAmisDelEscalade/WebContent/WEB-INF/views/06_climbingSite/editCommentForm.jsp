<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "deleteComment">delete Comment</a>
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/editCommentTmplt.jsp" %>
<br>
<br>
<table>
	<jstl:forEach items="${log}" var="entry">
		<tr>
			<td>
				${entry}
			</td>			
		</tr>


	</jstl:forEach>
</table>
</body>
</html>