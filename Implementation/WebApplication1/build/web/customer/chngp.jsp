<%-- 
    Document   : chngp
    Created on : 18 Apr, 2012, 10:07:24 PM
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
        <h2>Change password</h2>
        <form action="<s:url action="CustomerAction!chngpass" namespace="/customer"/>" method="post" id="formID">  
            <table>
                <tr><td><b> Old password :</b></td><td> <s:textfield  name="oldpass" cssClass="validate[required] text-input"/></td></tr>
                <tr><td><b>New Password :</b></td><td><s:textfield  name="pass1" id="pass1" cssClass="validate[required] text-input"/></td></tr>
                <tr><td><b>Confirm password :</b></td><td> <s:textfield name="pass2" cssClass="validate[required,equals[pass1]] text-input"/>/></td></tr>
            </table> 
       <input type="submit" value="Change" />
       <input type="reset"/>
        
        </form>
        </div>
    </body>
</html>
