<%-- 
    Document   : product
    Created on : 26 Mar, 2012, 12:48:51 PM
    Author     : shirish
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %><%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        
        
        <%! static int count ; %>
        
                
        <h2>Products</h2>
        
         <table border="0" width="50%" align="center" >
            <tr>
                <th>    </th>
                <th>Name</th>
                <th>Price</th>
                <th>    </th>
            </tr>
            <s:iterator value="c">
                <tr>
                    <td>
                            
                        
                        
                    </td>
                   
                    <td align="center"><s:param name="ProductName" value="ProductName"/><s:property value="ProductName"/></td>
                    <td align="center"><s:param name="price" value="price"/><s:property value="price"/><img src="../resources/images/Indian-Rupee-Currency-Symbol.png"</td>
                                       
                    <td><s:url id="url" action="OrderproductAction!generateProOrder" namespace="/customer"><s:param name="prodID" value="prodID"></s:param></s:url><s:a href="%{url}"><img src="../resources/images/buynow-green-5.png" /></s:a></td>
                     
                     
                </tr>
 
            </s:iterator>
        </table>
        
 
        
        
        </div>
          
          
    </body>
</html>
