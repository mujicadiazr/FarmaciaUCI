/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.util.List;

/**
 *
 * @author randy
 */
public class Venta {
    Vale vale;
    List<Medicamento> listaMed;
    Trabajador usuario;

    public Venta() {
        vale = null;
        listaMed = null;
        usuario = null;
    }

    public Vale getVale() {
        return vale;
    }

    public List<Medicamento> getListaMed() {
        return listaMed;
    }

    public Trabajador getUsuario() {
        return usuario;
    }

    public void setVale(Vale vale) {
        this.vale = vale;
    }

    public void setListaMed(List<Medicamento> listaMed) {
        this.listaMed = listaMed;
    }

    public void setUsuario(Trabajador usuario) {
        this.usuario = usuario;
    }   
    
}
