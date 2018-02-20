

function priceChange(){
	var id =this.id;
	
	$.post("AjaxPrice",{name: this.id},
		    function(data, status){ 
		       //alert(data);
		       
		       var ele=document.getElementsByClassName(id)[0];
	
		       ele.getElementsByClassName("modprice")[0].innerHTML="Price :"+data;
		    });
}

setInterval(function(){
	
	var classes=document.getElementsByClassName("modtime");
	
	for(i=0;i<classes.length;i++){
		
		var hr=parseInt(classes[i].textContent,10);
		hr=hr-1;
		
		
		classes[i].innerHTML=hr.toString();
	}
	
},60*1000);

