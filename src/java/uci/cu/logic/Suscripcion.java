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
public class Suscripcion {
    String ci;
    String nombre;
    String primerApell;
    String segundoApell;

    public Suscripcion(String ci, String nombre, String primerApell, String segundoApell) {
        this.ci = ci;
        this.nombre = nombre;
        this.primerApell = primerApell;
        this.segundoApell = segundoApell;
    }

    public Suscripcion(String ci) {
        this.ci = ci;
    }

    public Suscripcion() {
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApell() {
        return primerApell;
    }

    public String getSegundoApell() {
        return segundoApell;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApell(String primerApell) {
        this.primerApell = primerApell;
    }

    public void setSegundoApell(String segundoApell) {
        this.segundoApell = segundoApell;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.ci);
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
        final Suscripcion other = (Suscripcion) obj;
        if (!Objects.equals(this.ci, other.ci)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "ci=" + ci + ", nombre=" + nombre + ", primerApell=" + primerApell + ", segundoApell=" + segundoApell + '}';
    }
    
    
    
}
