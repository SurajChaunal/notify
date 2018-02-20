
window.onload=function(){	


	$.get("JsonProduct", function(data, status){
	;  
		
				var ret=JSON.parse(data);
    //		alert("Data: " + data + "\nStatus: " + status);
  
		
		for( i=0 ;i<ret.ProductDetails.length ;i++){
			var dv = document.createElement("div");// Create a <p> element
			var p1=document.createElement("p");
			var p2=document.createElement("p");
			var p3=document.createElement("p");
			var p4=document.createElement("p");
			var p5=document.createElement("p");
			var p6=document.createElement("p");
			
			var pid=ret.ProductDetails[i].imgid;
			var name = document.createTextNode("Product Name :"+ret.ProductDetails[i].name);
			var desc= document.createTextNode("Description :"+ret.ProductDetails[i].desc);
			var price =document.createTextNode("Price :"+ret.ProductDetails[i].price);
			var btn = document.createElement("button");
			var txt=document.createTextNode("BID ON");
			var inc=document.createTextNode("Increment Per Bid :"+ret.ProductDetails[i].incr);
			var hr=document.createTextNode(ret.ProductDetails[i].hour);
			
			
			dv.setAttribute("class",pid);
			p1.appendChild(name);
			p2.appendChild(desc);
			p3.appendChild(price);
			p4.appendChild(inc);
			p5.appendChild(hr);
			p6.appendChild(document.createTextNode("Minutes Left"));
			
			
			dv.style.border="dashed";
			p3.setAttribute("class","modprice");
			p5.setAttribute("class","modtime");
			var txt=document.createTextNode("BID ON");
			btn.setAttribute("id",pid);
			btn.appendChild(txt);
			btn.addEventListener("click",priceChange);
			//btn.addEventListener("click",priceChange);
			dv.appendChild(p1); 
			dv.appendChild(p2);
			dv.appendChild(p3);
			dv.appendChild(p4);
			dv.appendChild(p6);
			dv.appendChild(p5);
			dv.appendChild(btn);// Append the text to <p>
			dv.style.border="solid";
			
			document.getElementById("place").appendChild(dv);
			
			document.getElementById("place").appendChild(document.createElement("br"));
			
		}

	
        
	});
};