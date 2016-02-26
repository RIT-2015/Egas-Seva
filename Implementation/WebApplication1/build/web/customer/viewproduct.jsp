<%-- 
    Document   : viewproduct
    Created on : 25 Mar, 2012, 7:10:47 PM
    Author     : shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %><%@ page import="java.util.*" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is just a try</h1>
        <img src="Resources\images\autoLpg.jpg" alt="ye bhi nai aaya"/>
        
        <s:property value="img"/>
        
        <s:hidden id="m" value="\Picture1.jpg"/>
        <s:set name="image" value="img"/>
        <s:property value="#image"/>
        
        
        <s:url id="m2" value="#image" />
        <s:property value="%{m2}"/>
        
        
        <img src="%{image}"/>
        <img src="%{m}" />
        
        
        
        


        
        
        
        
        
        
        <img src="" />
        

        
        <s:textfield value="nai aaya"/>
        
        
        
    </body>
</html>
