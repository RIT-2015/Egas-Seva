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


                    

                    <TABLE cellpadding="7" width="85%">

                         <tr style="background-color: #b0c8f5"><td><b>Question :</b> </td><td> <s:property value="question"/> </td> </tr>
                         <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; "><td><b>Answer :</b> </td><td> <s:property value="answer"/> </td> </tr>
                       
                        </table>

            </s:iterator>
        </div>       

        
    </body>
</html>