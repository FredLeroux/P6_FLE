<style>
.iframe{
width:100%;

border:  solid;
border-color: rgb(17,36,45);



}


</style>
<div ><div id = "iFrameLoc" class = "iframe"></div></div>
<script type="text/javascript" src="jspCompomentsJavaScript/02_01_03_02_iFrameJavaScript.js"></script>
<script type="text/javascript">
var src= ${iFrameSource};
var iframe = newIframe("iFrameLoc");
iframe.loadIframe(src);
</script>
