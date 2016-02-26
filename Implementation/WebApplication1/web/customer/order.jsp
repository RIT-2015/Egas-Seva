<%-- 
    Document   : order
    Created on : 25 Mar, 2012, 1:04:32 AM
    Author     : shirish
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%--
        <form action="<s:url action="OrderAction!addOrder" namespace="/customer"/> " method="post"/>
        <h1>Order</h1>
        <b>C_id :</b><s:property value="cid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Product :</b><s:property value="type"/></br>
        <br>
        <b>order date :</b><s:property value="date1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Delivery date :</b><s:property value="date2"/><br>
        <br>
        
        <input type="submit" value="Confirm"/>
        --%>
        
        <div align="center">
        
        <h2>Order</h2>
        
        <table>
            <tr><td>
                    <fieldset>
                        <table>
                            <tr><td>
                                    <b>C_id :</b><s:property value="cid"/></td><td><b>Product :</b><s:property value="type"/> LPG</td></tr>
        
                            <tr><td> <b>order date :</b><s:property value="date1"/></td><td><b>Delivery date :</b><s:property value="date2"/></td></tr>
                            <tr><td>
         </td>
        </tr>
                        </table>
                            <pre>                                        </pre> <s:url id="url" action="OrderAction!addOrder" namespace="/customer"/><s:a href="%{url}"><img src="../resources/images/confirm.jpg"/></s:a>
       
        </fieldset> </td> </tr></table>
        
        
        </div>
    </body>
</html>
