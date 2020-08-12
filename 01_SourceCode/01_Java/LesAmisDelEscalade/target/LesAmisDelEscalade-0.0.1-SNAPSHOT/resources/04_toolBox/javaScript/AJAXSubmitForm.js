/**
 *
 * @param formId
 * @param action
 * @param method
 * @param urlKeyName the key in response under wich we will find the url
 * @returns
 */
function AJAXSubmitAndRedirect(formId,action,method,urlKeyName){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var obj = JSON.parse(this.responseText);
			location.href = obj["url"];
			}
		};
	  xhttp.open(method, action.concat(setRequest(formId)), true);
	  xhttp.send();
}



/**
 *
 * @param formId
 * @param action
 * @param method
 * @param iframeId
 * @param urlKeyName the key in response under wich we will find the url
 * @returns send textareas inputs value to backend (note: only textarea and input tag are implemented)
 */
function AJAXSubmitAndRedirectIframe(formId,action,method,iframeId,urlKeyName){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var obj = JSON.parse(this.responseText);
			var iframe = document.getElementById(iframeId);
			iframe .src = obj["url"];
			}
		};
	  xhttp.open(method, action.concat(setRequest(formId)), true);
	  xhttp.send();
}

function setRequest(formId){
	let getParameters =[];
	let formInputs = getAllFormInputs(formId);
	let formTextareas = getAllFormTextAreas(formId);
	appendParameters(formInputs, getParameters);
	appendParameters(formTextareas,getParameters);
	let requestParameters = requestParameterString(getParameters);
	clearFormValues(formInputs);
	clearFormValues(formTextareas);
	return requestParameters;
}

function getAllFormInputs(formId){
	return getForm(formId).getElementsByTagName("input");
}

function clearFormInputs(formId){
	let array = getAllFormInputs(formId)
	let i= 0;
	for(i;i<array.length;i++){
		getAllFormTextAreas(formId)[k].value="";
	}
}

function getAllFormTextAreas(formId){
	return getForm(formId).getElementsByTagName("textarea");
}

function clearFormTextAreas(formId){
	let i= 0;
	for(i;i<getAllFormTextAreas(formId).length;i++){
		getAllFormTextAreas(formId)[k].value="";
	}
}


function appendParameters(inputArray,requestParameterArray){
	if(inputArray.length != 0){
		fillRequestParameterArray(inputArray,requestParameterArray)
	}
}

function getForm(formId){
	return document.getElementById(formId);
}

function fillRequestParameterArray(inputArray,requestParameterArray){
	let i = 0;
	for(i;i<inputArray.length;i++){
		let input = inputArray[i];
		let inputId = input.id;
		let inputValue = input.value;
		let inputDatum = inputId.concat("=").concat(inputValue);
		requestParameterArray.push(inputDatum);
	}
}

function requestParameterString(requestParameterArray){
	let j=0;
	let parameterString = null;
	for(j;j<requestParameterArray.length;j++){
		let requestDatum = requestParameterArray[j];
		if(j==0){
			parameterString= "?".concat(requestDatum);
		}else{
			parameterString.concat("&").concat(requestDatum);
		}
	}
	return parameterString;
}

function clearFormValues(inputArray){
	let i = 0;
	for(i;i<inputArray.length;i++){
		inputArray[i].value ="";
	}
}








