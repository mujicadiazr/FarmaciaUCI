/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.servlets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import uci.cu.dao.impl.TrabajadorDAO;
import uci.cu.logic.Trabajador;

/**
 *
 * @author randy
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String accion = request.getParameter("accion");
            
            if (accion != null) {
                    request.getSession().setAttribute("session", null);
                    request.getSession().setAttribute("venta", null);
                    request.getSession().setAttribute("informe", null);
                    response.sendRedirect("index.jsp");
                                
            } else {       
        
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");

            Trabajador t = new Trabajador(user, pass);
            Trabajador tsession = null;
            TrabajadorDAO persiste = new TrabajadorDAO();
            List lista = null;

            try {
                lista = persiste.listarTodos();
            } catch (Exception e) {
                log(e.getMessage());
            }

            if (lista.contains(t)) { //Si es un usuario del sistema
                if (((Trabajador)lista.get(lista.indexOf(t))).getContrasenna().equals(pass)){ //si clave bien

                    tsession = (Trabajador)lista.get(lista.indexOf(t));
                    HttpSession sess = request.getSession(true);
                    
                    sess.setAttribute("session", tsession);

                    if (((Trabajador)lista.get(lista.indexOf(t))).getRol().equals("admin")) {
                        response.sendRedirect("views/admin/accedidoAdmin.jsp");
                    } else if(((Trabajador)lista.get(lista.indexOf(t))).getRol().equals("dep")) {
                        response.sendRedirect("views/dep/accedidoDep.jsp");
                    } 

                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña entrada es incorrecta");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario entrado no existe en el sistema");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
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
