<%-- 
    Document   : Cprod
    Created on : 24 Apr, 2012, 5:20:07 PM
    Author     : shirish
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><%boolean result=false;%>
    </head>
    <body>
        <div align="center">
        <h2 align="center">Product Orders</h2>
        </br>
       &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<s:url action="OrderproductAction!viewPProductOrder" namespace="/customer"/>"><img src="../resources/images/pending.jpg"/></a>
    <a href="<s:url action="OrderproductAction!viewDProductOrder" namespace="/customer"/>"><img src="../resources/images/deliveredorder.jpg"/></a>
    <a href="<s:url action="OrderproductAction!viewCProductOrder" namespace="/customer"/>"><img src="../resources/images/cancelled.jpg"/></a>

        <TABLE WIDTH="100%">
<s:iterator value="c"> <%result=true;%>
<tr>
    <td>
        <fieldset style="background-color: #FFFFCC">
            <table>
                <tr><td> <b style="font-family: georgia">Order ID:&nbsp;<s:param name="orderID" value="orderID"/><s:property value="orderID"/></br></br><b>Product Name: <s:param name="productName" value="productName"/><s:property value="productName"/>  </b>
                            </br> <b>Quantity : <s:param name="quantity" value="quantity" /> <s:property value="quantity" /></b> </br> <b>Cost :<s:param name="price" value="price" /> <s:property value="price" /></b>           
        <br/></br> <b>Order Date:&nbsp;<s:param name="orderDate" value="orderDate"/><s:property value="orderDate"/></b><br><b>Delivery Date:&nbsp;<s:param name="deliveryDate" value="deliveryDate"/><s:property value="deliveryDate"/></b>
        </br><b>Cancel Date :<s:param name="cancelDate" value="cancelDate"/><s:property value="cancelDate"/></b>
        </br></br> <b>Order Status:&nbsp;<s:param name="status" value="status"/><s:property value="status"/></b>
        
        </td>
            </table>
        </fieldset>
    </td>
</tr>
</s:iterator><% if(result==false){%>
<tr>
    
    <td><fieldset style="background-color: #FFFFCC"><i><h4 align="center">No Cancelled Orders</h4></i></fieldset></td>
</tr>
<% }%>
</TABLE>
    

    </body>
</html>
