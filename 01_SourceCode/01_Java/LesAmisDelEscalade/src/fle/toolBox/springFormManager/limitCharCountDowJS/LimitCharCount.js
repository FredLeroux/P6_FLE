

function updateCharOnInput(displayLocId,maxChar,stringLocId){
	getElement(stringLocId).setAttribute("oninput", "countCharLeft('"+displayLocId+"','"+maxChar+"','"+stringLocId+"')");
}



function countCharLeft(displayLocId,maxChar,stringLocId){
	innerCharLeft(displayLocId,getcharLeft(maxChar, getStringSize(stringLocId)));
}



function getStringSize(stringLocId){
	return getElement(stringLocId).value.length;
}

function innerCharLeft(displayLocId,charLeft){
	getElement(displayLocId).innerHTML = charLeft;
}

function getcharLeft(maxChar,currentChar){
	return maxChar-currentChar;
}

function getElement(elmtId){
	return document.getElementById(elmtId);
}