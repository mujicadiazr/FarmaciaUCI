/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import uci.cu.logic.Trabajador;

/**
 *
 * @author randy
 */
public class DISPATCHER {
    public static void redirect(String url, HttpServletResponse response, HttpServletRequest request) {
        try {
            if(request.getSession(false).getAttribute("session")== null) {
                JOptionPane.showMessageDialog(null, "Tiene que loguearse para entrar");
                response.sendRedirect(url);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
    }
}
