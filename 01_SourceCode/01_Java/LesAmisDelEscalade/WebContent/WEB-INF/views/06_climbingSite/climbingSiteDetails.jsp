<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
display: grid;
background-color: #2196F3;
grid-template-columns: 50% 50%;
grid-template-rows: auto;
grid-template-areas: 
'zone1 zone2'
'zone3 zone3';
}

.container>div{
background-color: white;
}
.zone1{grid-are: zone1;}
.zone2{grid-are: zone2;}
.zone3{grid-are: zone3;}
}











</style>
</head>
<body>

<div class="container" >
<div class="zone1">ZONE 1</div>
<div class="zone2">ZONE 2</div>
<div class="zone3">ZONE 3</div>



</div>







</body>
</html>