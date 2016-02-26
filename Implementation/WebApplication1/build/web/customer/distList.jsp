<%-- 
    Document   : distList
    Created on : 6 Mar, 2012, 6:47:04 PM
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
        <h1>distributor</h1>
        <table>

            <tr>
        <s:iterator value="d">
            <td>
                <s:url id="k1" action="DistributorAction!ret" namespace="/" method="ret"></s:url>
                <s:a href="%{k1}"><s:param name="Fname" value="Fname"/>
                    <s:property  value="Fname"/></s:a>
            </td>
            </tr>
        </s:iterator>
        </table>
        

            <p>After property</p>
    </body>
</html>
