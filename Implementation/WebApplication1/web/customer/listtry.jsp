<%-- 
    Document   : listtry
    Created on : 8 Mar, 2012, 12:11:40 AM
    Author     : Shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:form action="DistributorAction" namespace="/" >
            
            <s:select label="Area" name="area" list="dl" headerKey="1" headerValue="--SELECT--">
            </s:select>
            <s:submit label="Submit"/>
        </s:form>
        <%--<s:combobox list="dl" label="Distributor name" name="distName" />--%>
        <%--<s:combobox name="lang" label="Select lang" list="{'java','html'}" headerKey="-1" headerValue="--select lang--" emptyOption="true"/>--%>
        

    </body>
</html>
