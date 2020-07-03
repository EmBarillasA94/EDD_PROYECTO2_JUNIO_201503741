/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import java.io.File;
import java.io.FileWriter;
import proyecto2_201503741.Clases.Conductor;

/**
 *
 * @author EDDY
 */
public class Lista_Conductores {

    Conductor firts;
    Conductor last;
    int size;

    public Lista_Conductores() {
        this.firts = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.firts == null;
    }

    public void Insertar(Conductor n) {
        if (isEmpty()) {
            this.firts = n;
            this.last = n;
            this.firts.setBefore(this.last);
            this.last.setNext(this.firts);
            this.size++;
        } else if (n.getDpi() < this.firts.getDpi()) {
            n.setNext(this.firts);
            this.firts.setBefore(n);
            this.firts = n;
            this.last.setNext(this.firts);
            this.firts.setBefore(this.last);
            this.size++;
        } else if (n.getDpi() > this.last.getDpi()) {
            n.setBefore(this.last);
            this.last.setNext(n);
            this.last = n;
            this.last.setNext(this.firts);
            this.firts.setBefore(this.last);
            this.size++;
        } else {
            Conductor aux = this.firts;
            while (aux != null) {
                if (n.getDpi() < aux.getDpi()) {
                    aux.getBefore().setNext(n);
                    n.setBefore(aux.getBefore());
                    n.setNext(aux);
                    aux.setBefore(n);
                    this.size++;
                    break;
                }
                aux = aux.getNext();
            }
        }
    }

    public void Eliminar(long dpi) {
        Conductor aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            if (dpi == aux.getDpi()) {
                if (i == 0) {
                    this.firts = aux.getNext();
                    this.last.setNext(this.firts);
                    this.firts.setBefore(this.last);
                    this.size--;
                    break;
                } else if (i == this.size - 1) {
                    this.last = aux.getBefore();
                    this.firts.setBefore(this.last);
                    this.last.setNext(this.firts);
                    this.size--;
                    break;
                } else {
                    aux.getBefore().setNext(aux.getNext());
                    aux.getNext().setBefore(aux.getBefore());
                    this.size--;
                    break;
                }
            }
            aux = aux.getNext();
        }
    }

    public Conductor Buscar(long dpi) {
        Conductor aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            if (aux.getDpi() == dpi) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    public Conductor[] ListadoConductores() {
        Conductor[] Lista = new Conductor[this.size];
        Conductor aux = this.firts;
        for (int i = 0; i < Lista.length; i++) {
            Lista[i] = aux;
            aux = aux.getNext();
        }
        return Lista;
    }

    public void graph() {
        try {
            File archivo;
            FileWriter fw_archivo;
            archivo = new File("R_Lista_Doble_Circular.dot");
            fw_archivo = new FileWriter(archivo, false);
            char comillas = '"';
            String espacio = "&#92;n";

            fw_archivo.write("digraph G{ \n");
            fw_archivo.write("rankdir = LR; \n");
            fw_archivo.write("node[shape=box] \n");

            Conductor aux = this.firts;
            for (int i = 0; i < this.size; i++) {
                fw_archivo.write("" + comillas + aux.hashCode() + comillas + "[label =" + comillas + aux.getDpi() + espacio + aux.getNombres() + espacio + "Licencia Tipo: " + aux.getTipo_licencia() + comillas + "]; \n");
                aux = aux.getNext();
            }

            aux = this.firts;
            for (int i = 0; i < this.size; i++) {
                fw_archivo.write("" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getNext().hashCode() + comillas + "\n");
                fw_archivo.write("" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getBefore().hashCode() + comillas + "\n");
                aux = aux.getNext();
            }
            fw_archivo.write("}\n");

            fw_archivo.close();

            //"C:\\release\\bin\\dot.exe -Tpng R_ArbolAVL.dot -o Grafica_ArbolAVL.png"
            String Comando = "C:\\release\\bin\\dot.exe -Tpng R_Lista_Doble_Circular.dot -o Grafica_Lista_Doble_Circular.png";
            Process p;
            try {
                p = Runtime.getRuntime().exec(Comando);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Error al escribir el archivo R_TablaHash.dot");
        }
    }

    public String getSubgraph() {
        String texto = "";
        char comillas = '"';
        String espacio = "&#92;n";
        
        texto = texto + "subgraph Lista_Conductores{ \n";
        texto = texto + "rankdir = LR; \n";
        texto = texto + "node[shape=box] \n";

        Conductor aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            texto = texto + "" + comillas + aux.hashCode() + comillas + "[label =" + comillas + aux.getDpi() + espacio + aux.getNombres() + espacio + "Licencia Tipo: " + aux.getTipo_licencia() + comillas + "]; \n";
            aux = aux.getNext();
        }

        aux = this.firts;
        for (int i = 0; i < this.size; i++) {
            texto = texto + "" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getNext().hashCode() + comillas + "\n";
            texto = texto + "" + comillas + aux.hashCode() + comillas + "->" + comillas + aux.getBefore().hashCode() + comillas + "\n";
            aux = aux.getNext();
        }
        texto = texto + "}\n";
        return texto;
    }
}
