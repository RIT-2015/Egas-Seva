<%-- 
    Document   : cancelledorders
    Created on : Mar 18, 2012, 3:38:35 PM
    Author     : Somesh Mishra
--%>

<%@taglib uri="/struts-tags" prefix="s"%>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<s:url action="PendingOrders" namespace="/distributor"/>"><img src="../resources/images/pending.jpg"/></a>
   <a href="<s:url action="DeliveredOrders" namespace="/distributor"/>"><img src="../resources/images/deliveredorder.jpg"/></a>
   <a href="<s:url action="CancelledOrders" namespace="/distributor"/>"><img src="../resources/images/cancelled.jpg"/></a>

<%boolean result=false; %>
<fieldset>
       <h2 align="center">Cancelled Orders</h2>
<TABLE WIDTH="100%">
   
<s:iterator value="orders">
    <% result=true;%>
<tr>
    <td>
        <fieldset style="background-color: #FFFFCC">
            <b style="font-family: georgia">Order ID:&nbsp;<s:property value="o_id"/>
                <br/><b>Customer CID:&nbsp;<s:property value="c_id"/></b>
        <br/>  Customer Name:&nbsp;<s:property value="fname"/>&nbsp;<s:property value="mname"/>&nbsp;<s:property value="lname"/>
        <br/>   Address:&nbsp;<s:property value="address"/></b>
        <br/>   <b>LandMark:&nbsp;<s:property value="landmark"/></b>
        <br/>  <b>City:&nbsp;<s:property value="city"/></b> 
        <br/> <b>Order Date:&nbsp;<s:property value="o_date"/></b>
        <br/> <b>Cancelled date:&nbsp;<s:property value="cancel_date"/></b>
        </fieldset>
    </td>
</tr>
</s:iterator>
<% if(result==false){%>
<tr>
    
    <td><fieldset style="background-color: #FFFFCC"><i><h4 align="center">No Cancelled Orders</h4></i></fieldset></td>
</tr>
<% }%>
</TABLE>
</fieldset>