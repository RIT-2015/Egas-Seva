<%-- 
    Document   : booked
    Created on : 5 Mar, 2012, 12:18:41 AM
    Author     : Shirish

--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%--<h3>ORDERS</h3><br><br>
        <table border="1" >
            <tr>
                <th>Order Id</th>
                <th>Order Date</th>
                <th>Cancel Date</th>
                <th>Delivery Date</th>
                <th>Delivery Status</th>
            </tr>
            <s:iterator value="c">
                <tr>
                    <td align="center"><s:param name="o_id" value="o_id"/><s:property value="o_id"/></td>
                    <td align="center"><s:param name="o_date" value="o_date"/><s:property value="o_date"/></td>
                    <td align="center"><s:param name="cancel_date" value="cancel_date"/><s:property value="cancel_date"/></td>
                    <td align="center"><s:param name="deliver_date" value="deliver_date"/><s:property value="deliver_date"/></td>
                    <td align="center"><s:param name="status" value="status"/><s:property value="status"/></td>
                    <s:if test="%{status==\"undelivered\"}"><td><s:url id="url" action="OrderAction!delOrder" namespace="/customer"><s:param name="orderID" value="orderID"></s:param></s:url><s:a href="%{url}">Cancel Order</s:a></td>
               </s:if> 
                     </tr>

            </s:iterator>
        </table>--%>
        <div align="center">
             <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
        <h2 align="center">LPG Orders</h2>
        </br>
       &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<s:url action="OrderAction!pendingOrder" namespace="/customer"/>"><img src="../resources/images/pending.jpg"/></a>
    <a href="<s:url action="OrderAction!viewDeliveredOrders" namespace="/customer"/>"><img src="../resources/images/deliveredorder.jpg"/></a>
    <a href="<s:url action="OrderAction!viewCancelledOrders" namespace="/customer"/>"><img src="../resources/images/cancelled.jpg"/></a>

        
        
           
          
        
        
    </body>
</html>
