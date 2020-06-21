/**
 * 
 */

var toCheck;
var displayCharElmt;

function getToCheck() {
	return toCheck;
}

function setToCheck(toCheckLocId) {
	toCheck = getElmt(toCheckLocId);
}

function getDisplayCharElmt() {
	return displayCharElmt;
}

function setDisplayCharElmt(displayCharLocId) {
	displayCharElmt = getElmt(displayCharLocId)
}

function getElmt(locationId) {
	return document.getElementById(locationId);
}

function toggleClass(normalCSS, badCSS,pattern) {	
	if (parseInt(getDisplayCharElmt().textContent) == 0|| getToCheck().value.includes(pattern) ) {
		getToCheck().className= badCSS;
		getDisplayCharElmt().className= badCSS;
	} else {
		getToCheck().className= normalCSS;
		getDisplayCharElmt().className= normalCSS;
	}
}



function countAndCheckLimitCharOnKeyPress(valueTocheckLockId, submitButtonId,
		displayCharLocId, limitCharValuelocationId, pattern,
		submitMessageLocId, erroMessageLocId, normalCSS, badCSS) {
	setToCheck(valueTocheckLockId);
	setDisplayCharElmt(displayCharLocId)
	getToCheck().setAttribute(
			"oninput",
			"decrementLockAndToggleCSS('" 
			+ submitButtonId + "','"  
			+ limitCharValuelocationId + "','" 
			+ pattern + "','" 
			+ submitMessageLocId + "','" 
			+ erroMessageLocId + "','"
			+ normalCSS + "','"
			+ badCSS
			+"')");

}

function getElmtValue(input) {
	return input.value;
}

function getElmtSize(input) {
	return input.length;
}

function decrementLockAndToggleCSS(submitButtonId, 
		limitCharValuelocationId, pattern, submitMessageLocId, erroMessageLocId, normalCSS, badCSS) {
	var btn = submitButton(submitButtonId);
	displayCharLeftValue(
			getCharLimitValue(limitCharValuelocationId),
			getElmtSize(getElmtValue(getToCheck())));
	disableButtonOnPattern(getElmtValue(getToCheck()), pattern, btn);
	buttonMessage(getElmtValue(getToCheck()), pattern, btn, submitMessageLocId,
			erroMessageLocId);
	disableButtonOnPattern(getElmtValue(getToCheck()), pattern, btn);
	toggleClass(normalCSS, badCSS,pattern);
	

}

function buttonMessage(inputValue, pattern, button, sendMessage,
		patternPresentErrorMessage) {
	if (isPatternPresent(inputValue, pattern)) {
		button.value = message(patternPresentErrorMessage).value;
	} else {
		button.value = message(sendMessage).value;
	}
}

function message(messageInputId) {
	return document.getElementById(messageInputId);

}

function disableButtonOnPattern(inputValue, pattern, button) {
	if (isPatternPresent(inputValue, pattern)) {
		disableButton(button, true);
	} else {
		disableButton(button, false);
	}
}

function isPatternPresent(str, pattern) {
	if (str.includes(pattern)) {
		return true;
	} else {
		return false;
	}
}

function disableButton(button, bool) {
	button.disabled = bool
}

function submitButton(buttonId) {
	return document.getElementById(buttonId);
}

function displayCharLeftValue(maxChar, stringCurentSize) {
	getDisplayCharElmt().innerHTML = decrementChar(maxChar, stringCurentSize);
}

function decrementChar(maxChar, stringCurentSize) {
	return maxChar - stringCurentSize;
}

function getCharLimitValue(limitCharValuelocationId) {
	return document.getElementById(limitCharValuelocationId).value;
}

function modelTools() {
	return this;
}