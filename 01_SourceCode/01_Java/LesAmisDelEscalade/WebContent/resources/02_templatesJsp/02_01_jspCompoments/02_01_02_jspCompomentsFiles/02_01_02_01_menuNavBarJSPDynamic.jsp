<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
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
	<jstl:forEach items="${optionList}"  var="option">
	<li><a id="option1" href=<springTags:message code="${option.href}"></springTags:message>>
				<springTags:message code="${option.name}"></springTags:message>
			</a>


</jstl:forEach>
	
	</ul>
</div>
<div id= "conexionStatus" style = "display:none;">${sessionScope.logged}</div>




<script type="text/javascript" src="toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript">

var menuToggle = toggle();


menuToggle.addToggleDisplayAndColorOnclick("iconSet", "menuNavBar","iconSet", "iconBasis", "iconInvert");
//menuToggle.addToggleDisplayOnClick("connexion", "loginModal");
menuToggle.addSwitchAndToggleDisplayOnClick("conexionStatus","connexion", "loginModal","disconnect")

function getOption(option){
	return option;
}
</script>

