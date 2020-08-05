/**
 * Allow to generate a Iframe zone at the iFrameLoc setted, this one will be
 * 100% width of owner page and 100% height of target page
 */

/**
 * id of the div used to insert the iframe
 */
var iFrameLoc = null;

function setIFrameLoc(locationId) {
	iFrameLoc = locationId;
}

function getIFrameLoc() {
	return iFrameLoc;
}

/**
 * 
 * @param iFrameLoc id of the div used to insert the iframe
 * @returns this javaScript class (02_01_03_02_iFrameJavaScript.js) with iFrameloc setted
 *  Allow to set multiple iframes on the same page
 * 
 */
function newIframe(iFrameLoc) {
	setIFrameLoc(iFrameLoc);
	return this;
}

/**
 * 
 * append the iFrame at setted iFrameLoc
 */
function setIframe() {
	var location = document.getElementById(getIFrameLoc());
	var iframe = document.createElement("iframe");
	iframe.id = "iframeNav";
	iframe.width = "100%";
	iframe.setAttribute("frameborder", 0);
	//attribute scrolling avoid the iframe scroll bar keep in mind to adjuste the height and width
	iframe.setAttribute("scrolling", "no");
	iframe.setAttribute("onload",
			"this.style.height=this.contentDocument.body.scrollHeight + 'px'");
	location.appendChild(iframe);
}

/**
 * 
 * @param src the source to be displayed in the iframe
 * set the src to the iframe
 */
function navIframe(src) {
	var iframe = document.getElementById("iframeNav");
	iframe.setAttribute("src", src);

}

/**
 * 
 * @param src =  the source to be displayed in the iframe
 * Display the source in the iframe;
 */
function loadIframe(src){
	setIframe();
	navIframe(src);
		
}