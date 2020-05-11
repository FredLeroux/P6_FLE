<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${siteName}<br>
MEssage si la voie n'est nommé renseigner anonyme si plusieur incrémenter anamye de 1 en 1
<%@ include file="/resources/02_templatesJsp/02_02_formJsp/02_02_01_formFiles/createNewSiteRouteTmplt.jsp" %>		
		
<jstl:forEach items="${siteRoutesList}" var="route">
			<li><Label>${route.key}</Label>
		</jstl:forEach>
		<br><br>
		

</body>
</html>