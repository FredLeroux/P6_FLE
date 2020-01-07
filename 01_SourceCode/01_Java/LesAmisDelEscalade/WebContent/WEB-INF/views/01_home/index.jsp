<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/resources/00_centralisation/NewFile.jsp" %>
<%@ include file="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_02_headerJSP.jsp" %>
<div>
<%@ include file="/resources/02_templatesJsp/02_01_jspCompoments/02_01_02_jspCompomentsFiles/02_01_02_01_menuNavBarJSP.jsp" %>
</div>
<iframe src="iframeTest.html" style="border:2px solid red;"></iframe>
<div id = "iFrameLoc"></div>
<a href="views/test/iframeTest.html">iframetest</a>
<script type="text/javascript" src="${jspCompomentsJSPath}02_01_03_02_iFrameJavaScript.js"></script>
<script type="text/javascript">
var src= ${iFrameSource};
var iframe = newIframe("iFrameLoc");
iframe.loadIframe(src);
</script>

</body>
</html>