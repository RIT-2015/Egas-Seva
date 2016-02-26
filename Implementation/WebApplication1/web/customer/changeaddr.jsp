<%-- 
    Document   : changeaddr
    Created on : 21 Mar, 2012, 11:36:02 PM
    Author     : Shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--<h1>Hello World!</h1>

        <form action="<s:url action="TransferAction!changeAddr" namespace="/customer"/>" method="post">
            <table>
                <tr><td>C-id:</td><td><s:textfield name="t.c_id"/></td></tr>
                <tr><td>New Address:</td><td><s:textfield name="t.newaddr"/></td></tr>
                <tr><td>New City:</td><td><s:textfield name="t.newcity"/></td></tr>
                <tr><td>New State:</td><td><s:textfield name="t.newstate"/></td></tr>
                <tr><td>New Distributor:</td><td><s:textfield name="t.d_id"/></td></tr>
            </table>
            <input type="submit" value="Proceed"/>
        </form>
        
        --%>
        
        <div align="center">
           
            <h2>Transfer LPG Form</h2>
            
        <form action="<s:url action="TransferAction!changeAddr" namespace="/customer"/>" method="post" id="formID">
            <a href="<s:url action="IndiaPage" namespace="/maps"/>" target="_blank">click here to find your NEW distributor</a></br></br>
            <table>
                <tr><td>   <s:textfield name="t.newaddr" label="New Address" cssClass="validate[required] text-input"/> </td></tr>   
                <tr><td><s:textfield name="t.newcity" label="New City" cssClass="validate[required] text-input"/>    </td></tr>
                <tr><td> <s:textfield name="t.newstate" label="New State" cssClass="validate[required] text-input"/>    </td></tr>
                <tr><td> <s:textfield name="t.newlandmark" label="New Landmark" cssClass="validate[required] text-input"/>    </td></tr>
                <tr><td> <s:textfield name="t.d_id" label="New Distributor" cssClass="validate[required] text-input"/>    </td></tr>
                    
            
            </table>
             
            <input type="submit" value="Proceed"/>
        </form>
                

        </div>
    </body>
</html>
