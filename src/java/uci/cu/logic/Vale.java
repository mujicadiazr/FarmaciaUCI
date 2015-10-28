/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author randy
 */
public class Vale {
    Date fecha;
    Time hora;
    int id;

    public Vale() {
        fecha = null;
        hora = null;
        id = -1;
    }

    public Vale(Date fecha, Time hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    
    
    public Vale(Date fecha, Time hora, int id) {
        this.fecha = fecha;
        this.hora = hora;
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public int getId() {
        return id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Vale other = (Vale) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vale{" + "fecha=" + fecha + ", hora=" + hora + ", id=" + id + '}';
    }

    
    
}
