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

    public void Insertar_Vertice(Vertice v) {
        if (isEmpty()) {
            this.Inicio = v;
            this.size++;
        } else {
            Vertice v_buscado = Buscar(v.getNombre());
            if (v_buscado == null) {
                //vertice no existe
                Vertice aux = this.Inicio;
                while (aux.getAbajo() != null) {
                    aux = aux.getAbajo();
                }
                aux.setAbajo(v);
                this.size++;
            }
        }
    }

    public void Insertar_Arista(String origen, String destino, int tiempo) {
        Vertice v_buscar = Buscar(origen);
        if (v_buscar != null) {
            v_buscar.Insertar_Arista(origen, destino, tiempo);
        }
    }

    public Vertice Buscar(String nombre) {
        if (!isEmpty()) {
            Vertice aux = this.Inicio;
            while (aux != null) {
                if (aux.getNombre().equals(nombre)) {
                    return aux;
                }
                aux = aux.getAbajo();
            }
        }
        return null;
    }

//    private int posVertice(String nombre) {
//        Vertice vr = this.Inicio;
//        int pos = 0;
//        while (vr != null) {
//            if (vr.getNombre().equals(nombre)) {
//                return pos;
//            }
//            pos++;
//            vr = vr.getAbajo();
//        }
//        return pos;
//    }
    private Vertice getVertice(int i) {
        Vertice aux = this.Inicio;
        for (int j = 0; j < i; j++) {
            aux = aux.getAbajo();
        }
        return aux;
    }

    public Lista_Aristas Dijstra(String origen, String destino) {
        Vertice v_origen = Buscar(origen);
        Vertice aux = this.Inicio;

        while (aux != null) {
            aux.setValor(v_origen.getTiempo(aux.getNombre()));
            aux.setVisto(false);
            aux.setUltimo((v_origen.getArista(aux.getNombre()) != null) ? v_origen.getArista(aux.getNombre()).getOrigen() : "-");
            aux = aux.getAbajo();
        }

        v_origen.setValor(0);
        v_origen.setVisto(true);

        aux = this.Inicio;
        while (aux != null) {
            Vertice v_minimo = getVerticeMinimo();
            if (v_minimo != null) {
                Vertice aux2 = this.Inicio;
                while (aux2 != null) {
                    if (!aux2.isVisto() && (v_minimo.getValor() + v_minimo.getTiempo(aux2.getNombre()) < aux2.getValor())) {
                        aux2.setValor(v_minimo.getValor() + v_minimo.getTiempo(aux2.getNombre()));
                        aux2.setUltimo(v_minimo.getNombre());
                    }
                    aux2 = aux2.getAbajo();
                }
            }
            aux = aux.getAbajo();
        }

        return Obtener_Ruta(destino);

    }

    private Vertice getVerticeMinimo() {
        Vertice aux = this.Inicio;
        int valor_menor = Integer.MAX_VALUE / 2;
        int i = 0;
        int pos_vertice = -1;
        while (aux != null) {
            if (!aux.isVisto() && aux.getValor() < valor_menor) {
                valor_menor = aux.getValor();
                pos_vertice = i;
            }
            aux = aux.getAbajo();
            i++;
        }
        if (valor_menor != Integer.MAX_VALUE / 2 && pos_vertice != -1) {
            Vertice v_menor = getVertice(pos_vertice);
            v_menor.setVisto(true);
            return v_menor;
        }
        return null;

    }

    private Lista_Aristas Obtener_Ruta(String destino) {
        Vertice v_destino = Buscar(destino);
        Lista_Aristas lista_RutaCorta = new Lista_Aristas();
        while (v_destino != null) {
            Arista A = new Arista(v_destino.getUltimo(), v_destino.getNombre(), v_destino.getValor());
            lista_RutaCorta.Insertar_firts(A);
            v_destino = Buscar(v_destino.getUltimo());
        }
        return lista_RutaCorta;
    }

    public String[] ListadoVertices() {
        String[] listado = new String[this.size];
        Vertice aux = this.Inicio;
        if (!isEmpty()) {
            for (int i = 0; i < this.size; i++) {
                listado[i] = aux.getNombre();
                aux = aux.getAbajo();
            }
        }
        return listado;
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
                fw_archivo.write("" + comillas + aux.getNombre() + "_G" + comillas + "[label=" + comillas + aux.getNombre() + comillas + "] \n");
                aux = aux.getAbajo();
            }
            fw_archivo.write("\n");
            aux = this.Inicio;
            for (int i = 0; i < this.size; i++) {
                Arista auxArista = aux.getInicio();
                for (int j = 0; j < aux.getTamLista(); j++) {
                    fw_archivo.write("" + comillas + aux.getNombre() + "_G" + comillas + " -> " + comillas + auxArista.getDestino() + "_G" + comillas);
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

    public String getSubgraph() {
        String texto = "";
        char comillas = '"';

        texto = texto + "subgraph Grafo{ \n";
        texto = texto + "rankdir = LR; \n";
        texto = texto + "node[shape=oval, color=orange]; \n";

        Vertice aux = this.Inicio;
        for (int i = 0; i < this.size; i++) {
            texto = texto + "" + comillas + aux.getNombre() + "_G" + comillas + "[label=" + comillas + aux.getNombre() + comillas + "] \n";
            aux = aux.getAbajo();
        }
        texto = texto + "\n";
        aux = this.Inicio;
        for (int i = 0; i < this.size; i++) {
            Arista auxArista = aux.getInicio();
            for (int j = 0; j < aux.getTamLista(); j++) {
                texto = texto + "" + comillas + aux.getNombre() + "_G" + comillas + " -> " + comillas + auxArista.getDestino() + "_G" + comillas;
                texto = texto + "[label= " + comillas + auxArista.getTiempo() + comillas + "] \n";
                auxArista = auxArista.getSiguiente();
            }
            aux = aux.getAbajo();
        }
        texto = texto + "}";
        return texto;
    }

}
