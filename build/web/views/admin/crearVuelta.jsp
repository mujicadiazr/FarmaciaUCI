<%-- 
    Document   : accedidoAdmin
    Created on : May 18, 2013, 3:35:43 AM
    Author     : randy
--%>

<%@page import="uci.cu.util.DISPATCHER"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="/views/parts/title.jsp"></jsp:include>   
    <jsp:include page="/views/parts/head.jsp"></jsp:include>    
  </head>
  
  <% DISPATCHER.redirect("../../index.jsp", response, request); %>
  <body data-spy="scroll" data-target=".bs-docs-sidebar"> 
       <jsp:include page="/views/parts/navbar.jsp"></jsp:include>
       <jsp:include page="/views/parts/banner.jsp"></jsp:include>
       <div class="container">
            <div class="row">
                <jsp:include page="/views/parts/menuAdmin.jsp"></jsp:include>
                
                <div class="span9">
                    <section>
                        <!--Aki va el formulario-->
                        <form width="50%" action="../../VentaServlet" method="post">			
                            <fieldset>
                                    <legend>Entrar datos de la vuelta</legend>
                                    
                                    <label  for="textAnno">A&ntilde;o:</label>
                                    <input type="number" placeholder="A&ntilde;o" id="inputAnno" name="inputAnno" class="input-mini" onkeypress="return permite(event,'num');" required/>
                                    <label  for="textMes">Mes:</label>
                                    <input type="month" placeholder="Mes" id="inputMes" name="inputMes" class="input-medium" onkeypress="return permite(event,'num');" required/>
                                    
                                    <div class="controls">
                                            <button class="btn btn-success" type="submit">Aceptar</button>
                                            <a class="btn" href="../admin/accedidoAdmin.jsp">Cancelar</a>
                                            <input type="hidden" name="accion" value="crearVueltaVenta"/>
                                    <div>
                            </fieldset>			
                        </form>
                    </section>
                </div>
            </div>
        </div>
        <jsp:include page="/views/parts/footer.jsp"></jsp:include> 
  </body>
</html>
