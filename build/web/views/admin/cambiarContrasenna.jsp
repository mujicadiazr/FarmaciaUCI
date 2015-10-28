<%-- 
    Document   : cambiarContrasenna
    Created on : Jun 17, 2013, 11:28:03 PM
    Author     : randy
--%>
<%@page import="uci.cu.util.DISPATCHER"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
   </head>
<% DISPATCHER.redirect("../../index.jsp", response, request); %>
  <body data-spy="scroll" data-target=".bs-docs-sidebar">
        <jsp:include page="/views/parts/navbar.jsp"></jsp:include>
        <jsp:include page="/views/parts/banner.jsp"></jsp:include>    
      <div class="container">
            <div class="row">
            <jsp:include page="../parts/menuAdmin.jsp"></jsp:include>
               <div class="span9">
                    <section>
                        <!--Aki va el formulario-->
                        <form class="form-login central" action="../../CambioClaveServlet" method="post">
                            <h2 class="form-login-heading">Cambiar contrase&ntilde;a</h2>

                            <div class="input-prepend">
                              <span class="add-on"><i class="icon-user"></i></span>
                              <input id="usuario" name="usuario" class="span3" id="prependedInput" type="text" placeholder="Contrase&ntilde;a actual" required disabled="true">
                            </div> 
                            
                            <div class="input-prepend">
                              <span class="add-on"><i class="icon-ban-circle"></i></span>
                              <input id="passOld" name="passOld" class="span3" id="prependedInput" type="password" placeholder="Contrase&ntilde;a actual" required>
                            </div>        

                            <div class="input-prepend">
                                            <span class="add-on"><i class="icon-lock"></i></span>
                                            <input id="passNew" name="passNew" class="span3" id="prependedInput" type="password" placeholder="Contrase&ntilde;a Nueva " required>
                            </div>

                            <div class="input-prepend">
                                            <span class="add-on"><i class="icon-lock"></i></span>
                                            <input id="passConfirmNew" name="passConfirmNew" class="span3" id="prependedInput" type="password" placeholder="Confirmar Contrase&ntilde;a Nueva" required>
                            </div>

                            <button class="btn btn-large btn-primary" type="submit">Cambiar</button>
                            <input type="hidden" name="accion" value="cambiaPassDep"/>                            
                      </form>
                    </section>
               </div>
           </div>
      </div>
      <jsp:include page="/views/parts/footer.jsp"></jsp:include>         
  </body>
</html>