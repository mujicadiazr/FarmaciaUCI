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
              <li >
                  <a href="index.jsp" onmouseover="this.style.backgroundColor='black';" onmouseout="this.style.backgroundColor='';">Principal</a>
              </li>
              <li class="active">
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

        <div>
        <jsp:include page="views/parts/equipoDes.jsp"></jsp:include>
            
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
