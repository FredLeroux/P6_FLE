<%@ taglib uri="http://www.springframework.org/tags" prefix="springTag"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_03_cssFiles/pageAndResults.css" />
	

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/02_templatesJsp/02_03_listDisplayerFiles/02_03_04_javaScriptFiles/pageAndResultsMax.js"
	charset="UTF-8"></script>
<div class="resultsMax">
	<springTag:message code="resultsMax.info" />
	<span id="resultsPerPages"></span>
</div>

<div id="pageNav" class="grid-area pagesList">

	
		
		<a href="" id="highJumpMinus" class = "previousPlusPlusZone"><i class="fas fa-chevron-left"></i></a>
		<a href="" id="mediumJumpMinus" class = "previousPlusZone"><i class="fas fa-chevron-left"></i></a>
		<a href="" id="lowJumpMinus" class="previousZone"><i class="fas fa-chevron-left"></i></a>
		<a href="" id="highJumpPlus" class = "nextPlusPlusZone"><i class="fas fa-chevron-right"></i></a>
		<a href="" id="mediumJumpPlus" class = "nextPlusZone"><i class="fas fa-chevron-right"></i></a>
		<a href="" id="lowJumpPlus" class="nextZone"><i class="fas fa-chevron-right"></i></a>
		
		<div id="pageNumbers" class="pageZone"></div>
		
	</div>


	<script type="text/javascript">	
	var pageAndResults = setpageAndResultsMax()
	var navigation = ${navigation};
	var pageJump = ${pageJump}
	var currentPage = ${currentPage};	
	var resultsPerPagesList = ${rowsPerPagesList};
	var resultsPerPagesSelected = ${rowsPerPages};
	var rowsDisplayed = ${rowsDisplayed};
	var selectedPage = ${selectedPage};

	
	 
	pageAndResults.setResultsMaxFormAction(rowsDisplayed);
	pageAndResults.setResultsPerPagesList("resultsPerPages",
			resultsPerPagesList, resultsPerPagesSelected)
	pageAndResults.setPageLink(selectedPage,"?page=");
	pageAndResults.setSelectedPageCssClass("selected");
	pageAndResults.setPreviousCssClass("prevCss");
	pageAndResults.setNextCssClass("nextCss");
	pageAndResults.setPageSelected(currentPage);
	pageAndResults.pageNavigation("pageNumbers", "prev", "next", navigation);
	pageAndResults.setPageJump("pageNav",pageJump);
</script>