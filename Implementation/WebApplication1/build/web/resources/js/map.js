/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

(function() {
window.onload = function() {
// Creating an object literal containing the properties
// we want to pass to the map
var options = {
zoom: 5,
center: new google.maps.LatLng(23, 82),
mapTypeId: google.maps.MapTypeId.ROADMAP,
disableDefaultUI: true,
disableDoubleClickZoom: true,
draggable: false,
scrollwheel: false
};
// Creating the map
var map = new google.maps.Map(document.getElementById('map'), options);
// Creating an array that will contain the coordinates
// for New York, San Francisco, and Seattle
var places = new Array(3);
places [0]=new Array(2);
places[0][0]=new google.maps.LatLng(18.9, 72.85);
places[0][1]='http://localhost:8080/egas/maps/MumbaiPage.action';
places [1]=new Array(2);
places[1][0]=new google.maps.LatLng(28.63531 ,	77.22496);
places[1][1]='http://localhost:8080/egas/maps/DelhiPage.action';
places [2]=new Array(2);
places[2][0]=new google.maps.LatLng(13.06042, 	80.24958);
places[2][1]='http://localhost:8080/egas/maps/ChennaiPage.action'
// Adding a LatLng object for each city
//places.push(new google.maps.LatLng(18.9, 72.85));
//places.push(new google.maps.LatLng(28.63531 ,	77.22496));
//places.push(new google.maps.LatLng(13.06042 ,	80.24958));

// Looping through the places array
for (var i = 0; i < places.length; i++) {
    
// Adding the marker as usual
var marker = new google.maps.Marker({
position: places[i][0],
map: map,
title: 'Click to see Distributors of the city.'
});
// Wrapping the event listener inside an anonymous function
// that we immediately invoke and passes the variable i to.
(function(i, marker) {
// Creating the event listener. It now has access to the values of
// i and marker as they were during its creation
google.maps.event.addListener(marker, 'click', function() {
 window.location = places[i][1];
});
})(i, marker);
}
}
})();
