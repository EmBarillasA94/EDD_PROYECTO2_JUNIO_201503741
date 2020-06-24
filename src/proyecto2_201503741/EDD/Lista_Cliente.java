/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import proyecto2_201503741.Clases.Cliente;

/**
 *
 * @author EDDY
 */
public class Lista_Cliente {

    Cliente Inicio;
    int size;

    public Lista_Cliente() {
        this.Inicio = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.Inicio == null;
    }

    public void Insertar(Cliente n) {
        if (isEmpty()) {
            this.Inicio = n;
            this.size++;
        } else {
            n.setNext(this.Inicio);
            this.Inicio = n;
            this.size++;
        }
    }

    public Cliente Buscar(int dpi) {
        Cliente aux = this.Inicio;
        while (aux != null) {
            if (aux.getDpi() == dpi) {
                return aux;
            } else {
                aux = aux.getNext();
            }
        }
        return null;
    }

    public void Eliminar(int dpi) {
        if (this.Inicio.getDpi() == dpi) {
            this.Inicio = this.Inicio.getNext();
        } else {
            Cliente aux = this.Inicio;
            Cliente aux2 = this.Inicio;
            while (aux != null) {
                if (aux.getDpi() == dpi) {
                    aux2.setNext(aux.getNext());
                    this.size--;
                    break;
                } else {
                    aux2 = aux;
                    aux = aux.getNext();
                }
            }
        }
    }

}
