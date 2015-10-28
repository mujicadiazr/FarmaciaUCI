/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

/**
 *
 * @author randy
 */
public class Vuelta {
    int id;
    int anno;
    int mes;

    public Vuelta(int id) {
        this.id = id;
    }

    public Vuelta() {
    }

    public Vuelta(int anno, int mes) {
        this.anno = anno;
        this.mes = mes;
    }

    public Vuelta(int id, int anno, int mes) {
        this.id = id;
        this.anno = anno;
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    

    public int getId() {
        return id;
    }

    public int getAnno() {
        return anno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
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
        final Vuelta other = (Vuelta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
