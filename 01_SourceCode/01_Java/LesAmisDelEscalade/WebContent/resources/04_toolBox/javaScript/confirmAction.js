/**
 *
 *
 */

function actionConfirm(){
	return this
}


function deletionConfirm(deleteURL,message){
	if(confirm(message)){
		location.href = deleteURL;
	}
}

function deletionConfirmAndAppReload(contextPath,deleteURL,message){
	if(confirm(message)){
		location.href = deleteURL;
	}
	reInitApp(contextPath, deleteURL);
}

function deletionConfirmApplyURLToParent(deleteURL,message){
	if(confirm(message)){
		window.parent.location.href = deleteURL;
	}
}

function reInitApp(contextPath,url) {
	var xhttp1 = new XMLHttpRequest();
	xhttp1.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.parent.location.href= contextPath;
		}
	};
	xhttp1.open("GET", url, true);
	xhttp1.send();
}


