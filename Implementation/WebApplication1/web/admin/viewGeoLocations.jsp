<%-- 
    Document   : geoLocation
    Created on : Apr 9, 2012, 6:35:33 PM
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

        <h2 align="center" style=" color:#8DB638;">Products</h2>     

        <div style="margin-left:81% ">
            <table width="100%">
                <tr>
                    <td colspan="2"> <input type="submit" value="Cancel" id="cancel"/> </td>
                </tr>   
                <tr>    
                    <td colspan="2"> <input type="submit" value="Add Location" id="add"/> </td>
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



            <TABLE width="100%" cellpadding="5" BORDER=1 bordercolor="lightgreen">

                <tr style="background-color: #b0c8f5">
                    <th>ID</th>
                    <th>D_ID</th>
                    <th>Latitude</th>
                    <th>Longitude</th>

                    <th></th>
                    <th></th>

                </tr>

                <s:iterator value="glColln">               
                    <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; "> 
                        <td><s:property value="id" /></td>
                        <td> <s:property value="did"/> </td>
                        <td> <s:property value="latitude"/> </td>
                        <td> <s:property value="longitude"/> </td>

                        <td>
                            <a href="<s:url action='geoDel' namespace='/admin'>
                                   <s:param name='gl.id' value='id'/> </s:url>" >
                                   Delete
                               </a>           
                            </td>
                        </tr>
                </s:iterator> 
            </TABLE><br></br>

        </div>   





        <div id="2" align="center">

            <h2 align="center" style=" color:#8DB638;">Add New Geo Location</h2><br>            

            <s:form action="geoAdd" namespace="/admin" id="formID">

                <s:textfield name="gl.did" label="D_ID" cssClass="validate[required] text-input"/>
                <s:textfield name="gl.latitude" label="Latitude" cssClass="validate[required] text-input"/>
                <s:textfield name="gl.longitude" label="Longitude" cssClass="validate[required] text-input"/>  

                <table>
                    <tr><td>&nbsp; </td><td> </td></tr>
                    <tr><td colspan="2"><s:submit align="center"/> </td></tr>
                </table>
            </s:form>

        </div>  




    </body>
</html>





