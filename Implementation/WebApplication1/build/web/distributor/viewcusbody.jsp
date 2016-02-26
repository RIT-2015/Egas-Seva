<%-- 
    Document   : viewcusbody
    Created on : Mar 1, 2012, 11:45:09 AM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2 align="center">Customer List</h2>
<hr/>
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
        <span  style=" margin-left: 55%; font-family: georgia; color: #0000ff"><b>&nbsp;
                <s:url id="url" action="CustomerDetails" namespace="/distributor"><s:param name="c_id" value="c_id"/></s:url><s:a href="%{url}"><img src="../resources/images/viewdetails.jpg"/></s:a>
                &nbsp;&nbsp;
                <s:url id="uri" action="DeleteCustomer" namespace="/distributor"><s:param name="c_id" value="c_id"/></s:url><s:a href="%{uri}" onclick="return confirm('Are you sure you want to delete the customer?')"><img src="../resources/images/delete.jpg"/></s:a>
                &nbsp;</b></span>
        </fieldset>
    </td>
</tr>
</s:iterator>
<% if(result==false){%>
<tr>
    
    <td><fieldset style="background-color: #FFFFCC"><i><h4 align="center">No Customers </h4></i></fieldset></td>
</tr>
<% }%>
</TABLE>
