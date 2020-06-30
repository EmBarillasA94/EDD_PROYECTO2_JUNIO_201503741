/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Clases;

import proyecto2_201503741.EDD.Lista_Aristas;

/**
 *
 * @author EDDY
 */
public class Vertice {

    String nombre;
    Lista_Aristas Aristas;
    int valor;
    boolean visto;
    String ultimo;
    Vertice abajo;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.Aristas = new Lista_Aristas();
        this.valor = 0;
        this.visto = false;
        this.ultimo = "";
        this.abajo = null;
    }

    public void Insertar_Arista(String origen, String destino, int tiempo) {
        Arista a = new Arista(origen, destino, tiempo);
        this.Aristas.Insertar_last(a);
    }

    public int getTiempo(String destino) {
        Arista Destino = Aristas.Buscar(destino);
        if (Destino != null) {
            return Destino.getTiempo();
        }
        return Integer.MAX_VALUE / 2;
    }

    public Arista getArista(String destino){
        Arista ar= Aristas.Buscar(destino);
        return ar;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamLista() {
        return Aristas.getSize();
    }

    public Arista getInicio() {
        return Aristas.getInicio();
    }

    public Vertice getAbajo() {
        return abajo;
    }

    public void setAbajo(Vertice abajo) {
        this.abajo = abajo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }

}
