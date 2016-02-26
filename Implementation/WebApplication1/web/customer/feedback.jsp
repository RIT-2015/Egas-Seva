<%-- 
    Document   : feedback
    Created on : Feb 19, 2012, 2:03:07 AM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        
        <div align="center">
        <h2 style=" color:#8DB638;">Feedback or Complaint</h2>
        <s:form action="feedbackSend" namespace="/customer" id="formID">            
 <%-- 10 --%>
             
 <br>For Selecting Distributor<a href ="<s:url action="IndiaPage" namespace="/maps"/>" target="_blank"> Click here.</a>
     <table width="85%">
     
            <s:textfield name="fb.distID" label="Distributor ID" size="20"/>
            <s:textfield name="fb.custID" label="Consumer No." size="20" cssClass="validate[required] text-input"/>
            <s:select name="fb.type" label="Feedback Type" 
                      list="{'--- select type ---', 'Suggestion','Complaint','general'}" />
            
            <s:select name="fb.category" label="Category" 
                      list="{'--- select category ---','Service-related', 'Technical Query'}" />
             
            
            <s:textarea name="fb.description" label="Description" cols="25" rows="5" cssClass="validate[required] text-input"/>            
         
            <s:textfield name="fb.email" label="E-Mail Address" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>
     <%--       <s:textfield name="fb.referenceNo" label="ReferenceNo   (for old Complaints)" size="25"/>     --%>       
           
            
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2"><s:submit align="center"/> </td></tr>
            </table>
        </s:form>
        </div>
    </body>
</html>