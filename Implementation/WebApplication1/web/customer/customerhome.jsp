<%-- 
    Document   : customerhome
    Created on : Mar 28, 2012, 5:40:57 PM
    Author     : Somesh Mishra
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertTemplate template="/common/dislayout.jsp">
    <tiles:putAttribute name="title" value="e-gas Sewa" type="string"/>
    <tiles:putAttribute name="header" value="/common/disheader.jsp"/>
    <tiles:putAttribute name="topmenu" value="/common/topmenu.jsp"/>
    <tiles:putAttribute name="menu" value="/common/customermenu.jsp"/>
    <tiles:putAttribute name="body" value="/customer/cushomebody.jsp"/>
    <tiles:putAttribute name="footer" value="/common/footer.jsp"/>
</tiles:insertTemplate>