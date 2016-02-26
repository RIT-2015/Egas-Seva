<%-- 
    Document   : inserted.jsp
    Created on : 17 Mar, 2012, 10:17:46 AM
    Author     : shirish
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%--
        <form action="<s:url action="CustomerAction!ok" namespace="/customer"/>" method="post">
        <h2>Order Placed Successfully</h2>
        
        <input type="submit" value="Back to home"/>
        </form>--%>
       
       <div align="center">
           
           <h2>Order Placed Successfully</h2>
        <s:url id="url" action="OrderAction!viewOrder" namespace="/customer" /><s:a href="%{url}"><img src="..\resources\images\back.jpg"/></s:a>
       
           
           
       </div>
       
       
       
       
       
    </body>
</html>
