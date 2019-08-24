<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Control display testConnexionDb
<div>
<h1>Test form sending</h1>
<form:form action="savetest" method = "post" modelAttribute="testConnexionDb">
<form:hidden path="id" />
<form:label path="data1">data1</form:label><form:input path="data1" /><br>
<form:label path="data2">data2</form:label><form:input path="data2" />
<br>
<form:button>send</form:button><br>
<button type="submit">send button</button>

</form:form>
</div>
</body>
</html>