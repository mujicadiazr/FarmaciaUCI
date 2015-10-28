<%-- 
    Document   : listarUsuarios
    Created on : May 19, 2013, 4:22:02 AM
    Author     : randy
--%>

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
                                <legend>Usuarios del sistema:</legend>

                                <table class="table table-condensed table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>
                                            <th>1er Apellido</th>
                                            <th>2do Apellido</th>
                                            <th>CI</th>
                                            <th>Telefono</th>
                                            <th>Dir. Particular</th>
                                            <th>Usuario</th>
                                            <th>Rol</th>                                           
                                        </tr>                            
                                    </thead>
                                    <tbody>
                                    <%
                                        TrabajadorDAO tdao = new TrabajadorDAO();
                                        List lista = null;

                                        try {
                                            lista = tdao.listarTodos();
                                        } catch (Exception e) {
                                        }

                                        for (int i = 0; i < lista.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%=i + 1%></td>
                                        <td><%=((Trabajador) lista.get(i)).getNombre()%></td>
                                        <td><%=((Trabajador) lista.get(i)).getPrimerApellido()%></td>
                                        <td><%=((Trabajador) lista.get(i)).getSegundoApellido()%></td>
                                        <td><%=((Trabajador) lista.get(i)).getCi()%></td>
                                        <td><%=((Trabajador) lista.get(i)).getTelefono()%></td>
                                        <td><%=((Trabajador) lista.get(i)).getDireccionParticular()%></td>
                                        <td><%=((Trabajador) lista.get(i)).getUsuario()%></td>
                                <td>
                                    <%=((Trabajador) lista.get(i)).getRol().equals("dep") ? "Dependiente" : "Administrador"%>
                                </td>
                                <td>
                                    <a rel="tooltip" title="Editar" href="<%=request.getServletContext().getContextPath()%>/views/admin/editarUsuario.jsp?usuario=<%=((Trabajador) lista.get(i)).getUsuario()%>"><i class="icon-edit"></i></a>
                                    <a rel="tooltip" title="Eliminar" href="<%=request.getServletContext().getContextPath()%>/GestionarUsuariosServlet?usuario=<%=((Trabajador) lista.get(i)).getUsuario()%>&accion=eliminar"><i id="iconoEliminar" class="icon-trash"></i></a>
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

