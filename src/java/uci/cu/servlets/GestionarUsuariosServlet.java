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
import javax.swing.JOptionPane;
import uci.cu.dao.impl.TrabajadorDAO;
import uci.cu.logic.Trabajador;
import uci.cu.logic.Validator;

/**
 *
 * @author randy
 */
@WebServlet(name = "GestionarUsuariosServlet", urlPatterns = {"/GestionarUsuariosServlet"})
public class GestionarUsuariosServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
                
        Trabajador t,teditar;
        TrabajadorDAO tdao = new TrabajadorDAO();
        
        String ci, nombre, primerApellido, segundoApellido, direccionParticular, usuario,
               contrasenna, rol, usuarioEditar, telefono;
        
        switch (accion) {
            case "crear" :
                 ci = request.getParameter("inputCi");
                 nombre = request.getParameter("inputNombre");
                 primerApellido = request.getParameter("inputPrimerApell");
                 segundoApellido = request.getParameter("inputSegundoApell");    
                 telefono = request.getParameter("inputTelf");
                 direccionParticular = request.getParameter("inputDirParticular");
                 usuario = request.getParameter("inputUser");
                 contrasenna = request.getParameter("inputPass");
                 rol = request.getParameter("selectRol");
                
                 if(!Validator.ExisteUsuario(usuario,ci))
                 {  
                     if(Validator.EsNombre(nombre)&&Validator.EsNumero(ci)&&Validator.EsNombre(primerApellido)&&Validator.EsNombre(segundoApellido)
                         &&Validator.EsNumero(telefono)&&Validator.EsRol(rol)&&Validator.LetrasNumeros(usuario))
                    {
                        t = new Trabajador(ci, nombre, primerApellido, segundoApellido, telefono, direccionParticular, usuario, contrasenna, rol);
                        try {
                            tdao.salvar(t);
                        } catch(Exception e) {
                            int pinga;
                            System.out.print("dddfd");
                        }
                        JOptionPane.showMessageDialog(null, "Creado correctamente");
                    }
                     else
                    {
                     JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                    }
                }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "El usuario o el ci ya existe en el sistema");
                 }
                 
                response.sendRedirect("views/admin/accedidoAdmin.jsp");
                break;
            case "editar" :
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea guardar los cambios?") != 0){
                        response.sendRedirect("views/admin/listarUsuarios.jsp");
                        break;
                    } 
                 usuarioEditar = request.getParameter("userToEdit");
                
                 ci = request.getParameter("inputCi");
                 nombre = request.getParameter("inputNombre");
                 primerApellido = request.getParameter("inputPrimerApell");
                 segundoApellido = request.getParameter("inputSegundoApell");    
                 telefono = request.getParameter("inputTelf");
                 direccionParticular = request.getParameter("inputDirParticular");
                 usuario = request.getParameter("inputUser");
                 contrasenna = request.getParameter("inputPass");
                 rol = request.getParameter("selectRol");

                 if(Validator.EsNombre(nombre)&&Validator.EsNumero(ci)&&Validator.EsNombre(primerApellido)&&Validator.EsNombre(segundoApellido)
                         &&Validator.EsNumero(telefono)&&Validator.EsRol(rol)&&Validator.LetrasNumeros(usuario))
                 {
                    t = new Trabajador(ci, nombre, primerApellido, segundoApellido, telefono, direccionParticular, usuario, contrasenna, rol);
                    teditar = new Trabajador(usuarioEditar);
                    try {
                        tdao.modificar(teditar, t);
                    } catch(Exception e) {
                        log(e.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "Editado correctamente");
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Los datos no tienen el formato requerido");
                 }
                 
                response.sendRedirect("views/admin/listarUsuarios.jsp");
                break;
            case "eliminar" :
                if (JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar?") != 0){
                    response.sendRedirect("views/admin/listarUsuarios.jsp");
                    break;
                }
                
                usuario = request.getParameter("usuario");
                t = new Trabajador(usuario);
                
                try {
                    tdao.eliminar(t);
                } catch(Exception e) {
                    log(e.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                response.sendRedirect("views/admin/listarUsuarios.jsp");
                break;
                        case "listar" :
                response.sendRedirect("views/admin/listarUsuarios.jsp");
            default:
                response.sendRedirect("views/admin/listarUsuarios.jsp");                
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
