<%@ taglib prefix="springTag" uri="http://www.springframework.org/tags"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="jspCompomentsCss/02_01_01_03_loginModalCSS.css" />

<div id="loginModal" class="modal" style="display: none;">
	<!-- display set none here allow immediate action  -->
	<div>
		<form class="log-grid" action="${logAction}" method="post">
			<div class="header">
				<springTag:message code="logModal.name" />
			</div>
			<div class="close">
				<label id="close"><springTag:message code="close.name" /></label>
			</div>
			<div class="id">
				<label class="log-text" for="login"><springTag:message code="login.name" /></label>
			</div>
			<div class="inputId">
				<input type="text" name="login" id="login"
					placeholder='<springTag:message code ="login.placeHolder"/>'>
			</div>
			<div class="pass">
				<label class="log-text" for="pass"><springTag:message code="pass.name" /></label>
			</div>
			<div class="inputPass">
				<input type="password" name="pass" id="pass"
					placeholder='<springTag:message code ="pass.placeHolder"/>'>
			</div>
			<div class="forgot">
				<a href="<springTag:message code ="forgot.href"/>">
					<label><springTag:message code="forgot.name" /></label>
				</a>
			</div>
			<div class="createAccount">
				<a href="<springTag:message code ="createAccount.href"/>">
					<label><springTag:message code="createAccount.name" /></label>
				</a>
			</div>
			<div class="log">
				<input type="submit" value="<springTag:message code ="log.name"/>" />
			</div>
			<div id="cancel" class="cancel">
				<label><springTag:message code="cancel.name" /></label>
			</div>


		</form>
	</div>
</div>
<script type="text/javascript" src="toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript">
	var logToggle = toggle();
	logToggle.addToggleDisplayOnClick("cancel", "loginModal");
	logToggle.addToggleDisplayOnClick("close", "loginModal");
</script>