<%@taglib uri="http://www.springframework.org/tags" prefix="springTags" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/07_CSSFiles/07_01_pages/modalPage.css" />
<div id="siteCommentModal" class ="formModal" style="display: none;">
<div id="commentFormContainer" class = "formModal-content" >
<form action="06_climbingSite/postComment" method = "Post">
<span id="count">500</span><br>
<textarea id="comment" name="comment" rows="5" cols="100"></textarea>

<input type="submit"/>


</form>
</div>
</div>
<script type="text/javascript">

countOnkeyPress();


function getCharNb(){
	var comment = document.getElementById("comment");
	var str = comment.value;
	var size = str.length;
	countDown(size);
	
}

function countOnkeyPress(){
	
	var text = document.getElementById("comment");
	text.setAttribute("oninput", 'getCharNb()');
	
}

function countDown(value2){
	var label =document.getElementById("count");
	var value1 = 500;
	label.innerHTML= value1-value2;
}





</script>

