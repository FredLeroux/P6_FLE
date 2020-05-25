 function newFormFieldDisplayer(){
	 return this;
 }
 
 function label(labelId){
	 return document.getElementById(labelId);	 
 }
 
function input(inputId){
	return document.getElementById(inputId);
}

function display(displayVar,labelId,inputId){
	if(displayVar){
		label(labelId).style.display ="block";
		input(inputId).style.display ="block";
	}else{
		label(labelId).style.display ="none";
		input(inputId).style.display ="none";
	}
}