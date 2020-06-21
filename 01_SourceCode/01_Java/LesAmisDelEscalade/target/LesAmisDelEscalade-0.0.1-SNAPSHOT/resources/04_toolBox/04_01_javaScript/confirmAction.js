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

function deletionConfirmApplyURLToParent(deleteURL,message){
	if(confirm(message)){
		window.parent.location.href = deleteURL;		
	}	
}

