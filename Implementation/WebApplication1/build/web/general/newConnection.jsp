<%-- 
    Document   : newConnection
    Created on : Feb 19, 2012, 1:33:11 AM
    Author     : shashi
--%>

<%-- <s:head /> tag is used to include the required css and js file for the 
      selected theme. By default the xhtml theme is used. --%>

<%-- Struts 2 will automatically create the necessary tables for the page 
     based on the theme selected. By default the XHTML theme is selected. --%> 

<%-- fName,dName : second letter capital not allowed --%>  



<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>      


<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head theme="simple"/>



    </head>
    <body>        
        
        <div align="center"> 
           
            <b><font style="color: indianred; font-size: 21px;">
            <table align="center">
                <tr><s:label name="msg"/></tr>
            </table></font></b><br><br>
            
            
            <h2 style=" color:#8DB638;">New Connection Application</h2><br>

            <%--       <s:form action="NewConnection" namespace="/general" cssStyle="color:#7a3d3d">      --%>  
            <form action="<s:url action="NewConnection" namespace="/general"/>" method="post" id="formID" >    

                <%--22  +3  --%>  
                
                
                For Selecting Distributor <a href ="<s:url action="IndiaPage" namespace="/maps"/>" target="_blank">Click here.</a><br>
                <table align="center" width="45%">   
                    <s:textfield name="customer.d_id" label="Distributor ID" size="25" cssClass="validate[required] text-input"/>

                    <s:textfield name="customer.fname" label="First Name" size="25"  cssClass="validate[required] text-input"/>
                    <s:textfield name="customer.mname" label="Middle Name" size="25" cssClass="validate[required] text-input"/>
                    <s:textfield name="customer.lname" label="Last Name" size="25" cssClass="validate[required] text-input"/>
                    <s:datetimepicker displayFormat="dd/MM/yyyy" name="customer.dob" label="Date of Birth" cssClass="validate[required] text-input"/>  
                    <s:radio name="customer.gender" label="Gender" list="{'male','female'}" cssClass="validate[required] text-input"/>

                    <s:textarea name="customer.address" label="Address" cols="19" rows="3" cssClass="validate[required] text-input"/>
                    <s:textfield name="customer.landmark" label="Landmark" cssClass="fieldtext" size="25" cssClass="validate[required] text-input"/>
                    <s:textfield name="customer.pin" label="Pin No" size="25" cssClass="validate[required] text-input"/>
                    <s:textfield name="customer.city" label="city" size="25" cssClass="validate[required] text-input"/>
                    <s:select cssClass="validate[required]" name="customer.state" label="State"  
                              list="{'------ select state ------','Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Delhi','Goa','Gujrat','Haryana','Himachal Pradesh','Jammu and Kashmir','Jharkhand','Karnatka','Kerla','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Orissa','Punjab','Rajasthan','Sikkim','Tamil Nadu','Tripura','UNION TERRITORY','Uttar Pradesh','Uttranchal','West Bengal'}" />


                    <s:textfield name="customer.mobile" label="Mobile No" size="25" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/>
                    <s:textfield name="customer.contactno1" label="Office/Other No" size="25" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/>            
                    <s:textfield name="customer.contactno2" label="landline" size="25" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/>
                    <s:textfield name="customer.email" label="E-Mail Address" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>


                    <s:select name="customer.cus_type" label="Customer Type" cssClass="validate[required]"
                              list="{'---select type----','Home User','Commercial User'}" />

                    <%--     
                           <s:select name="customer.id1" label="ID Proof" required="true" requiredposition="left" list="{'-- select document --','Passport', 'Election Card', 'Pan Card','Bank Passbook'}" />

            <s:select name="customer.id2" label="Address Proof" required="true" requiredposition="left" list="{'-- select document --','Light Bill', 'Maintanence Bill','Room Agreement'}" />
                    --%>
                    <s:select name="customer.no_of_cylinder" label="No. of Cylinders" required="true" requiredposition="left" cssClass="validate[required]"
                              list="{'-- select count --' , '1', '2', '3' }" />

                    <s:hidden name="customer.status" label="status" value="waited"/>
<%--
                    <tr><td colspan="2"> <br>

                            <%
                                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lfzq84SAAAAAMV2etBy0FTKAWtiIzip3NgDGVK-", "6Lfzq84SAAAAAGddksYEC0cdWnCu18qNE50Mf-sw", false);
                                out.print(c.createRecaptchaHtml(null, null));
                            %>
                        </td></tr>
--%>
                    <tr><td>&nbsp; </td><td> </td></tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="submit" align="center"/> </td></tr>
                </table>

            </form>
        </div>
    </body>
</html>
