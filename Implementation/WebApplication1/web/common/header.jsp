<%-- 
    Document   : header.jsp
    Created on : Feb 24, 2012, 9:45:13 PM
    Author     : Somesh Mishra
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
<!--
function resize(multiplier) {
    if (document.body.style.fontSize == ""){ document.body.style.fontSize = "1.0em"; }
    document.body.style.fontSize = parseFloat(document.body.style.fontSize)
                                    + (multiplier * 0.2) + "em";
} 
-->
</script>

<script>
function googleTranslateElementInit() {
  new google.translate.TranslateElement({
    pageLanguage: 'en',
    includedLanguages: 'en,hi',
    layout: google.translate.TranslateElement.InlineLayout.SIMPLE
  }, 'google_translate_element');
}

</script><script src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>

<%--for translation in all languages :-
<div id="google_translate_element"></div><script>
function googleTranslateElementInit() {
  new google.translate.TranslateElement({
    pageLanguage: 'en',
    layout: google.translate.TranslateElement.InlineLayout.SIMPLE
  }, 'google_translate_element');
}
</script><script src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
--%>


<table align="right">
    <tr>
        <td>
        <div class="header">
       <a href="javascript:void(0);" onclick="resize(1)">
             <img src="../resources/images/home/zoom_in.png" ></img></a>  
     <a href="javascript:void(0);" onclick="resize(-1)"> 
             <img src="../resources/images/home/zoom_out.png" ></img></a> 
      </td>
        <td>   

 <div class="google">
<div id="google_translate_element"></div>
</div>
        </td> 
    <td>
     <s:if test="#session.user!=null">
         <p align="right" style="color: white; font-size: 15px">
             |&nbsp;<b>Welcome:<u><s:property value="#session.user.username"/></u></b>&nbsp;|&nbsp;<b><a href="<s:url action="Logout" namespace="/others"/>" style="color: white">Logout</a></b>&nbsp;|
         </p>
     </s:if>
     <s:if test="#session.user==null">
         <p align="right" style="color: white"> |&nbsp;<b><u><a href="<s:url action="UserLoginPage" namespace="/others"/>" style="color: white">Customer Login</a></u></b>&nbsp;|</p>
     </s:if> 
</td> 
</tr>
</table>
       
</div>
<br>



 
 