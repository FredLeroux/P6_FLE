<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<%@ taglib uri ="http://www.springframework.org/tags" prefix ="springTags" %>

<table>
<jstl:forEach items="${routes}" var="route">

<tr>
					<td><springTags:message code = "route.name"/> ${route}
					<jstl:forEach items="${pitchs[route]}" var="pitch" >					
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


