<%-- 
    Document   : accedidoAdmin
    Created on : May 18, 2013, 3:35:43 AM
    Author     : randy
--%>
<%@page import="uci.cu.util.DISPATCHER"%>
<%@page import="uci.cu.logic.InformeMedicamento"%>
<%@page import="java.util.List"%>
<%@page import="uci.cu.dao.impl.MedicamentoDAO"%>
<%@page import="uci.cu.logic.Medicamento"%>
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
                        <form action="../../GestionarDocumento" method="post">
                            <fieldset> 
                                <legend>Informe de recepci&oacute;n:</legend>

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
                                            <th>Estado</th>
                                        </tr>                            
                                    </thead>
                                    <tbody>
                                    <%
                                        InformeMedicamento im = (InformeMedicamento)request.getSession(false).getAttribute("informe");
                                        
                                        if (im == null) {
                                            im = new InformeMedicamento();
                                            request.getSession().setAttribute("informe", im);
                                        } 
                                        
                                        List<Medicamento> listaMed = im.getListaMed();
                                        List<Character> listaEstado = im.getListaEstado();
                                        if (listaMed.size() > 0)
                                        for (int i = 0; i < listaMed.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%=i + 1%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getNombre()%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getTipo()%></td>
                                        <td>$<%=((Medicamento) listaMed.get(i)).getCosto()%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getCantidad()%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getUnidadMedida()%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getLote()%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getFechaVencimiento()%></td>
                                            <%
                                                if (listaEstado.get(i).equals('n')) { //Si el estado es nuevo
                                            %>
                                        <td><i class="icon-ok"></i></td>
                                            <% } else { %>
                                        <td><i class="icon-refresh"></i></td>
                                            <% } %>                                
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                                <legend></legend>
                                
                                <div class="controls">
                                    <a class="btn btn-large" href="../admin/adicionarMedInforme.jsp">Agregar medicamento</a>
                                    <button type="submit" style="margin-right: 0.5em;" class="btn btn-success btn-large">Confirmar</button>                    
                                    <a class="btn btn-large btn-danger" style="margin-right: 0.5em; text-align: right;" href="../../GestionarDocumento?accion=cancelarInforme">Cancelar</a>
                                    
                                    <input type="hidden" name="accion" value="crearInforme"/>                        
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
