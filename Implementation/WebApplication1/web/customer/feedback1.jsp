<%-- 
    Document   : feedback1
    Created on : 25 Apr, 2012, 2:38:32 AM
    Author     : shirish
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <s:url id="url1" action="feedbackForm" /><s:a href="%{url1}" > <img src="..\resources\images\feedback_icon.jpg" /> </s:a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <s:url id="url2" action="FeedbackAction!viewReply"  /><s:a href="%{url2}" > <img src="..\resources\images\your_feedback_150.jpg"/>   </s:a>
        </div>
    </body>
</html>
