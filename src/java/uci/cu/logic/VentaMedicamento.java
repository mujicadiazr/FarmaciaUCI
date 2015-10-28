/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author randy
 */
public class VentaMedicamento {
    String medicamentoNombre;
    String medicamentoTipo;
    int valeId;
    String trabajadorUsuario;
    int cantMedicamento;

   public VentaMedicamento() {
        medicamentoNombre = null;
        medicamentoTipo = null;
        valeId = -1;
        trabajadorUsuario = null;
        cantMedicamento = -1;
    }
   
   public VentaMedicamento(String medicamentoNombre, String medicamentoTipo, int valeId, String trabajadorUsuario, int cantMedicamento) {
        this.medicamentoNombre = medicamentoNombre;
        this.medicamentoTipo = medicamentoTipo;
        this.valeId = valeId;
        this.trabajadorUsuario = trabajadorUsuario;
        this.cantMedicamento = cantMedicamento;
    }

    public String getMedicamentoNombre() {
        return medicamentoNombre;
    }

    public String getMedicamentoTipo() {
        return medicamentoTipo;
    }

    public int getValeId() {
        return valeId;
    }

    public String getTrabajadorUsuario() {
        return trabajadorUsuario;
    }

    public void setMedicamentoNombre(String medicamentoNombre) {
        this.medicamentoNombre = medicamentoNombre;
    }

    public void setMedicamentoTipo(String medicamentoTipo) {
        this.medicamentoTipo = medicamentoTipo;
    }

    public void setValeId(int valeId) {
        this.valeId = valeId;
    }

    public void setTrabajadorUsuario(String trabajadorUsuario) {
        this.trabajadorUsuario = trabajadorUsuario;
    }

    public int getCantMedicamento() {
        return cantMedicamento;
    }

    public void setCantMedicamento(int cantMedicamento) {
        this.cantMedicamento = cantMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.medicamentoNombre);
        hash = 31 * hash + Objects.hashCode(this.medicamentoTipo);
        hash = 31 * hash + (int) (this.valeId ^ (this.valeId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VentaMedicamento other = (VentaMedicamento) obj;
        if (!Objects.equals(this.medicamentoNombre, other.medicamentoNombre)) {
            return false;
        }
        if (!Objects.equals(this.medicamentoTipo, other.medicamentoTipo)) {
            return false;
        }
        if (this.valeId != other.valeId) {
            return false;
        }
        return true;
    }
   
    
}
