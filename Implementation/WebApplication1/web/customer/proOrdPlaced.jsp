<%-- 
    Document   : proOrdPlaced
    Created on : 20 Apr, 2012, 1:44:51 AM
    Author     : shirish
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><div align="center">
            <h2> Your Product is booked successfully.</h2><br>
            <font size="+2">Just select your preferred mode of payment</br>
           
             </font>
             
             <table>
                 <tr>
                     <td><a target="_blank" href="<s:url namespace="/others" action="Pay"/>"><img src="../resources/images/payment.jpg"/></a></td>
                     <td><a href="<s:url action="CusHome" namespace="/customer"/>"><img src="../resources/images/cash.jpg"/></a></td>
                 </tr>
             </table>
              
        </div>
    </body>
</html>
