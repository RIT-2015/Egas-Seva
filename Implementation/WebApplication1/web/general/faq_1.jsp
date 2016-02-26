<%-- 
    Document   : faq
    Created on : Mar 27, 2012, 5:52:37 AM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>

        <div id="1" align="center">

            <h2><s:text name="FAQ's"/></h2> 

            <s:iterator value="faqColln">  

                <fieldset>
                    <legend><b> <font color="green" size="4">FAQ_ID : <s:property value="faqID" /></font></b></legend>

                    <TABLE cellpadding="7" BORDER=1 BORDERCOLOR="lightgreen" >

                         <tr style="background-color: #b0c8f5"><td><b>Question :</b> </td><td> <s:property value="question"/> </td> </tr>
                         <tr style=" background-image: url(../Resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; "><td><b>Answer :</b> </td><td> <s:property value="answer"/> </td> </tr>
                       
                        </table>
                    </fieldset>
            </s:iterator>
        </div>       

        
    </body>
</html>