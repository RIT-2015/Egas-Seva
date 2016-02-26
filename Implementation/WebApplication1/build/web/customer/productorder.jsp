<%-- 
    Document   : productorder
    Created on : 26 Mar, 2012, 9:04:42 PM
    Author     : shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
function show_confirm()
{
var r=confirm("Are you sure you want to cancel order?");

}
</script>
    </head>
    
    
    <body>
        <div align="center">
             <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
        <div align="center">
        <h2 align="center">Product Orders</h2>
        </br>
       &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<s:url action="OrderproductAction!viewPProductOrder" namespace="/customer"/>"><img src="../resources/images/pending.jpg"/></a>
    <a href="<s:url action="OrderproductAction!viewDProductOrder" namespace="/customer"/>"><img src="../resources/images/deliveredorder.jpg"/></a>
    <a href="<s:url action="OrderproductAction!viewCProductOrder" namespace="/customer"/>"><img src="../resources/images/cancelled.jpg"/></a>

        
       <%-- 
        <table border="1" >
            <tr>
                <th>Order Id</th>
                <th>Product Id</th>
                <th>Name</th>
                <th>Order Date</th>
                
                <th>Cancel Date</th>
                <th>Delivery Date</th>
                <th>Delivery Status</th>
            </tr>
            <s:iterator value="c">
                <tr>
                    <td align="center"><s:param name="orderID" value="orderID"/><s:property value="orderID"/></td>
                    <td align="center"><s:param name="prodID" value="prodID"/><s:property value="prodID"/></td>
                    <td align="center"><s:param name="productName" value="productName"/><s:property value="productName"/></td>
                    
                    <td align="center"><s:param name="orderDate" value="orderDate"/><s:property value="orderDate"/></td>
                    <td align="center"><s:param name="cancelDate" value="cancelDate"/><s:property value="cancelDate"/></td>
                    <td align="center"><s:param name="deliveryDate" value="deliveryDate"/><s:property value="deliveryDate"/></td>
                    <td align="center"><s:param name="status" value="status"/><s:property value="status"/></td>
                    <s:if test="%{status==\"U\"}"><td><s:url id="url" action="OrderproductAction!delOrderProduct" namespace="/customer"><s:param name="orderID" value="orderID"></s:param></s:url><s:a href="%{url}">Cancel Product Order</s:a></td>
               </s:if> 
                     </tr>

            </s:iterator>
        </table>
        
        --%>
        
        
       
        
        
        
        
        
        
        
        
        
        
        </div>
    </body>
</html>
