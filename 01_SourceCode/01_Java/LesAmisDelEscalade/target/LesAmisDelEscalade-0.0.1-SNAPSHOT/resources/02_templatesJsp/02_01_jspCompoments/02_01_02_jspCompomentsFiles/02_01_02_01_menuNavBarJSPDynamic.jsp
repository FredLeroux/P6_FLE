<%@ taglib prefix="springTags" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<link rel="stylesheet" type="text/css" href="jspCompomentsCss/02_01_01_01_menuNavBarCSS.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<div class="menuBar">
	<div class="firstLign">
		<div class="hail">
			<div class="greetings">
				<label id="identifiedAs" class="identifiedAs">
					<springTags:message code="identifiedAs.name" />
				</label>
				<label id="pseudo" class="pseudo">
					${sessionScope.pseudo}
				</label>
			</div>
		</div>
		<div class ="borrow"> 
			<div id = "borrowInfoZone" style ="display: none" >
				<label id="borrowDemandsNb">
					0
				</label>
				<label>
					<springTags:message code="borrowDemands.name" />
				</label>
				<button onclick="location.href='borrowDemands'" >
					<springTags:message code="goBorrowDemands.name" />
				</button>
				<input id="displayNotification" value = true >
			</div>
		</div>
		<div class="logIn">
			<div class="containerConnexion">
				<label id="connexion" class="connexion">
					${sessionScope.connexion}
				</label>		
			</div>
		</div>		
		<div class="menu">
			<div class="menuDrop"><springTags:message code="siteMenu.name"/>
				
				
					<ul id="menuNavBarList" class="list">	
						<jstl:forEach items="${optionList}" var="option">
							<li>
								<a id="${option.name}" href=<springTags:message code="${option.href}"/>>
									<span class="menuNavBarIcon">
										<springTags:message code="${option.icon}"/>
									</span>
									<span>
										<springTags:message code="${option.name}"/>
									</span>
								</a>
						</jstl:forEach>
					</ul>
				
			
		</div>
	</div>
</div>
</div>
<div id="connexionStatus" style="display: none;">${sessionScope.logged}</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/toggle.js"></script>
<script type="text/javascript" src="/LesAmisDelEscalade/resources/04_toolBox/javaScript/ajaxUpdateByTimeInterval.js"></script>
<script type="text/javascript">
	var menuToggle = toggle();
	menuToggle.addSwitchAndToggleDisplayOnClick("connexionStatus", "connexion",	"loginModal", "disconnect");
	var updater = newAjaxUpdater();
	updater.updateBorrowDemand("borrowInfoZone", "borrowDemandsNb", "05_topo/updateBorrow","displayNotification");	
	updater.launchUpdateInterval(3000,"borrowInfoZone", "borrowDemandsNb", "05_topo/updateBorrow","displayNotification");	


</script>

