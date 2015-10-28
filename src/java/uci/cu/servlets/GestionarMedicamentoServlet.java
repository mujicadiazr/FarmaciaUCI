/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import sun.util.calendar.BaseCalendar;
import uci.cu.dao.impl.MedicamentoDAO;
import uci.cu.dao.impl.TrabajadorDAO;
import uci.cu.dao.impl.ValeDAO;
import uci.cu.dao.impl.VentaMedicamentoDAO;
import uci.cu.logic.Medicamento;
import uci.cu.logic.Trabajador;
import uci.cu.logic.Vale;
import uci.cu.logic.Validator;
import uci.cu.logic.VentaMedicamento;
import uci.cu.util.AutenticacionLDAP;

/**
 *
 * @author randy
 */
@WebServlet(name = "GestionarMedicamentoServlet", urlPatterns = {"/GestionarMedicamentoServlet"})
public class GestionarMedicamentoServlet extends HttpServlet {

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String accion = request.getParameter("accion");
                        
     Medicamento t,teditar;
     MedicamentoDAO  tdao = new MedicamentoDAO();
        
     String nombre = "", descripcion = "", tipo= "" , unidadMedida= "", nombreEdit= "", tipoEdit= "";
     float costo = 0.0F;
     int cantidad = 0, lote = 0, cantidadAVender = 0; 
     Date fechaVencimiento = null;
           
     
        switch (accion) {
            case "crear" :
                                  
                try {
                    nombre = request.getParameter("inputNombre");
                    descripcion = request.getParameter("textAreaDesc");
                    tipo = request.getParameter("inputTipo");
                    costo = Float.parseFloat(request.getParameter("inputCosto"));    
                    cantidad = Integer.parseInt(request.getParameter("inputCantidad"));
                    unidadMedida = request.getParameter("inputUMedida");
                    lote = Integer.parseInt(request.getParameter("inputLote"));
                    
                    String ds = request.getParameter("inputFVencimiento");
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    long mili = df.parse(ds).getTime();
                    
                    fechaVencimiento = new Date(mili);
                    
                } catch(Exception e) {
                    log(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                    
                    response.sendRedirect("views/admin/listarMedicamentos.jsp");
                    break;
                }
                 
                if(Validator.EsNombre(nombre)&&Validator.EsNombre(tipo)
                        &&Validator.LetrasNumeros(unidadMedida))
                {
                    t = new Medicamento(nombre, descripcion, tipo, costo, cantidad, unidadMedida, lote, fechaVencimiento);
                    try {
                        tdao.salvar(t);
                    } catch(Exception e) {
                        log(e.getMessage());
                    }JOptionPane.showMessageDialog(null, "Medicamento creado");
                }else{
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                }
                
                response.sendRedirect("views/admin/accedidoAdmin.jsp");
                break;
            case "editar" :
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea guardar los cambios?") != 0){
                        response.sendRedirect("views/admin/listarMedicamentos.jsp");
                        break;
                    } 
                 nombreEdit = request.getParameter("medNombre");
                 tipoEdit = request.getParameter("medTipo");
                
                 try {
                    nombre = request.getParameter("inputNombre");
                    descripcion = request.getParameter("textAreaDesc");
                    tipo = request.getParameter("inputTipo");
                    costo = Float.parseFloat(request.getParameter("inputCosto"));    
                    cantidad = Integer.parseInt(request.getParameter("inputCantidad"));
                    unidadMedida = request.getParameter("inputUMedida");
                    lote = Integer.parseInt(request.getParameter("inputLote"));
                    
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    long mili = df.parse(request.getParameter("inputFVencimiento")).getTime();
                    
                    fechaVencimiento = new Date(mili);
                } catch(Exception e) {
                    log(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                    response.sendRedirect("views/admin/listarMedicamentos.jsp");
                    break;
                }
                 
                 if(Validator.EsNombre(nombre)&&Validator.EsNombre(tipo)
                        &&Validator.LetrasNumeros(unidadMedida))
                {
                    t = new Medicamento(nombre, descripcion, tipo, costo, cantidad, unidadMedida, lote, fechaVencimiento);
                    teditar = new Medicamento(nombreEdit, tipoEdit);
                    try {
                        tdao.modificar(teditar, t);
                    } catch(Exception e) {
                        log(e.getMessage());
                    }JOptionPane.showMessageDialog(null, "Editado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                }
                 
                response.sendRedirect("views/admin/listarMedicamentos.jsp");
                break;
            case "eliminar" :
                
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar?") != 0){
                    response.sendRedirect("views/admin/listarMedicamentos.jsp");
                    break;
                }
                
                
                nombre = request.getParameter("nombre");
                tipo = request.getParameter("tipo");
                t = new Medicamento(nombre, tipo);
                
                try {
                    tdao.eliminar(t);
                } catch(Exception e) {
                    log(e.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                response.sendRedirect("views/admin/listarMedicamentos.jsp");
                break;
            case "listar" :
                response.sendRedirect("views/admin/listarMedicamentos.jsp");
                break;
            
            default:
                response.sendRedirect("views/admin/listarMedicamentos.jsp");
            
                
        }
        
        
        
    }   
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
