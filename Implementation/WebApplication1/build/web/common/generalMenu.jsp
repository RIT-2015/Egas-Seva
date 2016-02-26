<%-- 
    Document   : generalMenu
    Created on : Mar 17, 2012, 6:03:18 PM
    Author     : shashi
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
      <div id="panel-left">
                  
          
         <s:form action="Login" >
            <s:textfield name="user.username" label="Username" />
            <s:textfield name="user.password" label="Password" />

            <s:submit />
            <s:reset/>            
        </s:form>

          <pre>





          </pre>
          

        <s:form action="newConnectionForm" namespace="/general">
            <s:submit value="New Connection"/>
        </s:form>

        <s:form action="customerRegForm" namespace="/general">
            <s:submit value="Register"/>
        </s:form>

        <s:form action="distributorApplnForm" namespace="/general">
            <s:submit value="Distributor Application"/>
        </s:form>



        <s:form action="feedbackForm" namespace="/general">      
            <s:submit value="Feedback"/>              
        </s:form>             
            
            
      </div>
        
    </body>
</html>
