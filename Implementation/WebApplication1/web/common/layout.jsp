<%-- 
    Document   : layout
    Created on : Feb 24, 2012, 9:48:30 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title"/></title>
        <link rel="stylesheet" href="../resources/css/egasdefault.css" type="text/css"/>
        <link rel="stylesheet" href="../resources/css/smartmenu.css" type="text/css"/>
        <LINK REL="SHORTCUT ICON" HREF="../resources/images/title-image.jpg">
        <!--Accordian -->
        <script type="text/javascript" src="swfobject.js"></script>
		<script type="text/javascript">
			var flashvars = {};
			var params = {};
			params.scale = "noscale";
			params.salign = "tl";
			params.wmode = "transparent";
			var attributes = {};
			swfobject.embedSWF("AccordionNewsReaderFX.swf", "DivAccordionNewsReaderFX", "600", "380", "9.0.0", false, flashvars, params, attributes);
		</script>
        
<script src="AC_RunActiveContent.js" language="javascript"></script>
        <!--Flash slideshow -->
        <script type="text/javascript" src="swfobject.js"></script>
		<script type="text/javascript">
			var flashvars = {};
			var params = {};
			params.scale = "noscale";
			params.salign = "tl";
			params.wmode = "transparent";
			params.allowfullscreen = "true";
			var attributes = {};
			swfobject.embedSWF("BannerRotatorFX.swf", "BannerRotatorFXDiv", "600", "260", "9.0.0", false, flashvars, params, attributes);
		</script>
        
        <!-- Menu Javascript -->
        <script type="text/javascript" src="../resources/js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="../resources/js/smartmenu.js"></script> 
        <script type="text/javascript">
            jQuery(window).ready(function(){
            jQuery("#navigation").Smartmenu({animationDuration: 350});
            });
        </script>
    </head>
    <body topmargin="0">
        <table width="80%" align="center">
            <tr valign="bottom">
                <td colspan="2" height="150">
                    <tiles:insertAttribute name="header"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" height="5">
                    <tiles:insertAttribute name="topmenu"/>
                </td>
            </tr>
            <tr height="300">
                <td width="25%" valign="top">
                    <tiles:insertAttribute name="menu"/>
                </td>
                <td width="75%" valign="top">
                    <tiles:insertAttribute name="body"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" height="70">
                    <tiles:insertAttribute name="footer"/>
                </td> 
            </tr>
        </table>
    </body>
</html>
