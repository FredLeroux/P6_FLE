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
			<div id = "borrowInfoZone" >
				<label id="borrowDemandsNb">
					0
				</label>
				<label>
					<springTags:message code="borrowDemands.name" />
				</label>
				<button onclick="location.href='borrowDemands'" >
					<springTags:message code="goBorrowDemands.name" />
				</button>
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
	<div id="menuNavBar" >
		<ul id="menuNavBarList" class="list">	
			<jstl:forEach items="${optionList}" var="option">
				<li>
					<a id="${option.name}" href=<springTags:message code="${option.href}"/>>
					<span class="menuNavBarIcon"><springTags:message code="${option.icon}"/></span>
					<span><springTags:message code="${option.name}"/></span>
					</a>
			</jstl:forEach>
		</ul>
	</div>
</div>
</div>
</div>
</div>
<div id="connexionStatus" style="display: none;">${sessionScope.logged}</div>




<script type="text/javascript" src="toolBoxJavaScript/04_01_01_toggle.js"></script>
<script type="text/javascript">
	var menuToggle = toggle();
	menuToggle.addSwitchAndToggleDisplayOnClick("connexionStatus", "connexion",
			"loginModal", "disconnect");

	
	updateBorrowDemand();
	launchUpdateInterval();			
	
	function launchUpdateInterval() {
		setInterval("updateBorrowDemand()", 30000)
	}
	function count(num) {
		document.getElementById("borrowDemandsNb").innerHTML = parseInt(document
				.getElementById("borrowDemandsNb").textContent) + 1;
	}
	function updateBorrowDemand() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var obj = JSON.parse(this.responseText);
				getBorrowDemandElmt().innerHTML=obj.numberOfWaitingDemand;
				//toggleDisplayFunctionNumberOfDemand()
			}
		};
		xhttp.open("GET", "05_topo/updateBorrow", true);
		xhttp.send();
	}

	function toggleDisplayFunctionNumberOfDemand() {
		var div = document.getElementById("borrowInfoZone");
		if (getBorrowDemandNumber() == 0) {
			div.style.display = "none";
		} else {
			div.style.display = "block";
		}
	}
	function getBorrowDemandNumber() {
		return parseInt(getBorrowDemandElmt().textContent);
	}

	function getBorrowDemandElmt() {
		return document.getElementById("borrowDemandsNb");
	}
</script>

