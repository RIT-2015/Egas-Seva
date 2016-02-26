<%-- 
    Document   : cusdetailsbody
    Created on : Mar 1, 2012, 4:09:09 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2 align="center">Customer Details</h2>
<a href="<s:url action="ViewCustomer" namespace="/distributor"/>" style="margin-left: 80%"><img src="../resources/images/back.jpg"/></a>
<fieldset style="background-color: #FFFFCC">
    <legend>
        <b>Personal Details</b>
    </legend>
<table>
    <tr>
        <td><b>Customer ID:</b> &nbsp;&nbsp;<s:property value="customer.c_id"/></td>
    </tr>
    <tr>
        <td><b>Customer Name:</b> &nbsp;&nbsp;<s:property value="customer.fname"/>&nbsp;<s:property value="customer.mname"/>&nbsp;<s:property value="customer.lname"/></td>
    </tr>
    <tr>
        <td><b>Date of Birth:</b> &nbsp;&nbsp;<s:property value="customer.dob"/></td>
    </tr>
    <tr>
        <td><b>Age:</b> &nbsp;&nbsp;<s:property value="customer.age"/></td>
    </tr>
    <tr>
                <td><b>Customer Type:</b> &nbsp;&nbsp;<s:property value="customer.cus_type"/></td>
    </tr>
</table>
</fieldset>
    <br/>
    <fieldset style="background-color: #FFFFCC">
        <legend>
        <b>Location Details</b>
    </legend>
    <table>
    <tr>
        <td><b>Address:</b> &nbsp;&nbsp;<s:property value="customer.address"/></td>
    </tr>
    <tr>
        <td><b>LandMark:</b> &nbsp;&nbsp;<s:property value="customer.landmark"/></td>
    </tr>
    <tr>
        <td><b>City:</b> &nbsp;&nbsp;<s:property value="customer.city"/></td>
    </tr>
</table>
    </fieldset>
    <br/>
    <fieldset style="background-color: #FFFFCC">
        <legend>
            <b>Contact Details</b>
        </legend>
        <table>
            <tr>
                <td><b>Contact No1:</b> &nbsp;&nbsp;<s:property value="customer.contactno1"/></td>
            </tr>
            <tr>
                <td><b>Contact No2:</b> &nbsp;&nbsp;<s:property value="customer.contactno2"/></td>
            </tr>
            <tr>
                <td><b>Mobile:</b> &nbsp;&nbsp;<s:property value="customer.mobile"/></td>
            </tr>
            <tr>
                <td><b>Email Address:</b> &nbsp;&nbsp;<s:property value="customer.email"/></td>
            </tr>
        </table>
    </fieldset>
            <br/>
            <fieldset style="background-color: #FFFFCC">
                <legend>
                    <b>LPG GAS Consumption Details</b>
                </legend>
                <table>
                    <tr>
                <td><b>Total no of Cylinders:</b> &nbsp;&nbsp;<s:property value="customer.no_of_cylinder"/></td>
            </tr>
                </table>
            </fieldset>
            
            <fieldset style="background-color: #FFFFCC">
                <legend>
                    <b>Proof details</b>
                </legend>
                <table>
                    <tr>
                        <td><b>Proof Details 1:</b> &nbsp;&nbsp;<s:property value="proof.proofdetails1"/></td>
                    </tr>
                    <tr>
                        <td><b>Proof Details 2:</b> &nbsp;&nbsp;<s:property value="proof.proofdetails2"/></td>
                    </tr>
                    <tr>
                        <td><b>Proof Details 3:</b> &nbsp;&nbsp;<s:property value="proof.proofdetails3"/></td>
                    </tr>
                </table>
            </fieldset>