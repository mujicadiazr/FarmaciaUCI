<%-- 
    Document   : accedidoAdmin
    Created on : May 18, 2013, 3:35:43 AM
    Author     : randy
--%>

<%@page import="uci.cu.logic.Reclamacion"%>
<%@page import="uci.cu.dao.impl.ReclamacionDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uci.cu.logic.InformeRecepcion"%>
<%@page import="java.util.List"%>
<%@page import="uci.cu.dao.impl.InformeRecepcionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
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
                <jsp:include page="/views/parts/menuAdmin.jsp"></jsp:include>
                
                <div class="span9">
                    <section>
                        <!--Aki va el formulario-->
                         <form action="../../GestionarDocumento" method="post">
                            <fieldset> 
                                <legend>Lista de Informes de Recepci&oacute;n:</legend>

                
                                <table class="table table-condensed table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Usuario</th>                                            
                                            <th>Fecha</th>      
                                            <th>Datos reales</th>
                                            <th>Datos planilla</th>
                                        </tr>                            
                                    </thead>
                                    <tbody>
                                    <%
                                        ReclamacionDAO mdao = new ReclamacionDAO();
                                        List<Reclamacion> lista = new ArrayList<Reclamacion>();

                                        try {
                                            lista = (ArrayList<Reclamacion>)mdao.listarTodos();
                                        } catch (Exception e) {
                                        }

                                        for (int i = 0; i < lista.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%=((Reclamacion) lista.get(i)).getId()%></td>
                                        <td><%=((Reclamacion) lista.get(i)).getTrabajadorUsuario() %></td>
                                        <td><%=((Reclamacion) lista.get(i)).getFecha() %></td>
                                        <td><%=((Reclamacion) lista.get(i)).getDatosReales()%></td>
                                        <td><%=((Reclamacion) lista.get(i)).getDatosFactura()%></td>
                                <td>
                                    <a rel="tooltip" title="Eliminar" href="<%=request.getServletContext().getContextPath()%>/GestionarDocumento?id=<%=((Reclamacion) lista.get(i)).getId()%>&accion=eliminarReclamacion"><i id="iconoEliminar" class="icon-trash"></i></a>
                                    <a rel="tooltip" title="Imprimir" href="<%=request.getServletContext().getContextPath()%>/GestionarDocumento?id=<%=((Reclamacion) lista.get(i)).getId()%>&accion=imprimirReclamacion"><i id="iconoEliminar" class="icon-print"></i></a>
                                </td>                                
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </fieldset>
                    </form>
                    </section>
                </div>
            </div>
        </div>
        <jsp:include page="/views/parts/footer.jsp"></jsp:include> 
  </body>
</html>