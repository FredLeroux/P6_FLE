<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" type="text/css"
	href="/LesAmisDelEscalade/resources/02_templatesJsp/02_01_jspCompoments/02_01_01_jspCompomentsCSS/02_01_01_01_menuNavBarCSS.css" />
<springTags:message code="menuNavBarOption1.name"/>
<div id="menuNavBar">
	<ul id="menuNavBarList" class ="list">
		<li><a
			href=<springTags:message code="menuNavBarOption1.href"></springTags:message>><springTags:message
					code="menuNavBarOption1.name"></springTags:message></a>
		<li><a
			href=<springTags:message code="menuNavBarOption2.href"></springTags:message>><springTags:message
					code="menuNavBarOption2.name"></springTags:message></a>
		<li><a
			href=<springTags:message code="menuNavBarOption3.href"></springTags:message>><springTags:message
					code="menuNavBarOption3.name"></springTags:message></a>
		<li><a
			href=<springTags:message code="menuNavBarOption4.href"></springTags:message>><springTags:message
					code="menuNavBarOption4.name"></springTags:message></a>
		<li><a
			href=<springTags:message code="menuNavBarOption5.href"></springTags:message>><springTags:message
					code="menuNavBarOption5.name"></springTags:message></a>
	</ul>
</div>