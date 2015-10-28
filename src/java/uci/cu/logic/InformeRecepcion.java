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
public class InformeRecepcion extends Documento{
    float importe;

    public InformeRecepcion() {
    }

    public InformeRecepcion(int id) {
        super(id);
    }

    public InformeRecepcion(float importe, int id, String trabajadorUsuario, Date fecha, String datosFactura) {
        super(id, trabajadorUsuario, fecha, datosFactura);
        this.importe = importe;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
}
