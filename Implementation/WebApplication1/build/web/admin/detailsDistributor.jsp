<%-- 
    Document   : detailsDistributor
    Created on : Mar 26, 2012, 1:50:58 AM
    Author     : shashi
--%>

<%-- 24 --%>               

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>    

        <h2 style=" color:#8DB638;" align="center">Distributor </h2>
        
        <div align="left">
            
            <s:iterator value="distColln">

                <fieldset>
                    <legend><b> <font color="459cb5">Personal Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>D_ID </b></td><td>:&nbsp; <s:property value="distID" /> </td> </tr> 
                        <tr><td><b>Full Name </b> </td><td>:&nbsp; <s:property value="fname"/> <s:property value="mname"/> <s:property value="lname"/> </td> </tr> 
                        <tr><td><b>Date of Birth </b> </td><td>:&nbsp; <s:property value="dob"/> </td> </tr> 
                        <tr><td><b>Age </b> </td><td>:&nbsp; <s:property value="age"/> </td> </tr> 
                        <tr><td><b>Gender </b> </td><td>:&nbsp; <s:property value="gender"/> </td> </tr> 
                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="459cb5">Contact Details </font></b></legend>

                    <TABLE>
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Address </b> </td><td>:&nbsp; <s:property value="address"/> </td> </tr> 
                        <tr><td><b>Landmark </b> </td><td>:&nbsp; <s:property value="landmark"/> </td> </tr> 
                        <tr><td><b>Pin code </b> </td><td>:&nbsp; <s:property value="pin"/> </td> </tr> 
                        <tr><td><b>City </td><td>:&nbsp; <s:property value="city"/> </td> </tr> 
                        <tr><td><b>State </b> </td><td>:&nbsp; <s:property value="state"/> </td> </tr> 
                        <tr><td><b>Mobile no. </b> </td><td>:&nbsp; <s:property value="mobile"/> </td> </tr> 
                        <tr><td><b>Landline no. </b> </td><td>:&nbsp; <s:property value="landline"/> </td> </tr> 
                        <tr><td><b>E-mail ID </b> </td><td>:&nbsp; <s:property value="email"/> </td> </tr>
                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="459cb5">Document Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Document 1 </b> </td><td>:&nbsp; <s:property value="id1"/> </td> </tr> 
                        <tr><td><b>Document 2 </b> </td><td>:&nbsp; <s:property value="id2"/> </td> </tr> 
                        <tr><td><b>Document 3 </b> </td><td>:&nbsp; <s:property value="id3"/> </td> </tr>  
                        <tr><td><b>Service City </b> </td><td>:&nbsp; <s:property value="serviceCity"/> </td> </tr> 
                        <tr><td><b>Verified </b> </td><td>:&nbsp; <s:property value="verified"/> </td> </tr> 
                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="459cb5">Account Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Agency Name </b> </td><td>:&nbsp; <s:property value="agencyName"/> </td> </tr>
                        <tr><td><b>Username </b> </td><td>:&nbsp; <s:property value="userName"/> </td> </tr> 
                        <tr><td><b>Password </b> </td><td>:&nbsp; <s:property value="password"/> </td> </tr> 
                        <tr><td><b>Register Date </b></td><td>:&nbsp; <s:property value="regDate"/> </td> </tr>  
                    </table>
                </fieldset>

             <table>
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2">
                        <s:form action="distributor" namespace="/admin"> <s:submit value="Back"/> </s:form>
                    </td></tr>
            </table>

            </s:iterator>
        </div>



        


    </body>
</html>

