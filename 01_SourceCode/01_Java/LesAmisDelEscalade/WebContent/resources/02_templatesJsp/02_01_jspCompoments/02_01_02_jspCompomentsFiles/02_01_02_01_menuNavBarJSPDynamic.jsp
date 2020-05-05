<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="jspCompomentsCss/02_01_01_01_menuNavBarCSS.css" />

<div>
<div class="firstLign">
	<div class="greetings">
		<label id="identifiedAs" class="identifiedAs"><springTags:message code="identifiedAs.name" /></label>
		<label id="pseudo" class="pseudo">${sessionScope.pseudo}</label><br>
		</div>
		<div class="containerConnexion">
			<label id="connexion" class="connexion">${sessionScope.connexion} </label>
		
	</div>
</div>
</div>

<div id="menuNavBar" style="display: true;">

	<!-- display not in css allow toggle functional immediatly -->
	<ul id="menuNavBarList" class="list">	
		<jstl:forEach items="${optionList}" var="option">
			<li><a id="option1" href=<springTags:message code="${option.href}"></springTags:message>>
					<springTags:message code="${option.name}"></springTags:message>
				</a>
		</jstl:forEach>
	</ul>
</div>

 <div id="connexionStatus" style="display: none;">${sessionScope.logged}</div>
<span id="isMenuToDisplay" style="display: none">

</span>



<script type="text/javascript" src="toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript">
	var menuToggle = toggle();
	menuToggle.addSwitchAndToggleDisplayOnClick("connexionStatus", "connexion",
			"loginModal", "disconnect")

	
</script>

