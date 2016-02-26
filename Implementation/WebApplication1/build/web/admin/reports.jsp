<%-- 
    Document   : report
    Created on : Mar 18, 2012, 8:46:47 PM
    Author     : shashi
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

        <div align="left">
            <br></br>                  
            <h2 style=" color:#8DB638;"> Piechart </h2>        <br>
            <a href="piechart.action" style=" color:#459cb5;">Cylinders sold Report (last 5 years)</a> <br></br>
            
            <a href="distributorCitiesChart.action" style=" color:#459cb5;">Distributor's Registration Report in Metro cities</a>  <br></br>
                    
            <a href="regCustomerCitiesChart.action" style=" color:#459cb5;">User's Registration Report in Metro cities</a>  <br></br>
           
           <br>
           <h2 style=" color:#8DB638;"> Barchart </h2> <br>
            <a href="barchart.action" style=" color:#459cb5;">Cylinders sold Report (last 10 years)</a>  <br></br> 

        </div>
    </body>
</html>
