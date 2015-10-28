<%-- 
    Document   : listarUsuarios
    Created on : May 19, 2013, 4:22:02 AM
    Author     : randy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uci.cu.logic.Vale"%>
<%@page import="uci.cu.logic.Trabajador"%>
<%@page import="uci.cu.logic.Venta"%>
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
                        <%
                            Venta objVenta = (Venta)request.getSession(false).getAttribute("venta");
                            Trabajador tvende = objVenta.getUsuario();
                            List<Medicamento> listaMed = objVenta.getListaMed();
                            Vale objVale = objVenta.getVale();
                            List<Float> costos = new ArrayList<Float>();
                            
                            double importe = 0;
                            for (int i=0; i<listaMed.size(); i++) {
                                float precio = (new MedicamentoDAO()).obtenerPorID(listaMed.get(i)).getCosto();
                                costos.add(precio);
                                importe += precio * listaMed.get(i).getCantidad();
                            }
                            
                        %>
                        
                        
                        <form action="../../VentaServlet" method="post">
                            <fieldset> 
                               <legend>Transacci&oacute;n de venta:</legend>
                               
                               <h4>Por: <%= tvende.getNombre() %></h4>
                               <h4>No. Vale: <%= objVale.getId() %></h4>
                               <h4>Importe: <%= importe %></h4>
                               
                               <legend></legend>
                               
                               <table class="table table-condensed table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>                                            
                                            <th>Tipo</th>
                                            <th>Costo</th>
                                            <th>Cantidad</th>                                            
                                        </tr>                            
                                    </thead>
                                    <tbody>
                                    <%
                                       for (int i=0; i<listaMed.size(); i++) { 
                                    %>
                                    <tr>
                                        <td><%=i + 1%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getNombre()%></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getTipo()%></td>
                                        <td><%=costos.get(i) %></td>
                                        <td><%=((Medicamento) listaMed.get(i)).getCantidad()%></td>
                                                                
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                                <div class="controls" style="margin-right: 1em;">
                                    <a class="btn pull-left btn-large btn-success" href="../../VentaServlet?accion=confirmarVenta">Confirmar</a>
                                    <a class="btn pull-left btn-large btn-danger" href="../../VentaServlet?accion=cancelarVenta">Cancelar</a>
                                    <a class="btn pull-left btn-large " href="../dep/accedidoDep.jsp">Atr&aacute;s</a>
                                </div>    
                                
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../parts/footer.jsp"></jsp:include>
                            
    </body>
</html>

