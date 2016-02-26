<%-- 
    Document   : adminlogin
    Created on : Feb 24, 2012, 2:30:25 PM
    Author     : Somesh Mishra
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/common/layout2.jsp">
    <tiles:putAttribute name="title" value="e-gas Sewa" type="string"/>
    <tiles:putAttribute name="header" value="/common/header.jsp"/>
    <tiles:putAttribute name="topmenu" value="/common/topmenu.jsp"/>
    <tiles:putAttribute name="body" value="/admin/adminloginbody.jsp"/>
    <tiles:putAttribute name="footer" value="/common/footer.jsp"/>
</tiles:insertTemplate>