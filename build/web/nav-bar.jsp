<%-- 
    Document   : nav-bar
    Created on : Jun 20, 2013, 2:30:17 AM
    Author     : randy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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