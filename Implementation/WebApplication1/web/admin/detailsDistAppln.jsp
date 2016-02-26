<%-- 
    Document   : detailsApplication
    Created on : Mar 26, 2012, 1:54:13 AM
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
        <h2 align="center" style=" color:#8DB638;">Distributor Application</h2>

        <div align="left">

            <s:iterator value="distColln">

                <fieldset>
                    <legend><b> <font color="459cb5" size="4">Personal Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Application ID </b></td><td> :&nbsp;<s:property value="distID" /> </td> </tr> 
                        <tr><td><b>Full Name </b> </td><td> :&nbsp;<s:property value="fname"/> <s:property value="mname"/> <s:property value="lname"/> </td> </tr> 
                        <tr><td><b>Date of Birth </b> </td><td> :&nbsp;<s:property value="dob"/> </td> </tr> 
                        <tr><td><b>Age </b> </td><td> :&nbsp;<s:property value="age"/> </td> </tr> 
                        <tr><td><b>Gender </b> </td><td> :&nbsp;<s:property value="gender"/> </td> </tr> 
                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="459cb5" size="4">Contact Details </font></b></legend>

                    <TABLE>
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Address </b> </td><td> :&nbsp;<s:property value="address"/> </td> </tr> 
                        <tr><td><b>Landmark </b> </td><td> :&nbsp;<s:property value="landmark"/> </td> </tr> 
                        <tr><td><b>Pin code </b> </td><td> :&nbsp;<s:property value="pin"/> </td> </tr> 
                        <tr><td><b>City  </td><td> :&nbsp;<s:property value="city"/> </td> </tr> 
                        <tr><td><b>State </b> </td><td> :&nbsp;<s:property value="state"/> </td> </tr> 
                        <tr><td><b>Mobile no. </b> </td><td> :&nbsp;<s:property value="mobile"/> </td> </tr> 
                        <tr><td><b>Landline no. </b> </td><td> :&nbsp;<s:property value="landline"/> </td> </tr> 
                        <tr><td><b>E-mail ID </b> </td><td> :&nbsp;<s:property value="email"/> </td> </tr>
                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="459cb5" size="4">Document Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Document 1 </b> </td><td> :&nbsp;<s:property value="id1"/> </td> </tr> 
                        <tr><td><b>Document 2 </b> </td><td> :&nbsp;<s:property value="id2"/> </td> </tr> 
                        <tr><td><b>Document 3 </b> </td><td> :&nbsp;<s:property value="id3"/> </td> </tr>  
                        <tr><td><b>Service City </b> </td><td> :&nbsp;<s:property value="serviceCity"/> </td> </tr> 
                        <tr><td><b>Verified </b> </td><td> :&nbsp;<s:property value="verified"/> </td> </tr> 
                    </table>
                </fieldset><br>
                <fieldset>
                    <legend><b> <font color="459cb5" size="4">Account Details </font></b></legend>

                    <TABLE> 
                         <tr><td></td><td></td></tr>
                        <tr><td><b>Agency Name </b> </td><td> :&nbsp;<s:property value="agencyName"/> </td> </tr>
                        <tr><td><b>Username </b> </td><td> :&nbsp;<s:property value="userName"/> </td> </tr> 
                        <tr><td><b>Password </b> </td><td> :&nbsp;<s:property value="password"/> </td> </tr> 
                        <tr><td><b>Register Date  </b></td><td> :&nbsp;<s:property value="regDate"/> </td> </tr>  
                    </table>
                </fieldset><br>                

            <table>
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2">
                        <s:form action="distributorApplns" namespace="/admin"> <s:submit value="Back"/> </s:form>
                    </td></tr>
            </table>

            </s:iterator>
        </div>
        
        
        
    <div style="margin-left:70% ">
            <table>
                <tr>
                    <td><a href="#" id="first"><img src="../resources/images/approve.jpg"/></a></td>
                    <td><a href="#" id="second"><img src="../resources/images/disapprove.jpg"/></a></td>
                </tr>
            </table>
            <script>
                window.onload=(function (){
                    $("#2").hide();
                    $("#1").hide();
                })
                $("#first").click(function() {
                    $("#2").hide();
                    $("#1").show();
                    1
                });

                $("#second").click(function() {
                    $("#1").hide();
                    $("#2").show();
                    1
                });
            </script>
        </div>

        
        
        <div id="1">
            
            <h2 align="center" style=" color:#8DB638;">Enter the details of the documents submitted by the Distributor</h2>

            <h4 align="center">Distributor's ID : <s:property value="distributor.distID"/></h4>
            
            <s:form action="distributorApprove" namespace="/admin" id="formID">  
                
                <s:hidden name="distributor.distID"/>
                <s:hidden name="distributor.email"/>
                
                <table align="center" width="100%">
                    
                   
                    <tr>
                        <td><b>Document Details1:</b></td>
                        <td><s:textarea name="distributor.id1" cols="50" cssClass="validate[required] text-input"/></td>
                    </tr>
                    <tr>
                        <td><b>Document Details2:</b></td>
                        <td><s:textarea name="distributor.id2" cols="50" cssClass="validate[required] text-input"/></td>
                    </tr>
                    <tr>
                        <td><b>Document Details3:</b></td>
                        <td><s:textarea name="distributor.id3" cols="50" /></td>
                    </tr>
                    <tr>
                     <s:textfield name="distributor.email" label="E-Mail Address" value="copy from above form" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>
                    </tr>
                    <tr>
                        <td colspan="2"><s:submit value="Submit"/></td>
                    </tr>
                </table>

            </s:form>  
        </div>

            
        <div id="2">
            <h2 align="center" style=" color:#8DB638;">Enter Reason of disapproving</h2>
            <s:form action="distributorReject" namespace="/admin" id="formID">  
               
               <s:hidden name="distributor.distID"/>
               <s:hidden name="distributor.email"/>
               
                <table align="center">
                    <tr>
                        <td colspan="2"><b>Reason for Application Rejection:</b></td>
                    </tr>
                    <tr>
                        <td><s:textarea cols="50" name="distributor.rejReason" cssClass="validate[required] text-input"/></td>
                    </tr>
                    <tr>
                    <s:textfield name="distributor.email" label="E-Mail Address" value="copy from above form" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>
                    </tr>
                    <tr>
                        <td colspan="2"><s:submit value="Submit"/></td>
                    </tr>
                </table>
            </s:form>
        </div>    
    
            
            
    </body>
</html>

