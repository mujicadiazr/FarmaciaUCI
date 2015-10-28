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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.postgresql.jdbc2.EscapedFunctions;
import uci.cu.dao.impl.GestionAlmohadillaDAO;
import uci.cu.dao.impl.MedicamentoDAO;
import uci.cu.dao.impl.ValeDAO;
import uci.cu.dao.impl.VentaMedicamentoDAO;
import uci.cu.dao.impl.VueltaDAO;
import uci.cu.logic.GestionAlmohadilla;
import uci.cu.logic.Medicamento;
import uci.cu.logic.Trabajador;
import uci.cu.logic.Vale;
import uci.cu.logic.Validator;
import uci.cu.logic.Venta;
import uci.cu.logic.VentaMedicamento;
import uci.cu.logic.Vuelta;

/**
 *
 * @author randy
 */
@WebServlet(name = "VentaServlet", urlPatterns = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {

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
        String nombre,tipo;
        int cantidad;
                
        Medicamento m;
        MedicamentoDAO mdao = new MedicamentoDAO();
        
        
        HttpSession session = request.getSession(false);
        Venta objVenta = (Venta)session.getAttribute("venta");
        
        try {
        
            switch(accion) {
                case "agregarVenta" :
                    //Cogemos los datos del medicamento a vender
                    nombre = request.getParameter("inputNombre");
                    tipo = request.getParameter("inputTipo");
                    cantidad = Integer.parseInt(request.getParameter("inputCant"));
                    
                    //Comprobamos que la cantidad a vender sea mayor que cero
                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(null, "La cantidad de Medicamento a vender debe ser mayor que cero");
                        response.sendRedirect("views/dep/listarMedicamentos.jsp");
                        break;
                    }
                    
                    //Comprobamos si hay suficiente Medicamento como para realizar la venta
                    if (!Validator.SuficienteMedicamento(new Medicamento(nombre, tipo, cantidad))) {
                        JOptionPane.showMessageDialog(null, "No hay suficiente medicamento para realizar dicha venta");
                        response.sendRedirect("views/dep/listarMedicamentos.jsp");           
                        break;
                    }
                    
//                    if (!Validator.EsNombre(nombre)) {
//                        JOptionPane.showMessageDialog(null, "El nombre no es valido");
//                        response.sendRedirect("views/dep/listarMedicamentos.jsp");           
//                        break;
//                    }
//                    if (!Validator.LetrasNumeros(tipo)){
//                        JOptionPane.showMessageDialog(null, "No hay suficiente medicamento para realizar dicha venta");
//                        response.sendRedirect("views/dep/listarMedicamentos.jsp");           
//                        break;
//                    }
                    
                    if (objVenta == null) { // Si no hay venta creada aun
                        Calendar hoy = Calendar.getInstance();
                        objVenta = new Venta(); //Creamos una nueva venta
                        
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String ds = df.format(new java.util.Date());
                                                
                        long mili = df.parse(ds).getTime();
                        
//                        //Creamos el vale con la fecha y hora actuales
                        Vale objVale = new Vale(new Date(new java.util.Date().getTime()),new Time(new java.util.Date().getTime()));
                        (new ValeDAO()).salvar(objVale); //Guardamos el Vale en la BD
                        objVale = (new ValeDAO()).obtenerUltimoVale();//Como es ID autoincremental cojo el ultimo 
                        //seteamos el Vale a la venta
                        objVenta.setVale(objVale);
                        //seteamos el Trabajador a la Venta
                        objVenta.setUsuario((Trabajador)session.getAttribute("session"));
                        //Creamos la lista de Medicamentos de la Venta
                        objVenta.setListaMed(new ArrayList<Medicamento>());
                        
                        //Ahora podemos agregar el nuevo Medicacamento a la venta
                    }
                    
                    
                    //Agregamos el medicamento a la lista de venta
                    objVenta.getListaMed().add(new Medicamento(nombre, tipo, cantidad));
                    //Ahora podemos devolver nuestro objeto Venta a la session con el nuevo medicamento
                    session.setAttribute("venta", objVenta);
                    //Redireccionamos a la lista de Medicamentos de nuevo por si quiere seguir vendiendo
                    response.sendRedirect("views/dep/listarMedicamentos.jsp");
                    break;
                    
                case "confirmarVenta" :
                    List<Medicamento> listaMed = objVenta.getListaMed();
                    Vale objVale = objVenta.getVale();
                    Trabajador t = objVenta.getUsuario();
                    VentaMedicamento vm;
                    
                    for (int i=0; i<listaMed.size(); i++) {
                        //Creamos el registro de la Venta de cada Medicamento
                        vm = new VentaMedicamento(listaMed.get(i).getNombre(), 
                                                  listaMed.get(i).getTipo(), 
                                                  objVale.getId(),
                                                  t.getUsuario(),
                                                  listaMed.get(i).getCantidad());
                        //Lo guardamos en la BD
                        (new VentaMedicamentoDAO()).salvar(vm);
                        //Actualizamos la cantidad del Medicamento que queda
                        Medicamento actual = (new MedicamentoDAO()).obtenerPorID(listaMed.get(i));
                        actual.setCantidad(actual.getCantidad()-listaMed.get(i).getCantidad());
                        //Actualizamos la BD
                        (new MedicamentoDAO()).modificar(actual, actual);
                        
                        
                    }
                    //Eliminamos nuestra transaccion de Venta de la session
                    request.getSession().setAttribute("venta", null);
                    JOptionPane.showMessageDialog(null, "Venta realizada con exito");
                    
                    response.sendRedirect("views/dep/listarMedicamentos.jsp");
                    break;
                    
                case "cancelarVenta" :
                    //Eliminamos nuestra transaccion de Venta de la session
                    request.getSession().setAttribute("venta", null);
                    
                    response.sendRedirect("views/dep/listarMedicamentos.jsp");
                    break;
                case "vendeAlmo" :
                    String ci = request.getParameter("ci");
                    int idVuelta = (new VueltaDAO()).obtenerUltimaVuelta().getId();
                    String trabajadorUsuario = ((Trabajador)request.getSession(false).getAttribute("session")).getUsuario();
                    
                    if(!Validator.EsNumero(ci)||trabajadorUsuario==null)
                    {
                        JOptionPane.showMessageDialog(null, "CI no valido o trabajador no existe");
                        response.sendRedirect("views/dep/listarSuscripcion.jsp");
                        break;
                    }
                    
                    GestionAlmohadilla ga = new GestionAlmohadilla(idVuelta, ci, trabajadorUsuario);
                    (new GestionAlmohadillaDAO()).salvar(ga);
                    JOptionPane.showMessageDialog(null, "Venta realizada con exito");
                    
                    response.sendRedirect("views/dep/listarSuscripcion.jsp");
                    break;
                    
                case "crearVueltaVenta" :
                    String inputAnno = request.getParameter("inputAnno");
                    String inputMes = request.getParameter("inputMes");
                   
                    
                    //Valido que sea un anno correto
                    if (!Validator.EsAnno(inputAnno)) {
                        JOptionPane.showMessageDialog(null, "El anno entrado no es correcto");
                        response.sendRedirect("views/admin/accedidoAdmin.jsp");
                        break;
                    }
                    //Valido que sea un mes correto    
                    if (!Validator.EsMes(inputMes)) {
                        JOptionPane.showMessageDialog(null, "El mes entrado no es correcto");
                        response.sendRedirect("views/admin/accedidoAdmin.jsp");
                        break;
                    }
                    //Inserto al vuelta de venta en la BD
                    (new VueltaDAO()).salvar(new Vuelta(Integer.parseInt(inputAnno),
                            Integer.parseInt(inputMes)));
                    JOptionPane.showMessageDialog(null, "Vuelta creada con exito");
                    response.sendRedirect("views/admin/accedidoAdmin.jsp");
                    break;
                
                case "aVender":
                    Vuelta v= new Vuelta();
                    String p = request.getParameter("idv");
                    int a=0;
                    try{a=Integer.parseInt(p);}
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Error en el formato del id");
                        response.sendRedirect("views/admin/listarSuscripcion.jsp");
                        break;
                    };
                    v.setId(a);
                    Vuelta vu = new Vuelta();
                    vu=(new VueltaDAO()).obtenerPorID(v);
                    (new VueltaDAO()).eliminar(v);
                    (new VueltaDAO()).salvar(new Vuelta(vu.getAnno(),vu.getMes()));
                    JOptionPane.showMessageDialog(null, "Vuelta en venta");
                    response.sendRedirect("views/admin/listarSuscripcion.jsp");
                    break;
                    
                case "eliminar":
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro desea eliminar?") != 0){
                        response.sendRedirect("views/admin/listarVueltas.jsp");
                        break;
                    } 
                    
                    Vuelta da= new Vuelta();
                    String p1 = request.getParameter("idv");
                    int al=0;
                    try{al=Integer.parseInt(p1);}
                    catch(Exception e)
                    {;};
                    da.setId(al);
                    (new VueltaDAO()).eliminar(da);
                    JOptionPane.showMessageDialog(null, "Vuelta eliminada");
                    response.sendRedirect("views/admin/listarVueltas.jsp");
                    break;
                    
            }
        
        } catch(Exception e ) {
            log(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en formato de campos numericos");
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
