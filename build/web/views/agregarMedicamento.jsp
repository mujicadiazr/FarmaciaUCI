<%-- 
    Document   : agregarMedicamento
    Created on : May 15, 2013, 5:32:44 AM
    Author     : randy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Nuevo medicamento</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
                <link rel="stylesheet" type="text/css" href="css/forms.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
		
	</head>
	<body>
		
            <form class="form-horizontal" action="gestionarMedicamentosServlet" method="post">
		<fieldset class="centrado">
			<legend>Datos del medicamento</legend>
    		<div class="control-group">
    			<label class="control-label" for="inputNombre">Nombre</label>
    			<div class="controls">
    				<input type="text" id="inputNombre" class="input-medium" required>
    			</div>
    		</div>
    		<div class="control-group">
    			<label class="control-label" for="textAreaNumero">Descripci&oacute;n</label>
    			<div class="controls">
    				<textarea row=3 id="textAreaNumero" class="input-medium" ></textarea> 
    			</div>
    		</div>
            <div class="control-group">
                <label class="control-label" for="inputTipo">Tipo</label>
                <div class="controls">
                    <input type="text" id="inputTipo" class="input-medium" required>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputCosto" >Costo</label>
                <div class="controls">
                <div class="input-prepend" class="control-group">
                    <span class="add-on" >$</span> 
                    <input type="text" id="inputCosto" id="prependedInput" class="input-medium" required/> 
                </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputCantidad">Cantidad</label>
                <div class="controls">
                    <input type="text" id="inputCantidad" class="input-medium" required />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputUMedida">Unidad de medida</label>
                <div class="controls">
                    <input type="text" id="inputUMedida" class="input-medium" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputLote">Lote</label>
                <div class="controls">
                    <input type="text" id="inputLote" class="input-medium" required/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputFVencimiento">Fecha de vencimiento</label>
                <div class="controls">
                    <input type="text" id="inputFVencimiento" class="input-medium" required/>
                </div>
            </div>
    		<div class="control-group form-actions">
    			<button type="submit"  class="btn btn-success btn-large  pull-left" >Agregar</button>
                <div class="controls">
                    <input type="button" class="btn pull-left btn-large" value="Cancelar" />
                </div>
    		</div>  
    	</fieldset>  
                <input type="hidden" name="accion" value="agregar"/>
    </form>
    
	</body>
</html>
