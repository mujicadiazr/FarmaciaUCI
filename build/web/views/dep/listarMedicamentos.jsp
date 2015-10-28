<%-- 
    Document   : listarUsuarios
    Created on : May 19, 2013, 4:22:02 AM
    Author     : randy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uci.cu.dao.impl.MedicamentoDAO" %>
<%@page import="uci.cu.logic.Medicamento" %>
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
                <jsp:include page="../parts/menuDep.jsp"></jsp:include>

                    <div class="span9">
                        <!--Aki va el formulario-->
                        <form action="../../GestionarMedicamentoServlet" method="post">
                            <fieldset> 
                                <input type="hidden" name="accion"/>
                                <input type="hidden" name="usuario"/>
                                <legend>Lista de medicamentos:</legend>

                
                                <table class="table table-condensed table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>                                            
                                            <th>Tipo</th>
                                            <th>Costo</th>
                                            <th>Cantidad</th>
                                            <th>U/M</th>
                                            <th>Lote</th>
                                            <th>Fecha de Vencimiento</th>
                                        </tr>                            
                                    </thead>
                                    <tbody>
                                    <%
                                        MedicamentoDAO mdao = new MedicamentoDAO();
                                        List lista = null;

                                        try {
                                            lista = mdao.listarTodos();
                                        } catch (Exception e) {
                                        }

                                        for (int i = 0; i < lista.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%=i + 1%></td>
                                        <td><%=((Medicamento) lista.get(i)).getNombre()%></td>
                                        <td><%=((Medicamento) lista.get(i)).getTipo()%></td>
                                        <td>$<%=((Medicamento) lista.get(i)).getCosto()%></td>
                                        <td><%=((Medicamento) lista.get(i)).getCantidad()%></td>
                                        <td><%=((Medicamento) lista.get(i)).getUnidadMedida()%></td>
                                        <td><%=((Medicamento) lista.get(i)).getLote()%></td>
                                <td>
                                    <%=((Medicamento) lista.get(i)).getFechaVencimiento()%>
                                </td>
                                <td>
                                    <a rel="tooltip" title="Vender" href="<%=request.getServletContext().getContextPath()%>/views/dep/venderMedicamento.jsp?nombre=<%=((Medicamento) lista.get(i)).getNombre()%>&tipo=<%=((Medicamento) lista.get(i)).getTipo()%>"><i class="icon-shopping-cart"></i></a>
                                    <a rel="tooltip" title="Ver descripci&oacute;n" href="<%=request.getServletContext().getContextPath()%>/views/dep/descMedicamento.jsp?nombre=<%=((Medicamento) lista.get(i)).getNombre()%>&tipo=<%=((Medicamento)lista.get(i)).getTipo()%>"><i class="icon-list-alt"></i></a>
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

