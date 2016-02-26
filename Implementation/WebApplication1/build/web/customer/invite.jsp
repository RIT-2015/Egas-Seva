<%-- 
    Document   : invite
    Created on : 7 Apr, 2012, 10:27:25 AM
    Author     : shirish
--%>
<%@page import="javax.xml.registry.infomodel.User"%>
<%@page import="mybeans.Customer"%>
<%@page import="mydatabase.CustomerDAO"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
        
        <h2 align="center" style=" color:#8DB638;">Invite a Friend</h2>
        
        <div align="center">
             <form action="<s:url action="mailSend" namespace="/customer"/>" method="post" id="formID">              
                   
             <table align="center" width="35%">             
             <s:textfield name="to" label="E-mail Address:" size="35" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>                 
                       
             <s:hidden name="subject"/>  
                       
             <s:hidden name="message" value="You have been invited to be a part of E gas Sewa : http://localhost:8080/egas/" /> 
     
            <table border="0" align="center" cellpadding="5">       
                    <tr>
                        <td>&nbsp;</td>
                        <td colspan="2" align="center" style="margin-right: 10%;">                      
                            <s:submit value="Send Mail" />                         
                        <td>
                    </tr>
                
            </table> 
        </form>
        </div>
    </body>
</html>
