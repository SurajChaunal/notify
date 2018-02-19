

function priceChange(){
	var id =this.id;
	
	$.post("AjaxPrice",{name: this.id},
		    function(data, status){ 
		       //alert(data);
		       
		       var ele=document.getElementsByClassName(id)[0];
	
		       ele.getElementsByClassName("modprice")[0].innerHTML=data;
		    });
}