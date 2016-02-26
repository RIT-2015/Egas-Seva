<%-- 
    Document   : viewProduct
    Created on : Feb 25, 2012, 4:19:08 PM
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
            
       <h2 align="center" style=" color:#8DB638;">Products</h2>     
            
        <div style="margin-left:81% ">
            <table width="100%">
                <tr>
                    <td colspan="2"> <input type="submit" value="Cancel" id="cancel"/> </td>
                </tr>   
                <tr>    
                    <td colspan="2"> <input type="submit" value="Add Product" id="add"/> </td>
                </tr>
            </table>
            <script>
                window.onload=(function (){
                    $("#1").show();
                    $("#2").hide();
                    $("#cancel").hide();
                })
                $("#add").click(function() {
                    $("#2").show();
                    $("#cancel").show();
                    $("#1").hide();                    
                    $("#add").hide();                    
                });

                $("#cancel").click(function() {
                    $("#1").show();
                    $("#add").show();
                    $("#2").hide();
                    $("#cancel").hide();
                });
            </script>
        </div>
            
        
       

        
        <div id="1" align="center">            

             
             
            <table width="100%" cellpadding="7" cellspacing="2" bordercolor="lightgreen" border="1" >
                
                <tr style="background-color: #b0c8f5">
                    <th>P_ID</th>
                    <th>Name</th>
                    <th>Details</th>
                    <th>Price</th>
                    <th>Sold Pieces</th>
                    <th></th>

                </tr>


                <s:iterator value="prodColln"> 

                    <tr style=" background-image: url(../resources/images/home/egasFooter1.jpg); background-repeat: no-repeat; ">
                        <td><s:property value="prodID" /> </td>
                        <td> <s:property value="name"/> </td>
                        <td> <s:property value="details"/> </td>
                        <td> <s:property value="price"/> </td>
                        <td> <s:property value="soldPieces"/> </td>              
                        <td>  
                            <a href="<s:url action='productDel' namespace='/admin'> 
                                   <s:param name='product.prodID' value='prodID'/> </s:url>">                           
                                   Delete
                               </a>                 
                            </td>       
                        </tr>
                </s:iterator>       

            </TABLE><br></br>

        </div>   

       



            <div id="2" align="center">

             <h2 align="center" style=" color:#8DB638;">Add New Product</h2><br>            
            
            <s:form action="productAdd" namespace="/admin" id="formID">  
                        
                <s:textfield name="product.name" label="Name" cssClass="validate[required] text-input"/>
                <s:textfield name="product.details" label="Details" cssClass="validate[required] text-input"/>
                <s:textfield name="product.price" label="price" cssClass="validate[required,custom[integer],min[0]] text-input"/>               
                <s:hidden name="product.soldPieces" value=""/> 

                <table>
                <tr><td>&nbsp; </td><td> </td></tr>
                <tr><td colspan="2"><s:submit align="center"/> </td></tr>
            </table>
            </s:form>

        </div>  

            
            
            
            
      
       
    </body>
</html>



        
        
      