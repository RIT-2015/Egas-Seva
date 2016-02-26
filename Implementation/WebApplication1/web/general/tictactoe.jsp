<%-- 
    Document   : tictactoe
    Created on : Feb 8, 2012, 9:15:12 PM
    Author     : shashi
--%>


   <script src="../Resources/js/tictactoe.js"></script>


<style>

table.board {

  border: 1px solid green;
  height: 310px;
  width: 450px;
} 

body {

  text-align: center;
  align: center;
}

td {

  height: 100px;
  width: 100px;
  text-align: center;
  vertical-align: middle;
  font-size: 59px;
  font-weight: bold;
  font-color: green;
  font-family: geniva, verdana, helvetica;
  border: 1px solid green;
}

#menu {

  text-align: center;
  position: absolute;
  width: 150;
  height: 150;
  margin-left: 40px;
  margin-top: 100px;
  border: 5px double red;
  display: none;
  vertical-align: middle;
  background-color: #B7DF63;
}

 
#play_again {

  font-size: 25px;
  color: #F00;
}

</style>

 

<table border="0px" align="center">

<tr><td>

<div id="menu"></div>

<div id="board"></div>

</td></tr>

</table>

 



