<%-- 
    Document   : payment
    Created on : Apr 26, 2012, 5:32:30 PM
    Author     : Somesh Mishra
--%>

<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="net.authorize.sim.*" %>
<%
        
        String apiLoginId = "3Tb4Euh3J";
        String transactionKey = "64864EEw8A9M2bbB";
        String amount = "1.99";
        Fingerprint fingerprint = Fingerprint.createFingerprint(
            apiLoginId,
            transactionKey,
            1234567890, // random sequence used for creating the finger print

            amount);
        long x_fp_sequence = fingerprint.getSequence();
        long x_fp_timestamp = fingerprint.getTimeStamp();
        String x_fp_hash = fingerprint.getFingerprintHash();
%>
<h3 align="center" style="color: #8DB638">Please confirm the amount to be transacted.</h3>
<div align="center">
  <FORM NAME='formName' ID='formID' ACTION='https://test.authorize.net/gateway/transact.dll'
    METHOD='POST'>
    <INPUT TYPE='HIDDEN' NAME='x_login' VALUE='<%=apiLoginId%>'>
    <INPUT TYPE='HIDDEN' NAME='x_fp_sequence' VALUE='<%=x_fp_sequence%>'>
    <INPUT TYPE='HIDDEN' NAME='x_fp_timestamp' VALUE='<%=x_fp_timestamp%>'>
    <INPUT TYPE='HIDDEN' NAME='x_fp_hash' VALUE='<%=x_fp_hash%>'>
    <INPUT TYPE='HIDDEN' NAME='x_invoice_num' VALUE='<%=(int)(Math.random()*10000)%>'>
    <INPUT TYPE='HIDDEN' NAME='x_description' VALUE='Products from e gas'>
    <INPUT TYPE='HIDDEN' NAME='x_version' VALUE='3.1'>
    <INPUT TYPE='HIDDEN' NAME='x_method' VALUE='CC'>
    <INPUT TYPE='HIDDEN' NAME='x_type' VALUE='AUTH_CAPTURE'>
    <INPUT TYPE='TEXT' NAME='x_amount' VALUE='<%=amount%>'>
    <INPUT TYPE='HIDDEN' NAME='x_show_form' VALUE='payment_form'>
    <INPUT TYPE='HIDDEN' NAME='x_test_request' VALUE='FALSE'>
    <INPUT TYPE='SUBMIT' NAME='submit_button' VALUE='Confirm' CLASS='null'>
  </FORM>
</div>