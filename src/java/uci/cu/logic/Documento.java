/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.sql.Date;

/**
 *
 * @author randy
 */
public class Documento {
    int id;
    String trabajadorUsuario;
    Date fecha;
    String datosFactura;

    public Documento(int id) {
        this.id = id;
    }

    public Documento() {
    }
        
    
    public Documento(int id, String trabajadorUsuario, Date fecha, String datosFactura) {
        this.id = id;
        this.trabajadorUsuario = trabajadorUsuario;
        this.fecha = fecha;
        this.datosFactura = datosFactura;
    }

    public int getId() {
        return id;
    }

    public String getTrabajadorUsuario() {
        return trabajadorUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDatosFactura() {
        return datosFactura;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrabajadorUsuario(String trabajadorUsuario) {
        this.trabajadorUsuario = trabajadorUsuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDatosFactura(String datosFactura) {
        this.datosFactura = datosFactura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final Documento other = (Documento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
