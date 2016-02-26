<%-- 
    Document   : home
    Created on : Feb 25, 2012, 10:45:49 AM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/common/layout.jsp">
    <tiles:putAttribute name="title" value="e-gas Sewa" type="string"/>
    <tiles:putAttribute name="header" value="/common/header.jsp"/>
    <tiles:putAttribute name="topmenu" value="/common/topmenu.jsp"/>
    <tiles:putAttribute name="menu" value="/common/leftmenu.jsp"/>
    <tiles:putAttribute name="body" value="/others/homebody.jsp"/>
    <tiles:putAttribute name="footer" value="/common/footer.jsp"/>
</tiles:insertTemplate>