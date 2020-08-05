



function newAjaxUpdater() {
	return this;
}

function launchUpdateInterval(intervalMs,toDisplayLocId,borrowDemandsNbLoc,controllerUrl,displayNotificationInputLoc) {
	setInterval("updateBorrowDemand('"+toDisplayLocId+"','"+borrowDemandsNbLoc+"','"+controllerUrl+"','"+displayNotificationInputLoc+"')", intervalMs)
}

function updateBorrowDemand(toDisplayLocId,borrowDemandsNbLoc,controllerUrl,displayNotificationInputLoc) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var obj = JSON.parse(this.responseText);
			let i = obj.numberOfWaitingDemand;
			getBorrowDemandElmt(borrowDemandsNbLoc).innerHTML = i;
			toggleDisplayFunctionNumberOfDemand(toDisplayLocId,borrowDemandsNbLoc,displayNotificationInputLoc)
		}
	};
	xhttp.open("GET", "05_topo/updateBorrow", true);
	xhttp.send();
}

function toggleDisplayFunctionNumberOfDemand(toDisplayLocId,borrowDemandsNbLoc,displayNotificationInputLoc) {
	var div = document.getElementById(toDisplayLocId);
	var displayBool = document.getElementById(displayNotificationInputLoc).value;
	if (getBorrowDemandNumber(borrowDemandsNbLoc)==0 || displayBool=="false") {
		div.style.display = "none";
	} else {
		div.style.display = "block";
	}
}

function hideNumberOfDemandOnParent(toDisplayLocId){
	var div = window.parent.document.getElementById(toDisplayLocId);
	div.style.display = "none";
}

function setInputDisplayNotificationToFalse(inputDisplayNotificationLocId){
var notificationDisplay = window.parent.document.getElementById(inputDisplayNotificationLocId);
	 notificationDisplay.value = false;
}


function getBorrowDemandNumber(borrowDemandsNbLoc) {
	return parseInt(getBorrowDemandElmt(borrowDemandsNbLoc).textContent);
}

function getBorrowDemandElmt(borrowDemandsNbLoc) {
	return document.getElementById(borrowDemandsNbLoc);
}


function updateBorrowNumber(borrowDemandsNbLoc,demandLeftNb) {
	window.parent.document.getElementById(borrowDemandsNbLoc).innerHTML = demandLeftNb;


function myFunction() {

	}	}