<%-- 
    Document   : buscarMedicamento
    Created on : Jun 17, 2013, 11:21:23 PM
    Author     : randy
--%>
<%@page import="uci.cu.util.DISPATCHER"%>
<%@page import="uci.cu.logic.Medicamento"%>
<%@page import="uci.cu.dao.impl.MedicamentoDAO"%>
<%@page import="uci.cu.dao.impl.VueltaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uci.cu.logic.Vuelta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
   </head>
<% DISPATCHER.redirect("../../index.jsp", response, request); %>
  <body data-spy="scroll" data-target=".bs-docs-sidebar">
        <jsp:include page="/views/parts/navbar.jsp"></jsp:include>
        <jsp:include page="/views/parts/banner.jsp"></jsp:include>    
      <div class="container">
            <div class="row">
            <jsp:include page="../parts/menuAdmin.jsp"></jsp:include>
               <div class="span9">
                    <section>
                    <!--Aki va el formulario-->
                        <legend>Adicionar medicamentos al Informe de Recepci&oacute;n</legend>
                            <div>
                                <ul id="tabMed" class="nav nav-tabs">
                                  <li class=""><a href="#nuevo" data-toggle="tab">Nuevo</a></li>
                                  <li class="active"><a href="#existente" data-toggle="tab">Existente</a></li>
                                </ul>
                                <div id="myTabContent" class="tab-content">
                                  <div class="tab-pane fade" id="nuevo">
                                      <!--Aqui va el formulario-->
                                      <form action="../../GestionarDocumento" method="post">
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
                                                    <input type="text" id="inputCosto" class="input-medium" onkeypress="return permite(event,'num');" name="inputCosto" required/> 
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
                                                    <button type="submit" class="btn pull-left btn-large btn-success" style="margin-right: 0.5em">Agregar</button>
                                                   <a class="btn pull-left btn-large" href="../admin/crearInforme.jsp">Cancelar</a>
                                                   <input type="hidden" name="accion" value="agregarMedicamneto"/>
                                                   <input type="hidden" name="t" value="new"/>
                                            </div> 
                                        </fieldset>  
                                    </form>
                                  </div>
                                  <div class="tab-pane fade active in" id="existente">
                                      <!--El existente va aqui-->
                                      <form action="../../GestionarDocumento" method="post">
                                      
                                            <select name="selectMed">
                                              <%
                                                  MedicamentoDAO mdao = new MedicamentoDAO();
                                                  List lista = null;

                                                  try {
                                                      lista = mdao.listarTodos();
                                                  }catch (Exception e) {}

                                                  for (int i = 0; i < lista.size(); i++) {
                                              %>
                                              <option value="<%=i%>">Nombre: "<%=((Medicamento)lista.get(i)).getNombre()%>" Tipo: "<%=((Medicamento)lista.get(i)).getTipo()%>"</option>
                                              <%}%>
                                          </select>
                                          <label class="control-label" for="inputCantidad">Cantidad</label>
                                          <input type="text" id="inputCantidad" class="input-medium" name="inputCantidad" onkeypress="return permite(event,'num');" required />
                                          
                                          <div class="controls" >
                                                   <button type="submit" class="btn pull-left btn-large btn-success" style="margin-right: 0.5em">Agregar</button>
                                                   <a class="btn pull-left btn-large" href="../admin/crearInforme.jsp">Cancelar</a>
                                                   <input type="hidden" name="accion" value="agregarMedicamneto"/>
                                                   <input type="hidden" name="t" value="exi"/>
                                            </div> 
                                      </form>
                                  </div>
                                </div>
                              </div>
                        
                    </section>
               </div>
           </div>
      </div>
      <jsp:include page="/views/parts/footer.jsp"></jsp:include>
      <script src="../../js/busquedas.js" type="text/javascript"></script>
  </body>
</html>