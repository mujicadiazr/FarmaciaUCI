/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author randy
 */
 

public class Medicamento {

    
    private String nombre;
    private String descripcion; 
    private String tipo;
    private float costo;
    private int cantidad; 
    private String unidadMedida;
    private int Lote; 
    private Date fechaVencimiento;

    public Medicamento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Medicamento(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    
    

    public Medicamento(String nombre, String descripcion, String tipo, float costo, int cantidad, String unidadMedida, int Lote, Date fechaVencimiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.Lote = Lote;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getLote() {
        return Lote;
    }

    public void setLote(int Lote) {
        this.Lote = Lote;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + ", costo=" + costo + ", cantidad=" + cantidad + ", unidadMedida=" + unidadMedida + ", Lote=" + Lote + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.tipo);
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
        final Medicamento other = (Medicamento) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    
    
}
