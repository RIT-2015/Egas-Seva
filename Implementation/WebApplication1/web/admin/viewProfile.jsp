<%-- 
    Document   : viewProfile
    Created on : Feb 27, 2012, 12:05:31 PM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
            
        <h2 align="center" style=" color:#8DB638;">Administrator's Profile</h2>

        <div align="left">

            <s:iterator value="adminColln">

                <fieldset>
                    <legend><b> <font color="#459cb5" size="4">Personal Details </font></b></legend>

                    <TABLE> 
                        <tr><td></td><td></td></tr>
                        <tr><td><b>Admin ID </b></td><td>:&nbsp;<s:property value="adminID" /> </td> </tr> 
                        <tr><td><b>Full Name </b> </td><td> :&nbsp;<s:property value="fname"/> <s:property value="mname"/> <s:property value="lname"/> </td> </tr> 
                        <tr><td><b>Date of Birth </b> </td><td> :&nbsp;<s:property value="dob"/> </td> </tr> 
                        <tr><td><b>Age </b> </td><td> :&nbsp;<s:property value="age"/> </td> </tr> 
                        <tr><td><b>Gender </b> </td><td> :&nbsp;<s:property value="gender"/> </td> </tr> 

                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="#459cb5" size="4">Contact Details </font></b></legend>

                    <TABLE>
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Address </b> </td><td> :&nbsp;<s:property value="address"/> </td> </tr> 
                        <tr><td><b>Landmark </b> </td><td>:&nbsp; <s:property value="landmark"/> </td> </tr> 
                        <tr><td><b>Pin code </b> </td><td> :&nbsp;<s:property value="pin"/> </td> </tr> 
                        <tr><td><b>City </b> </td><td> :&nbsp;<s:property value="city"/> </td> </tr> 
                        <tr><td><b>State </b> </td><td> :&nbsp;<s:property value="state"/> </td> </tr> 
                        <tr><td><b>Mobile no. </b> </td><td> :&nbsp;<s:property value="mobile"/> </td> </tr> 
                        <tr><td><b>Landline no. </b> </td><td> :&nbsp;<s:property value="landline"/> </td> </tr> 
                        <tr><td><b>E-mail ID </b> </td><td> :&nbsp;<s:property value="email"/> </td> </tr>

                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="#459cb5" size="4">Account Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Username </b> </td><td> :&nbsp;<s:property value="username"/> </td> </tr> 
                        <tr><td><b>Password </b> </td><td> :&nbsp;<s:property value="password"/> </td> </tr> 
                        <tr><td><b>Register Date </b> </td><td> :&nbsp;<s:property value="regDate"/> </td> </tr> 

                    </TABLE>
                </fieldset><br>

                <TABLE>                         
                    <tr><td colspan="2" align="center">
                            <s:form action="updatePageAdmin" namespace="/admin"> 
                                <s:submit align="center" value="Update"/>
                            </s:form>
                        </td>
                    </tr>
                </TABLE>

            </s:iterator>

        </div>
    </body>
</html>

