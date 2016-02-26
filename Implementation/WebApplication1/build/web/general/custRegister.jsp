<%-- 
    Document   : custReg
    Created on : Feb 19, 2012, 1:32:53 AM
    Author     : shashi
--%>

<%@page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<%@page import="java.util.*;" %>
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
            
            <h2 style=" color:#8DB638;">Customer Online Registration</h2><br>
       
         <form action="<s:url action="customerReg" namespace="/general"/>" method="post" id="formID">    
 
         <table align="center" width="44%">               
            
    <%--   <s:textfield name="cust.d_id" label="Distributor" />    --%>
            
            <s:textfield name="cust.c_id" label="Consumer No" size="25" cssClass="validate[required] text-input"/>  
            <s:textfield name="cust.email" label="E-Mail" size="25" cssClass="validate[required] text-input" cssClass="validate[required,custom[email]] text-input"/>
            <s:textfield name="cust.username" label="Username" size="25" cssClass="validate[required] text-input"/>
            <s:password name="cust.password" label="Password" id="password" size="25" cssClass="validate[required] text-input"/>
            <s:password name="password2" label="Re-Enter Password" size="25" cssClass="validate[required] text-input" cssClass="validate[required,equals[password]] text-input"/>
            <s:textfield name="cust.mobile" label="Mobile No" size="25" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/> 
            
            <s:textfield name="cust.city" label="City" size="25" cssClass="validate[required] text-input"/>
            <s:select name="cust.state" label="State" list="{'----- select state -----','Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Delhi','Goa','Gujrat','Haryana','Himachal Pradesh','Jammu and Kashmir','Jharkhand','Karnatka','Kerla','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Orissa','Punjab','Rajasthan','Sikkim','Tamil Nadu','Tripura','UNION TERRITORY','Uttar Pradesh','Uttranchal','West Bengal'}" />
            
            
            <%
                java.util.Date d=new java.util.Date();
                Calendar cal=Calendar.getInstance();
                cal.setTime(d);
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DATE);
                String curDate=day+"/"+month+"/"+year;
            %>
         
            <s:radio name="customer.mVerify" label="SMS Alerts" list="{'Yes','No'}" cssClass="validate[required] text-input"/>
            <s:textfield name="cust.regDate" label="Reg Date" value="<%=curDate%>" readonly="true" size="25"/>
            
            <s:label value="Terms & Conditions"/>
             
            <s:checkbox name="t_and_c" label="Accepted" />
            <tr><td colspan="2"><br></br> 
   <%--         
             <%
                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lfzq84SAAAAAMV2etBy0FTKAWtiIzip3NgDGVK-", "6Lfzq84SAAAAAGddksYEC0cdWnCu18qNE50Mf-sw", false);
                out.print(c.createRecaptchaHtml(null, null));
            %>
</td></tr>
    --%>         
             <tr><td>&nbsp; </td><td>&nbsp; </td></tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="submit" align="center"/> </td></tr>
                </table>

            </form>
            
            
            
            
            
        </div>    
            
    </body>
</html>