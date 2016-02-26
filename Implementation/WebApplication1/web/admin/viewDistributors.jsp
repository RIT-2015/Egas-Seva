<%-- 
    Document   : viewDistributors
    Created on : Feb 25, 2012, 1:12:14 PM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
            
        <div align="center">
            <h2 style=" color:#8DB638;"> Distributors </h2>
            <TABLE width="100%" cellpadding="5" bordercolor="lightgreen" border="1" >

                <tr style="background-color: #b0c8f5">
                    <th>D_ID</th>
                    <th>Name</th>
                    

                    <th>State</th>
                    <th>Service City</th>            
                    <th>Agency Name</th>
                    <th></th>
                    <th></th>
                </tr>
                
        <s:iterator value="distColln">
            
                <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; ">
                
                        <td> <s:property value="distID" /> </td>
                        <td> <s:property value="fname"/> <s:property value="mname"/><s:property value="lname"/></td>
                        

                        <td> <s:property value="state"/> </td>
                        <td> <s:property value="serviceCity"/> </td>               
                        <td> <s:property value="agencyName"/> </td>          

                        <td>  
                            <a href="<s:url action='distributorDetails' namespace='/admin'> 
                                   <s:param name='distributor.distID' value='distID'/> </s:url>">

                                   View Details
                               </a>                 
                        </td>
                        <td>  
                            <a href="<s:url action='distributorDel' namespace='/admin'> 
                                   <s:param name='distributor.distID' value='distID'/> </s:url>" onclick="return confirm('Are you sure you want to cancel order?')" >
                                Delete</a>

                        </td>
                        
                     </tr>
                </s:iterator>


            </TABLE>
        </div>
    </body>
</html>