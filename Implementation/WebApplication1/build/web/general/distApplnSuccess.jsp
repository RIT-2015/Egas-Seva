<%-- 
    Document   : newApplSuccess
    Created on : Apr 2, 2012, 10:06:54 PM
    Author     : shashi
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
        
        
        <br><br><br><br><br>
        <h1 style=" color:#8DB638;">New Distributor Application submitted successfully...</h1><br>
        
       <font color="chocolate">
        Your application for new Distributor is received.<br>
        We will send you a form by email on your email address.<br>
        Please fill that form and submit it on your selected Distributor Office with documents.</font>
        
        <a href="<s:url action='HomePage' namespace='/others'/>"><img src="../resources/images/back.png"/></a>
    </body>
</html>

