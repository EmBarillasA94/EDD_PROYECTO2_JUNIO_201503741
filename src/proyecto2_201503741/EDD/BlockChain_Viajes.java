/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import java.io.File;
import java.io.FileWriter;
import proyecto2_201503741.Clases.Nodo_BlockChain;

/**
 *
 * @author EDDY
 */
public class BlockChain_Viajes {

    Nodo_BlockChain firts;
    Nodo_BlockChain last;
    int size;

    public BlockChain_Viajes() {
        this.firts = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.firts == null;
    }

    public void Insertar(Nodo_BlockChain n) {
        if (isEmpty()) {
            this.firts = n;
            this.last = n;
//            this.firts.setBefore(this.last);
//            this.last.setNext(this.firts);
            this.size++;
        } else {
            this.last.setNext(n);
            n.setBefore(this.last);
            this.last = n;
//            this.last.setNext(this.firts);
//            this.firts.setBefore(this.last);
            this.size++;
        }
    }

    public void Graph() {
        try {
            File archivo;
            FileWriter fw_archivo;
            archivo = new File("R_BlockChain.dot");
            fw_archivo = new FileWriter(archivo, false);
            char comillas = '"';
            String espacio = "&#92;n";

            fw_archivo.write("digraph BlockChain{ \n");
            fw_archivo.write("node[shape=box]; \n");
            fw_archivo.write("rankdir = LR; \n");
            fw_archivo.write("\n");

            Nodo_BlockChain aux = this.firts;
            for (int i = 0; i < this.size; i++) {
                fw_archivo.write("" + comillas + aux.hashCode() + comillas + "[label = " + comillas + aux.getLlave() + comillas + "] \n");
                aux = aux.getNext();
            }
            aux = this.firts;
            for (int i = 0; i < this.size; i++) {
                if (aux.getBefore() != null) {
                    fw_archivo.write("" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getBefore().hashCode() + comillas + "; \n");
                }
                if (aux.getNext() != null) {
                    fw_archivo.write("" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getNext().hashCode() + comillas + "; \n");
                }
                aux = aux.getNext();
            }
            fw_archivo.write("\n");

            aux = this.firts;
            for (int i = 0; i < this.size; i++) {
                fw_archivo.write(aux.getRuta().Graph_RutaCorta("" + aux.hashCode()));
                fw_archivo.write("\n");
                aux = aux.getNext();
            }

            aux = this.firts;
            for (int i = 0; i < this.size; i++) {
                fw_archivo.write("{rank=same " + comillas + aux.hashCode() + comillas + " " + comillas + aux.getRuta().getInicio().getDestino() + "_" + aux.hashCode() + comillas + "} \n");
                fw_archivo.write(comillas + aux.hashCode() + comillas + "->"+comillas + aux.getRuta().getInicio().getDestino() + "_" + aux.hashCode() + comillas+"; \n");
                aux = aux.getNext();
            }
            fw_archivo.write("\n");
            fw_archivo.write("}");
        } catch (Exception e) {
        }
    }

}