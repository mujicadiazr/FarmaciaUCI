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
                    <form class="form-horizontal" action="../../GestionarMedicamentoServlet" method="post">
		<fieldset class="centrado">
			<legend>Datos del medicamento</legend>
    		<div class="control-group">
    			<label class="control-label" for="inputNombre">Nombre</label>
    			<div class="controls">
                            <input type="text" id="inputNombre" class="input-medium" onkeypress="return permite(event,'car');" name="inputNombre" required>
    			</div>
    		</div>
    		<div class="control-group">
    			<label class="control-label" for="textAreaDesc">Descripci&oacute;n</label>
    			<div class="controls">
                            <textarea row=3 id="textAreaDesc" name="textAreaDesc" ></textarea> 
    			</div>
    		</div>
            <div class="control-group">
                <label class="control-label" for="inputTipo">Tipo</label>
                <div class="controls">
                    <input type="text" id="inputTipo" class="input-medium" name="inputTipo" onkeypress="return permite(event,'car');" required>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputCosto" >Costo</label>
                <div class="controls">
                <div class="input-prepend" class="control-group">
                    <span class="add-on" >$</span> 
                    <input type="text" id="inputCosto" class="input-medium" name="inputCosto" onkeypress="return permite(event,'num');" required/> 
                </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputCantidad">Cantidad</label>
                <div class="controls">
                    <input type="text" id="inputCantidad" class="input-medium" name="inputCantidad" onkeypress="return permite(event,'num');" required />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputUMedida">Unidad de medida</label>
                <div class="controls">
                    <input type="text" id="inputUMedida" class="input-medium" name="inputUMedida" onkeypress="return permite(event,'car_sim');" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputLote">Lote</label>
                <div class="controls">
                    <input type="text" id="inputLote" class="input-medium"  name="inputLote" onkeypress="return permite(event,'num');" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputFVencimiento">Fecha de vencimiento</label>
                <div class="controls">
                    <input type="date" id="inputFVencimiento" class="input-medium" name="inputFVencimiento" required/>
                </div>
            </div>
            <div class="controls" >
                                <button type="submit" style="margin-right: 0.5em;" class="btn btn-success btn-large pull-left">Agregar</button>                    
                                <a class="btn pull-left btn-large" href="../admin/listarMedicamentos.jsp">Cancelar</a>
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
