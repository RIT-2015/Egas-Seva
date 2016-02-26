<%-- 
    Document   : productbook
    Created on : 1 Apr, 2012, 9:21:56 PM
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
        
               
        <div align="center">`
        <form action="<s:url action="OrderproductAction!placeOrder" namespace="/customer" />" method="post" id="formID">
            
            <table>
                <tr><td>
                        <b>  Product ID : </b>   <s:property  value="pid" /></td></tr>
                <tr><td><b>Product name :</b><s:property value="Pname" /></td></tr>
                <tr><td><b>Price :</b> <s:property value="Pprice"  /></td></tr>
                <tr><td><b>Enter Quantity : </b><s:textfield name="ordpro.quantity" cssClass="validate[required,custom[integer],min[1]] text-input"/></td></tr>
               
            </table>
        
        
        
      
        
        
          
        
        <input type="submit" />
        </form>
       
        
                    </div>
        </body>
</html>
