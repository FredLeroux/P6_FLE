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
	if (element.style.display == "none") {
		element.style.display = "block";
	} else {
		element.style.display = "none";
	}

}


function displayLoadModal(loadModalId){
	elementToggleDisplay(loadModalId);
}



function elementToggleDisplay(elementId) {
	var element = document.getElementById(elementId);
	if (element.style.display == "none") {
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
	if (element.style.display == "block") {
		element.style.display = "none";
	}
}

function killModal(parentModalId) {
	var element = document.getElementById(parentModalId);
	if (element.style.display == "block") {
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

function killModalOnHashChange() {
	document.addEventListener("hashchange", killModal("loading"));
}

function killParentModalOnHashChange(modalName) {
	document.addEventListener("hashchange", killParentModal(modalName));
}

function killModalOnHashChange(modalName) {
	document.addEventListener("hashchange", killModal(modalName));
}


function addToParentElementToggleDisplayOnClickAndHashChange(element,
		elementToToggleId) {
	element.setAttribute("onclick", "parentElementToggleDisplay('"
			+ elementToToggleId + "')");
	killParentModalOnHashChange(elementToToggleId);
}

function addToElementToggleDisplayOnClickAndHashChange(element,
		elementToToggleId) {
	element.setAttribute("onclick", "elementToggleDisplay('"
			+ elementToToggleId + "')");
	killModalOnHashChange(elementToToggleId);
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
 * @param buttonId button on which to apply the on click toggle action.
 * @default modal id is "loading" in accordance to 02_01_02_04_loginModal.jsp.
 */
function addButtonOnclickParentModalToggle(buttonId) {
	var element = document.getElementById(buttonId);
	addToParentElementToggleDisplayOnClickAndHashChange(element, "loading")

}

function addOnclickToggleLoadModalOnMultipleLinkTag(linkTagsContainerId) {
	var container = document.getElementById(linkTagsContainerId)
	var elements = container.getElementsByTagName("a");
	let i = 0;
	for(i;i<elements.length;i++){
		addToElementToggleDisplayOnClickAndHashChange(elements[i], "loading")
	}

}
/**
 *
 * @param element on which to apply the on click toggle action.
 * @default modal id is "loading" in accordance to loginModal.jsp.
 */
function onclickParentModalToggle(element) {
	addToParentElementToggleDisplayOnClickAndHashChange(element, "loading")
}

/**
 *
 * @param element on which to apply the on click toggle action.
 * @param modaId the modal name to be toggle
 *
 */
function onclickParentModalToggle(element, modalId) {
	addToParentElementToggleDisplayOnClickAndHashChange(element, modalId)
}

/**
 *
 * @param  button on which to apply the on click toggle action
 *@param modaId the modal name to be toggle
 *
 */
function addButtonOnclickParentModalToggleCustomModalName(buttonId, modalId) {
	var element = document.getElementById(buttonId);
	addToParentElementToggleDisplayOnClickAndHashChange(element, modalId)
}

function addOnclickToggleLoadModalOnMultipleLinkTagCustomModalName(linkTagsContainerId, modalId) {
	var elements = document.getElementsByName("a");
	let i = 0;
	for(i;i<elements.length;i++){
		addToElementToggleDisplayOnClickAndHashChange(elements[i], modalId)
	}

}
