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
import uci.cu.dao.impl.MedicamentoDAO;
import uci.cu.dao.impl.SuscripcionDAO;
import uci.cu.logic.Medicamento;
import uci.cu.logic.Suscripcion;
import uci.cu.logic.Validator;

/**
 *
 * @author randy
 */
@WebServlet(name = "GestionarSuscripcionServlet", urlPatterns = {"/GestionarSuscripcionServlet"})
public class GestionarSuscripcionServlet extends HttpServlet {

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
                        
     Suscripcion s,seditar;
             
     String ci="",nombre="",primerApell="",segundoApell="",suscripcionToEdit="";
    
           
     
        switch (accion) {
            case "crear" :
                                  
                try {
                    ci = request.getParameter("inputCi");
                    nombre = request.getParameter("inputNombre");
                    primerApell= request.getParameter("inputPrimerApell");
                    segundoApell= request.getParameter("inputSegundoApell");
                    
                } catch(Exception e) {
                    log(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                    response.sendRedirect("views/admin/accedidoAdmin.jsp");
                break;
                }
                 
                if(Validator.EsNombre(nombre)&&Validator.EsNumero(ci)&&Validator.EsNombre(primerApell)&&Validator.EsNombre(segundoApell)
                         )
                {
                    s = new Suscripcion(ci, nombre, primerApell, segundoApell);
                    try {
                        (new SuscripcionDAO()).salvar(s);
                    } catch(Exception e) {
                        log(e.getMessage());
                    }JOptionPane.showMessageDialog(null, "Suscripcion creada");
                }else {
                      JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                  }
                
                response.sendRedirect("views/admin/accedidoAdmin.jsp");
                break;
            case "editar" :
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea guardar los cambios?") != 0){
                        response.sendRedirect("views/admin/listarSuscripcion.jsp");
                        break;
                    } 
                 suscripcionToEdit = request.getParameter("suscripcionToEdit");
                                 
                 try {
                    ci = request.getParameter("inputCi");
                    nombre = request.getParameter("inputNombre");
                    primerApell= request.getParameter("inputPrimerApell");
                    segundoApell= request.getParameter("inputSegundoApell");
              
                } catch(Exception e) {
                    log(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                    response.sendRedirect("views/admin/listarSuscripcion.jsp");
                break;
                }
                 
                if(Validator.EsNombre(nombre)&&Validator.EsNumero(ci)&&Validator.EsNombre(primerApell)&&Validator.EsNombre(segundoApell)
                         )
                { 
                    s = new Suscripcion(ci, nombre, primerApell, segundoApell);
                    seditar = new Suscripcion(suscripcionToEdit);
                    try {
                        (new SuscripcionDAO()).modificar(seditar, s);
                    } catch(Exception e) {
                        log(e.getMessage());
                        response.sendRedirect("views/admin/listarSuscripcion.jsp");
                    break;
                    }JOptionPane.showMessageDialog(null, "Suscripcion editada");
                }else{
                    JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                }
                
                response.sendRedirect("views/admin/listarSuscripcion.jsp");
                break;
            case "eliminar" :
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar?") != 0){
                        response.sendRedirect("views/admin/listarSuscripcion.jsp");
                        break;
                    } 
                ci = request.getParameter("ci");
                s = new Suscripcion(ci);
                
                try {
                    (new SuscripcionDAO()).eliminar(s);
                } catch(Exception e) {
                    log(e.getMessage());
                }
                JOptionPane.showMessageDialog(null, "suscripcion eliminada");
                response.sendRedirect("views/admin/listarSuscripcion.jsp");
                break;
            case "listar" :
                response.sendRedirect("views/admin/listarSuscripcion.jsp");
                break;
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
