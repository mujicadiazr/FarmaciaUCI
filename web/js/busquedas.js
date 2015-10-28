
function accionClose(element)
{
	//$(this).closest('div').remove();
	$('ul.dropdown-menu#uno li').each(function()
	{
		if ($(element.parentNode).find('input').attr('placeholder')===$(this).find('a').text()) 
			{
				$(this).find('i').attr('class','icon-pencil');
			};
	});
	$(element.parentNode).remove();
}


function accionNav(element)
	{
		//alert($(element).find('i').attr('class'));
		//alert('Tocado ' + $(element).find('a').text()+' ICONO ' + $(element).find('i').attr('class'));
		if($(element).find('i').attr('class')==='icon-ban-circle')
			{
				$(element).find('i').attr('class','icon-pencil');
				var nomb=$(element).find('a').text();
				$("div.input-append")
					.each(function()
					{
						if($(this).find('input').attr('placeholder')===nomb)
								$(this).remove();
					});
			}
			
		else if($(element).find('i').attr('class')==='icon-pencil')
			{
				$(element).find('i').attr('class','icon-ban-circle');
				$('<div class="input-append" id="divapp"> <input type="text" class="span2 search-query" id="default" '+
					' ></input><span class="add-on btn btn-close"><a class="icon-remove"></a></span></div>')
				.find('input').attr('placeholder',$(element).find('a').text())
				.end().find('span').attr('onClick','accionClose(this)').end()
				.insertBefore($('form').find('button'));
			}
	};

/*jQuery.fn.closest = function( selector ){
return this.map(function(){
var $parent = jQuery(this).parents();
return jQuery(this).add($parents).filter( selector )[0];
});
}*/



$(function(){

	$('ul.dropdown-menu#uno').find('li').attr('onClick','accionNav(this)');
	$('div#divapp').find('span').attr('onClick','accionClose(this)');

});