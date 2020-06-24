/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import proyecto2_201503741.Clases.Cliente;
import proyecto2_201503741.Clases.Nodo_TablaHash;

/**
 *
 * @author EDDY
 */
public class Tabla_Hash {

    Nodo_TablaHash[] Tabla;
    int porcentaje;

    public Tabla_Hash() {
        this.Tabla = new Nodo_TablaHash[37];
        this.porcentaje = 0;
    }

    private int CalcularHash(int dpi){
        return dpi % this.Tabla.length;
    }
    
    public void Insertar(Cliente NuevoCliente){
        
        int hash = CalcularHash(NuevoCliente.getDpi());
        
        if (Tabla[hash] == null) {
            Tabla[hash] = new Nodo_TablaHash();
            Tabla[hash].Insertar(NuevoCliente);
            this.porcentaje++;
        } else {
            Tabla[hash].Insertar(NuevoCliente);
        }
        
        //calcular si ya se lleno mas del 75%
    }
}
