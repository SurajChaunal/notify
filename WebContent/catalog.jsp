<!DOCTYPE html>
<html>
<head>

<style>
body{
	background-color:mediumseagreen;

}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    
	$("#btn").click(function(){
		
		$("#btn").hide();
    	
		$.get("JsonProduct", function(data, status){
		//document.getElementById("test").innerHTML="hello";  
			
			//alert(data);
			var ret=JSON.parse(data);
//    		alert("Data: " + data + "\nStatus: " + status);
  //  		document.getElementById("test").innerHTML=ret.ProductDetails[0]["name"];
			
			for( i=0 ;i<ret.ProductDetails.length ;i++){
				var dv = document.createElement("div");// Create a <p> element
				var p1=document.createElement("p");
				var p2=document.createElement("p");
				var p3=document.createElement("p");
				var p4=document.createElement("p");
							
				var name = document.createTextNode(ret.ProductDetails[i].name);
				var desc= document.createTextNode(ret.ProductDetails[i].desc);
				var price =document.createTextNode(ret.ProductDetails[i].price);
				var btn = document.createElement("button");
				var txt=document.createTextNode("BID ON");
				var inc=document.createTextNode(ret.ProductDetails[i].incr);
				
				p1.appendChild(name);
				p2.appendChild(desc);
				p3.appendChild(price);
				p4.appendChild(inc);
				dv.style.border="dashed"
				
				var txt=document.createTextNode("BID ON");
				btn.appendChild(txt);
				dv.appendChild(p1); 
				dv.appendChild(p2);
				dv.appendChild(p3);
				dv.appendChild(p4);
				dv.appendChild(btn);// Append the text to <p>
				dv.style.border="solid";
				document.getElementById("place").appendChild(dv);
				document.getElementById("place").appendChild(document.createElement("br"));
				}
    
    	
    	});        
    });
});
</script>

</head>
<body>
<div id="place"></div>
<input type="button" id="btn" value="click here">
</body>
</html>
