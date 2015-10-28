<%-- 
    Document   : listarUsuarios
    Created on : May 19, 2013, 4:22:02 AM
    Author     : randy
--%>

<%@page import="uci.cu.logic.Suscripcion"%>
<%@page import="uci.cu.dao.impl.SuscripcionDAO"%>
<%@page import="uci.cu.dao.impl.GestionAlmohadillaDAO"%>
<%@page import="java.sql.Time"%>
<%@page import="java.sql.Date"%>
<%@page import="uci.cu.dao.impl.VentaMedicamentoDAO"%>
<%@page import="uci.cu.logic.VentaMedicamento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uci.cu.dao.impl.ValeDAO"%>
<%@page import="uci.cu.logic.Vale"%>
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
                                <legend>Lista de vales de venta:</legend>
                                <%
                                    List<Vale> listaVales = (ArrayList<Vale>)(new ValeDAO()).listarTodos();
                                    List<VentaMedicamento> listaVenta = null;
                                    float importe = 0;
                                    
                                    for (int i=0; i<listaVales.size(); i++) {                                    
                                        int valeId = listaVales.get(i).getId();
                                        listaVenta = (new VentaMedicamentoDAO()).MedDeVale(valeId);
                                        String usuario = null; 
                                        Date fecha = listaVales.get(i).getFecha();
                                        Time hora = listaVales.get(i).getHora();
                                        
                                        if (listaVenta.size() > 0)
                                            usuario = listaVenta.get(0).getTrabajadorUsuario();
                                        importe = 0;
                                        
                                        
                                %>
                                
                               
                               <h5>No. Vale: <%= valeId %></h5>
                               <h5>Por: <%= usuario %></h5>
                               <h5>Fecha: <%= fecha %></h5>
                               <h5>Hora: <%= hora %></h5>     
                                
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
                                        
                                        for (int j=0; j<listaVenta.size(); j++) {
                                            Medicamento med = new Medicamento(listaVenta.get(j).getMedicamentoNombre(), listaVenta.get(j).getMedicamentoTipo());                                        
                                            float costo = (new MedicamentoDAO()).obtenerPorID(med).getCosto();
                                            importe += costo;
                                    %>
                                    <tr>
                                        <td><%=j + 1%></td>
                                        <td><%=listaVenta.get(j).getMedicamentoNombre() %></td>
                                        <td><%=listaVenta.get(j).getMedicamentoTipo()%></td>
                                        <td>$<%=costo%></td>
                                        <td><%=listaVenta.get(j).getCantMedicamento()%></td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
                                <h4 style="text-align: right;">Importe: $<%= importe %></h4>
                                <legend></legend>
                                <%}%>
                                <%
                                        SuscripcionDAO tdao = new SuscripcionDAO();
                                        List lista = null;
                                        float importeAlm = 0;
                                        try {
                                            lista = tdao.listarTodos();
                                        } catch (Exception e) {
                                        }
                                        
                                        for (int i = 0; i < lista.size(); i++) {
                                            boolean yaCogio = (new SuscripcionDAO()).yaCogio((Suscripcion)lista.get(i));
                                            if (yaCogio)
                                                importeAlm += 0.40;
                                        }
                                    %>
                                
                                <legend></legend>
                                <h3 style="text-align: right;">Importe en venta de almohadillas: $<%= importeAlm %></h3>
                                <legend></legend>
                                
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../parts/footer.jsp"></jsp:include>
                            
    </body>
</html>

