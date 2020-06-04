function newLoadModal() {
	return this;
}

/**
 * 
 * @param elementId iframe parent element to toggle display
 * @apiNote allow to toggle display an iframe parent element
 */
function parentElementToggleDisplay(elementId) {
	var element = window.parent.document.getElementById(elementId);
	if (element.style.display === "none") {
		element.style.display = "block";
	} else {
		element.style.display = "none";
	}

}

/**
 * 
 * @param parentModalId the parent modal id
 * @apiNote on iframe allow to close modal if previous source has open it
 */
function killParentModal(parentModalId) {
	var element = window.parent.document.getElementById(parentModalId);
	if (element.style.display === "block") {
		element.style.display = "none";
	}
}

/**
 * 
 * @param parentModalId the parent modal id
 * @returns
 */
function killParentModalOnHashChange() {
	document.addEventListener("hashchange", killParentModal("loading"));
}


function killParentModalOnHashChange(modalName) {
	document.addEventListener("hashchange", killParentModal(modalName));
}


function addToElementToggleDisplayOnClickAndHashChange(element,
		elementToToggleId) {
	element.setAttribute("onclick", "parentElementToggleDisplay('"
			+ elementToToggleId + "')");
	killParentModalOnHashChange(element);

}
/**
 * 
 * @apiNote On hashchange(example load,URL hashchange ...) switch off iframe parent modal
 * @default modal id is "loading" in accordance to 02_01_02_04_loginModal.jsp.
 */
function disableLoadModal() {
	killParentModalOnHashChange("loading");
}
/**
 * 
 * @apiNote On hashchange(example load,URL hashchange ...) switch off iframe parent modalId
 * 
 */
function disableLoadModalCustom(modalId) {
	killParentModalOnHashChange(modalId);
}

/**
 * 
 * @param buttonElementContainerId the tag element (div,spam,...)containing button(s) 
 * on which to apply the on click toggle action.
 * @apiNote create an array containins all buttons of the buttonElementContainerId 
 * an add to each addToElementToggleDisplayOnClickAndHashChange() function.
 * @default modal id is "loading" in accordance to 02_01_02_04_loginModal.jsp.
 */
function addButtonOnclickParentModalToggle(buttonId) {
	var element = document.getElementById(buttonId);	
		addToElementToggleDisplayOnClickAndHashChange(element, "loading")
	
}


/**
 * 
 * @param buttonElementContainerId the tag element (div,spam,...)containing button(s) 
 * on which to apply the on click toggle action
 * @apiNote create an array containins all buttons of the buttonElementContainerId 
 * an add to each addToElementToggleDisplayOnClickAndHashChange() function to iframe parent modalId.
 * 
 */
function  addButtonOnclickParentModalToggleCustomModalName(buttonId, modalId) {
	var element = document.getElementById(buttonId);	
	addToElementToggleDisplayOnClickAndHashChange(element, modalId)
}
