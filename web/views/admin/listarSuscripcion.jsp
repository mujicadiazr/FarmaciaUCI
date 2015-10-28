<%-- 
    Document   : listarUsuarios
    Created on : May 19, 2013, 4:22:02 AM
    Author     : randy
--%>

<%@page import="uci.cu.logic.Suscripcion"%>
<%@page import="uci.cu.dao.impl.SuscripcionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uci.cu.dao.impl.TrabajadorDAO" %>
<%@page import="uci.cu.logic.Trabajador" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/views/parts/title.jsp"></jsp:include>
        <jsp:include page="/views/parts/head.jsp"></jsp:include>
        </head>
<%@page import="uci.cu.util.DISPATCHER"%>
  <% DISPATCHER.redirect("../../index.jsp", response, request); %>
        <body data-spy="scroll" data-target=".bs-docs-sidebar"> 
        <jsp:include page="../parts/navbar.jsp"></jsp:include>
        <jsp:include page="../parts/banner.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                <jsp:include page="../parts/menuAdmin.jsp"></jsp:include>

                    <div class="span9">
                        <!--Aki va el formulario-->
                        <form action="../../GestionarUsuariosServlet" method="post">
                            <fieldset> 
                                <input type="hidden" name="accion"/>
                                <input type="hidden" name="usuario"/>
                                <legend>Lista de suscripciones de almohadillas sanitarias:</legend>

                                <table class="table table-condensed table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>CI</th>
                                            <th>Nombre</th>
                                            <th>1er Apellido</th>
                                            <th>2do Apellido</th>
                                        </tr>                            
                                    </thead>
                                    <tbody>
                                    <%
                                        SuscripcionDAO tdao = new SuscripcionDAO();
                                        List lista = null;

                                        try {
                                            lista = tdao.listarTodos();
                                        } catch (Exception e) {
                                        }

                                        for (int i = 0; i < lista.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%=i + 1%></td>
                                        <td><%=((Suscripcion) lista.get(i)).getCi()%></td>
                                        <td><%=((Suscripcion) lista.get(i)).getNombre()%></td>
                                        <td><%=((Suscripcion) lista.get(i)).getPrimerApell()%></td>
                                        <td><%=((Suscripcion) lista.get(i)).getSegundoApell()%></td>
                                        
                                <td>
                                    <a rel="tooltip" title="Editar" href="<%=request.getServletContext().getContextPath()%>/views/admin/editarSuscripcion.jsp?ci=<%=((Suscripcion) lista.get(i)).getCi()%>"><i class="icon-edit"></i></a>
                                    <a rel="tooltip" title="Eliminar" href="<%=request.getServletContext().getContextPath()%>/GestionarSuscripcionServlet?ci=<%=((Suscripcion) lista.get(i)).getCi()%>&accion=eliminar"><i id="iconoEliminar" class="icon-trash"></i></a>
                                </td>                                
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../parts/footer.jsp"></jsp:include>
                    
    </body>
</html>

