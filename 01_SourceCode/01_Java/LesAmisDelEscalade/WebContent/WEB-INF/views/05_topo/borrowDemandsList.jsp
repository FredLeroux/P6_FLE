<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code="borrowDemandList.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />	
</head>
<div class="borrowDemandTableName">
	<springTags:message code="borrowDemandTable.name"/>
</div>
<jstl:set var="list" value="${borrowList}"></jstl:set>
<jstl:if test="${empty(list) }">
	<div class="emptyBorrowList" >
		<div class = "emptyBorrowListIconExclamation">
			<springTags:message code ="noResultToDisplay.title"/>
		</div>
		<br>
		<springTags:message code="emptyBorrowList.name"/>
		<br>
		<br>
	</div>
	<br>
</jstl:if>
<jstl:if test="${!empty(list) }">
	<table class="tableStyle0"> 
		<thead>
			<tr>
				<th>
					<springTags:message code="topoTitle.name"/>
				</th>
				<th>
					<springTags:message code="borrower.name"/>
				</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items = "${borrowList}" var="listElmt">
				<tr>
					<td>
						${listElmt.climbingTopo}
					</td>
					<td>
						${listElmt.borrowerUserInfo}
					</td>
					<td>
						<a href="borrowDemand?demand=accepted&id=${listElmt.id}" onclick="parentElementToggleDisplay('loading')" class="borrowDemandAccept">
							<springTags:message code="borrowDemand.accepted"/>
						</a>
					</td>
					<td>
						<a href="borrowDemand?demand=rejected&id=${listElmt.id}" onclick="parentElementToggleDisplay('loading')" class="borrowDemandReject">
							<springTags:message code="borrowDemand.rejected"/>
						</a>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</jstl:if>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_loadModalJavaScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/ajaxUpdateByTimeInterval.js"></script>
<script type="text/javascript">
	var demmandLeft = ${borrowDemand}
	var borrowUpdate = newAjaxUpdater();
	borrowUpdate.hideNumberOfDemandOnParent("borrowInfoZone");
	window.onload = function() {
		borrowUpdate.setInputDisplayNotificationToFalse("displayNotification")
		};
	var loadModal = newLoadModal();
	loadModal.disableLoadModalCustom('loading');
</script>
