<%-- 
    Document   : navbar
    Created on : Jun 8, 2013, 9:50:26 PM
    Author     : randy
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="uci.cu.logic.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <%
                Trabajador tsession = (Trabajador)request.getSession().getAttribute("session");
//                
                if (tsession != null) {
                                                
            %>            
            <div class="brand" style="align: rigth;">
                <h5 class="pull-left" style="color: white; margin-right: 3em;">Bienvenido, <%= tsession.getNombre()%></h5>
                <a href="<%= request.getServletContext().getContextPath()%>/LoginServlet?accion=logout" class="btn btn-primary">Logout</a>
            </div> 
            
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active">
                        <% if (tsession.getRol().equals("dep")){%>    
                        
                        <a href="../../views/dep/accedidoDep.jsp" onmouseover="this.style.backgroundColor = 'black';" onmouseout="this.style.backgroundColor = '';">Principal</a>
                        
                        <% } else {%>
                        <a href="../../views/admin/accedidoAdmin.jsp" onmouseover="this.style.backgroundColor = 'black';" onmouseout="this.style.backgroundColor = '';">Principal</a>
                        <% }%>
                    </li>                      
                </ul>
            </div>
            <% } %>        
                    
        </div>
    </div>
</div> 
