<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springTags"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User_Info</title>
</head>
<body>
Control user info display 
<div>Formulaire d inscription test create and read </div>
<springForm:form action="saveUser" method="post" modelAttribute="UserInfo">
<table id="userInfoFormTable">
<springForm:hidden path="id" />
<springTags:bind path="firstName">
<tr>
<td id="firstNameLbl"><springForm:label path="firstName">Prénom</springForm:label></td>
<td id="firstNameInput"><springForm:input path="firstName"/>
<td><springForm:errors path="firstName"></springForm:errors></td>
</tr>
</springTags:bind>
<springTags:bind path="firstName">
<tr>
<td id="firstNameLbl">Prénom</td>
<td id="firstNameInput"><springForm:input path="firstName"/>
<td><springForm:errors path="firstName"></springForm:errors></td>
</tr>
</springTags:bind>


</table>

</springForm:form>
</body>
</html>