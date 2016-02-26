<%-- 
    Document   : success
    Created on : Feb 19, 2012, 4:28:42 PM
    Author     : shashi
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript" src="../Resources/js/jquery-1.4.2.min.js"></script>
    </head>
    <s:head />   <%-- tag is used to include the required css and js file 
                      for the selected theme. By default the xhtml theme is used.--%>
    
    <body>
       
        <h1>success</h1>
        
        <div id="1">
            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<br><br>
            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<br>
           
            </br>
        </div>
        <div id="2">
            ssssssssssssssssssssssssssssssssssssssssssss<br>
            ssssssssssssssssssssssssssssssssssssssssss<br><br>
            
            </br>
        </div>
        
          <a href="#" id="first">first</a><br>
          <a href="#" id="second">second</a><br>
          <a href="#" id="both">both</a><br>
          
         
        <script>
            
            
$("#first").click(function() {
$("#2").show();
$("#1").hide();
1
});

$("#second").click(function() {
$("#1").show();
$("#2").hide();
1
});

$("#both").click(function() {
$("#1").show();
$("#2").show();
1
});
        </script>
        
      <%--  <h1><s:property value="cust.age" /></h1>  getCust().getAge(); --%>
    </body>
</html>