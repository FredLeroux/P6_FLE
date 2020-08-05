<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<head>
	<title>
		<springTags:message code = "siteRoutesForm.title"/>
	</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssFiles/07_01_pages/pageElmtCss.css" />
</head>
<div id="up"></div>
<br>
<div class="siteRoutesFormPageTitle" >
	<springTags:message code = "siteRoutesForm.title"/>
</div>
<div class ="routeAndPitchFormHead">
	<table style="align-content: right" class="routeAndPitchFormHeadTable">
		<tr>
			<th>
				<springTags:message code = "siteNameTitle.name"/>	
			</th>
			<td>
				${siteName}	
			</td>
		</tr>	
	</table>
</div>
<br>
<div>
	<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewSiteRouteTmplt.jsp" %>	
</div>	
<div class="routeFormEndingButtonPositioning">
	<button class="pageButtonNormal"  onclick="window.location.href='${routeEndController}'">
		<springTags:message code = "finishHim.name"/>
	</button>
</div>
<br>
<div>
	<jstl:set var="hrefParamaters" value="?route=${routeName}&index=${indexGetter.index}"></jstl:set>
	<jstl:set var="checkList" value="${siteRoutesList}"	></jstl:set>
	<jstl:if test="${!empty(checkList)}">	
		<div class="routesListTitle" >
			<springTags:message code = "routesListTitle.name"/>
		</div>
		<br>
		<table class ="tableStyle1">	
			<jstl:forEach items="${siteRoutesList}" var="route">
				<jstl:set var = "routeName" value = "${route.key}">
				</jstl:set>
				<tr>
					<td>
						${routeName}
					</td>
					<td>
						<a href="${siteRouteEditController}?route=${routeName}#upEditRouteName" class="linkInTable">
							<springTags:message code = "routeNameModification.name"/>
						</a>
					</td>
					<td>
						<a href="${editRoutePitchs}?route=${routeName}#pitchFormUp" class="linkInTable">
							<springTags:message code = "routePitchListModification.name"/>
						</a>
					</td>
					<td>
						<a href="${siteRouteDeleteController}?route=${routeName}" class="trash" >
						<springTags:message code = "deleteSiteRoute.name"/>
						</a>
					</td>				
				</tr>
			</jstl:forEach>		
		</table>
	</jstl:if>	
</div>
<br>


