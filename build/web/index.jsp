<%-- 
    Document   : index
    Created on : May 14, 2013, 11:50:53 PM
    Author     : randy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <link href="css/docs.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="ico/icon.jpeg" rel="shortcut icon" >
  </head>

<body>



    <!-- NAVBAR
    ================================================== -->
<!-- Navbar
    ================================================== -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">
              <form class="form-inline" action="LoginServlet" method="post">
                <div class="input-prepend">
                   <span class="add-on"><i class="icon-user"></i></span>
                   <input id="user" name="user"class="span2 btn-small" id="prependedInput" type="text" placeholder="Usuario" required>
                </div>

                <div class="input-prepend">
                  <span class="add-on"><i class="icon-lock"></i></span>
                  <input id="pass" name="pass" class="span2 btn-small" id="prependedInput" type="password" placeholder="Contrase&ntilde;a" required>
                </div>
<!--                <label class="checkbox">
                   <input type="checkbox" value="remember-me" > Recordar datos de usuario
                </label>-->
                <button class="btn btn-primary" type="submit">Acceder</button>
              </form>
         </a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active">
                  <a href="index.jsp" onmouseover="this.style.backgroundColor='black';" onmouseout="this.style.backgroundColor='';">Principal</a>
              </li>
              <li class="">
                  <a href="equipoDeDesarrollo.jsp" onmouseover="this.style.backgroundColor='black';" onmouseout="this.style.backgroundColor='';">Equipo de desarrollo</a>
              </li>              
            </ul>
          </div>
        </div>
      </div>
    </div>

        
        <!-- Subhead
    ================================================== -->
        <jsp:include page="/views/parts/banner.jsp"></jsp:include>

    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="img/s1.jpg" alt=""/>
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>Example headline.</h1> -->
              <p class="lead">La mejor promoción del mundo de los fármacos la encontrará aquí.</p>
              <!-- <a class="btn btn-large btn-primary" href="#">Sign up today</a> -->
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/s2.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>Another example headline.</h1> -->
              <p class="lead">Date una vuelta por aquí y no te arrepentirás.</p>
              <!-- <a class="btn btn-large btn-primary" href="#">Learn more</a> -->
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/s3.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>One more for good measure.</h1> -->
              <p class="lead">Con solo un clic puedes estar al tanto de los medicamentos que ofertamos.</p>
             <!--  <a class="btn btn-large btn-primary" href="#">Browse gallery</a> -->
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/s4.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>One more for good measure.</h1> -->
              <p class="lead">La mejor opción para que compres ese medicamento que necesitas.</p>
              <!-- <a class="btn btn-large btn-primary" href="#">Browse gallery</a> -->
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/s5.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>One more for good measure.</h1> -->
              <p class="lead">Todos tus problemas tienen solución aquí.</p>
              <!-- <a class="btn btn-large btn-primary" href="#">Browse gallery</a> -->
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->



    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">
        <ul class="thumbnails">
          <li class="span4">
            <a href="http://www.sld.cu" class="thumbnail">
              <img src="img/infomed.jpeg" data-src="holder.js/100x100" alt="">
            </a>
          </li>
          <li class="span4">
            <a href="http://farmaciacuba.com" class="thumbnail">
              <img src="img/far-cuba.jpeg" data-src="holder.js/100x100" alt="">
            </a>
          </li>
          <li class="span4">
            <a href="http://www.labiofam.cu" class="thumbnail">
              <img src="img/lab.jpeg" data-src="img/lab.jpeg/100x100" alt="">
            </a>
          </li>
          
        </ul>
        
        
<!--        
        <div class="row-fluid">
        <div class="span4">
            <img src="img/infomed.jpeg" class="img-rounded">
          <h2>Infomed</h2>
          <p><a class="btn" href="http://www.sld.cu">Ver detalles &raquo;</a></p>
        </div>
        <div class="span4">
            <img src="img/far-cuba.jpeg" class="img-rounded">
          <h2>Farmacia Cuba</h2>
          <p><a class="btn" href="http://farmaciacuba.com">Ver detalles &raquo;</a></p>
        </div>
        <div class="span4">
            <img src="img/lab.jpeg" class="img-rounded">
          <h2>LABIOFAM</h2>
          <p><a class="btn" href="http://www.labiofam.cu">Ver detalles &raquo;</a></p>
        </div>
      </div>-->
    </div>
      <!-- FOOTER -->
    <footer class="footer">
    <div class="container">
        <p>&copy; 2012 - 2013 UCI, Cuba. &middot;</p>
        <ul class="footer-links">
          <li><a href="http://intranet2.uci.cu">Intranet</a></br></li>
          <li><a href="http://www.uci.cu">UCI</a></br></li>
        </ul>
      </div>
    </footer>

    </div><!-- /.container -->



    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>
    <script src="js/bootstrap-affix.js"></script>
    <script src="js/holder/holder.js"></script>
    <script src="js/google-code-prettify/prettify.js"></script>
    <script src="js/application.js"></script>
  </body>
</html>
