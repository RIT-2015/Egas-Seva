<%-- 
    Document   : adminpage
    Created on : Mar 22, 2012, 5:04:22 PM
    Author     : Somesh Mishra
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/common/dislayout.jsp">
    <tiles:putAttribute name="title" value="e-gas Sewa" type="string"/>
    <tiles:putAttribute name="header" value="/common/disheader.jsp"/>
    <tiles:putAttribute name="topmenu" value="/common/topmenu.jsp"/>
    <tiles:putAttribute name="menu" value="/common/adminMenu.jsp"/>
    <tiles:putAttribute name="body" value="/admin/adminHome.jsp"/>
    <tiles:putAttribute name="footer" value="/common/footer.jsp"/>
</tiles:insertTemplate>
