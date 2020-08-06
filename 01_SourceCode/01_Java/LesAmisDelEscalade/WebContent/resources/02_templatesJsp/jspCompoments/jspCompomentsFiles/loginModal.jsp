<%@ taglib prefix="springTag" uri="http://www.springframework.org/tags"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jspCompomentsCss/loginModalCSS.css" />
<div id="loginModal" class="modal" style="display: none;">
	<!-- display set none here allow immediate action  -->
	<div id ="logForm">
		<form class="log-grid" action=<springTag:message code="loginAction.form" /> method="post">
			<div class="header">
				<springTag:message code="logModal.name" />
			</div>
			<div class="close" >
				<label id="close"><i class="fas fa-window-close"></i></label>
			</div>
			<div id= "error" class="error">${error}</div>
			<div class="id">
				<label class="log-text" for="login"><springTag:message code="login.name" /></label>
			</div>
			<div class="inputId">
				<input type="text" name="login" id="login"
					placeholder='<springTag:message code ="login.placeHolder"/>'>
			</div>
			<div class="pass">
				<label id="passLabel" class="log-text" for="pass"><springTag:message code="pass.name" /></label>
			</div>
			<div class="inputPass">
				<input type="password" name="pass" id="pass"  
					placeholder='<springTag:message code ="pass.placeHolder"/>'>
			</div>
			<div class="forgot">
				<a href="<springTag:message code ="forgot.thref"/>">
					<label><springTag:message code="forgot.name" /></label>
				</a>
			</div>
			<div class="empty"></div>
			<div class="showPass" >
			<i id="visibility" onclick="togglePassVisibility()" class="fas fa-eye"></i>
			</div>
			<div class="log">
				<button type="submit"><springTag:message code ="log.name"/></button>
			</div>
			<div class="createAccount">			
				<a href="<springTag:message code ="createAccount.href"/>">
					<label><springTag:message code="createAccount.name" /></label>
				</a>
			</div>			
			<div id="cancel" class="cancel">
				<label><springTag:message code="cancel.name" /></label>
			</div>			
		</form>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/toggle.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jspCompomentsJavaScript/iFrameJavaScript.js"></script>
<script type="text/javascript">
	var logToggle = toggle();		
	logToggle.addToggleDisplayOnClickAndClearError("cancel", "loginModal", "error","pass","visibility");
	logToggle.addToggleDisplayOnClickAndClearError("close", "loginModal", "error","pass","visibility");
	logToggle.addOnclickTogglePassVisibility("pass","visibility");
	logToggle.displayOnError("error","loginModal");
</script>

