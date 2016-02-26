<%-- 
    Document   : Geolocation
    Created on : Apr 20, 2012, 8:33:17 PM
    Author     : Acer
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2 align="center">Locate Your Self on the Map</h2>
<s:property value="conmsg"/>
<fieldset>
    <legend align="center">
        <h4>Geolocation Form</h4>
    </legend>
    <form action="<s:url action="Geoadd" namespace="/distributor"/>" method="post" id="formID" >    
    
<table align="center">
    <tr>
        <td>Lattitude:</td><td><s:textfield name="latt" cssClass="validate[required] text-input"/></td>
    </tr>
    <tr>
        <td>Longitude:</td><td><s:textfield name="longi" cssClass="validate[required] text-input"/></td>
    </tr>
    <tr>
        <td colspan="2"><a href="#" id="first">Click here to know your location</a></td>
    </tr>
    <tr>
        <td><s:submit value="Update"/></td>
    </tr>
</table>
    </form>
</fieldset>
<script>
     window.onload=(function (){
         $("#1").hide();
     })
$("#first").click(function() {
$("#1").show();
1
});

 </script>
<div id="1">
<iframe src="http://universimmedia.pagesperso-orange.fr/geo/loc.htm" style="margin-left: 50px" frameborder="0" width="728" height="950" scrolling="auto">
</iframe>
 </div>

 
 
     
