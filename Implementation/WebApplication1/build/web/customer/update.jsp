<%-- 
    Document   : update
    Created on : 17 Mar, 2012, 11:38:58 PM
    Author     : Shirish
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div align="center">
            <h2>Profile</h2>
            <form action="<s:url action="CustomerAction!updateProfile" namespace="/customer"/>" method="post" id="formID">
        <table>
            <tr><td><b>Username :</b></td><td><s:textfield name="cust.username" disabled="true"/></td></tr>
            <tr><td><b>Password :</b></td><td><s:textfield name="cust.password" disabled="true"/></td></tr>
            <tr><td><b>Message Alerts :</b></td><td><s:if test="mv==\"yes\""><s:radio name="mv2" list="{'Enable','Disable'}" value="'Enable'" /></s:if><s:elseif test="mv==\"no\""><s:radio name="mv2" list="{'Enable','Disable'}" value="'Disable'" /></s:elseif>   </td></tr>
            
            
            <tr><td><b>Customer No :</b></td><td><s:textfield name="cust.c_id" disabled="true"/></td></tr>
            <tr><td><b>First Name :</b></td><td><s:textfield name="cust.fname" disabled="true"/></td></tr>
            <tr><td><b>Middel Name :</b></td><td><s:textfield name="cust.mname" disabled="true"/></td></tr>
            <tr><td><b>Last Name :</b></td><td><s:textfield name="cust.lname" disabled="true"/></td></tr>
            
            <tr><td><b>Date Of Birth :</b></td><td><s:textfield name="cust.dob" cssClass="validate[required] text-input"/></td></tr>
            <tr><td><b>Customer Type :</b></td><td><s:textfield name="cust.cus_type" disabled="true"/></td></tr>
            <tr><td><b>Distributor ID :</b></td><td><s:textfield name="cust.d_id" disabled="true"/></td></tr>
            <tr><td><b>Address :</b></td><td><s:textfield name="cust.address" disabled="true"/></td></tr>
            <tr><td><b>Landmark :</b></td><td><s:textfield name="cust.landmark" disabled="true" /></td></tr>
            <tr><td><b>City :</b></td><td><s:textfield name="cust.city"  disabled="true"/></td></tr>
            <tr><td><b>State :</b></td><td><s:textfield name="cust.state"  disabled="true"/></td></tr>
            <tr><td><b>Phone No 1 :</b></td><td><s:textfield name="cust.contactno1"  cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/></td></tr>
                <tr><td><b>Phone No 2 :</b></td><td><s:textfield name="cust.contactno2" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/></td></tr>
                <tr><td><b>Mobile No :</b></td><td><s:textfield name="cust.mobile" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/></td></tr>
                <tr><td><b>E-mail :</b></td><td><s:textfield name="cust.email" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/></td></tr>
        </table>
        <input type="submit" value="Save"/>
       </form></div>
    </body>
</html>
