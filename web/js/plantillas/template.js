$(document).ready(function()
{
  
  $(' <div class="navbar navbar-inverse navbar-fixed-top"><div class="navbar-inner"><div class="container"><button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><div class="nav-collapse collapse"><ul class="nav"><li class="active"><a href="#">Principal</a></li><li class=""><a href="#">Acerca de...</a></li><li class=""><a href="#">Equipo de desarrollo</a></li></ul></div></div></div></div> ').insertBefore("body");
	
  $('<link href="../../css/bootstrap.css" rel="stylesheet">'+
    '<link href="../../css/bootstrap-responsive.css" rel="stylesheet">'+
    '<link href="../../css/docs.css" rel="stylesheet">'+
    '<link href="../../js/google-code-prettify/prettify.css" rel="stylesheet"> ').insertBefore('head');
	 

//<!-- Subhead
//================================================== -->
$ ('<header class="jumbotron subhead">'+
  '<div class="container">'+
    '<h1>Farmacia UCI</h1>'+
    '<p class="lead">Donde encuentra soluci&oacute;n a su vida.'+
  '</div>'+
'</header>').insertBefore("body");

    $('<footer class="footer">'+
      '<div class="container">'+
        '<p> Creado con todo el amor del mundo para la <a href="http://www.uci.cu"> UCI </a> </p>'+
        '<p>Por <a href="mailto:rmujica@estudiantes.uci.cu"> Randy</a>'+
        '<a href="mailto:rmujica@estudiantes.uci.cu"> Hector</a>'+
        '</p>'+
        '<ul class="footer-links">'+
          '<li><a href="http://intranet2.uci.cu">Intranet</a></li>'+
        '</ul>'+
      '</div>'+
    '</footer>').appendTo("body");
}
); 
