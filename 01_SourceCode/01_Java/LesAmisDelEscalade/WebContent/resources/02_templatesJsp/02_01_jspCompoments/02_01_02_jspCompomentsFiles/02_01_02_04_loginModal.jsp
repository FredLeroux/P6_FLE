<%@ taglib prefix="springTag" uri="http://www.springframework.org/tags" %>


<div>

<form action="${logAction}" method="post">
<label for="login"><springTag:message code="login.name"/></label>
<input type="text" name="login" id="login" placeholder='<springTag:message code ="login.placeHolder"/>' >
<label for="pass"><springTag:message code="pass.name"/></label>
<input type="password" name="pass" id="pass" placeholder='<springTag:message code ="pass.placeHolder"/>' >


</form>
</div>