<%-- 
    Document   : newConSuccess
    Created on : Apr 2, 2012, 9:59:37 PM
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
        
        <A HREF="javascript:window.print()">
            <IMG SRC="../resources/images/printer.png" BORDER="0"></img> </A>
        
        <br><br><br><br><br>
        <h1 style=" color:#8DB638;">New Connection Application submitted successfully...</h1><br>
      
       
        <font color="chocolate">
        Your application for new connection is received.<br>
        
        Please submit your documents on your selected Distributor Office.</font>
    
        <br><br><font color="green">
        Following Documents are required:<br><br>
        1. Ration Card &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
        2. Election Card / Pan Card / Driving License</font><br></br>
       
                Please submit documents within 15 days.
        <a href="<s:url action='HomePage' namespace='/others'/>"><img src="../resources/images/back.png"/></a>
   
    </body>
</html>
