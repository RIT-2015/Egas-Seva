<%-- 
    Document   : udateProfile
    Created on : Feb 22, 2012, 5:22:20 PM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>      

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head theme="simple"/>
        
    </head>
    <body>  
        
        <h2 align="center" style=" color:#8DB638;">Administrator's Profile</h2><br></br>
        
        <div align="center">
                            
         <%--   <s:form action="updateProfileAdmin" namespace="/admin">  --%> 
         
            <form action="<s:url action="updateProfileAdmin" namespace="/admin"/>" method="post" id="formID">  
                   
<%-- 19  --%>  
<table>
    <tr>    <s:textfield name="admin.adminID" label="Admin ID" readonly="true" /></tr>
    <tr>        <s:textfield name="admin.fname" label="First Name" readonly="true" /></tr>
    <tr>        <s:textfield name="admin.mname" label="Middle Name" readonly="true" /></tr>
        <tr>    <s:textfield name="admin.lname" label="Last Name" readonly="true" /></tr>
        <tr>    <s:textfield name="admin.dob" label="Date of Birth" /></tr>
            
         <tr>   <s:textfield name="admin.address" label="Address" cssClass="validate[required] text-input"/></tr>
         <tr>   <s:textfield name="admin.landmark" label="Landmark" /></tr>
         <tr>   <s:textfield name="admin.pin" label="Pin No" cssClass="validate[required] text-input"/></tr>
         <tr>   <s:textfield name="admin.city" label="city" cssClass="validate[required] text-input"/> </tr>
         <tr>   <s:textfield name="admin.state" key="" label="State" cssClass="validate[required] text-input"/></tr>
         <tr>   <s:textfield name="admin.mobile" label="Mobile No" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/></tr>
         <tr>   <s:textfield name="admin.landline" label="landline" cssClass="validate[custom[phone]] text-input"/></tr>
         <tr>   <s:textfield name="admin.email" label="E-Mail Address" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>    </tr>                
           
         <tr> <td>  <s:textfield name="admin.username" label="Username" readonly="true" /> 
              <%--      <a href="<s:url action='checkUsernameAdmin' namespace='/admin'>
                             <s:param name='admin.username' value='admin.username'/> </s:url>" >
                     <!--     Check Availability
 -->                    </a> --%></td></tr> 
   <%--      
         <tr><td>           
             <b><font style="color: indianred; font-size: 21px;">
            <table align="left">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
            
             </td></tr>   
  --%>       
         <tr>   <s:textfield name="admin.password" label="Password" /></tr>
         <tr>   <s:textfield name="admin.regDate" label="Reg Date" readonly="true" /></tr>
            
            
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2"><s:submit align="center"/> </td></tr>
       </table>
                      
           
            
        </form>
        </div>
    </body>
</html>

