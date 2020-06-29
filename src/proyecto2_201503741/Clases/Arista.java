/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Clases;

/**
 *
 * @author EDDY
 */
public class Arista {

    String origen;
    String destino;
    int tiempo;
    Arista siguiente;

    public Arista(String origen, String destino, int tiempo) {
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
        this.siguiente = null;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Arista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }
    
}
