<%-- 
    Document   : deleted
    Created on : 16 Mar, 2012, 1:33:35 AM
    Author     : Shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <h2>Order canceled!!</h2>
        
        
            <s:url id="url" action="OrderAction!viewOrder" namespace="/customer" /><s:a href="%{url}"><img src="../resources/images/back.jpg"/></s:a>
        </div>
        
      <%--  <table border="1">
            <tr>
                <th>Order Id</th>
                <th>Order Date</th>
                <th>Delivery Date</th>
                <th>Delivery Status</th>
            </tr>
            <%--<s:iterator value="c">
                <tr>
                    <td align="center"><s:param name="orderID" value="orderID"/><s:property value="orderID"/></td>
                    <td align="center"><s:param name="orderDate" value="orderDate"/><s:property value="orderDate"/></td>
                    <td align="center"><s:param name="deliveryDate" value="deliveryDate"/><s:property value="deliveryDate"/></td>
                    <td align="center"><s:param name="status" value="status"/><s:property value="status"/></td>
                    <td><s:url action="OrderAction!delOrder"/><s:a href="%{url}">Cancel Order</s:a></td>
                </tr>

            </s:iterator>--%>
      </table>
    </body>
</html>
