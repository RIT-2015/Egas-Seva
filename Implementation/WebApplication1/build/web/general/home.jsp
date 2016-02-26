<%-- 
    Document   : index1
    Created on : Jan 26, 2012, 7:08:08 PM
    Author     : shashi                         Alt + shift + F
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>

        <s:head/>

    </head>
    <body>

        <div id="right-panel">  

            <br></br>

            <div align="right">
                <script language="JavaScript" type="text/javascript">
                    <!--
                    var currentDate = new Date()
                    var day = currentDate.getDate()
                    var month = currentDate.getMonth() + 1
                    var year = currentDate.getFullYear()
  
                    var day_names = new Array(7)
                    day_names[0] = "Sunday"
                    day_names[1] = "Monday"
                    day_names[2] = "Tuesday"
                    day_names[3] = "Wednesday"
                    day_names[4] = "Thursday"
                    day_names[5] = "Friday"
                    day_names[6] = "Saturday"
  
                    var day_value = currentDate.getDay()
                    day_name = day_names[day_value]
  
                    document.write("<b>"+"  "+day_name+" "+ day + "/" + month + "/" + year + "</b>")
  
  
  
                    var currentTime = new Date()
                    var hours = currentTime.getHours()
                    var minutes = currentTime.getMinutes()

                    var suffix = "AM";
                    if (hours >= 12) {
                        suffix = "PM";
                        hours = hours - 12;
                    }
                    if (hours == 0) {
                        hours = 12;
                    }

                    if (minutes < 10)
                        minutes = "0" + minutes

                    document.write("<b>  " + hours + ":" + minutes + " " + suffix + "</b>")
    
                    //-->

                </script>                       


                <br>  IP Address = <%=request.getRemoteAddr()%> <br>

                <A HREF="javascript:window.print()">
                    <IMG SRC="../Resources/images/print_icon.gif" BORDER="0"</A></img>    

                <%--      <html:link action="/tictactoe">tictactoe</html:link>
                          <html:link action="/uploadFile">Struts File Upload</html:link>
                --%> 

            </div>

            <pre>


            </pre>
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" 
                    codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,16,0"
                    width="800" height="351" >
                <param name="movie" value="Resources/images/home/egas_home.swf">
                <param name="quality" value="high">
                <param name="play" value="true">
                <param name="LOOP" value="true">

                <embed src="../Resources/images/home/egas_home.swf" width="653" height="303" play="true" loop="true" 
                       quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" 
                       type="application/x-shockwave-flash">
                </embed>

            </object>

                
        </div>
                <pre>






                </pre>
         
                
              
                <div align="left">        
                
                
        <script src="https://www.google.com/jsapi" type="text/javascript"></script>

        <script language="Javascript" type="text/javascript">
    
            google.load('search', '1');

            function OnLoad() {
                // Create a search control
                var searchControl = new google.search.SearchControl();

                // Add in a full set of searchers
                var localSearch = new google.search.LocalSearch();
                searchControl.addSearcher(localSearch);
                searchControl.addSearcher(new google.search.WebSearch());
                searchControl.addSearcher(new google.search.VideoSearch());
                searchControl.addSearcher(new google.search.BlogSearch());
                searchControl.addSearcher(new google.search.NewsSearch());
                searchControl.addSearcher(new google.search.ImageSearch());
                searchControl.addSearcher(new google.search.BookSearch());
                searchControl.addSearcher(new google.search.PatentSearch());

                // Set the Local Search center point
                localSearch.setCenterPoint("India, in");

                // tell the searcher to draw itself and tell it where to attach
                searchControl.draw(document.getElementById("searchcontrol"));

                // execute an inital search
                searchControl.execute("");
            }
            google.setOnLoadCallback(OnLoad);
    
        </script>
        <pre>





        </pre>
        <div id="searchcontrol"> Loading </div>
                </div>
         
    </body>
</html>