<%-- 
    Document   : delhi
    Created on : Mar 16, 2012, 12:59:27 AM
    Author     : Acer
--%>
        <%@page import="java.sql.*"%>
        <% try {%> 
        <style type="text/css"> 
#map {
    ALIGN:center;
width: 55%;
height: 1200px;
border: 1px solid #000;
}
        </style>
         <%
            try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con= DriverManager.getConnection("jdbc:db2://localhost:50000/EGASSEWA","db2admin","a");
			Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("select count(*) from crce.distributor d, crce.geolocation g where lower(d.city) like 'delhi' and d.d_id=g.d_id"); 
                            rs.next();
                            int len=Integer.parseInt(rs.getString(1));
                         
%>
<script type="text/javascript"
src="http://maps.google.com/maps/api/js?sensor=false"></script>

        <script type="text/javascript">
            /* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {
window.onload = function() {
// Creating an object literal containing the properties
// we want to pass to the map
var options = {
zoom: 12,
center: new google.maps.LatLng(28.63531 ,	77.22496),
mapTypeId: google.maps.MapTypeId.ROADMAP,
disableDefaultUI: false,
disableDoubleClickZoom: true,
draggable: false,
scrollwheel: false
};
// Creating the map
var map = new google.maps.Map(document.getElementById('map'), options);
// Creating an array that will contain the coordinates
// for New York, San Francisco, and Seattle
var places = new Array (<%= len%>);
<%
rs=stmt.executeQuery("select * from crce.distributor d, crce.geolocation g where lower(d.city) like 'delhi' and d.d_id=g.d_id");
int i=0; 
while(rs.next()){
%>
places[<%=i%>]=new Array (2);
places[<%=i%>][0]=new google.maps.LatLng(<%=rs.getString("lattitude")%>,<%=rs.getString("longitude")%>);
places[<%=i%>][1]='<%=rs.getString("address").toUpperCase()+" "+rs.getString("landmark").toUpperCase()+" "+rs.getString("city").toUpperCase()+" "+rs.getString("state").toUpperCase()+" "+rs.getString("pin_code")%>';
<%
i++;
}
            }
            catch (Exception e){
    System.out.println ("JSP Error \n"+e);
    }
%>
// Adding a LatLng object for each city

// Looping through the places array
for (var i = 0; i < places.length; i++) {
// Adding the marker as usual
var marker = new google.maps.Marker({
position: places[i][0],
map: map,
title: 'Click to see Distributors'
});
// Wrapping the event listener inside an anonymous function
// that we immediately invoke and passes the variable i to.
(function(i, marker) {
// Creating the event listener. It now has access to the values of
// i and marker as they were during its creation
google.maps.event.addListener(marker, 'click', function() {
var infowindow = new google.maps.InfoWindow({
content: places[i][1]
});
infowindow.open(map, marker);
});
})(i, marker);
}
}
})();

        </script>

        <h2 align="center">List of Distributors in Delhi</h2>
        
        <h4 align="center">Please click on the location to view Distributor Details</h4>
        <div id="map" style="width: 80%; margin-left: 110px"></div>

<% } 
        catch(Exception e){
            System.out.println ("JSP ERROR 2"+e);
        }
        %>