<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReloadPage</title>
</head>
<body onload="changeParentLocation('${pageContext.request.contextPath}?error=501')">
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/link.js"></script>
</body>
</html>