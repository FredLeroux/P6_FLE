
<<<<<<< HEAD
/**
 * 
 * @param notDisplayCode
 *            the code to not display an option<br>
 * @allows to display an option in function of the text of this one i.e.
 *          <br>
 *          if notDisplayisCode is "adminOnly", we can via filter/controller
 *          change the name of an option by using model.addObject and change the
 *          springtag:message code to this model variable and target a specific
 *          property.key in our case "adminOnly" in this case the option will be
 *          not displayed and is name and href can't be named "adminOnly"
 */
function conditionalOptionsDiplay(notDisplayCode) {
	var tagA = document.getElementsByTagName("a");
	var i = 0;
	for (i; i < tagA.length; i++) {
		var str = tagA[i].toString();
		bool = tagA[i].toString().includes(notDisplayCode)
=======
function displayOption(){
	return this;
}

/**
 * 
 * @param notDisplayCode
 *            the code to not display an option<br>
 * @allows to display an option in function of the text of this one i.e.
 *          <br>
 *          if notDisplayisCode is "adminOnly", we can via filter/controller
 *          change the name of an option by using model.addObject and change the
 *          springtag:message code to this model variable and target a specific
 *          property.key in our case "adminOnly" in this case the option will be
 *          not displayed and is name and href can't be named "adminOnly"
 */
function conditionalOptionsDiplay(notDisplayCode) {
	var tagA = document.getElementsByTagName("a");
	var i = 0;
	for (i; i < tagA.length; i++) {
		var str = tagA[i].toString();
		//window.alert(str);
		bool = str.includes(notDisplayCode)
>>>>>>> refs/heads/AccountAndCreation
		if (bool) {
			var element = document.getElementById(tagA[i].id);
			element.style.display = "none";
		}
	}
}
<<<<<<< HEAD
=======

function hey(mes){
	//window.alert(mes);
}
>>>>>>> refs/heads/AccountAndCreation
