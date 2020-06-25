/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Clases;

import proyecto2_201503741.EDD.Lista_Cliente;

/**
 *
 * @author EDDY
 */
public class Nodo_TablaHash {
    
    Lista_Cliente Lista;

    public Nodo_TablaHash() {
        this.Lista = new Lista_Cliente();
    }
    
    public void Insertar(Cliente NuevoCliente){
        this.Lista.Insertar(NuevoCliente);
    }
    
    public Cliente Buscar(long dpi){
        Cliente cli = this.Lista.Buscar(dpi);
        return cli;
    }
    
    public void Eliminar(long dpi){
        this.Lista.Eliminar(dpi);
    }

    public boolean isEmpty(){
        return this.Lista.isEmpty();
    }
    public Lista_Cliente getLista() {
        return Lista;
    }
    
}
