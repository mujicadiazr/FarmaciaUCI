/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author randy
 */
public class InformeMedicamento {
    List<Medicamento> listaMed;
    List<Character> listaEstado;

    public InformeMedicamento() {
        listaMed = new ArrayList<Medicamento>();
        listaEstado = new ArrayList<Character>();
    }

    public List<Medicamento> getListaMed() {
        return listaMed;
    }

    public List<Character> getListaEstado() {
        return listaEstado;
    }

    public void setListaMed(List<Medicamento> listaMed) {
        this.listaMed = listaMed;
    }

    public void setListaEstado(List<Character> listaEstado) {
        this.listaEstado = listaEstado;
    }

        
    
}
