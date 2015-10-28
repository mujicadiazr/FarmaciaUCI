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
public class Reclamacion extends Documento{
    String datosReales;

    public Reclamacion(int id) {
        super(id);
    }

    public Reclamacion(String datosReales, int id, String trabajadorUsuario, Date fecha, String datosFactura) {
        super(id, trabajadorUsuario, fecha, datosFactura);
        this.datosReales = datosReales;
    }

    public Reclamacion() {
    }

    public String getDatosReales() {
        return datosReales;
    }

    public void setDatosReales(String datosReales) {
        this.datosReales = datosReales;
    }
    
    
}
