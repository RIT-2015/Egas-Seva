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
        <h2>Feedback or Complaint</h2>
        <s:form action="feedbackSend" namespace="/general">            
 <%-- 10 --%>
             
     <br>
     <table width="40%">
     
     <s:textfield name="fb.distID" label="Distributor ID" size="20"/>
            <s:textfield name="fb.custID" label="Consumer No." size="20"/>
            <s:select name="fb.type" label="Feedback Type" 
                      list="{'--- select type ---', 'Suggestion','Complaint','general'}" />
            
            <s:select name="fb.category" label="Category" 
                      list="{'--- select category ---','Service-related', 'Technical Query'}" />
             
            
            <s:textarea name="fb.description" label="Description" cols="25" rows="5"/>            
         
            <s:textfield name="fb.email" label="E-Mail Address" size="25"/>
            <s:textfield name="fb.referenceNo" label="ReferenceNo   (for old Complaints)" size="25"/>            
           
            
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2"><s:submit align="center"/> </td></tr>
            </table>
        </s:form>
        </div>
    </body>
</html>