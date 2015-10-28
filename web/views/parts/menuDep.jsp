<%-- 
    Document   : menuDep
    Created on : May 19, 2013, 8:03:19 AM
    Author     : randy
--%>

<%@page import="uci.cu.logic.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="span3 bs-docs-sidebar" >
    <ul class="nav nav-list bs-docs-sidenav">
        <li><a href="../dep/cambiarContrasenna.jsp">Cambiar contrase&ntilde;a</a></li>
        <%
            Venta objVenta = (Venta)request.getSession(false).getAttribute("venta");
            
        %>
        
        <li class="dropdown-submenu">
            <a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Medicamento</a>
	    <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                <li><a href="../dep/listarMedicamentos.jsp">Listar</a></li>
<!--                <li><a href="../dep/buscarMedicamento.jsp">Buscar</a></li>-->
                    <%
                        if (objVenta != null) {
                    %>
                <li><a href="../dep/confirmacionVenta.jsp"><i class="icon-ok"></i>Venta en curso</a></li>
                    <% } %>
            </ul>
        </li>
        <li><a href="../dep/listarValesVenta.jsp">Listar vales de venta</a></li>
        <li><a href="../dep/listarSuscripcion.jsp">Listar suscripciones de almohadillas</a></li>
        
    </ul>                 
</div>
