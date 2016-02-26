<%-- 
    Document   : viewprofile
    Created on : 17 Mar, 2012, 9:23:19 PM
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
             <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
            
        
       <%-- <form action="<s:url action="CustomerAction!update" namespace="/"/>" method="post">
            <s:iterator value="c">
                <s:textfield disabled="true" label="First Name" name="fname"value="%{fname}"/><br>
                <s:textfield disabled="true" label="Last Name" name="lname" value="%{lname}"/><br>
                <s:textfield disabled="true" label="Address" name="addr" value="%{address}"/><br>
                <s:textfield disabled="true" label="City" name="city" value="%{city}"/><br>
                <s:textfield disabled="true" label="State" name="state" value="%{state}"/><br>
                <s:textfield disabled="true" label="Distributor ID" name="did" value="%{distName}"/><br>
                <s:textfield disabled="true" label="Customer Type" name="ctype" value="%{cust_type}"/><br>
         </s:iterator>
                <input type="submit" value="Update profile" />
    </form>--%>
        
       <h2 align="center">Profile</h2>
              
       <form action="<s:url action="CustomerAction!update" namespace="/customer" />" method="post" >
        <fieldset>
            <legend>
                <b>Personal Details</b>
            </legend>
           
           
           <table>
               <tr><td><b>Username :</b></td><td><s:property value="cust.username"/></td></tr>
            <tr><td><b>Password :</b></td><td><s:property value="cust.password"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:url id="p" action="CustomerAction!chng"/><s:a href="%{p}">Change password</s:a></td></tr></td></tr>
          <tr><td><b>Message alerts :</b></td><td><s:if test="mv==\"no\""> Disabled </s:if><s:elseif test="mv==\"yes\""> Enabled </s:elseif></td></tr>
               
               
            <tr><td><b>Customer No :</b></td><td><s:property value="cust.c_id"/></td></tr>
            <tr><td><b>Name :</b></td><td><s:property value="cust.fname"/>&nbsp;<s:property value="cust.mname"/>&nbsp;<s:property value="cust.lname"/></td></tr>
            <tr><td><b>Date Of Birth :</b></td><td><s:property value="cust.dob"/></td></tr>
            <tr><td><b>Customer Type :</b></td><td><s:property value="cust.cus_type"/></td></tr>
            <tr><td><b>Distributor ID :</b></td><td><s:property value="cust.d_id"/></td></tr>
           </table>
        </fieldset><br>
           <fieldset>
               <legend>
                   <b>Address</b>
               </legend>
            <table>
            <tr><td><b>Address :</b></td><td><s:property value="cust.address"/></td></tr>
            <tr><td><b>Landmark :</b></td><td><s:property value="cust.landmark" /></td></tr>
            <tr><td><b>City :</b></td><td><s:property value="cust.city" /></td></tr>
            <tr><td><b>State :</b></td><td><s:property value="cust.state" /></td></tr>
            </table>
           </fieldset><br>
           <fieldset>
               <legend>
                   <b>Contact details</b>
               </legend>
               <table>
                <tr><td><b>Phone No 1 :</b></td><td><s:property value="cust.contactno1"/></td></tr>
                <tr><td><b>Phone No 2 :</b></td><td><s:property value="cust.contactno2"/></td></tr>
                <tr><td><b>Mobile No :</b></td><td><s:property value="cust.mobile"/></td></tr>
                <tr><td><b>E-mail :</b></td><td><s:property value="cust.email"/></td></tr>
               </table>    
           </fieldset>
           
        <input type="Submit" value="Update"/>
        </form>
        </div>
    </body>
</html>
