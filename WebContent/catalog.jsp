<!DOCTYPE html>
<html>



<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="javascript/script1.js" ></script>
<script type="text/javascript" src="javascript/bidding.js" ></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
body{
background-color:#white;
font:  16px bold arial, sans-serif;

}
.modprice{


}

.modtime{
color:red;
font:20px;
}

div {
border-width:1px;
border-style:none none solid none;

}

#place{
border-style:none;

}

#bless{
border-style:none;


}
</style>
</head>

<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("index.jsp");
	
}
else{ 
	user = (String) session.getAttribute("user");
	out.print("you are successfully logged in");
}

%>

<div id="bless" class="row">
<div class="col-sm-12">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">YourAuctionSite.com</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home.jsp">Home</a></li>
      <li><a href="bootstrap_inp.jsp">Add Product</a></li>
      <li><a href="catalog.jsp">Browse</a></li>
      
    </ul>
  </div>
</nav>
</div>
</div>

<div id="place" class="container"></div>>





</body>
</html>
