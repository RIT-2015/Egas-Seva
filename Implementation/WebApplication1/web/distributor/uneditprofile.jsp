<%-- 
    Document   : uneditprofile
    Created on : Apr 20, 2012, 7:19:33 PM
    Author     : Acer
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2 align="center">Profile</h2>
    
        <fieldset>
            <legend>
                <b>Personal Details</b>
            </legend>
    <table>
    <tr>
        <td colspan="2"><b>Distributor ID:</b> &nbsp;&nbsp;<s:property  value="distributor.distID"/></td>
    </tr>
    <tr>
        <td><b>First Name:</b></td><td><s:property  value="distributor.fname"/></td>
    </tr>
    <tr>
        <td><b>Middle Name:</b></td><td><s:property value="distributor.mname"/></td>
    </tr>
    <tr>
        <td><b>Last Name:</b></td><td><s:property value="distributor.lname"/></td>
    </tr>
    <tr>
        <td><b>Date of Birth:</b></td><td><s:property value="distributor.dob"/></td>
    </tr>
    <tr>
        <td><b>Age:</b></td><td><s:property value="distributor.age"/></td>
    </tr>
    <tr>
        <td><b>Gender:</b></td><td><s:property value="distributor.gender"/></td>
    </tr>
    <tr>
        <td><b>Password:</b></td><td><s:property value="distributor.password"/></td>
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
        <td><b>Address:</b></td><td><s:property value="distributor.address"/></td>
    </tr>
    <tr>
        <td><b>Land Mark:</b></td><td><s:property value="distributor.landmark"/></td>
    </tr>
    <tr>
        <td><b>City:</b></td><td><s:property value="distributor.city"/></td>
    </tr>
   <tr>
        <td><b>State:</b></td><td><s:property value="distributor.state"/></td>
    </tr>
    <tr>
        <td><b>Pincode:</b></td><td><s:property value="distributor.pin"/></td>
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
        <td><b>Mobile No:</b></td><td><s:property value="distributor.mobile"/></td>
    </tr>
    <tr>
        <td><b>Landline No:</b></td><td><s:property value="distributor.landline"/></td>
    </tr>
    <tr>
        <td><b>Email:</b></td><td><s:property value="distributor.email"/></td>
    </tr>
</table>
    </fieldset>
    <br/>
    <a href="<s:url action="ViewProfile" namespace="/distributor"/>"><img src="../resources/images/update.jpg"/></a>
    
