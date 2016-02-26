<%-- 
    Document   : pendingOrd
    Created on : 24 Apr, 2012, 3:47:12 PM
    Author     : shirish
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><%boolean result=false;%>
        
    </head>
    <body>
        <h2 align="center">LPG Orders</h2>
        </br>
       &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<s:url action="OrderAction!pendingOrder" namespace="/customer"/>"><img src="../resources/images/pending.jpg"/></a>
    <a href="<s:url action="OrderAction!viewDeliveredOrders" namespace="/customer"/>"><img src="../resources/images/deliveredorder.jpg"/></a>
    <a href="<s:url action="OrderAction!viewCancelledOrders" namespace="/customer"/>"><img src="../resources/images/cancelled.jpg"/></a>

        
        <div align="center">
             <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
           
        
        <TABLE WIDTH="100%">
<s:iterator value="c">
    <%result=true;%>
<tr>
    <td>
        <fieldset style="background-color: #FFFFCC">
            <table>
                <tr><td> <b style="font-family: georgia">Order ID:&nbsp;<s:param name="o_id" value="o_id"/><s:property value="o_id"/>
                
                            <br/> <b> Order Date:&nbsp;<s:param name="o_date" value="o_date"/><s:property value="o_date"/></b><b><br> Delivery Date:<s:param name="deliver_date" value="deliver_date"/><s:property value="deliver_date"/></b>
   
        </br><b>Order Status:&nbsp;<s:param name="status" value="status"/><s:property value="status"/></b>
        
        <br/><br></td><td align="right"><pre>                                    </pre>
        <s:if test="%{status==\"undelivered\"}"><td><s:url id="url" action="OrderAction!delOrder" namespace="/customer"><s:param name="o_id" value="o_id"></s:param></s:url><s:a href="%{url}" onclick="return confirm('Are you sure you want to cancel order?')"><img  src="../resources/images/cancel.jpg"/></s:a>
               </s:if> 
        </td>
            </table>
        </fieldset>
    </td>
</tr>
</s:iterator><% if(result==false){%>
<tr>
    
    <td><fieldset style="background-color: #FFFFCC"><i><h4 align="center">No Pending Orders</h4></i></fieldset></td>
</tr>
<% }%>
</TABLE>
        
        
        </div>  
        
        
    </body>
</html>
