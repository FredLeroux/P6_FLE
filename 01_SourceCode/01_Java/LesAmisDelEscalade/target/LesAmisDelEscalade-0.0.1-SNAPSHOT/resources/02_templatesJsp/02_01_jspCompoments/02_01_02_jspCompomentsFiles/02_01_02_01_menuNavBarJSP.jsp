<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="jspCompomentsCss/02_01_01_01_menuNavBarCSS.css" />

<div id="menuIcon" class="icon">
<span id="iconSet" class ="iconBasis"><i class="fas fa-bars"></i></span>
	
</div>
<div class="containerConnexion">
	<label id="connexion" class="connexion">${sessionScope.connexion}  </label><!-- ${connexionName} -->
</div>

<div id="menuNavBar" style="display: none;">
	<!-- display not in css allow toggle functional immediatly -->
	<ul id="menuNavBarList" class="list">
		<li><a id="option1" href=<springTags:message code="menuNavBarOption1.href"></springTags:message>>
				<springTags:message code="menuNavBarOption1.name"></springTags:message>
			</a>
		<li><a id="option2" href=<springTags:message code="menuNavBarOption2.href"></springTags:message>>
				<springTags:message code="menuNavBarOption2.name"></springTags:message>
			</a>
		<li><a id="option3" href=<springTags:message code="menuNavBarOption3.href"></springTags:message>>
				<springTags:message code="menuNavBarOption3.name"></springTags:message>
			</a>
		<li><a id="option4" href=<springTags:message code="${option4}"></springTags:message>>
				<springTags:message code="${option4}"></springTags:message>
			</a>
	</ul>
</div>
<script type="text/javascript" src = "jspCompomentsJavaScript/02_01_03_01_menuNavBarJavaScript.js">

</script>
<script type="text/javascript" src="toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript">
//var option4 = ${option4};
//var adminCode = ${adminHide};
var menuToggle = toggle();
var option = displayOption();

menuToggle.addToggleDisplayAndColorOnclick("iconSet", "menuNavBar","iconSet", "iconBasis", "iconInvert");
menuToggle.addToggleDisplayOnClick("connexion", "loginModal");
option.conditionalOptionsDiplay("adminOnly");
function getOption(option){
	return option;
}
</script>

