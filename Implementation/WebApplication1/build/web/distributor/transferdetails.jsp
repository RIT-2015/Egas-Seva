<%-- 
    Document   : transferdetails
    Created on : Apr 2, 2012, 10:18:11 AM
    Author     : Acer
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<h2 align="center">Transfer Requests Details</h2>
<a href="<s:url action="NewTransferReq" namespace="/distributor"/>" style="margin-left: 80%"><img src="../resources/images/back.jpg"/></a>
<fieldset>
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
    <fieldset>
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
    <fieldset>
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
              <h2 align="center">Enter the details of the proof supplied by the Customer</h2>

<h4 align="center">Customer's CID : <s:property value="c_id"/></h4>
<s:form action="UpdateCusProof" namespace="/distributor">
    <s:hidden name="c_id"/>
    <table align="center">
        <tr>
            <td><b>Proof Details 1:</b></td>
            <td><s:textarea name="proof.proofdetails1" cols="60"/></td>
        </tr>
        <tr>
            <td><b>Proof Details 2:</b></td>
            <td><s:textarea name="proof.proofdetails2" cols="60"/></td>
        </tr>
        <tr>
            <td><b>Proof Details 3:</b></td>
            <td><s:textarea name="proof.proofdetails3" cols="60"/></td>
        </tr>
        <tr>
            <td colspan="2"><s:submit value="Submit"/></td>
        </tr>
    </table>
    
</s:form>  
            </div>

<div id="2">
    <h2 align="center">Enter Reason of disapproving</h2>
    <s:form action="TransferDisapprove" namespace="/distributor">
        <s:hidden name="c_id"/>
    <table align="center">
        <tr>
            <td colspan="2"><b>Reason for Application Rejection:</b></td>
        </tr>
        <tr>
            <td><s:textarea cols="50" name="rej_reason"/></td>
        </tr>
        <tr>
            <td colspan="2"><s:submit value="Submit"/></td>
        </tr>
    </table>
    </s:form>
</div>