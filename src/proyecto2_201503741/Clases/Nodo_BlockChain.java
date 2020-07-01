/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Clases;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import proyecto2_201503741.EDD.Lista_Aristas;

/**
 *
 * @author EDDY
 */
public class Nodo_BlockChain {
    String llave;
    String Lugar_origen;
    String Lugar_destino;
    Cliente cliente;
    Conductor conductor;
    Vehiculo vehiculo;
    Lista_Aristas ruta;

    public Nodo_BlockChain(String llave, String Lugar_origen, String Lugar_destino, Cliente cliente, Conductor conductor, Vehiculo vehiculo, Lista_Aristas ruta) {
        this.llave = Generar_llave(llave);
        this.Lugar_origen = Lugar_origen;
        this.Lugar_destino = Lugar_destino;
        this.cliente = cliente;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.ruta = ruta;
    }
    
    public static String Generar_llave(String llave){
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(llave.getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b : hash){
                sb.append(String.format("%02x",b&0xff));
            }
            
            digest = sb.toString();
            
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
//            Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex);
        }
//            Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex);
        
        return digest;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getLugar_origen() {
        return Lugar_origen;
    }

    public void setLugar_origen(String Lugar_origen) {
        this.Lugar_origen = Lugar_origen;
    }

    public String getLugar_destino() {
        return Lugar_destino;
    }

    public void setLugar_destino(String Lugar_destino) {
        this.Lugar_destino = Lugar_destino;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Lista_Aristas getRuta() {
        return ruta;
    }

    public void setRuta(Lista_Aristas ruta) {
        this.ruta = ruta;
    }
    
    
}
