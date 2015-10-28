<%-- 
    Document   : crearUsuario
    Created on : May 19, 2013, 4:23:36 AM
    Author     : randy
--%>
<%@page import="uci.cu.util.DISPATCHER"%>
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
                    <form class="form-horizontal" action="../../GestionarUsuariosServlet" method="post">
			<fieldset class="centrado">
				<legend>Crear usuario:</legend>
				
				<div class="control-group" >
                                    <label class="control-label" for="inputNombre">Nombre</label>
                                    <div class="controls">
                                        <input type="text" id="inputNombre" name="inputNombre" onkeypress="return permite(event,'car');" required>
                                    </div>
                                </div>
				<div class="control-group">
                                    <label class="control-label" for="inputPrimerApell">Primer Apellido</label>
                                    <div class="controls">
                                        <input type="text" id="inputPrimerApell" name="inputPrimerApell" onkeypress="return permite(event,'car');" required>
                                    </div>
                                </div>
				<div class="control-group">
                                    <label class="control-label" for="inputSegundoApell">Segundo Apellido</label>
                                     <div class="controls">
                                        <input type="text" id="inputSegundoApell" name="inputSegundoApell" onkeypress="return permite(event,'car');" required>
                                     </div>
                                </div>
				<div class="control-group">
                	<label class="control-label" for="inputUser">Usuario</label>
                	<div class="controls">
                    	<input type="text" id="inputUser" name="inputUser" onkeypress="return permite(event,'car');" required>
                	</div>
            	</div>
				<div class="control-group">
                	<label class="control-label" for="inputPass">Contrase&ntilde;a</label>
                	<div class="controls">
                    	<input type="password" id="inputPass" name="inputPass" onkeypress="return permite(event,'num_car_sim');" required>
                	</div>
            	</div>
				<div class="control-group">
                	<label class="control-label" for="inputCi">Numero de Identidad</label>
                	<div class="controls">
                    	<input type="text" id="inputCi" name="inputCi" onkeypress="return permite(event,'num');" required>
                	</div>
            	</div>
				<div class="control-group">
                	<label class="control-label" for="inputTelf">Tel&eacute;fono</label>
                	<div class="controls">
                    	<input type="text" id="inputTelf" name="inputTelf" onkeypress="return permite(event,'num');">
                	</div>
            	</div>
            	<div class="control-group">
                	<label class="control-label" for="inputDirParticular">Direcci&oacute;n Particular</label>
                	<div class="controls">
                            <input type="text" id="inputDirParticular" name="inputDirParticular" onkeypress="return permite(event,'num_car_sim');">
                	</div>
            	</div>	
                <div class="control-group">
                	<label class="control-label" for="selectRol">Rol</label>
                	<div class="controls">
                                <select id="selectRol" name="selectRol">
                                    <option value="admin">Administrador</option>
                                    <option value="dep" selected="selected">Dependiente</option>                                
                                </select>
                	</div>
            	</div> 
                                
		<div class="controls" >
                    <button type="submit" style="margin-right: 0.5em;" class="btn btn-success btn-large pull-left">Crear</button>                    
                    <a class="btn pull-left btn-large" href="../admin/accedidoAdmin.jsp">Cancelar</a>
                    <input type="hidden" name="accion" value="crear"/>
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
