<%-- 
    Document   : products
    Created on : Apr 27, 2012, 6:07:59 AM
    Author     : Somesh Mishra
--%>

<%@taglib uri="/struts-tags" prefix="s"%>

    
<%boolean result=false; %>
   <fieldset>
       <h2 align="center">Product Orders</h2>
<TABLE WIDTH="100%">
 
<s:iterator value="productorders">
    <% result=true;%>
<tr>
    <td>
        <fieldset style="background-color: #FFFFCC">
            <b style="font-family: georgia">Order ID:&nbsp;<s:property value="orderID"/>
                <br/><b>Customer CID:&nbsp;<s:property value="consumerNo"/></b>
        <br/> <b>Order Date:&nbsp;<s:property value="orderDate"/></b>
        <br/> <b>Quantity&nbsp;<s:property value="quantity"/></b>
        <br/> <b>Status&nbsp;<s:property value="Status"/></b>
        <s:if test="%{status==\"undelivered\"}">
        <s:url id="url" action="DeliverProduct" namespace="/distributor"><s:param name="o_id" value="o_id"/>
            <s:param name="orderID" value="orderID"/></s:url><s:a href="%{url}" onclick="return confirm('Are you sure you want to deliver order?')"><img style="margin-left: 75%" src="../resources/images/deliver.jpg"/></s:a>
        </s:if>
            </fieldset>
    </td>
</tr>

</s:iterator>
<% if(result==false){%>
<tr>
    
    <td><fieldset style="background-color: #FFFFCC"><i><h4 align="center">No Orders</h4></i></fieldset></td>
</tr>
<% }%>
</TABLE>
</fieldset>