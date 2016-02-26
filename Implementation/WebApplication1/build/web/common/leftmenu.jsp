<%-- 
    Document   : left
    Created on : Feb 24, 2012, 9:46:46 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<fieldset>
    <legend align="center">
        <b>Registration Box</b>
    </legend>
    <ul>
        <li>
            <a href="<s:url action="newConnectionForm" namespace="/general"/>">New LPG Connection</a>
        </li>
        <br/>
        <li>
            <a href="<s:url action="customerRegForm" namespace="/general"/>">Online Customer Registration</a>
        </li>
        <br/>
        <li>
            <a href="<s:url action="distributorApplnForm" namespace="/general"/>">Distributor Application</a>
        </li>
        <br/>
        
    </ul>
    </fieldset>