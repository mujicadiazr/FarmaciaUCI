<%-- 
    Document   : menuAdmin
    Created on : May 19, 2013, 7:12:22 AM
    Author     : randy
--%>
<div class="span3 bs-docs-sidebar" >
    <ul class="nav nav-list bs-docs-sidenav">
	<li class="dropdown-submenu">
            <a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Usuario</a>
            <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                <li><a href="../admin/crearUsuario.jsp">Crear</a></li>
                <li><a href="../admin/listarUsuarios.jsp">Listar</a></li>                
            </ul>
        </li>
        
        <li class="dropdown-submenu">
            <a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Medicamento</a>
	    <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                <li><a href="../admin/crearMedicamento.jsp">Crear</a></li>
                <li><a href="../admin/listarMedicamentos.jsp">Listar</a></li>		
            </ul>
        </li>
        
        <li class="dropdown-submenu">
            <a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Almohadillas Sanitarias</a>
            <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                <li class="dropdown-submenu"><a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Vuelta</a>
                    <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                        <li><a href="../admin/crearVuelta.jsp">Crear</a></li>
                        <li><a href="../admin/listarVueltas.jsp">Listar</a></li>                        
                    </ul>
                </li>
                <li class="dropdown-submenu">
                    <a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Suscripci&oacute;n</a>
                    <ul class="nav nav-list bs-docs-sidenav dropdown-menu">                
                        <li><a href="../admin/crearSuscripcion.jsp">Crear</a></li>
                        <li><a href="../admin/listarSuscripcion.jsp">Listar</a></li>		
                    </ul>
                </li>
            </ul>
        </li>
	
        	
         
        <li class="dropdown-submenu">
            <a tabindex="-1" href="#"><i class="icon-chevron-right"></i> Documentos</a>
            <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                <li class="dropdown-submenu"><a tabindex="-1" href="#"> <i class="icon-chevron-right"></i>Informe de recepci&oacute;n</a>
                    <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                        <li><a href="../admin/crearInforme.jsp">Crear</a></li>
                        <li><a href="../admin/listarInformeRecepcion.jsp">Listar</a></li>
                    </ul>
                </li>
                <li class="dropdown-submenu"><a tabindex="-1" href="#"> <i class="icon-chevron-right"></i>Reclamaci&oacute;n</a>
                    <ul class="nav nav-list bs-docs-sidenav dropdown-menu">
                        <li><a href="../admin/crearReclamacion.jsp">Crear</a></li>
			<li><a href="../admin/listarReclamacion.jsp">Listar</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>                 
</div>
