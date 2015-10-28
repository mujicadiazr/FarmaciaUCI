<%-- 
    Document   : venderMedicamento
    Created on : Jun 18, 2013, 2:27:46 AM
    Author     : randy
--%>

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
                    <form width="50%" action="../../VentaServlet" method="post">
                            <% 
                                String nombre = request.getParameter("nombre");
                                String tipo = request.getParameter("tipo");                            
                            %> 
                            <fieldset >
                                    <legend>Vender medicamento:</legend>
                                    
                                    <label for="inputNombre">Nombre</label>
                                    <input type="text" id="inputNombre" class="input-medium" name="inputNombre" contenteditable="false" required value="<%=nombre%>"/>
                                    
                                    <label for="inputTipo">Tipo</label>
                                    <input type="text" id="inputTipo" class="input-medium" name="inputTipo" contenteditable="false" required value="<%=tipo%>"/>
                                       
                                    <label for="inputCant">Cantidad</label>
                                    <input type="number" id="inputCant" class="input-medium" name="inputCant" required/>
                                    
                                    <div class="controls" >
                                            <button class="btn btn-large btn-success" style="margin-right: 0.5em;" type="submit">Agregar a venta</button>
                                            <a class="btn pull-left btn-large" href="../dep/listarMedicamentos.jsp">Cancelar</a>
                                            <input type="hidden" name="accion" value="agregarVenta"/>
                                    </div>
                            </fieldset>

                        </form>
                    </section>
               </div>
           </div>
      </div>
      <jsp:include page="/views/parts/footer.jsp"></jsp:include>         
  </body>
</html>
