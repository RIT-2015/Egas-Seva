<%-- 
    Document   : viewFeedback
    Created on : Feb 26, 2012, 4:51:31 AM
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
            
        <div align="center">
            <h2 style=" color:#8DB638;"> Feedback or Complaints </h2>
            <TABLE width="100%" cellpadding="5" BORDER=1 bordercolor="lightgreen">

                <tr style="background-color: #b0c8f5">
                    <th>F_ID</th>
                    <th>Type</th>
                    <th>Category</th>
                    <th>E-Mail</th>

                    <th>C_ID</th>
                    <th></th>
                    <th></th>

                </tr>

                <s:iterator value="fbColln">               
                    <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; "> 
                        <td><s:property value="fbID" /></td>
                        <td> <s:property value="type"/> </td>
                        <td> <s:property value="category"/> </td>
                        <td> <s:property value="email"/> </td>
                        <td> <s:property value="custID"/> </td>

                        <td>
                            <a href="<s:url action='feedbackDetails' namespace='/admin'>
                                   <s:param name='fb.fbID' value='fbID'/> </s:url>" >
                                   View Details
                               </a>           
                            </td>
                            <td>
                                <a href="<s:url action='feedbackDel' namespace='/admin'>
                                   <s:param name='fb.fbID' value='fbID'/> </s:url>" >
                                   Delete
                               </a>           
                            </td>
                        </tr>
                </s:iterator> 
            </TABLE>
        </div>
            
            
            
    </body>
</html>


