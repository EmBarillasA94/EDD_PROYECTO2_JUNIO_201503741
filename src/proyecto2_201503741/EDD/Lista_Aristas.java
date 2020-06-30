/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import proyecto2_201503741.Clases.Arista;

/**
 *
 * @author EDDY
 */
public class Lista_Aristas {

    Arista Inicio;
    int size;

    public Lista_Aristas() {
        this.Inicio = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return this.Inicio == null;
    }
    
    public void Insertar_last(Arista n){
        if (isEmpty()) {
            this.Inicio = n;
            this.size++;
        }else{
            Arista aux = this.Inicio;
            while (aux.getSiguiente() != null) {                
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(n);
            this.size++;
        }
    }
    
    public void Insertar_firts(Arista n){
        if (isEmpty()) {
            this.Inicio = n;
            this.size++;
        }else{
            n.setSiguiente(this.Inicio);
            this.Inicio = n;
            this.size++;
        }
    }
    public int getSize(){
        return this.size;
    }

    public Arista getInicio() {
        return this.Inicio;
    }
    
    public Arista Buscar(String destino){
        Arista aux = this.Inicio;
        while (aux != null) {            
            if (aux.getDestino().equals(destino)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
}
