<%-- 
    Document   : home
    Created on : 21 Mar, 2012, 5:17:01 PM
    Author     : shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <s:url id="a1" action="OrderAction!viewOrder" namespace="/"></s:url>
        <s:a href="%{a1}">Show Orders</s:a>
        <br>
        <s:url id="a2" action="DistributorAction!viewDist" namespace="/"></s:url>
        <s:a href="%{a2}">List Distributor</s:a>
        <s:url id="a3" action="DistributorAction!viewDistList" namespace="/"></s:url>
        <s:a href="%{a3}">List Try</s:a><br>
        <s:url id="a4" action="OrderAction!addOrder" namespace="/"></s:url>
        <s:a href="%{a4}">Order A LPG</s:a>
        <s:url id="a5" action="CustomerAction!viewCDetails" namespace="/"></s:url>
        <s:a href="%{a5}">Profile</s:a>
         <s:url id="a6" action="TransferAction!changereq" namespace="/"></s:url>
        <s:a href="%{a6}">change address</s:a>
       
       
       
       
       
       
       
        
    </body>
</html>
