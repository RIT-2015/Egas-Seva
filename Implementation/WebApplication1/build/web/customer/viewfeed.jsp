<%-- 
    Document   : viewfeed
    Created on : 3 Apr, 2012, 4:11:13 AM
    Author     : shirish
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <h2>Feedback</h2>
        
        <table>
            <s:iterator value="c">
            <tr>           
                <td>You :</td><td><fieldset><s:property value="description"/></fieldset></td>
            </tr>
            <tr>           
                <td>Reply :</td><td><fieldset><s:property value="reply"/></fieldset></td>
            </tr>
            
            </s:iterator>
           
        </table>
        
        
        </div>
    </body>
</html>
