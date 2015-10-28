<%-- 
    Document   : editarUsuario
    Created on : May 19, 2013, 6:54:38 AM
    Author     : randy
--%>

<%@page import="uci.cu.dao.impl.TrabajadorDAO"%>
<%@page import="uci.cu.logic.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <%@page import="uci.cu.util.DISPATCHER"%>
  <head>
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
    
  </head>
  <% DISPATCHER.redirect("../../index.jsp", response, request); %>
  
  <body data-spy="scroll" data-target=".bs-docs-sidebar"> 
       <jsp:include page="/views/parts/navbar.jsp"></jsp:include>
       <jsp:include page="/views/parts/banner.jsp"></jsp:include>
       <%       
        if(request.getSession().getAttribute("session") != null) {
        String usuario = request.getParameter("usuario");
        Trabajador t = new Trabajador("");
        
        if (usuario != null) {
            Trabajador tedit = new Trabajador(usuario);
            TrabajadorDAO tdao = new TrabajadorDAO();
            t = tdao.obtenerPorID(tedit);
        } else 
            response.sendRedirect("listarUsuarios.jsp");
        
        if (t.getUsuario().equals(""))
            response.sendRedirect("listarUsuarios.jsp");
        
        
    %>
       <div class="container">
            <div class="row">
                <jsp:include page="/views/parts/menuAdmin.jsp"></jsp:include>
                
                <div class="span9">
                    <section>
                        <!--Aki va el formulario-->
                        <form class="form-horizontal" action="../../GestionarUsuariosServlet" method="post">
                        <fieldset class="centrado">
                            <legend>Editar usuario:</legend>
                                                        
                            <div class="control-group" >
                                <label class="control-label" for="inputNombre">Nombre</label>
                                <div class="controls">
                                    <input type="text" id="inputNombre" name="inputNombre" onkeypress="return permite(event, 'car');" value="<%= t.getNombre() %>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPrimerApell">Primer Apellido</label>
                                <div class="controls">
                                    <input type="text" id="inputPrimerApell" name="inputPrimerApell" onkeypress="return permite(event, 'car');" value="<%=t.getPrimerApellido() %>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputSegundoApell">Segundo Apellido</label>
                                <div class="controls">
                                    <input type="text" id="inputSegundoApell" name="inputSegundoApell" onkeypress="return permite(event, 'car');" value="<%=t.getSegundoApellido()%>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputUser">Usuario</label>
                                <div class="controls">
                                    <input type="text" id="inputUser" name="inputUser" onkeypress="return permite(event, 'car');" value="<%=t.getUsuario()%>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPass">Contrase&ntilde;a</label>
                                <div class="controls">
                                    <input type="password" id="inputPass" name="inputPass" onkeypress="return permite(event, 'num_car_sim');" value="<%=t.getContrasenna()%>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputCi">Numero de Identidad</label>
                                <div class="controls">
                                    <input type="text" id="inputCi" name="inputCi" onkeypress="return permite(event, 'num');" value="<%=t.getCi() %>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputTelf">Tel&eacute;fono</label>
                                <div class="controls">
                                    <input type="text" id="inputTelf" name="inputTelf" onkeypress="return permite(event, 'num');" value="<%=t.getTelefono()%>">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputDirParticular">Direcci&oacute;n Particular</label>
                                <div class="controls">
                                    <input type="text" id="inputDirParticular" name="inputDirParticular" onkeypress="return permite(event, 'num_car_sim');" value="<%=t.getDireccionParticular() %>">
                                </div>
                            </div>	
                            <div class="control-group">
                                <label class="control-label" for="selectRol">Rol</label>
                                <div class="controls">
                                    <% if (t.getRol() != null) {%>
                                    <select id="selectRol" name="selectRol">
                                        <option <%if (t.getRol().equals("admin")) { %> 
                                            selected="selected" 
                                                <%}%>
                                            value="admin">Administrador</option>
                                        <option <%if (t.getRol().equals("dep")) { %> 
                                            selected="selected" 
                                                <% } %>
                                            value="dep">Dependiente</option>                                
                                    </select>
                                     <% } %>
                                </div>
                            </div> 

                            <div class="controls" >
                                <button type="submit" style="margin-right: 0.5em;" class="btn btn-success btn-large pull-left">Actualizar</button>                    
                                <a class="btn pull-left btn-large" href="../admin/listarUsuarios.jsp">Cancelar</a>
                                <input type="hidden" name="accion" value="editar"/>
                                <input type="hidden" name="userToEdit" value="<%=usuario%>"/>
                            </div>
                            </div>
                            </div> 
                            </div>
                    </section>
                </div>
            </div>
        </div>
        <% } %>
        <jsp:include page="/views/parts/footer.jsp"></jsp:include> 
  </body>
</html>
