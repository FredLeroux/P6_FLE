<%@ taglib prefix ="springTags" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<springTags:url value="/jspCompomentsCss/" var="css"></springTags:url>
<springTags:url value="/jspCompomentsJavaScript/" var="js"></springTags:url>
<springTags:url value="/jspCompomentsFiles/" var="file"></springTags:url>
<!-- CSS -->
<c:set var="jspCompomentsCSSPath" 	value=" ${css}"  scope="application" />
<!-- JSP-Files -->    
<c:set var="jspCompomentsFilePath" 	value=" ${file}"
    scope="application" />
<!-- JavaScript -->
<c:set var="jspCompomentsJavaSCriptPath"	value=" ${js}"
    scope="application" />

    
   
    