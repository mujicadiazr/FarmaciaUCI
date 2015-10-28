<%-- 
    Document   : editarUsuario
    Created on : May 19, 2013, 6:54:38 AM
    Author     : randy
--%>

<%@page import="uci.cu.util.DISPATCHER"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="uci.cu.dao.impl.SuscripcionDAO"%>
<%@page import="uci.cu.logic.Suscripcion"%>
<%@page import="uci.cu.dao.impl.TrabajadorDAO"%>
<%@page import="uci.cu.logic.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
    <% 
        String ci = request.getParameter("ci");
        Suscripcion t = new Suscripcion("");
        
        if (ci != null) {
            Suscripcion tedit = new Suscripcion(ci);
            SuscripcionDAO tdao = new SuscripcionDAO();
            t = tdao.obtenerPorID(tedit);
        } else {
            JOptionPane.showMessageDialog(null, "El CI de la suscripcion es nulo");
            response.sendRedirect("listarSuscripcion.jsp");
        }
        
        if (t.getCi().equals("")) {
            JOptionPane.showMessageDialog(null, "La suscripcion no existe en la BD");
            response.sendRedirect("listarSuscripcion.jsp");
        }
    %>
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
                        <form class="form-horizontal" action="../../GestionarSuscripcionServlet" method="post">
                        <fieldset class="centrado">
                            <legend>Editar suscripci&oacute;n:</legend>
                                                        
                            <div class="control-group" >
                                    <label class="control-label" for="inputCi">CI</label>
                                    <div class="controls">
                                        <input type="text" id="inputCi" name="inputCi" onkeypress="return permite(event,'num');" value="<%=t.getCi() %>" required>
                                    </div>
                                </div>
                                <div class="control-group" >
                                    <label class="control-label" for="inputNombre">Nombre</label>
                                    <div class="controls">
                                        <input type="text" id="inputNombre" name="inputNombre" onkeypress="return permite(event,'car');" value="<%=t.getNombre() %>" required>
                                    </div>
                                </div>
				<div class="control-group">
                                    <label class="control-label" for="inputPrimerApell">Primer Apellido</label>
                                    <div class="controls">
                                        <input type="text" id="inputPrimerApell" name="inputPrimerApell" onkeypress="return permite(event,'car');" value="<%=t.getPrimerApell() %>" required>
                                    </div>
                                </div>
				<div class="control-group">
                                    <label class="control-label" for="inputSegundoApell">Segundo Apellido</label>
                                     <div class="controls">
                                        <input type="text" id="inputSegundoApell" name="inputSegundoApell" onkeypress="return permite(event,'car');" value="<%=t.getSegundoApell() %>" required>
                                     </div>
                                </div>

                            <div class="controls" >
                                <button type="submit" style="margin-right: 0.5em;" class="btn btn-success btn-large pull-left">Actualizar</button>                    
                                <a class="btn pull-left btn-large" href="../admin/listarSuscripcion.jsp">Cancelar</a>
                                <input type="hidden" name="accion" value="editar"/>
                                <input type="hidden" name="suscripcionToEdit" value="<%=ci%>"/>
                            </div>
                            </div>
                            </div> 
                            </div>
                    </section>
                </div>
            </div>
        </div>
        <jsp:include page="/views/parts/footer.jsp"></jsp:include> 
  </body>
</html>
