<%-- 
    Document   : cambiarContrasenna
    Created on : Jun 17, 2013, 11:28:03 PM
    Author     : randy
--%>

<%@page import="uci.cu.logic.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
   </head>
<%@page import="uci.cu.util.DISPATCHER"%>
  <% DISPATCHER.redirect("../../index.jsp", response, request); %>
  <body data-spy="scroll" data-target=".bs-docs-sidebar">
        <jsp:include page="/views/parts/navbar.jsp"></jsp:include>
        <jsp:include page="/views/parts/banner.jsp"></jsp:include>    
      <div class="container">
            <div class="row">
                <jsp:include page="../parts/menuDep.jsp"></jsp:include>
               <div class="span9">
                    <section>
                        <!--Aki va el formulario-->
                        <form class="form-login central" action="../../CambioClaveServlet" method="post">
                            <h2 class="form-login-heading">Cambiar contrase&ntilde;a</h2>

                              <input id="passOld" name="passOld" class="span3" type="password" placeholder="Contrase&ntilde;a actual" required>
                              <br>
                              <input id="passNew" name="passNew" class="span3" type="password" placeholder="Contrase&ntilde;a Nueva " required>
                              <br>
                              <input id="passConfirmNew" name="passConfirmNew" class="span3" type="password" placeholder="Confirmar Contrase&ntilde;a Nueva" required>
                              
                              <div class="controls">
                                    <button class="btn btn-large btn-primary pull-left" style="margin-right: 0.5em;" type="submit">Cambiar</button>
                                    <a class="btn pull-left btn-large" href="../dep/accedidoDep.jsp">Cancelar</a>
                                    <input type="hidden" name="accion" value="cambiaPassDep"/> 
                              </div>
                      </form>
                    </section>
               </div>
           </div>
      </div>
      <jsp:include page="/views/parts/footer.jsp"></jsp:include>         
  </body>
</html>