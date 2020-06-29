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
    
    public void Insertar(Arista n){
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
    
    public int getSize(){
        return this.size;
    }

    public Arista getInicio() {
        return this.Inicio;
    }
    
}
