<%-- 
    Document   : pinbody
    Created on : Feb 25, 2012, 3:51:07 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
 <s:if test="#session.user!=null">
         <s:if test="#session.user.logintype=='distributor'">
             <META HTTP-EQUIV="Refresh" CONTENT="0;URL=/egas/distributor/dishome.jsp"/>
         </s:if>
</s:if>
<h2>Please Enter Your Random Pin</h2>
<s:form action="PinCheck" namespace="/others">
    <s:label name="errormsg"/>
            <s:textfield name="pinvalue"/>
            <s:hidden name="user.logintype" />
            <s:hidden name="msg"/>
            <s:hidden name="user.username"/>
            <s:submit/>
 </s:form>