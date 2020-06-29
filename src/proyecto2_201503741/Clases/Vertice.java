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
    Vertice abajo;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.Aristas = new Lista_Aristas();
        this.abajo = null;
    }
    
    public void Insertar_Arista(String origen, String destino, int tiempo){
        Arista a = new Arista(origen, destino, tiempo);
        this.Aristas.Insertar(a);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getTamLista(){
        return Aristas.getSize();
    }
    
    public Arista getInicio(){
        return Aristas.getInicio();
    }
    
    public Vertice getAbajo() {
        return abajo;
    }

    public void setAbajo(Vertice abajo) {
        this.abajo = abajo;
    }
    
    
}
