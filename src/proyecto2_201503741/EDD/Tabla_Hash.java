/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import java.io.File;
import java.io.FileWriter;
import proyecto2_201503741.Clases.Cliente;
import proyecto2_201503741.Clases.Nodo_TablaHash;

/**
 *
 * @author EDDY
 */
public class Tabla_Hash {

    Nodo_TablaHash[] Tabla;
    int tam;
    int claves_ocupadas;
    int cantidad_clientes;

    public Tabla_Hash() {
        this.Tabla = new Nodo_TablaHash[37];
        this.tam = 37;
        this.claves_ocupadas = 0;
    }

    public int CalcularHash(long dpi) {
        return (int) (dpi % this.tam);
    }

    private float CalcularPorcentaje() {
        return claves_ocupadas * 100 / this.tam;
    }

    public void Insertar(Cliente NuevoCliente) {

        int hash = CalcularHash(NuevoCliente.getDpi());

        if (this.Tabla[hash] == null) {
            this.Tabla[hash] = new Nodo_TablaHash();
            this.Tabla[hash].Insertar(NuevoCliente);
            this.claves_ocupadas++;
            this.cantidad_clientes++;
        } else {
            Tabla[hash].Insertar(NuevoCliente);
            this.cantidad_clientes++;
        }

        //calcular si ya se lleno mas del 75%
        if (CalcularPorcentaje() > 75) {
            //aumentar la tabla
            Aumentar_Tabla();
        }
    }

    public void Aumentar_Tabla() {
        this.tam = tam + 37;
        this.claves_ocupadas = 0;
        Nodo_TablaHash[] Tabla_auxiliar = new Nodo_TablaHash[tam];
        for (int i = 0; i < this.Tabla.length; i++) {
            if (this.Tabla[i] != null) {
                Cliente aux = this.Tabla[i].getLista().getInicio();
                while (aux != null) {
                    int hash = CalcularHash(aux.getDpi());
                    if (Tabla_auxiliar[hash] == null) {
                        Tabla_auxiliar[hash] = new Nodo_TablaHash();
                        Tabla_auxiliar[hash].Insertar(aux);
                        this.claves_ocupadas++;
                    } else {
                        Tabla_auxiliar[hash].Insertar(aux);
                    }
                    aux = aux.getNext();
                }
            }
        }
        this.Tabla = null;
        this.Tabla = Tabla_auxiliar;
    }

    public void Eliminar(long dpi) {
        int hash = CalcularHash(dpi);
        this.Tabla[hash].Eliminar(dpi);
        this.cantidad_clientes--;
        if (this.Tabla[hash].isEmpty()) {
            this.Tabla[hash] = null;
            this.claves_ocupadas--;
        }
    }

    public Cliente Buscar(long dpi) {
        int hash = CalcularHash(dpi);
        Cliente cli = this.Tabla[hash].Buscar(dpi);
        return cli;
    }

    public Cliente[] ListaClientes() {
        Cliente[] Lista = new Cliente[this.cantidad_clientes];
        int j = 0;
        for (int i = 0; i < this.tam; i++) {
            Nodo_TablaHash aux = this.Tabla[i];
            if (aux != null) {
                if (!aux.getLista().isEmpty()) {
                    Cliente aux2 = aux.getLista().getInicio();
                    while (aux2 != null) {
                        Lista[j] = aux2;
                        j++;
                        aux2 = aux2.getNext();
                    }
                }
            }
        }
        return Lista;
    }

    public void Graph() {
        try {
            File archivo;
            FileWriter fw_archivo;
            archivo = new File("R_TablaHash.dot");
            fw_archivo = new FileWriter(archivo, false);
            char comillas = '"';
            int altura = this.claves_ocupadas / 2;

            fw_archivo.write("digraph G{ \n");
            fw_archivo.write("nodesep =.01; \n");
            fw_archivo.write("rankdir = LR; \n");
            fw_archivo.write("node[shape=record,width=.1,height=" + altura + "]; \n");
//            fw_archivo.write("node[shape=record] \n");
//            fw_archivo.write("nodeArray[label =" + comillas + "<f0>0|<f1>1|<f2>2|<f3>3|<f4>4|<f5>5|<f6>6|<f7>7|<f8>8|<f9>9|<f10>10|<f11>11|<f12>12|<f13>13|<f14>14|<f15>15|<f16>16|<f17>17|<f18>18|<f19>19|<f20>20|<f21>21|<f22>22|<f23>23|<f24>24|<f25>25|<f26>26|<f27>27|<f28>28|<f29>29|<f30>30|<f31>31|<f32>32|<f33>33|<f34>34|<f35>35|<f36>36" + comillas + "]; \n");
            fw_archivo.write("nodeArray[label=" + comillas);
            for (int i = 0; i <= this.Tabla.length - 1; i++) {
                fw_archivo.write("<f" + i + ">" + i);
                if (i < this.Tabla.length - 1) {
                    fw_archivo.write("|");
                }
            }
            fw_archivo.write(comillas + "]; \n");
//            fw_archivo.write("node[width = 1.5 \n]");

            for (int i = 0; i < Tabla.length; i++) {
                if (Tabla[i] != null) {
                    if (!Tabla[i].getLista().isEmpty()) {
                        String ListaEstudiantes = Tabla[i].getLista().ListaClientes();
                        fw_archivo.write("node" + i + "[label=" + comillas + "{" + ListaEstudiantes + "}" + comillas + ", height = 0.1]; \n");
                    }
                }
            }
            fw_archivo.write("\n");
            for (int i = 0; i < Tabla.length; i++) {
                if (Tabla[i] != null) {
                    if (!Tabla[i].getLista().isEmpty()) {
                        fw_archivo.write("nodeArray:f" + i + "->node" + i + ":f0; \n");
                    }
                }
            }

            fw_archivo.write("} \n");
            fw_archivo.close();

            //"C:\\release\\bin\\dot.exe -Tpng R_ArbolAVL.dot -o Grafica_ArbolAVL.png"
            String Comando = "C:\\release\\bin\\dot.exe -Tpng R_TablaHash.dot -o Grafica_TablaHash.png";
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

    public String getSubGraph() {
        String texto = "";
        char comillas = '"';
        int altura = this.claves_ocupadas / 2;

        texto = texto + "subgraph TablaHash{ \n";
        texto = texto + "nodesep =.01; \n";
        texto = texto + "rankdir = LR; \n";
        texto = texto + "node[shape=record,width=.1,height=" + altura + ", color=yellow]; \n";

        texto = texto + "nodeArray[label=" + comillas;
        for (int i = 0; i <= this.Tabla.length - 1; i++) {
            texto = texto + "<f" + i + ">" + i;
            if (i < this.Tabla.length - 1) {
                texto = texto + "|";
            }
        }
        texto = texto + comillas + "]; \n";
//            fw_archivo.write("node[width = 1.5 \n]");

        for (int i = 0; i < Tabla.length; i++) {
            if (Tabla[i] != null) {
                if (!Tabla[i].getLista().isEmpty()) {
                    String ListaEstudiantes = Tabla[i].getLista().ListaClientes();
                    texto = texto + "node" + i + "[label=" + comillas + "{" + ListaEstudiantes + "}" + comillas + ", height = 0.1]; \n";
                }
            }
        }
        texto = texto + "\n";
        for (int i = 0; i < Tabla.length; i++) {
            if (Tabla[i] != null) {
                if (!Tabla[i].getLista().isEmpty()) {
                    texto = texto + "nodeArray:f" + i + "->node" + i + ":f0; \n";
                }
            }
        }

        texto = texto + "} \n";
        return texto;
    }
}
