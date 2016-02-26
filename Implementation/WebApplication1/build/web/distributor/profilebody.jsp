<%-- 
    Document   : profilebody
    Created on : Feb 26, 2012, 5:24:58 PM
    Author     : Somesh Mishra
--%>
<%@taglib prefix="s" uri="/struts-tags" %>

    <h2 align="center">Profile</h2>
    <form name="profile" action="<s:url action="UpdateProfile" namespace="/distributor"/>" method="post" id="formID">  
        <fieldset>
            <legend>
                <b>Personal Details</b>
            </legend>
    <table>
    <tr>
        <td colspan="2"><b>Distributor ID:</b> &nbsp;&nbsp;<s:textfield disabled="true" name="distributor.distID"/></td>
    </tr>
    <tr>
        <td><b>First Name:</b></td><td><s:textfield  disabled="true" name="distributor.fname"/></td>
    </tr>
    <tr>
        <td><b>Middle Name:</b></td><td><s:textfield  disabled="true" name="distributor.mname"/></td>
    </tr>
    <tr>
        <td><b>Last Name:</b></td><td><s:textfield  disabled="true" name="distributor.lname"/></td>
    </tr>
    <tr>
        <td><b>Date of Birth:</b></td><td><s:textfield  disabled="true" name="distributor.dob"/></td>
    </tr>
    <tr>
        <td><b>Age:</b></td><td><s:textfield  disabled="true" name="distributor.age"/></td>
    </tr>
    <tr>
        <td><b>Gender:</b></td><td><s:textfield  disabled="true" name="distributor.gender"/></td>
    </tr>
    <tr>
        <td><b>Password:</b></td><td><s:textfield id="password" name="distributor.password" cssClass="validate[required] text-input"/></td>
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
        <td><b>Address:</b></td><td><s:textfield  disabled="true" name="distributor.address"/></td>
    </tr>
    <tr>
        <td><b>Land Mark:</b></td><td><s:textfield  disabled="true" name="distributor.landmark"/></td>
    </tr>
    <tr>
        <td><b>City:</b></td><td><s:textfield  disabled="true" name="distributor.city"/></td>
    </tr>
   <tr>
        <td><b>State:</b></td><td><s:textfield  disabled="true" name="distributor.state"/></td>
    </tr>
    <tr>
        <td><b>Pincode:</b></td><td><s:textfield  disabled="true" name="distributor.pin"/></td>
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
        <td><b>Mobile No:</b></td><td><s:textfield   name="distributor.mobile" cssClass="validate[required] text-input" cssClass="validate[custom[phone]] text-input"/></td>
    </tr>
    <tr>
        <td><b>Landline No:</b></td><td><s:textfield name="distributor.landline" cssClass="validate[custom[phone]] text-input"/></td>
    </tr>
    <tr>
        <td><b>Email:</b></td><td><s:textfield size="50px" name="distributor.email" cssClass="validate[required] text-input"  cssClass="validate[required,custom[email]] text-input"/></td>
    </tr>
</table>
    </fieldset>
    <br/>
    <input style="margin-left: 75%" type="submit" value="Update"/>
    </form> 
