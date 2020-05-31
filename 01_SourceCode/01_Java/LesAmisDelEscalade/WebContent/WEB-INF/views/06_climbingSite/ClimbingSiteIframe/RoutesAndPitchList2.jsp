<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>
<div id= "title">
<springTags:message code ="routesAndPitchsList.title"></springTags:message>
</div>
<div id ="pageNav" style="display:flex; justify-content: center;">
<button id="buttonPrev"><i class="fas fa-arrow-alt-circle-left"></i></button>
<div id = "currentPage"></div>/<div id = "totalPages"></div>
<button id="buttonNext" onclick ="nextPage()"><i class="fas fa-arrow-alt-circle-right"></i></button>
</div>
<table>
<jstl:forEach items="${list}" var="route">

<tr>
					<td><springTags:message code = "route.name"/> ${route.routeName}
					<jstl:forEach items="${route.pitchsList}" var="pitch" >					
					<tr>
					<td>   <td>									
					<td><springTags:message code = "pitch.name"/> ${pitch.pitchNumber}</td>
					<td><springTags:message code = "cotation.name"/>${pitch.pitchClimbingLevels}</td>	
					</tr>								
					</jstl:forEach>
					
</td>					
</tr>
</jstl:forEach>
</table>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/routesAndPitchsList.js"></script>
<script type="text/javascript">
var totalPages = ${totalPages};
var currentPage = ${currentPage};

var manager = newRoutesAndPitchsList();
manager.setTotalPages("totalPages", totalPages)
manager.setCurrentPage("currentPage", currentPage)


</script>

