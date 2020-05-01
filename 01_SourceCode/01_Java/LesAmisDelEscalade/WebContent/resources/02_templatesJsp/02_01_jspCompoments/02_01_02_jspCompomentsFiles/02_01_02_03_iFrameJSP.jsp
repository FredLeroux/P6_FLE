<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iframe</title>
</head>
<body>
<div id = "iFrameLoc" class = "iframe"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/02_01_03_02_iFrameJavaScript.js"></script>
<script type="text/javascript">
var src= ${iFrameSource};
var iframe = newIframe("iFrameLoc");
iframe.loadIframe(src);
</script>
</body>
</html>