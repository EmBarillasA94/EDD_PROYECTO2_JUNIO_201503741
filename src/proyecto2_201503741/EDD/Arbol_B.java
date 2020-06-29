/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.EDD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto2_201503741.Clases.Nodo_B;
import proyecto2_201503741.Clases.Vehiculo;

/**
 *
 * @author EDDY
 */
public class Arbol_B {
    
    Nodo_B raiz;
    
    public Arbol_B() {
        this.raiz = new Nodo_B();
    }
    
    public void Insertar(Vehiculo n) {
        Insertar_en_Hoja(this.raiz, n);
    }
    
    private void Insertar_en_Hoja(Nodo_B nodo, Vehiculo vehiculo) {
        if (nodo != null) {
            if (!nodo.getEsPadre()) {//es una hoja
                nodo.Insertar(vehiculo);
                if (nodo.getCantidad() == 5) {
                    //dividir el nodo
                    Dividir(nodo);
                }
            } else {//es padre
                for (int i = 0; i < nodo.getVehiculos().length; i++) {
                    if (nodo.getVehiculos()[i] != null) {
                        int comparacion = vehiculo.getPlaca().compareTo(nodo.getVehiculos()[i].getPlaca());
                        if (comparacion < 0) {
                            Insertar_en_Hoja(nodo.getRamas()[i], vehiculo);
                            break;
                        }
                    } else {
                        Insertar_en_Hoja(nodo.getRamas()[i], vehiculo);
                        break;
                    }
                }
            }
        }
        
    }
    
    private void Dividir(Nodo_B nodo) {
        Nodo_B H_Izquierdo = new Nodo_B();
        Nodo_B H_Derecho = new Nodo_B();
        
        if (nodo.getEsPadre()) {//si tiene hijos antes de dividirlo hay que asignar las ramas a los hijos
            //al hijo izquierdo
            H_Izquierdo.getRamas()[0] = nodo.getRamas()[0];
            H_Izquierdo.getRamas()[1] = nodo.getRamas()[1];
            H_Izquierdo.getRamas()[2] = nodo.getRamas()[2];
            H_Izquierdo.setEsPadre(true);
            nodo.getRamas()[0].setPadre(H_Izquierdo);
            nodo.getRamas()[1].setPadre(H_Izquierdo);
            nodo.getRamas()[2].setPadre(H_Izquierdo);
            //al hijo derecho
            H_Derecho.getRamas()[0] = nodo.getRamas()[3];
            H_Derecho.getRamas()[1] = nodo.getRamas()[4];
            H_Derecho.getRamas()[2] = nodo.getRamas()[5];
            H_Derecho.setEsPadre(true);
            nodo.getRamas()[3].setPadre(H_Derecho);
            nodo.getRamas()[4].setPadre(H_Derecho);
            nodo.getRamas()[5].setPadre(H_Derecho);
            //borrando las ramas del nodo
            for (int i = 0; i < nodo.getRamas().length; i++) {
                nodo.getRamas()[i] = null;
            }
        }

        //pasar los valores del nodo que se va a dirivir a los hijos
        H_Izquierdo.Insertar(nodo.getVehiculos()[0]);
        H_Izquierdo.Insertar(nodo.getVehiculos()[1]);
        H_Derecho.Insertar(nodo.getVehiculos()[3]);
        H_Derecho.Insertar(nodo.getVehiculos()[4]);

        //pasando el valor de en medio al principio de la lista y borrando los demas
        nodo.getVehiculos()[0] = nodo.getVehiculos()[2];
        nodo.getVehiculos()[1] = null;
        nodo.getVehiculos()[2] = null;
        nodo.getVehiculos()[3] = null;
        nodo.getVehiculos()[4] = null;
        nodo.setCantidad(1);

        //enlazando el nodo dividido con los hijos 
        nodo.getRamas()[0] = H_Izquierdo;
        nodo.getRamas()[1] = H_Derecho;
        H_Izquierdo.setPadre(nodo);
        H_Derecho.setPadre(nodo);
        nodo.setEsPadre(true);

        //revisar si el nodo que se dividio tiene un padre para subir el valor y los hijos
        if (nodo.getPadre() != null) {
            Nodo_B auxPadre = nodo.getPadre();
            auxPadre.Insertar(nodo.getVehiculos()[0]);
            auxPadre.Eliminar_Rama(nodo.getVehiculos()[0]);
            auxPadre.Insertar_Rama(H_Izquierdo);
            auxPadre.Insertar_Rama(H_Derecho);
            H_Izquierdo.setPadre(auxPadre);
            H_Derecho.setPadre(auxPadre);
            nodo.getRamas()[0] = null;
            nodo.getRamas()[1] = null;
            nodo = null;
            if (auxPadre.getCantidad() == 5) {
                Dividir(auxPadre);
            }
        }
    }
    
    public Vehiculo Buscar(String placa) {
        Nodo_B aux = this.raiz;
        Vehiculo v = Buscar_P(aux, placa);
        return v;
    }
    
    private Vehiculo Buscar_P(Nodo_B nodo, String placa) {
        if (nodo != null) {
            int comparacion;
            for (int i = 0; i < nodo.getVehiculos().length; i++) {
                if (nodo.getVehiculos()[i] != null) {
                    comparacion = placa.compareTo(nodo.getVehiculos()[i].getPlaca());
                    if (comparacion == 0) {
                        Vehiculo aux = nodo.getVehiculos()[i];
                        return aux;
                    } else if (comparacion < 0) {
                        return Buscar_P(nodo.getRamas()[i], placa);
                    }
                } else {
                    return Buscar_P(nodo.getRamas()[i], placa);
                }
            }
        }
        return null;
    }
    
    Nodo_B buscar;
    
    public void EliminarPorplaca(String placa) {
        Nodo_B aux = this.raiz;
        Nodo_B NodoBuscado = BuscarNodo(aux, placa);
        if (NodoBuscado != null) {
            if (NodoBuscado == this.raiz && !NodoBuscado.getEsPadre()) {//1
                EliminarHoja(NodoBuscado, placa);//el nodo es la raiz pero no tiene hijos
            } else if (NodoBuscado == this.raiz && NodoBuscado.getEsPadre()) {//el nodo es la raiz pero tiene hijos (2)
                //validar cuantos valores tiene el nodo 
                if (NodoBuscado.getCantidad() > 1) {
                    EliminarVehiculoRama(NodoBuscado, placa);
                } else {
                    EliminarVehiculoRama(NodoBuscado, placa);
                }
            } else if (NodoBuscado != this.raiz && !NodoBuscado.getEsPadre()) {//3
                EliminarHoja(NodoBuscado, placa);//el nodo es una hoja
            } else if (NodoBuscado != this.raiz && NodoBuscado.getEsPadre()) {//el nodo no es la raiz pero tiene hijos
                EliminarVehiculoRama(NodoBuscado, placa);//Rama
            }
        } else {
            JOptionPane.showMessageDialog(null, "El placa no existe en la biblioteca");
        }
        buscar = null;
    }
    
    private Nodo_B BuscarNodo(Nodo_B raiz, String placa) {
        if (raiz != null) {
            int comparacion;
            for (int i = 0; i < raiz.getVehiculos().length; i++) {
                if (raiz.getVehiculos()[i] != null) {
                    comparacion = placa.compareTo(raiz.getVehiculos()[i].getPlaca());
                    if (comparacion == 0) {
                        buscar = raiz;
                        return buscar;
                    }
                }
            }
            for (int i = 0; i < raiz.getRamas().length; i++) {
                BuscarNodo(raiz.getRamas()[i], placa);
            }
        }
        return buscar;
    }
    
    private void EliminarHoja(Nodo_B NodoBuscado, String placa) {//cuando es hoja y > 2
        boolean eliminado = false;
        for (int i = 0; i < NodoBuscado.getVehiculos().length; i++) {
            if (NodoBuscado.getVehiculos()[i] != null) {
                if (NodoBuscado.getVehiculos()[i].getPlaca().equals(placa) && !eliminado) {
                    NodoBuscado.getVehiculos()[i] = null;
                    NodoBuscado.setCantidad(NodoBuscado.getCantidad() - 1);
                    eliminado = true;
                }
                if (eliminado) {
                    NodoBuscado.getVehiculos()[i] = NodoBuscado.getVehiculos()[i + 1];
                }
            }
        }
        if (NodoBuscado != this.raiz) {
            //balancear
            if (NodoBuscado.getCantidad() < 2) {
                Balancear2(NodoBuscado.getPadre());
            }
        }
    }
    
    private void Balancear2(Nodo_B Padre) {
        if (Padre != null) {
            int posNodo = 0;
            boolean bandera = false;
            for (int i = 0; i < Padre.getRamas().length; i++) {
                if (Padre.getRamas()[i] != null) {
                    if (Padre.getRamas()[i].getCantidad() < 2) {
                        posNodo = i;//2
                        bandera = true;
                        break;
                    }
                }
            }
            
            if (bandera) {//hay nodos < 2 
                if (posNodo == 0) {
                    //consultar si el nodo hermano tiene para pasar 
                    if (Padre.getRamas()[posNodo + 1].getCantidad() > 2) {
//                        Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getVehiculos()[posNodo];
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo]);
                        Padre.getVehiculos()[posNodo] = Padre.getRamas()[posNodo + 1].getVehiculos()[0];
                        //validar si el derecho tiene hijos
                        if (Padre.getRamas()[posNodo + 1].getEsPadre()) {
                            //pasar el primer nodoRama al hijo izquierdo en su ultima posicion valida
                            int pos = Padre.getRamas()[posNodo].getCantidad();
//                            Padre.getRamas()[pos] = Padre.getRamas()[posNodo + 1].getRamas()[0];
                            Padre.getRamas()[posNodo].getRamas()[pos] = Padre.getRamas()[posNodo + 1].getRamas()[0];
                            Padre.getRamas()[posNodo + 1].getRamas()[0].setPadre(Padre.getRamas()[posNodo]);
                            //eliminar el nodoRama del hijo derecho
                            Padre.getRamas()[posNodo + 1].getRamas()[0] = null;
                            //actualizar lista de nodosRamas
                            ActualizarListaNodos(Padre.getRamas()[posNodo + 1]);
//                            EliminarHoja(Padre.getRamas()[posNodo + 1], Padre.getVehiculos()[posNodo].getPlaca());
                        }
                        EliminarHoja(Padre.getRamas()[posNodo + 1], Padre.getVehiculos()[posNodo].getPlaca());
                    } else {//unir nodos
                        //pasar el menor del padre al nodo izquierdo
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo]);
                        //pasar lo valores del nodo de la derecha al nodo de la izquierda
                        Padre.getRamas()[posNodo].Insertar(Padre.getRamas()[posNodo + 1].getVehiculos()[0]);
                        Padre.getRamas()[posNodo].Insertar(Padre.getRamas()[posNodo + 1].getVehiculos()[1]);
                        //Ver si el nodo de la derecha tiene ramas
                        if (Padre.getRamas()[posNodo + 1].getEsPadre()) {
                            for (int i = 0; i < Padre.getRamas()[posNodo + 1].getRamas().length; i++) {
                                if (Padre.getRamas()[posNodo + 1].getRamas()[i] != null) {
                                    Padre.getRamas()[posNodo].Insertar_Rama(Padre.getRamas()[posNodo + 1].getRamas()[i]);
                                    Padre.getRamas()[posNodo + 1].getRamas()[i].setPadre(Padre.getRamas()[posNodo]);
                                }
                            }
                        }
                        //Eliminar nodo derecho
                        Padre.getRamas()[posNodo + 1] = null;
                        //actualizar nodos
                        ActualizarListaNodos(Padre);
                        //eliminar menor del nodo padre (ciclo)
                        EliminarHoja(Padre, Padre.getVehiculos()[posNodo].getPlaca());
                        if (Padre == this.raiz && Padre.getCantidad() < 1) {
                            this.raiz = Padre.getRamas()[0];
                            this.raiz.setPadre(null);
                        }
                    }
                } else if (Padre.getVehiculos()[posNodo] == null) {//si la rama es la ultima
                    if (Padre.getRamas()[posNodo - 1].getCantidad() > 2) {
//                        Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getVehiculos()[posNodo - 1];
//                        ordenar(Padre.getRamas()[posNodo].valores, 6);
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo - 1]);
                        Padre.getVehiculos()[posNodo - 1] = Padre.getRamas()[posNodo - 1].getVehiculos()[Padre.getRamas()[posNodo - 1].getCantidad() - 1];
                        EliminarHoja(Padre.getRamas()[posNodo - 1], Padre.getVehiculos()[posNodo - 1].getPlaca());
                    } else {//unir nodos
                        //Pasar el mayor del padre al nodo derecho
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo - 1]);
                        //Pasar los valores del nodo de la izquierda al nodo de la derecha
                        Padre.getRamas()[posNodo].Insertar(Padre.getRamas()[posNodo - 1].getVehiculos()[0]);
                        Padre.getRamas()[posNodo].Insertar(Padre.getRamas()[posNodo - 1].getVehiculos()[1]);
                        //si el nodo tiene hijos hay que pasarlos tambien 
                        if (Padre.getRamas()[posNodo - 1].getEsPadre()) {
                            for (int i = 0; i < Padre.getRamas()[posNodo - 1].getRamas().length; i++) {
                                if (Padre.getRamas()[posNodo - 1].getRamas()[i] != null) {
                                    Padre.getRamas()[posNodo].Insertar_Rama(Padre.getRamas()[posNodo - 1].getRamas()[i]);
                                    Padre.getRamas()[posNodo - 1].getRamas()[i].setPadre(Padre.getRamas()[posNodo]);
                                }
                            }
                        }
                        //eliminar nodo izquierdo
                        Padre.getRamas()[posNodo - 1] = null;
                        //Actualizar nodos
                        ActualizarListaNodos(Padre);
                        //eliminar mayor del nodo padre
                        EliminarHoja(Padre, Padre.getVehiculos()[posNodo - 1].getPlaca());
                        if (Padre == this.raiz && Padre.getCantidad() < 1) {
                            this.raiz = Padre.getRamas()[0];
                            this.raiz.setPadre(null);
                        }
                    }
                    
                } else {
                    if (Padre.getRamas()[posNodo + 1].getCantidad() > 2) {
//                        Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getVehiculos()[posNodo];
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo]);
                        Padre.getVehiculos()[posNodo] = Padre.getRamas()[posNodo + 1].getVehiculos()[0];
//                        Padre.Insertar(Padre.getRamas()[posNodo + 1].getVehiculos()[0]);
                        EliminarHoja(Padre.getRamas()[posNodo + 1], Padre.getVehiculos()[posNodo].getPlaca());
                    } else if (Padre.getRamas()[posNodo - 1].getCantidad() > 2) {
                        //cambio con los de la izquierda
//                        Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getVehiculos()[posNodo - 1];
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo - 1]);
//                        EliminarHoja(Padre,Padre.getVehiculos()[posNodo - 1].getPlaca());
//                        ordenar(Padre.getRamas()[posNodo].valores, 6);
                        Padre.getVehiculos()[posNodo - 1] = Padre.getRamas()[posNodo - 1].getVehiculos()[Padre.getRamas()[posNodo - 1].getCantidad() - 1];
//                        Padre.Insertar(Padre.getRamas()[posNodo - 1].getVehiculos()[Padre.getRamas()[posNodo - 1].getCantidad() - 1]);
                        EliminarHoja(Padre.getRamas()[posNodo - 1], Padre.getVehiculos()[posNodo - 1].getPlaca());
                    } else {//unir nodos
                        //pasar el menor del padre al nodo izquierdo
                        Padre.getRamas()[posNodo].Insertar(Padre.getVehiculos()[posNodo]);
                        //pasar lo valores del nodo de la derecha al nodo de la izquierda
                        Padre.getRamas()[posNodo].Insertar(Padre.getRamas()[posNodo + 1].getVehiculos()[0]);
                        Padre.getRamas()[posNodo].Insertar(Padre.getRamas()[posNodo + 1].getVehiculos()[1]);
                        //Ver si el nodo de la derecha tiene ramas
                        if (Padre.getRamas()[posNodo + 1].getEsPadre()) {
                            for (int i = 0; i < Padre.getRamas()[posNodo + 1].getRamas().length; i++) {
                                if (Padre.getRamas()[posNodo + 1].getRamas()[i] != null) {
                                    Padre.getRamas()[posNodo].Insertar_Rama(Padre.getRamas()[posNodo + 1].getRamas()[i]);
                                    Padre.getRamas()[posNodo + 1].getRamas()[i].setPadre(Padre.getRamas()[posNodo]);
                                }
                            }
                        }
                        //Eliminar nodo derecho
                        Padre.getRamas()[posNodo + 1] = null;
                        //actualizar nodos
                        ActualizarListaNodos(Padre);
                        //eliminar menor del nodo padre (ciclo)
                        EliminarHoja(Padre, Padre.getVehiculos()[posNodo].getPlaca());
                        if (Padre == this.raiz && Padre.getCantidad() < 1) {
                            this.raiz = Padre.getRamas()[0];
                            this.raiz.setPadre(null);
                        }
                    }
                }
            }
            if (Padre.getEsPadre()) {
                for (int i = 0; i < Padre.getRamas().length; i++) {
                    Balancear2(Padre.getRamas()[i]);
                }
            }
            
        }
    }
    
    private void EliminarVehiculoRama(Nodo_B NodoBuscado, String placa) {
        //encontrar la posicion del vehhiculo enla lista de valores
        int posVehiculo = 0;
        for (int i = 0; i < NodoBuscado.getVehiculos().length; i++) {
            if (NodoBuscado.getVehiculos()[i] != null) {
                if (NodoBuscado.getVehiculos()[i].getPlaca().equals(placa)) {
                    posVehiculo = i;//0
                    break;
                }
            }
        }

        //buscando el sucesor mayor a la izquierda
        Vehiculo SM = SucesorMayorIzquierdo(NodoBuscado.getRamas()[posVehiculo]);
        NodoBuscado.getVehiculos()[posVehiculo] = SM;
        
        Balancear2(this.raiz);
    }
    
    private void EliminarVehiculoRamaAjustar(Nodo_B NodoBuscado, String placa) {
        boolean eliminado = false;
        for (int i = 0; i < NodoBuscado.getVehiculos().length; i++) {
            if (NodoBuscado.getVehiculos()[i] != null) {
                if (NodoBuscado.getVehiculos()[i].getPlaca().equals(placa) && !eliminado) {
                    NodoBuscado.getVehiculos()[i] = null;
                    NodoBuscado.setCantidad(NodoBuscado.getCantidad() - 1);
                    eliminado = true;
                }
                if (eliminado) {
                    NodoBuscado.getVehiculos()[i] = NodoBuscado.getVehiculos()[i + 1];
                }
            }
        }

        //balancear
        if (NodoBuscado.getCantidad() < 2) {
            BalancearAjustar(NodoBuscado.getPadre());
        }
        
    }
    
    private void BalancearAjustar(Nodo_B Padre) {
        if (Padre != null) {
            int posNodo = 0;
            boolean bandera = false;
            for (int i = 0; i < Padre.getRamas().length; i++) {
                if (Padre.getRamas()[i] != null) {
                    if (Padre.getRamas()[i].getCantidad() < 2) {
                        posNodo = i;//1
                        bandera = true;
                    }
                }
            }
            if (bandera) {
                if (posNodo == 0) {
                    //pasar el menor del padre al nodo izquierdo
                    Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getVehiculos()[posNodo];
                    //pasar lo getVehiculos() del nodo de la derecha al nodo de la izquierda
                    Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getRamas()[posNodo + 1].getVehiculos()[0];
                    Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getRamas()[posNodo + 1].getVehiculos()[1];
                    //Eliminar nodo derecho
                    Padre.getRamas()[posNodo + 1] = null;
                    //actualizar nodos
                    ActualizarListaNodos(Padre);
                    //eliminar menor del nodo padre (ciclo)
                    EliminarHoja(Padre, Padre.getVehiculos()[posNodo].getPlaca());
                    this.raiz = Padre.getRamas()[posNodo];
                } else {
                    //Pasar el mayor del padre al nodo derecho
                    Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getVehiculos()[posNodo - 1];
                    //ordenar getVehiculos()
//                    ordenar(Padre.getRamas()[posNodo].getVehiculos(), 6);
                    //Pasar los getVehiculos() del nodo de la izquierda al nodo de la derecha
                    Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getRamas()[posNodo - 1].getVehiculos()[0];
                    Padre.getRamas()[posNodo].getVehiculos()[Padre.getRamas()[posNodo].getCantidad()] = Padre.getRamas()[posNodo - 1].getVehiculos()[1];
                    //ordenar de nuevo
//                    ordenar(Padre.getRamas()[posNodo].getVehiculos(), 6);
                    //eliminar nodo izquierdo
                    Padre.getRamas()[posNodo - 1] = null;
                    //Actualizar nodos
                    ActualizarListaNodos(Padre);
                    //eliminar mayor del nodo padre
                    EliminarHoja(Padre, Padre.getVehiculos()[posNodo - 1].getPlaca());
                    this.raiz = Padre.getRamas()[posNodo - 1];
                }
            }
        }
    }
    
    private Vehiculo SucesorMayorIzquierdo(Nodo_B NodoIzquierdo) {
        if (NodoIzquierdo.getEsPadre()) {//Buscar el mas a su derecha
            return SucesorMayorDerecho(NodoIzquierdo.getRamas()[NodoIzquierdo.getCantidad()]);
        } else {
            Vehiculo aux = NodoIzquierdo.getVehiculos()[NodoIzquierdo.getCantidad() - 1];
            NodoIzquierdo.getVehiculos()[NodoIzquierdo.getCantidad() - 1] = null;
            NodoIzquierdo.setCantidad(NodoIzquierdo.getCantidad() - 1);
            return aux;
        }
    }
    
    private Vehiculo SucesorMayorDerecho(Nodo_B NodoDerecho) {
        if (NodoDerecho.getEsPadre()) {//Buscar el mas a su derecha
            return SucesorMayorDerecho(NodoDerecho.getRamas()[NodoDerecho.getCantidad()]);
        } else {
            Vehiculo aux = NodoDerecho.getVehiculos()[NodoDerecho.getCantidad() - 1];
            NodoDerecho.getVehiculos()[NodoDerecho.getCantidad() - 1] = null;
            NodoDerecho.setCantidad(NodoDerecho.getCantidad() - 1);
            return aux;
        }
    }
    
    private void ActualizarListaNodos(Nodo_B Padre) {
        if (Padre != null) {
            for (int i = 0; i < Padre.getRamas().length; i++) {
                try {
                    if (Padre.getRamas()[i] == null && Padre.getRamas()[i + 1] != null) {
                        Padre.getRamas()[i] = Padre.getRamas()[i + 1];
                        Padre.getRamas()[i + 1] = null;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
                
            }
        }
    }
    
    File R_ArbolB;
    FileWriter FW_ArbolB;
    char com = '"';
    String espacio = "&#92;n";
    
    public void Reporte_ArbolB() {
        try {
            R_ArbolB = new File("R_ArbolB.dot");
            FW_ArbolB = new FileWriter(R_ArbolB);
            
            FW_ArbolB.write("digraph g{ \n");
            FW_ArbolB.write("rankdir = TB; \n");
            FW_ArbolB.write("node [shape = record]; \n");

//            Nodo_B aux = this.primerNodo;
            GraficarNodos(this.raiz);
            FW_ArbolB.write("\n");
            CrearEnlaces(this.raiz);
            FW_ArbolB.write("} \n");
            FW_ArbolB.close();

            //"C:\\release\\bin\\dot.exe -Tpng R_ArbolAVL.dot -o Grafica_ArbolAVL.png"
            String Comando = "C:\\release\\bin\\dot.exe -Tpng R_ArbolB.dot -o Grafica_ArbolB.png";
            Process p;
            try {
                p = Runtime.getRuntime().exec(Comando);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void GraficarNodos(Nodo_B Raiz) {
        if (Raiz != null) {
            try {
                FW_ArbolB.write(Raiz.hashCode() + "[label =" + com);
            } catch (IOException ex) {
                Logger.getLogger(Arbol_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            int nonull = 0;
            for (int i = 0; i < Raiz.getRamas().length; i++) {
                if (Raiz.getRamas()[i] != null) {
                    nonull++;
                }
            }
            for (int i = 0; i < 5; i++) {
                if (Raiz.getRamas()[i] != null) {
                    try {
                        FW_ArbolB.write("<" + Raiz.getRamas()[i].hashCode() + ">");
                    } catch (IOException ex) {
                        Logger.getLogger(Arbol_B.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (i < nonull - 1) {
                    try {
                        FW_ArbolB.write("|");
                    } catch (IOException ex) {
                        Logger.getLogger(Arbol_B.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (Raiz.getVehiculos()[i] != null) {
                    try {
                        FW_ArbolB.write(Raiz.getVehiculos()[i].getPlaca() + espacio + Raiz.getVehiculos()[i].getModelo() + "|");
                    } catch (IOException ex) {
                        Logger.getLogger(Arbol_B.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            try {
                FW_ArbolB.write(com + "]; \n");
            } catch (IOException ex) {
                Logger.getLogger(Arbol_B.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (int i = 0; i < Raiz.getRamas().length; i++) {
                GraficarNodos(Raiz.getRamas()[i]);
            }
        }
    }
    
    private void CrearEnlaces(Nodo_B Raiz) {
        if (Raiz != null) {
            for (int i = 0; i < Raiz.getRamas().length; i++) {
                if (Raiz.getRamas()[i] != null) {
                    try {
                        FW_ArbolB.write(Raiz.hashCode() + ":" + Raiz.getRamas()[i].hashCode() + "->" + Raiz.getRamas()[i].hashCode() + ":n; \n");
                    } catch (IOException ex) {
                        Logger.getLogger(Arbol_B.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            for (int i = 0; i < Raiz.getRamas().length; i++) {
                CrearEnlaces(Raiz.getRamas()[i]);
            }
        }
    }
    
}
