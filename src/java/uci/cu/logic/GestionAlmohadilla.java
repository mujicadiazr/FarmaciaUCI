/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.util.Objects;

/**
 *
 * @author randy
 */
public class GestionAlmohadilla {
    int vueltaId;
    String suscripcionCi;
    String trabajadorUsuario;

    public GestionAlmohadilla(int vueltaId, String suscripcionCi, String trabajadorUsuario) {
        this.vueltaId = vueltaId;
        this.suscripcionCi = suscripcionCi;
        this.trabajadorUsuario = trabajadorUsuario;
    }

    public GestionAlmohadilla() {
    }

    public int getVueltaId() {
        return vueltaId;
    }

    public String getSuscripcionCi() {
        return suscripcionCi;
    }

    public String getTrabajadorUsuario() {
        return trabajadorUsuario;
    }

    public void setVueltaId(int vueltaId) {
        this.vueltaId = vueltaId;
    }

    public void setSuscripcionCi(String suscripcionCi) {
        this.suscripcionCi = suscripcionCi;
    }

    public void setTrabajadorUsuario(String trabajadorUsuario) {
        this.trabajadorUsuario = trabajadorUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.vueltaId;
        hash = 47 * hash + Objects.hashCode(this.suscripcionCi);
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
        final GestionAlmohadilla other = (GestionAlmohadilla) obj;
        if (this.vueltaId != other.vueltaId) {
            return false;
        }
        if (!Objects.equals(this.suscripcionCi, other.suscripcionCi)) {
            return false;
        }
        return true;
    }
    
    
}
