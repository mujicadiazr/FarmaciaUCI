<%-- 
    Document   : editarUsuario
    Created on : May 19, 2013, 6:54:38 AM
    Author     : randy
--%>

<%@page import="uci.cu.util.DISPATCHER"%>
<%@page import="uci.cu.dao.impl.MedicamentoDAO"%>
<%@page import="uci.cu.logic.Medicamento"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
    <% 
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        Medicamento m = new Medicamento("","");
        
        if (nombre != null && tipo != null) {
            Medicamento medit = new Medicamento(nombre,tipo);
            MedicamentoDAO tdao = new MedicamentoDAO();
            m = tdao.obtenerPorID(medit);
        } else 
            response.sendRedirect("listarMedicamentos.jsp");
        
        if (m.getNombre().equals("") || m.getTipo().equals(""))
            response.sendRedirect("listarMedicamentos.jsp");
    %>
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
                            <input type="text" id="inputNombre" class="input-medium" name="inputNombre" required onkeypress="permite(this,'car');" value="<%=m.getNombre()%>">
    			</div>
    		</div>
    		<div class="control-group">
    			<label class="control-label" for="textAreaDesc">Descripci&oacute;n</label>
    			<div class="controls">
    				<textarea row=3 id="textAreaDesc" class="input-medium" name="textAreaDesc"><%=m.getDescripcion()%></textarea> 
    			</div>
    		</div>
            <div class="control-group">
                <label class="control-label" for="inputTipo">Tipo</label>
                <div class="controls">
                    <input type="text" id="inputTipo" class="input-medium" name="inputTipo" required onkeypress="permite(this,'num_car');" value="<%=m.getTipo()%>">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputCosto" >Costo</label>
                <div class="controls">
                <div class="input-prepend" class="control-group">
                    <span class="add-on" >$</span> 
                    <input type="text" id="inputCosto" id="prependedInput" class="input-medium" name="inputCosto" onkeypress="permite(this,'num');" required value="<%=m.getCosto()%>"/> 
                </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputCantidad">Cantidad</label>
                <div class="controls">
                    <input type="text" id="inputCantidad" class="input-medium" name="inputCantidad" onkeypress="permite(this,'num');" required value="<%=m.getCantidad()%>"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputUMedida">Unidad de medida</label>
                <div class="controls">
                    <input type="text" id="inputUMedida" class="input-medium" name="inputUMedida" onkeypress="permite(this,'num_car_sim');" required value="<%=m.getUnidadMedida()%>"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputLote">Lote</label>
                <div class="controls">
                    <input type="text" id="inputLote" class="input-medium" name="inputLote" onkeypress="permite(this,'num');" required value="<%=m.getLote()%>"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputFVencimiento">Fecha de vencimiento</label>
                <div class="controls">
                    <input type="date" id="inputFVencimiento" class="input-medium" name="inputFVencimiento" required value="<%=m.getFechaVencimiento()%>"/>
                </div>
            </div>
    		<div class="controls">
    			<button type="submit" style="margin-right: 0.5em;" class="btn btn-success btn-large pull-left">Actualizar</button>                    
                        <a class="btn pull-left btn-large" href="../admin/listarMedicamentos.jsp">Cancelar</a>
                         <input type="hidden" name="accion" value="editar"/>
                         <input type="hidden" name="medNombre" value="<%=m.getNombre()%>"/>
                         <input type="hidden" name="medTipo" value="<%=m.getTipo()%>"/>
    		</div>  
    	</fieldset>  
    </form>
               </section>
              </div>
             </div> 
            </div>                         
                            
                    
      </div>
   </div>
   </div>
        <jsp:include page="/views/parts/footer.jsp"></jsp:include> 
  </body>
</html>
