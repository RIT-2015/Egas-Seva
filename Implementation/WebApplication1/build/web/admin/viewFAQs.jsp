<%-- 
    Document   : viewFAQ
    Created on : Feb 25, 2012, 4:19:37 PM
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
            
            
            <h2 align="center" style=" color:#8DB638;">FAQ's</h2> 
            
            
            
         <div style="margin-left:81% ">
            <table>
                <tr>
                    <td colspan="2"> <input type="submit" value="Cancel" id="cancel"/> </td>
                </tr>   
                <tr>    
                    <td colspan="2"> <input type="submit" value="Add FAQ" id="add"/> </td>
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
        
            
        <div id="1" align="center">            

            <s:iterator value="faqColln">  

                <fieldset>
                    <legend><b> <font color="green" size="4">FAQ_ID : <s:property value="faqID" /></font></b></legend>

                    <TABLE width="100%" cellpadding="7" BORDER=1 BORDERCOLOR="lightgreen" >

                         <tr style="background-color: #b0c8f5"><td><b>Question :</b> </td><td> <s:property value="question"/> </td> </tr>
                        <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; "><td><b>Answer :</b> </td><td> <s:property value="answer"/> </td> </tr>
                        <tr>
                            <td colspan="2" align="">  <a href="<s:url action='faqDel' namespace='/admin'> 
                                         <s:param name='faq.faqID' value='faqID'/> </s:url>">                           
                                         Delete
                                     </a></td> 
                            </tr>
                        </table>
                    </fieldset>
            </s:iterator>
        </div>       




        <div id="2" align="center" >

            <s:form action="faqAdd" namespace="/admin" id="formID">       

                 <h2 style=" color:#8DB638;"> Add New FAQ </h2>
                <s:textarea name="faq.question" label="Question" cols="49" rows="2" cssClass="validate[required] text-input"/>
                <s:textarea name="faq.answer" label="Answer" cols="49" rows="5" cssClass="validate[required] text-input"/>

              <table>
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2"><s:submit align="center"/> </td></tr>
              </table>
            </s:form>

        </div>


       

    </body>
</html>





