<%-- 
    Document   : header
    Created on : Feb 26, 2012, 10:06:35 AM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<p align="right" style="color: white; font-size: 15px">
    <s:if test="#session.user==null">
        
         <META HTTP-EQUIV="Refresh" CONTENT="0;URL=/egas/others/home.jsp">
    </s:if>
         |&nbsp;<b>Welcome:<u><s:property value="#session.user.username"/></u></b>&nbsp;|&nbsp;<b><a href="<s:url action="Logout" namespace="/others"/>" style="color: white">Logout</a></b>&nbsp;|
</p>