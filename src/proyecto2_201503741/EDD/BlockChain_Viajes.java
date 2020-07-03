/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import java.io.File;
import java.io.FileWriter;
import proyecto2_201503741.Clases.Nodo_BlockChain;
import static proyecto2_201503741.Proyecto2_201503741.Arbol_Vehiculos;
import static proyecto2_201503741.Proyecto2_201503741.TablaHash_Clientes;
import static proyecto2_201503741.Proyecto2_201503741.ListaCirculoar_Conductores;
import static proyecto2_201503741.Proyecto2_201503741.Block_Viajes;
import static proyecto2_201503741.Proyecto2_201503741.Grafo;

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

    public Nodo_BlockChain Buscar(String llave) {
        Nodo_BlockChain aux = this.firts;
        String llave_encriptada = aux.Generar_llave_MD5(llave);
        for (int i = 0; i < this.size; i++) {
            if (llave_encriptada.equals(aux.getLlave())) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
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
                fw_archivo.write("" + comillas + aux.hashCode() + comillas + "[label = " + comillas + aux.getLlave() + espacio + "Lugar Origen: " + aux.getLugar_origen() + espacio + "Lugar Destino: " + aux.getLugar_destino() + espacio + "Fecha y Hora: " + aux.getFecha_hora_inicio() + espacio + "Cliente: " + aux.getCliente().getDpi() + espacio + "Conductor: " + aux.getConductor().getDpi() + espacio + "Vehiculo: " + aux.getVehiculo().getPlaca() + comillas + "] \n");
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
                fw_archivo.write("" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getRuta().getInicio().getDestino() + "_" + aux.hashCode() + comillas + "; \n");
                aux = aux.getNext();
            }
            fw_archivo.write("\n");
            fw_archivo.write("}");
            fw_archivo.close();

            //"C:\\release\\bin\\dot.exe -Tpng R_ArbolAVL.dot -o Grafica_ArbolAVL.png"
            String Comando = "C:\\release\\bin\\dot.exe -Tpng R_BlockChain.dot -o Grafica_BlockChain.png";
            Process p;
            try {
                p = Runtime.getRuntime().exec(Comando);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    public String getSubGraph() {
        String texto = "";
        char comillas = '"';
        String espacio = "&#92;n";

        texto = texto + "subgraph BlockChain{ \n";
        texto = texto + "node[shape=box]; \n";
        texto = texto + "rankdir = LR; \n";
        texto = texto + "\n";

        Nodo_BlockChain aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            texto = texto + "" + comillas + aux.hashCode() + comillas + "[label = " + comillas + aux.getLlave() + espacio + "Lugar Origen: " + aux.getLugar_origen() + espacio + "Lugar Destino: " + aux.getLugar_destino() + espacio + "Fecha y Hora: " + aux.getFecha_hora_inicio() + espacio + "Cliente: " + aux.getCliente().getDpi() + espacio + "Conductor: " + aux.getConductor().getDpi() + espacio + "Vehiculo: " + aux.getVehiculo().getPlaca() + comillas + "] \n";
            aux = aux.getNext();
        }
        aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            if (aux.getBefore() != null) {
                texto = texto + "" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getBefore().hashCode() + comillas + "; \n";
            }
            if (aux.getNext() != null) {
                texto = texto + "" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getNext().hashCode() + comillas + "; \n";
            }
            aux = aux.getNext();
        }
        texto = texto + "\n";

        aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            texto = texto + aux.getRuta().Graph_RutaCorta("" + aux.hashCode());
            texto = texto + "\n";
            aux = aux.getNext();
        }

        aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            texto = texto + "{rank=same " + comillas + aux.hashCode() + comillas + " " + comillas + aux.getRuta().getInicio().getDestino() + "_" + aux.hashCode() + comillas + "} \n";
            texto = texto + "" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getRuta().getInicio().getDestino() + "_" + aux.hashCode() + comillas + "; \n";
            aux = aux.getNext();
        }
        texto = texto + "\n";
        texto = texto + "}";
        return texto;
    }
    
    public void Graph_General(){
        try {
            File archivo;
            FileWriter fw_archivo;
            archivo = new File("R_General.dot");
            fw_archivo = new FileWriter(archivo, false);
            char comillas = '"';
            String espacio = "&#92;n";

            fw_archivo.write("digraph General{ \n");
            fw_archivo.write("node[shape=box]; \n");
            fw_archivo.write("rankdir = LR; \n");
            fw_archivo.write("\n");
            
            //subgrafo del arbol
            fw_archivo.write("\n");
            fw_archivo.write(Arbol_Vehiculos.getSubGraph());
            fw_archivo.write("\n");
            
            //subgrafo de la tabla
            fw_archivo.write("\n");
            fw_archivo.write(TablaHash_Clientes.getSubGraph());
            fw_archivo.write("\n");
            
            //subgrafo de la lista doble
            fw_archivo.write("\n");
            fw_archivo.write(ListaCirculoar_Conductores.getSubgraph());
            fw_archivo.write("\n");
            
            //subgrafo del blockchain
            fw_archivo.write("\n");
            fw_archivo.write(Block_Viajes.getSubGraph());
            fw_archivo.write("\n");
            
            //subgrafo del grafo
            fw_archivo.write("\n");
            fw_archivo.write(Grafo.getSubgraph());
            fw_archivo.write("\n");
            
            fw_archivo.write("}");
            
            fw_archivo.close();
            
            //"C:\\release\\bin\\dot.exe -Tpng R_ArbolAVL.dot -o Grafica_ArbolAVL.png"
            String Comando = "C:\\release\\bin\\dot.exe -Tpng R_General.dot -o Grafica_General.png";
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
