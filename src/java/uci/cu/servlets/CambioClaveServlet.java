/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.IconView;
import uci.cu.dao.impl.TrabajadorDAO;
import uci.cu.logic.Trabajador;

/**
 *
 * @author randy
 */
@WebServlet(name = "CambioClaveServlet", urlPatterns = {"/CambioClaveServlet"})
public class CambioClaveServlet extends HttpServlet {

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
         
         Trabajador t;
        TrabajadorDAO tdao = new TrabajadorDAO();
        
        switch(accion) {
            case "cambiaPassDep" :
                String passOld = request.getParameter("passOld");
                String passNew = request.getParameter("passNew");
                String passConfirmNew = request.getParameter("passConfirmNew");
                
                              
                t = (Trabajador)request.getSession(false).getAttribute("session");
                if (passOld.equals(t.getContrasenna()) && passNew.equals(passConfirmNew)) {
                    Trabajador tnew = t;
                    tnew.setContrasenna(passNew);
                    
                    try {
                        tdao.modificar(t, tnew);
                    } catch(Exception e) {
                        log(e.getMessage());
                    }JOptionPane.showMessageDialog(null, "Clave cambiada");
                }
                else if (!passOld.equals(t.getContrasenna()))
                {
                    JOptionPane.showMessageDialog(null, "Clave Incorrecta", "Error en autenticación", 0, null);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Claves no coinciden", "Error en autenticación", 0, null);
                }
                
                response.sendRedirect("views/dep/accedidoDep.jsp");               
                
                break;
            case "cambiaPassAdmin" :
                
                
                break;
                
            default:                
                
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
