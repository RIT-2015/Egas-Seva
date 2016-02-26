<%-- 
    Document   : index
    Created on : Oct 8, 2011, 3:02:58 AM          
    Author     : shashi
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%-- netbeans runs build folder  --%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Java Mail </title>
               
    </head>
    <body>

       <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
        
        <h2 align="center" style=" color:#8DB638;">Send Mail</h2>
        
        <div align="center">
             <form action="<s:url action="mailSend" namespace="/admin"/>" method="post" id="formID">              
                   
             <table align="center" width="35%">             
             <s:textfield name="to" label="To" size="35" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>                 
                       
             <s:textfield name="subject" label="Subject" size="35" cssClass="validate[required] text-input"/>  
                       
             <s:textarea name="message" label="Message" cols="30" rows="8" /> 
     
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