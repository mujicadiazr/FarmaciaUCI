<%-- 
    Document   : buscarMedicamento
    Created on : Jun 17, 2013, 11:21:23 PM
    Author     : randy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <jsp:include page="/views/parts/title.jsp"></jsp:include>
    <jsp:include page="/views/parts/head.jsp"></jsp:include>
   </head>
<%@page import="uci.cu.util.DISPATCHER"%>
  <% DISPATCHER.redirect("../../index.jsp", response, request); %>
  <body data-spy="scroll" data-target=".bs-docs-sidebar">
        <jsp:include page="/views/parts/navbar.jsp"></jsp:include>
        <jsp:include page="/views/parts/banner.jsp"></jsp:include>    
      <div class="container">
            <div class="row">
                <jsp:include page="../parts/menuDep.jsp"></jsp:include>
               <div class="span9">
                    <section>
                    <!--Aki va el formulario-->
                        <ul class="nav ">
                            <li class="dropdown">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">
                                    Seleccionar
                                    <span class="caret pagination-centered"></span>
                                    </a>
                                <ul class="dropdown-menu" id="uno" >
                                            <li onclick="accionNav(this)"><a href="#" ><i class="icon-pencil"></i>Tipo</a></li>
                                            <li onclick="accionNav(this)"><a href="#" ><i class="icon-ban-circle"></i>Nombre</a></li>
                                            <li onclick="accionNav(this)"><a href="#"><i class="icon-pencil"></i>Costo</a></li>
                                            <li onclick="accionNav(this)"><a href="#"><i class="icon-pencil"></i>Cantidad</a></li>
                                            <li onclick="accionNav(this)"><a href="#"><i class="icon-pencil"></i>Unidad Medida</a></li>
                                            <li onclick="accionNav(this)"><a href="#"><i class="icon-pencil"></i>Lote</a></li>
                                            <li onclick="accionNav(this)"><a href="#"><i class="icon-pencil"></i>Fecha de Vencimiento</a></li>
                                    </ul>
                            </li>
                        </ul>
                        <form class="form-search">
                                <fieldset>
                                        <legend>Criterios de b&uacute;squeda</legend>
                                        <div class="input-append" id="divapp">

                                                <input type="text" class="span2 search-query" id="default" placeholder="Nombre"></input>
                                                <span class="add-on btn btn-close" onclick="accionClose(this)"><a class="icon-remove"></a></span>
                                        </div>
                                        <button type="submit" id="btnFind" class="btn disabled">Buscar<i class="icon-search icon-blue"></i></button>

                                </fieldset>
                        </form>
                    </section>
               </div>
           </div>
      </div>
      <jsp:include page="/views/parts/footer.jsp"></jsp:include>
      <script src="../../js/busquedas.js" type="text/javascript"></script>
  </body>
</html>
