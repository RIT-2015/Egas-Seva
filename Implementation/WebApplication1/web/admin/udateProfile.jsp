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
        <s:head/>
    </head>
    <body>  
        
        <div align="center">
         <h2>Admin Profile</h2>
        <s:form >              
<%-- 19  --%>  
            
            <s:textfield name="admin.adminID" label="Admin ID"  />
            <s:textfield name="admin.fname" label="First Name"  value=""/>
            <s:textfield name="admin.mname" label="Middle Name" value=""/>
            <s:textfield name="admin.lname" label="Last Name" value=""/>
            <s:textfield name="admin.dob" label="Date of Birth" value=""/>
            <s:textfield name="admin.age" label="Age" value=""/>
            <s:radio name="admin.gender" label="Gender" list="{'male','female'}"/>
            
            <s:textfield name="admin.address" label="Address" value="" />
            <s:textfield name="admin.landmark" label="Landmark" value=""/>
            <s:textfield name="admin.pin" label="Pin No" value=""/>
            <s:textfield name="admin.city" label="city" /> 
            <s:textfield name="admin.state" key="" label="State" />
            <s:textfield name="admin.mobile" label="Mobile No" value=""/>
            <s:textfield name="admin.landline" label="landline" value=""/>
            <s:textfield name="admin.email" label="E-Mail Address" value=""/>                    
           
            <s:textfield name="admin.username" label="Username" value=""/>
            <s:textfield name="admin.password" label="Password" value=""/>
            <s:textfield name="admin.regDate" label="Reg Date" value=""/>
            

            <table><tr colspan="2">      <td colspan="2">
            <s:submit align="center"/>  </td><td colspan="2">
            <s:reset align=""/></td>  </tr></table>
        </s:form>
        </div>
    </body>
</html>

