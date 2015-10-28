/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uci.cu.logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.runtime.Log;
import uci.cu.dao.impl.MedicamentoDAO;
import uci.cu.dao.impl.TrabajadorDAO;

/**
 *
 * @author randy
 */
public class Validator {
    public static boolean SuficienteMedicamento(Medicamento med) {
        boolean ret = true;
        
        try {
        
            int cantActual = (new MedicamentoDAO()).obtenerPorID(med).getCantidad();
            ret = (med.getCantidad() <= cantActual);  
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return ret;  
    } 
    
    public static boolean EsAnno(String anno) {
        if (anno.length() < 4 || anno.length() > 4 )
            return false;
        
        try {
            if (Integer.parseInt(anno) < 2000)
                return false;
        } catch (Exception e) {
            return false;
        }        
        return true;
                
    }
    
    public static boolean EsMes(String anno) {
            
        try {
            if (Integer.parseInt(anno) > 12 || Integer.parseInt(anno) < 1)
                return false;
        } catch (Exception e) {
            return false;
        }        
        return true;
                
    }
    
    public static boolean EsNombre(String nombre)
    {
        if (nombre!=null)
        {  int count=0;
            for(int i=0 ; i<nombre.length();i++)
            {
                if(!Character.isLetter(nombre.charAt(i)))
                    count +=1;
            }
            if(!Character.isUpperCase(nombre.charAt(0)))
                count +=1;

            if(count==0)
                return true;
        }
        return false;
    }
    
     public static boolean EsNumero(String numero)
    {
        if (numero!=null)
        {  int count=0;
            for(int i=0 ; i<numero.length();i++)
            {
                if(!Character.isDigit(numero.charAt(i)))
                    count +=1;
            }
            if(count==0)
                return true;
        }
        return false;
    }
     
     public static boolean EsRol(String rol)
     {
         if("admin".equals(rol)||"dep".equals(rol))
             return true;
         return false;
     }
    
    public static boolean ExisteUsuario(String t, String CI)
    {
        try {
            if(!(new TrabajadorDAO()).estaTrabajadorIdUser(CI, t))
                return false;
        } catch (Exception ex) {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static boolean TieneLetra(String palabra)
    {
        if (palabra!=null)
        {  int count=0;
            for(int i=0 ; i<palabra.length();i++)
            {
                if(Character.isLetter(palabra.charAt(i)))
                    count +=1;
            }
            if(count!=0)
                return true;
        }
        return false;
    }
    
    public static boolean TieneNumero(String palabra)
    {
        if (palabra!=null)
        {  int count=0;
            for(int i=0 ; i<palabra.length();i++)
            {
                if(Character.isDigit(palabra.charAt(i)))
                    count +=1;
            }
            if(count!=0)
                return true;
        }
        return false;
    }
    
    public static boolean LetrasNumeros(String palabra)
    {
        
        if (palabra!=null)
        {  int count=0;
            for(int i=0 ; i<palabra.length();i++)
            {
                if(!Character.isLetterOrDigit(palabra.charAt(i)))
                    count +=1;
            }
            if(count==0)
                return true;
        }
        return false;
    }
}
