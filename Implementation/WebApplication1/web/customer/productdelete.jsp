<%-- 
    Document   : productdelete
    Created on : 26 Mar, 2012, 11:53:50 PM
    Author     : shirish
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div align="center">
        <h2>Your order was canceled!</h2>
        
        
        <s:url id="url" action="OrderproductAction!viewProductOrder" namespace="/customer" /><s:a href="%{url}"><img src="..\resources\images\back.jpg"/></s:a>
        </div>
        
    </body>
</html>
