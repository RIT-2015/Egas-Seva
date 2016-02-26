<%-- 
    Document   : distributorApplications
    Created on : Feb 28, 2012, 10:14:20 PM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>

        <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br>
            
        <div align="center" >
    <%--        <h3> <s:text name="distributors.list.header"/> </h3>   --%>
           
          <h2 style=" color:#8DB638;"> New Distributor Applications </h2>
            <TABLE width="100%" cellpadding="5" BORDER=1 bordercolor="lightgreen" >

                <tr style="background-color: #b0c8f5">
                    <th>Appln ID</th>
                    <th>Name</th>  
                    
                    <th>State</th>                    
                    <th>Service City</th> 
                    <th>Appln Date</th>
                    <th></th>

                </tr>
               
                    <s:iterator value="distColln">     
                        
                        <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; ">
                        <td> <s:property value="distID" /> </td>              
                        <td> <s:property value="fname"/> <s:property value="mname"/><s:property value="lname"/></td>
                                            
                        <td> <s:property value="state"/> </td>
                        <td> <s:property value="serviceCity"/> </td>
                        <td> <s:property value="regDate"/> </td>

                        <td>  
                            <a href="<s:url action='distApplnDetails' namespace='/admin'> 
                                   <s:param name='distributor.distID' value='distID'/> </s:url>">                           
                                   View Details
                               </a>                 
                            </td>  

                        </tr>
                </s:iterator>


            </TABLE>
        </div>
    </body>
</html>

