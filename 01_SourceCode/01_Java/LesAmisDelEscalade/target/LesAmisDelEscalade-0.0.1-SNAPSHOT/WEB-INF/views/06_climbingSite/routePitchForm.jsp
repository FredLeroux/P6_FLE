<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
 <%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "routePitchForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/pages/pageElmtCss.css" />
</head>
<div id="pitchFormUp"></div>
<br>
<div class="sitePitchFormPageTitle" >
	<springTags:message code = "routePitchForm.title"/>
</div>
<div class ="routeAndPitchFormHead">
	<table  class="routeAndPitchFormHeadTable">
		<tbody>
			<tr>
				<th>
					<springTags:message code = "siteNameTitle.name"/>	
				</th>
				<td>
					${siteName}	
				</td>
			</tr>	
			<tr>		
				<th>
					<springTags:message code = "routeNameTitle.name"/>	
				</th>
				<td>
					${routeName}	
				</td>
			</tr>
		</tbody>
	</table>
</div>
<br>
<div>
	<%@ include file="/resources/02_templatesJsp/formJsp/formFiles/createNewRoutePitchTmplt.jsp" %>
</div>
<div class="routeFormEndingButtonPositioning">
	<button class="pageButtonNormal"  onclick="window.location.href='${pitchEndController}'">
		<springTags:message code = "finishHim.name"/>
	</button>
</div>
<br>
<div>
	<jstl:set var="routePithContainer" scope="page" value="${routePitchList}"/>
	<jstl:if test="${!empty(routePithContainer)}">
	<div class="pitchsListTitle" >
			<springTags:message code = "pitchsListTitle.name"/>
	</div>
	<br>
	<table class ="tableStyle1">
		<jstl:forEach items="${routePitchList}" var="pitch" varStatus="indexGetter">
			<jstl:set var="lvl" scope="page" value="${pitch.climbingLevels}"/>
			<jstl:set var="hrefParamaters" value="?route=${routeName}&index=${indexGetter.index}"></jstl:set>
				<tr>
					<td>
						<springTags:message code = "pitch1.name"/>${pitch.pitchNumber}
					</td>
					<td>
						<springTags:message code = "cotation1.name"/>${lvl.cotationLevel}
					</td>
					<td>
						<a href="${pitchRouteModification}${hrefParamaters}#upEditPitch" class="linkInTable" >
							<springTags:message code = "pitchModification.name"/>
						</a>
					</td>
					<td>
						<a href="${deleteRoutePitch}${hrefParamaters}" class="trash" >
							<springTags:message code = "deletePitch.name"/>
						</a>
					</td>
				</tr>		
		</jstl:forEach>
	</table>
	</jstl:if>
</div>
<br>
	

	

