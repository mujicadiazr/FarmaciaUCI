/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

/**
 *
 * @author randy
 */


public class Trabajador {

    String ci;
    String nombre;
    String primerApellido;
    String segundoApellido;    
    String telefono;
    String direccionParticular;
    String usuario;
    String contrasenna;
    String rol;

    public Trabajador(String ci, String nombre, String primerApellido, String segundoApellido, String telefono, String direccionParticular, String usuario, String contrasenna, String rol) {
        this.ci = ci;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccionParticular = direccionParticular;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Trabajador) && ((Trabajador)obj).getUsuario().equals(usuario))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }

       
    public Trabajador(String usuario) {
        this.usuario = usuario;
    }

    public Trabajador(String usuario, String contrasenna) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

    public Trabajador(String usuario, String contrasenna, String rol) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }

     public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
         
        
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setDireccionParticular(String direccionParticular) {
        this.direccionParticular = direccionParticular;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCi() {
        return ci;
    }

    public String getDireccionParticular() {
        return direccionParticular;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

       
}


