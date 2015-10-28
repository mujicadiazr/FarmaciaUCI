document.onload
{
	var a=document.getElementByID("default");
	a.onModified=activarBuscar();
	function activarBuscar()
	{
			var bott=document.getElementByID("btnFind");
			bott.class="btn";
	}
} 
