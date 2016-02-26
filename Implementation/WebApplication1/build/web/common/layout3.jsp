<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="Resources/css/egasdefault.css" type="text/css"/>
        <link rel="stylesheet" href="Resources/css/smartmenu.css" type="text/css"/>
        <title><tiles:getAsString name="title" /></title>
    </head>
    <body>
        <table width="100%" height="100%">

            <tr height="20%">
                <td colspan="2" align="center" valign="top"> <tiles:insertAttribute name="header" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><tiles:insertAttribute name="menu"/></td>
            </tr>
            
            <tr>
                <td align="left" valign="top"><tiles:insertAttribute name="userMenu"/></td>
                <td align="center" valign="top"><tiles:insertAttribute name="body" /></td>
            </tr>
            
            <tr height="20%">
                <td colspan="2" align="center"><tiles:insertAttribute name="footer" /></td>
            </tr>
            
        </table>
    </body>
</html>