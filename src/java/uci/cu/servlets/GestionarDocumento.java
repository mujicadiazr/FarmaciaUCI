/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import uci.cu.dao.impl.InformeRecepcionDAO;
import uci.cu.dao.impl.MedicamentoDAO;
import uci.cu.dao.impl.ReclamacionDAO;
import uci.cu.logic.InformeMedicamento;
import uci.cu.logic.InformeRecepcion;
import uci.cu.logic.Medicamento;
import uci.cu.logic.Reclamacion;
import uci.cu.logic.Trabajador;
import uci.cu.logic.Validator;

/**
 *
 * @author randy
 */
@WebServlet(name = "GestionarDocumento", urlPatterns = {"/GestionarDocumento"})
public class GestionarDocumento extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        String nombre,descripcion,tip,unidadMedida,ds;
        Date fechaVencimiento;
        
        float costo;
        int cantidad, lote;
        
        InformeMedicamento im = null;
        
        
        try {
        switch(accion) {
            case "agregarMedicamneto":
                
                String tipo = request.getParameter("t");
                im = (InformeMedicamento)request.getSession(false).getAttribute("informe");
                                
                //Si es un medicamento nuevo, no existe en la farmacia
                if (tipo.equals("new")) {
                    nombre = request.getParameter("inputNombre");
                    descripcion = request.getParameter("textAreaDesc");
                    tip = request.getParameter("inputTipo");
                    costo = Float.parseFloat(request.getParameter("inputCosto"));    
                    cantidad = Integer.parseInt(request.getParameter("inputCantidad"));
                    unidadMedida = request.getParameter("inputUMedida");
                    lote = Integer.parseInt(request.getParameter("inputLote"));
                    ds = request.getParameter("inputFVencimiento");
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    long mili = df.parse(ds).getTime();
                    fechaVencimiento = new Date(mili);
                  
                     if(Validator.EsNombre(nombre)&&Validator.LetrasNumeros(unidadMedida)
                         &&Validator.LetrasNumeros(tip))
                    {
                        Medicamento t = new Medicamento(nombre, descripcion, tip, costo, cantidad, unidadMedida, lote, fechaVencimiento);
                        im.getListaMed().add(t);
                        im.getListaEstado().add('n');
                    }
                     else
                    {
                     JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                    }
                   
                
                //Si es uno que ya existe    
                } else if (tipo.equals("exi")) {
                    int pos = Integer.parseInt(request.getParameter("selectMed"));
                    
                    cantidad  = Integer.parseInt(request.getParameter("inputCantidad"));
                    Medicamento m =(Medicamento)(new MedicamentoDAO()).listarTodos().get(pos);
                    m.setCantidad(cantidad);
                    
                    im.getListaMed().add(m);
                    im.getListaEstado().add('e');
                }
                
                response.sendRedirect("views/admin/crearInforme.jsp");
                break;
                
            case "crearInforme":
                
                im = (InformeMedicamento)request.getSession(false).getAttribute("informe");
                InformeRecepcion ir = new InformeRecepcion();
                float importe = 0;
                String trabajadorUsuario = ((Trabajador)request.getSession(false).getAttribute("session")).getUsuario();
                String datosFactura = ""; 
                Date fecha = new Date(new java.util.Date().getTime());        
                
                //Valido que hayan medicamentos en InformeMedicamento para poder hacer el informe
                if (im.getListaMed().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe agregar los medicamentos recibidos");
                    response.sendRedirect("views/admin/crearInforme.jsp");
                    break;
                }
                
                for (int i=0; i<im.getListaMed().size(); i++) {
                    datosFactura += im.getListaMed().get(i).toString() + "\n";
                    importe += im.getListaMed().get(i).getCosto() * im.getListaMed().get(i).getCantidad();
                    //Si el medicamento es nuevo, lo agrego a los medicamentos
                    if (im.getListaEstado().get(i) == 'n')
                        (new MedicamentoDAO()).salvar(im.getListaMed().get(i));
                    
                    //Si existe modifico la cantidad
                    if (im.getListaEstado().get(i) == 'e'){
                        Medicamento temp = (new MedicamentoDAO()).obtenerPorID(im.getListaMed().get(i));
                        temp.setCantidad(temp.getCantidad() + im.getListaMed().get(i).getCantidad());
                        (new MedicamentoDAO()).modificar(temp, temp);
                    }
                }
                
                ir.setDatosFactura(datosFactura);
                ir.setFecha(fecha);
                ir.setImporte(importe);
                ir.setTrabajadorUsuario(trabajadorUsuario);
                
                (new InformeRecepcionDAO()).salvar(ir);
                //Borramos el informe que esta en la session
                request.getSession(false).setAttribute("informe", null);
                
                JOptionPane.showMessageDialog(null, "Informe de recepcion creado correctamente");
                response.sendRedirect("views/admin/listarMedicamentos.jsp");
                break;
            
            
            case "cancelarInforme":
                request.getSession(false).setAttribute("informe", null);
                response.sendRedirect("views/admin/accedidoAdmin.jsp");
                break;
            case "eliminarInforme":
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar?") != 0){
                        response.sendRedirect("views/admin/listarInformeRecepcion.jsp");
                        break;
                    }  
                
                int id = Integer.parseInt(request.getParameter("id"));
                (new InformeRecepcionDAO()).eliminar(new InformeRecepcion(id));
                JOptionPane.showMessageDialog(null, "Informe eliminado");
                response.sendRedirect("views/admin/listarInformeRecepcion.jsp");
                break;
            case "crearReclamacion":
                int inputCantidadReal = Integer.parseInt(request.getParameter("inputCantidadReal"));
                int inputCantidadPlanilla = Integer.parseInt(request.getParameter("inputCantidadPlanilla"));
                int selectMed = Integer.parseInt(request.getParameter("selectMed"));
                Medicamento m = (Medicamento)(new MedicamentoDAO()).listarTodos().get(selectMed);
                
                String datosReales = "Nombre: "+m.getNombre()+" Tipo: "+m.getTipo()+" Cantidad: "+inputCantidadReal;
                String sdatosFactura = "Nombre: "+m.getNombre()+" Tipo: "+m.getTipo()+" Cantidad: "+inputCantidadPlanilla;
                String strabajadorUsuario = ((Trabajador)request.getSession(false).getAttribute("session")).getUsuario();
                Date sfecha = new Date(new java.util.Date().getTime());
                
                Reclamacion r = new Reclamacion();
                r.setDatosFactura(sdatosFactura);
                r.setDatosReales(datosReales);
                r.setTrabajadorUsuario(strabajadorUsuario);
                r.setFecha(sfecha);
                
                (new ReclamacionDAO()).salvar(r);
                response.sendRedirect("views/admin/accedidoAdmin.jsp");
                
                break;
                
                case "eliminarReclamacion" :
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar?") != 0){
                        response.sendRedirect("views/admin/listarReclamacion.jsp");
                        break;
                    }   
                    
                    int ids = Integer.parseInt(request.getParameter("id"));
                    (new InformeRecepcionDAO()).eliminar(new InformeRecepcion(ids));
                    JOptionPane.showMessageDialog(null, "Reclamacion eliminada");
                    response.sendRedirect("views/admin/listarReclamacion.jsp");
                break;
                    
                case "imprimirInforme" :
                    response.sendRedirect("views/admin/listarInformeRecepcion.jsp");
                break;
                case "imprimirReclamacion" :
                    response.sendRedirect("views/admin/listarReclamacion.jsp");
                break;
        }
        } catch (Exception e) {
            log(e.getMessage());
            JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
            response.sendRedirect("views/admin/accedidoAdmin.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
