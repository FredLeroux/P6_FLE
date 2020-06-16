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