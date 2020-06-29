/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import java.io.File;
import java.io.FileWriter;
import proyecto2_201503741.Clases.Arista;
import proyecto2_201503741.Clases.Vertice;

/**
 *
 * @author EDDY
 */
public class Lista_Adyacencia {

    Vertice Inicio;
    int size;

    public Lista_Adyacencia() {
        this.Inicio = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.Inicio == null;
    }

    public void Insertar_Vertice(String origen, String destino, int tiempo) {
        if (isEmpty()) {
            Vertice v = new Vertice(origen);
            v.Insertar_Arista(origen, destino, tiempo);
            this.Inicio = v;
            this.size++;
        } else {
            //buscar si el nodo ya existe e insertarlo ahi si no crearlo 
            Vertice aux = this.Inicio;
            boolean ingresado = false;
            while (aux != null) {
                if (aux.getNombre().equals(origen)) {
                    aux.Insertar_Arista(origen, destino, tiempo);
                    ingresado = true;
                    break;
                }
                aux = aux.getAbajo();
            }
            if (!ingresado) {
                aux = this.Inicio;
                while (aux.getAbajo() != null) {                    
                    aux = aux.getAbajo();
                }
                Vertice v = new Vertice(origen);
                v.Insertar_Arista(origen, destino, tiempo);
                aux.setAbajo(v);
                this.size++;
            }
        }
    }

    public Vertice Buscar(String nombre) {
        return null;
    }

    public void Graph() {
        try {
            File archivo;
            FileWriter fw_archivo;
            archivo = new File("R_Grafo.dot");
            fw_archivo = new FileWriter(archivo, false);
            char comillas = '"';

            fw_archivo.write("digraph G{ \n");
            fw_archivo.write("rankdir = LR; \n");
            Vertice aux = this.Inicio;
            for (int i = 0; i < this.size; i++) {
                Arista auxArista = aux.getInicio();
                for (int j = 0; j < aux.getTamLista(); j++) {
                    fw_archivo.write("" + comillas + aux.getNombre() + comillas + " -> " + comillas + auxArista.getDestino() + comillas);
                    fw_archivo.write("[label= " + comillas + auxArista.getTiempo() + comillas + "] \n");
                    auxArista = auxArista.getSiguiente();
                }
                aux = aux.getAbajo();
            }
            fw_archivo.write("}");

            fw_archivo.close();

            //"C:\\release\\bin\\dot.exe -Tpng R_ArbolAVL.dot -o Grafica_ArbolAVL.png"
            String Comando = "C:\\release\\bin\\dot.exe -Tpng R_Grafo.dot -o Grafica_Grafo.png";
            Process p;
            try {
                p = Runtime.getRuntime().exec(Comando);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
        }
    }
}
