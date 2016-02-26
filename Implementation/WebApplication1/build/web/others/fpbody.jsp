<%-- 
    Document   : fpbody
    Created on : Feb 25, 2012, 3:59:48 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
 <s:if test="#session.user!=null">
         <s:if test="#session.user.logintype=='distributor'">
             <META HTTP-EQUIV="Refresh" CONTENT="0;URL=/egas/distributor/dishome.jsp"/>
         </s:if>
</s:if>
<h3 align="center">Please Enter Your Username</h3>
<table align="center">
    <tr><td>
            <s:form action="SendPassword" namespace="/others">
                <s:label name="errormsg"/>
    <s:textfield name="user.username"/>
    <s:submit/>  
</s:form>
        </td></tr>
</table>