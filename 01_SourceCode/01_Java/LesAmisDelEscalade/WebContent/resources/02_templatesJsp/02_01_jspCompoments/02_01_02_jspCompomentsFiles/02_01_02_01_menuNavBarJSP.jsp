<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${jspCompomentsCSSPath}02_01_01_01_menuNavBarCSS.css" />

<div id="menuIcon" class="icon">
	<i class="fas fa-bars"></i>
</div>
<div class="containerConnexion">
	<a class="connexion" href="${connexionHref}">
		${connexionName}
	</a>
</div>
<br>
<div id="menuNavBar" style = display:none;><!-- display not in css allow toggle functional immediatly -->
	<ul id="menuNavBarList" class="list">
		<li><a href=<springTags:message code="menuNavBarOption1.href"></springTags:message>>
				<springTags:message code="menuNavBarOption1.name"></springTags:message>
			</a>
		<li><a href=<springTags:message code="menuNavBarOption2.href"></springTags:message>>
				<springTags:message code="menuNavBarOption2.name"></springTags:message>
			</a>
		<li><a href=<springTags:message code="menuNavBarOption3.href"></springTags:message>>
				<springTags:message code="menuNavBarOption3.name"></springTags:message>
			</a>
		<li><a href=<springTags:message code="menuNavBarOption4.href"></springTags:message>>
				<springTags:message code="menuNavBarOption4.name"></springTags:message>
			</a>
	</ul>
</div>
<script type="text/javascript" 

src="${jspCompomentsJSPath}02_01_03_01_menuNavBarJavaScript.js"></script>
<script type="text/javascript">
addToggleDisplayOnclick("menuIcon", "menuNavBar")
</script>
