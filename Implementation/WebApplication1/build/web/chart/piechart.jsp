<%-- 
    Document   : jsppiechart
    Created on : Oct 29, 2011, 1:42:28 AM
    Author     : shashi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.awt.*" %>
<%@ page import="java.io.*" %>
<%--<%@ page import="org.jfree.chart.*" %>--%>

<%--    JFreeChart chart = ChartFactory.createPieChart("Pie Chart ", data, true, true, false);     --%>

<% response.addHeader("Refresh", "10");%>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>                 
    </head>
    <body>
        
         <IMG SRC="../resources/images/charts/piechart.png" WIDTH="600" HEIGHT="400"
             BORDER="0" >
<%--
        <IMG SRC="../Resources/images/charts/customerCities.png" WIDTH="600" HEIGHT="400"
             BORDER="0" >

        
        <IMG SRC="../Resources/images/charts/distributorCities.png" WIDTH="600" HEIGHT="400"
             BORDER="0" >
      
        <IMG SRC="../Resources/images/charts/regCustomerCities.png" WIDTH="600" HEIGHT="400"
             BORDER="0" >
 --%>         
        
    </body>
</html>