<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix ="springTags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table> 
<thead>
<tr>
<th><springTags:message code="topoTitle.name"/></th>
<th><springTags:message code="borrower.name"/></th>
<th><springTags:message code="borrowDemandStatus.name"/></th>
</tr>
</thead>
<tbody>
<jstl:forEach items = "${borrowList}" var="list">
<tr>
<td>${list.climbingTopo}</td>
<td>${list.borrowerUserInfo}</td>
<td>${list.lendingStatus}</td>
<td><a href="borrowDemand?demand=accepted&id=${list.id}"><springTags:message code="borrowDemand.accepted"/></a></td>
<td><a href="borrowDemand?demand=rejected&id=${list.id}"><springTags:message code="borrowDemand.rejected"/></a></td>
</tr>
</jstl:forEach>
</tbody>
</table>
</body>
</html>