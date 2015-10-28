<%-- 
    Document   : accedidoAdmin
    Created on : May 18, 2013, 3:35:43 AM
    Author     : randy
--%>
<%@page import="uci.cu.util.DISPATCHER"%>
<%@page import="uci.cu.logic.Medicamento"%>
<%@page import="java.util.List"%>
<%@page import="uci.cu.dao.impl.MedicamentoDAO"%>
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
                        <legend>Crear Reclamaci&oacute;n</legend>
                        <form class="form-inline"method="post" action="../../GestionarDocumento">
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
                                <label class="control-label" for="inputCantidad">Cantidad Real</label>
                                    <input type="text" id="inputCantidad" class="input-medium" name="inputCantidadReal" required onkeypress="return permite(event,'num');" />
                                <label class="control-label" for="inputCantidad">Cantidad en Planilla</label>
                                    <input type="text" id="inputCantidad" class="input-medium" name="inputCantidadPlanilla" onkeypress="return permite(event,'num');" required />
                                    <div class="controls" >
                                        <button type="submit" class="btn pull-left btn-large btn-success" style="margin-right: 0.5em">Agregar</button>
                                        <a class="btn pull-left btn-large" href="../admin/accedidoAdmin.jsp">Cancelar</a>
                                        <input type="hidden" name="accion" value="crearReclamacion"/>
                                    </div>  
                        </form>
                    </section>
                </div>
            </div>
        </div>
        <jsp:include page="/views/parts/footer.jsp"></jsp:include> 
  </body>
</html>