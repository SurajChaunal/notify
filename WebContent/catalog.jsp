<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    
	$("#btn").click(function(){
    
		$.get("JsonProduct", function(data, status){
			document.getElementById("test").innerHTML="hello";  
			//alert(data);
			var ret=JSON.parse(data);
    		alert("Data: " + data + "\nStatus: " + status);
    		document.getElementById("test").innerHTML=ret.ProductDetails[0]["name"];
    		
    	
    	});        
    });
});
</script>

</head>
<body>
<p id="test" ></p>
<input type="button" id="btn">
</body>
</html>
