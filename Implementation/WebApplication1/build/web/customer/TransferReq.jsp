<%-- 
    Document   : TransferReq
    Created on : 25 Mar, 2012, 4:05:33 PM
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
        <h1>New Address </h1>
        <form action="<s:url action="TransferAction!changeAddr" namespace="/customer"/>" method="post">
        <b>C_id :</b><s:property value="cid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>New D_id :</b><s:property value="newdid"/><br>
        <br></br>
        <b>New address :</b><s:property value="newaddr"/><br>
        <b>New city :</b><s:property value="newcity"/><br>
        <b>New State :</b><s:property value="newstate"/><br>
        
        <input type="submit" value="Confirm"/>
        
        </form>
    </body>
</html>
