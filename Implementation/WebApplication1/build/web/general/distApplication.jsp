<%-- 
    Document   : distReg
    Created on : Feb 20, 2012, 1:13:26 PM
    Author     : shashi
--%>

<%@page import="java.util.Calendar"%>
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
            
        <h2 align="center" style=" color:#8DB638;">Distributor Application</h2><br>       
            
            
<%-- 24  --%>
        <form action="<s:url action="distributorInsertAppln" namespace="/general"/>" method="post" id="formID">    
            
        <table align="center" width="45%">   
            <s:textfield name="distributor.fname" label="First Name" size="25" cssClass="validate[required] text-input"/>
            <s:textfield name="distributor.mname" label="Middle Name" size="25" cssClass="validate[required] text-input"/>
            <s:textfield name="distributor.lname" label="Last Name" size="25" cssClass="validate[required] text-input"/>            
            <s:datetimepicker displayFormat="dd/MM/yyyy" name="distributor.dob" label="Date of Birth"/>
            <s:radio name="distributor.gender" label="Gender" list="{'male','female'}"/>

            <s:textarea name="distributor.address" label="Address" cols="20" rows="3" cssClass="validate[required] text-input"/>
            <s:textfield name="distributor.landmark" label="Landmark" size="25" cssClass="validate[required] text-input"/>
            <s:textfield name="distributor.pin" label="Pin Code" size="25" cssClass="validate[required] text-input"/>            
            <s:textfield name="distributor.city" label="city" size="25" cssClass="validate[required] text-input"/>
            <s:select name="distributor.state" label="State" list="{'----- select state -----','Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Delhi','Goa','Gujrat','Haryana','Himachal Pradesh','Jammu and Kashmir','Jharkhand','Karnatka','Kerla','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Orissa','Punjab','Rajasthan','Sikkim','Tamil Nadu','Tripura','UNION TERRITORY','Uttar Pradesh','Uttranchal','West Bengal'}" />

            <s:textfield name="distributor.mobile" label="Mobile No" size="25" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/>
            <s:textfield name="distributor.landline" label="landline" size="25" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/>
            <s:textfield name="distributor.email" label="E-Mail Address" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>
<%--
            <s:select name="distributor.id1" label="Document 1"  required="true" requiredposition="left" list="{'-- select document --','Passport', 'Election Card', 'Pan Card','Bank Passbook'}" />
            <s:select name="distributor.id2" label="Document 2"  required="true" requiredposition="left" list="{'-- select document --','Light Bill', 'Maintanence Bill','Room Agreement'}" />
            <s:textfield name="distributor.id3" label="Other Document" />
--%>
            <s:textfield name="distributor.serviceCity" label="Select City (for service)" size="25"/>


            <%
                java.util.Date d = new java.util.Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DATE);
                String curDate = day + "/" + month + "/" + year;
            %>  

            <s:hidden name="distributor.regDate" label="Registration Date" value="<%=curDate%>"/> 

            <s:hidden name="distributor.verified" label="Verified" value="false"/> 
            <s:hidden name="distributor.agencyName" label="Agency Name" value="na" />
            <s:hidden name="distributor.userName" label="User Name" value="na"/>
            <s:hidden name="distributor.password" label="Password" value="na"/>
<%--
            <tr><td colspan="2"> <br>
            
             <%
                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lfzq84SAAAAAMV2etBy0FTKAWtiIzip3NgDGVK-", "6Lfzq84SAAAAAGddksYEC0cdWnCu18qNE50Mf-sw", false);
                out.print(c.createRecaptchaHtml(null, null));
            %>
</td></tr>--%>
            <tr><td>&nbsp; </td><td> </td></tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="submit" align="center"/> </td></tr>
                </table>

            </form>
        </div>
    </body>
</html>

