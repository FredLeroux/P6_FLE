<%@taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/modalPage.css" />
<style type="text/css">
.normalCSS{

}
.badCSS{
color:darkOrange;
font-style: italic;
}

</style>
</head>

<div id="siteCommentModal" class ="formModal" style="display: none;">
<div id="commentFormContainer" class = "formModal-content" >
<form action="06_climbingSite/postComment" method = "Post">
<span id="count">${commentMaxChar}</span><br>
<textarea id="comment" name="comment" rows="10" cols="50" maxlength="${commentMaxChar}"></textarea>
<input id="postCommentBtn" type="submit" value="<springTags:message code="sendComment.message"/>"/>
</form>
<input id="charLimit" type="hidden" value="${sessionScope.commentMaxChar}">
<input id="errorMessage" type ="hidden" value="<springTags:message code="starNotAccepted.message"/>">
<input id="sendMessage" type ="hidden" value="<springTags:message code="sendComment.message"/>">
<input id="errorLimitMessage" type ="hidden" value="<springTags:message code="charLimitReached.message"/>">
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/toolBoxJavaScript/modalTools.js"></script>
<script type="text/javascript">
countAndCheckLimitCharOnKeyPress("comment", "postCommentBtn", "count", "charLimit", "*", "sendMessage", "errorMessage","normalCSS","badCSS");
/*
//var commentLimitChar = document.getElementById("charLimit").value;
displayInitCharLimit(commentLimitChar);
countOnkeyPress(commentLimitChar);


function getCharNb(maxChar){
	var comment = document.getElementById("comment");
	var str = comment.value;
	var size = str.length;
	countDown(maxChar,size);
	setAlert(str,maxChar);
	//charLimitReached(str,maxChar)
	
}

function countOnkeyPress(maxChar){
	
	var text = document.getElementById("comment");
	text.setAttribute("oninput", 'getCharNb('+maxChar+')');
	
}

function countDown(maxChar,currentInputSize){
	var label =document.getElementById("count");
	
	label.innerHTML= maxChar-currentInputSize;
	
}


	function setAlert(inputValue, limit) {
		var button = getSubmitButton("postCommentBtn");
		if (inputValue.includes("*") || inputValue.length > limit) {
			disableButton(button, true)
			if (inputValue.includes("*")) {
				button.value = message("errorMessage").value;
			} else {
				button.value = message("errorLimitMessage").value;
			}

		} else {
			disableButton(button, false)
			button.value = message("sendMessage").value;
		}
	}

	function charLimitReached(inputValue, limit) {
		var button = getSubmitButton("postCommentBtn");
		if (inputValue.length > limit) {
			disableButton(button, true)
			button.value = message("errorLimitMessage").value;

		} else {
			disableButton(button, false)
			button.value = message("sendMessage").value;
		}
	}

	function getSubmitButton(buttonId) {
		var btn = document.getElementById(buttonId);
		return btn;

	}

	function disableButton(btn, bool) {
		btn.disabled = bool;
	}

	function message(inputId) {
		return document.getElementById(inputId);
	}

	function displayInitCharLimit(limit){
		var label =document.getElementById("count");
		
		label.innerHTML= limit ;
		}*/
</script>