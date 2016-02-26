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
        <!-- Menu Javascript -->
        <script type="text/javascript" src="../resources/js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="../resources/js/smartmenu.js"></script> 
        <script type="text/javascript">
            jQuery(window).ready(function(){
            jQuery("#navigation").Smartmenu({animationDuration: 350});
            });
        </script>
        <script language="JavaScript">
            <!--
            var backColor = new Array(); // don't change this
 // Enter the colors you wish to use.  Follow the pattern to use more colors.The number 
 // in the brackets [] is the number you will use in the function call to pick each color.

            backColor[0] = '#eedef8';       //violet
            backColor[1] = '#c1f8c1';       //green
            backColor[2] = '#eff4c1';       //yellow
            backColor[3] = '#FFFFFF';       //white
            backColor[4] = '#fbdcfb';       //pink
            backColor[5] = '#e0fbf9';       //blue
            backColor[6] = '#dde1cb';       //chocolate

            function changeBG(whichColor){
               
               document.bgColor = backColor[whichColor];
            }
</script>
<script type="text/javascript">
<!--
function resize(multiplier) {
    if (document.body.style.fontSize == ""){ document.body.style.fontSize = "1.0em"; }
    document.body.style.fontSize = parseFloat(document.body.style.fontSize)
                                    + (multiplier * 0.2) + "em";
} 
-->
</script>

        
    </head>
    <body topmargin="0">
        <table width="80%" align="center">
            <tr valign="bottom">
                <td height="150">
                    <tiles:insertAttribute name="header"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" height="5">
                    <tiles:insertAttribute name="topmenu"/>
                </td>
            </tr>
            <tr height="100" valign="top">
                <td width="75%">
                    <tiles:insertAttribute name="body"/>
                </td>
            </tr>
            <tr>
                <td height="70">
                    <tiles:insertAttribute name="footer"/>
                </td> 
            </tr>
        </table>
    </body>
</html>
