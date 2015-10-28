<%-- 
    Document   : buscarMedicamento
    Created on : Jun 17, 2013, 11:21:23 PM
    Author     : randy
--%>

<%@page import="uci.cu.dao.impl.VueltaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uci.cu.logic.Vuelta"%>
<%@page import="java.util.List"%>
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
            <jsp:include page="../parts/menuAdmin.jsp"></jsp:include>
               <div class="span9">
                    <section>
                    <!--Aki va el formulario-->
                    <form action="../../VentaServlet" method="post">
                        <fieldset>
                            <input type="hidden" name="accion"/>
                            <input type="hidden" name="usuario"/>
                            <legend>Lista de Vueltas</legend>
                            <% 
                                List<Vuelta> listVueltas= new ArrayList<Vuelta>();
                                try {
                                    listVueltas = (ArrayList<Vuelta>)(new VueltaDAO()).listarTodos();
                                } catch (Exception e) {
                                        }
                            %>
                            <table class="table table-condensed table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>A&ntilde;o</th>
                                        <th>Mes</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (int i = 0; i < listVueltas.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%=((Vuelta) listVueltas.get(i)).getId()%></td>
                                        <td><%=((Vuelta) listVueltas.get(i)).getAnno()%></td>
                                        <td><%=((Vuelta) listVueltas.get(i)).getMes()%></td>
                                        <td><a rel="tooltip" title="A Vender" href="<%=request.getServletContext().getContextPath()%>/VentaServlet?idv=<%=((Vuelta) listVueltas.get(i)).getId()%>&accion=aVender"><i class="icon-shopping-cart"></i></a>
                                        <!--<a rel="tooltip" title="Rechazar Vender"href="<%=request.getServletContext().getContextPath()%>/VentaServlet?idv=<%=((Vuelta) listVueltas.get(i)).getId()%>&accion=noVender"><i class="icon-ban-circle"></i></a>-->
                                        <a rel="tooltip" title="Editar" href="<%= request.getServletContext().getContextPath()  %>/views/admin/listarSuscripcion.jsp?idv=<%= ((Vuelta) listVueltas.get(i)).getId()%>"><i class="icon-edit"></i></a>
                                        <a rel="tooltip" title="Eliminar"href="<%=request.getServletContext().getContextPath()%>/VentaServlet?idv=<%=((Vuelta) listVueltas.get(i)).getId()%>&accion=eliminar"><i id="iconoEliminar" class="icon-trash"></i></a>
                                        </td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                    </form>
                    </section>
               </div>
           </div>
      </div>
      <jsp:include page="/views/parts/footer.jsp"></jsp:include>
      <script src="../../js/busquedas.js" type="text/javascript"></script>
  </body>
</html>