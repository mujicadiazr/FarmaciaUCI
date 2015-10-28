//@import "../jquery.js";

$(document).ready(function()
{
	$ (' <div class="navbar navbar-inverse navbar-fixed-top"><div class="navbar-inner"><div class="container"><button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a class="brand" href="#">Farmacia UCI</a><div class="nav-collapse collapse"><ul class="nav"><li class="active"><a href="#">Principal</a></li><li class=""><a href="#">Acerca de...</a></li><li class=""><a href="#">Equipo de desarrollo</a></li><li class=""><a href="#">Autenticar</a></li></ul></div></div></div></div> ').appendTo("body");
	$('<link href="../css/docs.css" rel="stylesheet"><link href="../css/bootstrap.css" rel="stylesheet"><link href="../css/bootstrap-responsive.css" rel="stylesheet"><link href="../js/google-code-prettify/prettify.css" rel="stylesheet"> ').appendTo('head');
}
);
