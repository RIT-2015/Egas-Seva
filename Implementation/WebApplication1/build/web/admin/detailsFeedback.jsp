<%-- 
    Document   : detailsFeedback
    Created on : Mar 26, 2012, 1:53:25 AM
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
            
        <h2 align="center" style=" color:#8DB638;">Feedback or Complaint</h2>

        <div align="left">

            <s:iterator value="fbColln">

                <fieldset>
                    <legend><b> <font color="459cb5" size="4">Customer Details </font></b></legend>

                    <TABLE> 
                        <tr><td></td><td></td></tr>
                        <tr><td><b>Consuner No. </b> </td><td> :&nbsp;<s:property value="custID"/> </td> </tr> 
                        <tr><td><b>Distributor ID </b> </td><td> :&nbsp;<s:property value="distID"/> </td> </tr>
                        <tr><td><b>E-mail </b> </td><td> :&nbsp;<s:property value="email"/> </td> </tr> 
                       
                    </table>
                </fieldset><br>              
                <fieldset>
                    <legend><b> <font color="459cb5" size="4">Feedback</font></b></legend>

                    <TABLE> 
                        <tr><td></td><td></td></tr>
                        <tr><td><b>F_ID </b></td><td> :&nbsp;<s:property value="fbID" /> </td> </tr> 
                        <tr><td><b>Type </b> </td><td> :&nbsp;<s:property value="type"/> </td> </tr> 
                        <tr><td><b>Category </b> </td><td> :&nbsp;<s:property value="category"/> </td> </tr>
                        <tr><td><b>Description </b> </td><td> :&nbsp;<s:property value="description"/> </td> </tr> 
                                              
                        <tr><td><b>Reference No </b> </td><td> :&nbsp;<s:property value="referenceNo"/> </td> </tr> 
                        <tr><td><b>Reply  </b></td><td> :&nbsp;<s:property value="reply"/> </td> </tr>  

                    </TABLE>                   
                </fieldset><br>                

            </s:iterator>    

        </div>





        <div id="2" align="center"> 

            <s:form action="feedbackReply" namespace="/admin" >
             
               <s:iterator value="fbColln">  
            <%--    <s:property value="email"/>       --%>
                <s:hidden name="fb.fbID"/>
                <s:hidden name="fb.email"/>
               </s:iterator>  
                <s:textfield name="fb.email" label="E-Mail" value="Copy customer's Email from above form" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>
                <s:textarea name="fb.reply" label="Reply" cols="50" rows="7" />
                <s:submit value="Send" align="center"/>
                
            </s:form>

        </div>



        <div style="margin-left:3% ">
            <table>
                <tr>
                    <td colspan="2"> <input type="submit" value="Cancel" id="cancel"/> </td>
                </tr>   
                <tr>    
                    <td colspan="2"> <input type="submit" value="Reply" id="add"/> </td>
                </tr>
            </table>
            <script>
                window.onload=(function (){
                    $("#1").show();
                    $("#2").hide();
                    $("#cancel").hide();
                })
                $("#add").click(function() {
                    $("#2").show();
                    $("#cancel").show();
                    $("#1").hide();                    
                    $("#add").hide();                    
                });

                $("#cancel").click(function() {
                    $("#1").show();
                    $("#add").show();
                    $("#2").hide();
                    $("#cancel").hide();
                });
            </script>
        </div>

    </body>
</html>