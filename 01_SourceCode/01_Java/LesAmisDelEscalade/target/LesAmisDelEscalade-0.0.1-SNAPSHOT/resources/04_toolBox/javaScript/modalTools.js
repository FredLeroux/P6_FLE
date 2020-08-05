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

function toggleClass(commentNormalCSS, charLimitNormalCss, commentBadCSS,
		charLimitBadCSS, pattern) {
	if (parseInt(getDisplayCharElmt().textContent) == 0
			|| getToCheck().value.includes(pattern)) {
		getToCheck().className = commentBadCSS;
		getDisplayCharElmt().className = charLimitBadCSS;
	} else {
		getToCheck().className = commentNormalCSS;
		getDisplayCharElmt().className = charLimitNormalCss;
	}
}

function countAndCheckLimitCharOnKeyPress(valueTocheckLockId, submitButtonId,
		displayCharLocId, limitCharValuelocationId, pattern,
		submitMessageLocId, erroMessageLocId, commentNormalCSS,
		charLimitNormalCss, commentBadCSS, charLimitBadCSS) {
	setToCheck(valueTocheckLockId);
	setDisplayCharElmt(displayCharLocId)
	getToCheck().setAttribute(
			"oninput",
			"decrementLockAndToggleCSS('" + submitButtonId + "','"
					+ limitCharValuelocationId + "','" + pattern + "','"
					+ submitMessageLocId + "','" + erroMessageLocId + "','"
					+ commentNormalCSS+ "','" +
					charLimitNormalCss+ "','" + commentBadCSS+ "','" + charLimitBadCSS+ "')");

}

function getElmtValue(input) {
	return input.value;
}

function getElmtSize(input) {
	return input.length;
}

function decrementLockAndToggleCSS(submitButtonId, limitCharValuelocationId,
		pattern, submitMessageLocId, erroMessageLocId, commentNormalCSS,
		charLimitNormalCss, commentBadCSS, charLimitBadCSS) {
	var btn = submitButton(submitButtonId);
	displayCharLeftValue(getCharLimitValue(limitCharValuelocationId),
			getElmtSize(getElmtValue(getToCheck())));
	disableButtonOnPattern(getElmtValue(getToCheck()), pattern, btn);
	buttonMessage(getElmtValue(getToCheck()), pattern, btn, submitMessageLocId,
			erroMessageLocId);
	disableButtonOnPattern(getElmtValue(getToCheck()), pattern, btn);
	toggleClass(commentNormalCSS, charLimitNormalCss, commentBadCSS,
			charLimitBadCSS, pattern);

}

function buttonMessage(inputValue, pattern, button, sendMessage,
		patternPresentErrorMessage) {
	if (isPatternPresent(inputValue, pattern)) {
		button.innerHTML = message(patternPresentErrorMessage).value;
		button.style.opacity=0.5;
	} else {
		button.innerHTML = message(sendMessage).value;
		button.style.opacity=1;
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


function hideOnclick(elementToImplement,elementToHide){
	getElmt(elementToImplement).setAttribute("onclick", "hide('"+elementToHide+"')");
}

function hide(elementToHide){
	getElmt(elementToHide).style.display ="none";
}

function modelTools() {
	return this;
}