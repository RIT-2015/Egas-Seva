<%-- 
    Document   : newcusappbody
    Created on : Mar 17, 2012, 1:31:03 PM
    Author     : Somesh Mishra
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<h2 align="center">Transfer Requests</h2>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<s:url action="NewApplication" namespace="/distributor"/>"><img src="../resources/images/newapp.jpg"/></a>
    <a href="<s:url action="NewTransferReq" namespace="/distributor"/>"><img src="../resources/images/transfer.jpg"/></a>
<%boolean result=false; %>
<TABLE WIDTH="100%">
<s:iterator value="cus">
    <% result=true;%>
<tr>
    <td>
        <fieldset style="background-color: #FFFFCC">
            <b style="font-family: georgia">Customer ID:&nbsp;<s:property value="c_id"/>
        <br/>   Name:&nbsp;<s:property value="fname"/>&nbsp;<s:property value="mname"/>&nbsp;<s:property value="lname"/>
        <br/>   Address:&nbsp;<s:property value="address"/></b><br/>
        <span  style=" margin-left: 75%; font-family: georgia; color: #0000ff"><b>
                <s:url id="url" action="TransferDetails" namespace="/distributor"><s:param name="c_id" value="c_id"/></s:url><s:a href="%{url}"><img src="../resources/images/viewdetails.jpg"/></s:a>
                </b></span>
        </fieldset>
    </td>
</tr>
</s:iterator>
<% if(result==false){%>
<tr>
    
    <td><fieldset style="background-color: #FFFFCC"><i><h4 align="center">No Transfer Requests</h4></i></fieldset></td>
</tr>
<% }%>
</TABLE>
