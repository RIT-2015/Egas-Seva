<%-- 
    Document   : report
    Created on : Apr 3, 2012, 7:32:22 AM
    Author     : Acer
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<fieldset style="background-color: #FFFFCC">
    <legend  align="center"><h2>Reports</h2></legend>
    <table align="center" width="100%">
        <tr>
            <td align="center"><a href="<s:url action="LPGOrderPDF" namespace="/reports"/>" ><img src="../resources/images/lpgpdf.jpg"/></a></td>
            <td align="center"><a href="<s:url action="LPGOrderXLS" namespace="/reports"/>" ><img src="../resources/images/lpgrtf.jpg"/></a></td>
        </tr>
    </table>
</fieldset>

