/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import proyecto2_201503741.Clases.Cliente;
import proyecto2_201503741.Clases.Conductor;
import proyecto2_201503741.Clases.Vehiculo;
import proyecto2_201503741.Clases.Vertice;
import proyecto2_201503741.EDD.Arbol_B;
import proyecto2_201503741.EDD.Lista_Conductores;
import proyecto2_201503741.EDD.Tabla_Hash;
import proyecto2_201503741.EDD.Lista_Adyacencia;

/**
 *
 * @author EDDY
 */
public class Proyecto2_201503741 {

    public static Tabla_Hash Tabla = new Tabla_Hash();
    public static Lista_Conductores Lista_Conductores = new Lista_Conductores();
    public static Arbol_B Arbol_Vehiculos = new Arbol_B();
    public static Lista_Adyacencia Grafo = new Lista_Adyacencia();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        long a = 2552889210101l;
//        long b = 2552889210100l;
//        int clave = (int) (a % 37);
//        System.out.println("a: "+ a);
//        System.out.println("b: "+b);
//        System.out.println("clave: "+clave);
//        System.out.println("suma de a y b: "+(a+b));
//        if (a > b) {
//            System.out.println("el mayor es a");
//        } else {
//            System.out.println("el mayor es b");
//        }
//        String ruta = "C:\\Users\\EDDY\\Desktop\\Clientes.txt";
//
//        LeerArchivoClientes(ruta);
//        Tabla.Eliminar(465321232212l);
//        Tabla.Graph();
//        Cliente cli = Tabla.Buscar(221374732231l);
//        if (cli != null)
//        System.out.println("cliente: " + cli.getDpi() + " " + cli.getNombres());
//        for (int i = 0; i <= 111; i++) {
//            Cliente cli = new Cliente(i, "cliente"+i, "apellidos", "genero", "fecha nacimiento", 12345, "direccion");
//            Tabla.Insertar(cli);
//        }
//        Tabla.Graph();
//
//        String ruta = "C:\\Users\\EDDY\\Desktop\\Conductores.txt";
//        LeerArchivoConductores(ruta);
//        Lista_Conductores.Eliminar(3875490173451l);
//        Lista_Conductores.graph();
//        String placa1 = "P654CRV";
//        String placa2 = "P876GDW";
//        int comparacion = placa1.compareTo(placa2);
//        if (comparacion < 0) {
//            System.out.println("la placa1 es mayor");
//            System.out.println(placa1);
//            System.out.println("Comparacion: " + comparacion);
//        } else {
//            System.out.println("La placa2 es mayor");
//            System.out.println(placa2);
//            System.out.println("Comparcion: "+ comparacion);
//        }
//        String ruta = "C:\\Users\\EDDY\\Desktop\\Vehiculos.txt";
//        LeerArchivoVehiculos(ruta);
//        Vehiculo b = Arbol_Vehiculos.Buscar("P345RTX");
//        if (b != null) {
//            System.out.println("Vehiculo encontrado");
//            System.out.println(b.getPlaca());
//            System.out.println(b.getMarca());
//            System.out.println(b.getModelo());
//        }
//        Arbol_Vehiculos.EliminarPorplaca("P050OEX");
//        Arbol_Vehiculos.EliminarPorplaca("P175EOS");
//        Arbol_Vehiculos.EliminarPorplaca("P100TEW");
//        Arbol_Vehiculos.EliminarPorplaca("P250JSI");
//        Arbol_Vehiculos.EliminarPorplaca("P400EPQ");
//        Arbol_Vehiculos.EliminarPorplaca("P140GNI");
//        Arbol_Vehiculos.EliminarPorplaca("P425HRP");
//        Arbol_Vehiculos.EliminarPorplaca("P300QEA");
//        Arbol_Vehiculos.EliminarPorplaca("P900VSF");
//        Arbol_Vehiculos.EliminarPorplaca("P325YWP");
//        Arbol_Vehiculos.EliminarPorplaca("P150ERT");
//        Arbol_Vehiculos.EliminarPorplaca("P600ANB");
//        Arbol_Vehiculos.EliminarPorplaca("P140GNI");
//        Arbol_Vehiculos.EliminarPorplaca("P300QEA");
//        Arbol_Vehiculos.EliminarPorplaca("P345RTX");
//        Arbol_Vehiculos.EliminarPorplaca("P175EOS");
//        Arbol_Vehiculos.EliminarPorplaca("P425HRP");
//        Arbol_Vehiculos.EliminarPorplaca("P200CDQ");
//        Arbol_Vehiculos.EliminarPorplaca("P625DWE");
//        Arbol_Vehiculos.EliminarPorplaca("P550MXA");
//        Arbol_Vehiculos.EliminarPorplaca("P654CRV");
//        Arbol_Vehiculos.EliminarPorplaca("P100TEW");   
//        Arbol_Vehiculos.EliminarPorplaca("P400EPQ");
//        Arbol_Vehiculos.EliminarPorplaca("P250JSI");
//        Arbol_Vehiculos.EliminarPorplaca("P125QPW");
//        Arbol_Vehiculos.EliminarPorplaca("P450ZNQ");
//        Arbol_Vehiculos.EliminarPorplaca("P050OEX");
//        Arbol_Vehiculos.EliminarPorplaca("P075WOQ");
//        Arbol_Vehiculos.EliminarPorplaca("P500RTI");
//        Arbol_Vehiculos.EliminarPorplaca("P700YQZ");
//        Arbol_Vehiculos.EliminarPorplaca("P876GDW");
//        Arbol_Vehiculos.Reporte_ArbolB();

        String ruta = "C:\\Users\\EDDY\\Desktop\\Rutas.txt";
        LeerArchivoRutas(ruta);
        Grafo.Graph();
        Grafo.Dijstra("Zaragoza", "Gerona");
        
    }

    public static void LeerArchivoClientes(String ruta) {

        String texto = "";
        try {
            File archivo = new File(ruta);
            FileReader fr_archivo = new FileReader(archivo);
            BufferedReader br_archivo = new BufferedReader(fr_archivo);

            String linea;
            while ((linea = br_archivo.readLine()) != null) {
                texto = texto + linea;
            }
            fr_archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Texto: "+texto);
        String[] separador = texto.split(";");
        for (int i = 0; i < separador.length; i++) {
            String[] separador2 = separador[i].split(",");
            String dpi = separador2[0].trim();
            String nombres = separador2[1].trim();
            String apellidos = separador2[2].trim();
            String genero = separador2[3].trim();
            String fecha = separador2[4].trim();
            String telefono = separador2[5].trim();
            String direccion = separador2[6].trim();
            Cliente ClienteNuevo = new Cliente(Long.parseLong(dpi), nombres, apellidos, genero, fecha, Integer.parseInt(telefono), direccion);
            Tabla.Insertar(ClienteNuevo);
        }
    }

    public static void LeerArchivoConductores(String ruta) {
        String texto = "";
        try {
            File archivo = new File(ruta);
            FileReader fr_archivo = new FileReader(archivo);
            BufferedReader br_archivo = new BufferedReader(fr_archivo);

            String linea;
            while ((linea = br_archivo.readLine()) != null) {
                texto = texto + linea;
            }
            fr_archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Texto: "+texto);
        String[] separador = texto.split(";");
        for (int i = 0; i < separador.length; i++) {
            String[] separador2 = separador[i].split("%");
            String dpi = separador2[0].trim();
            String nombres = separador2[1].trim();
            String apellidos = separador2[2].trim();
            String licencia = separador2[3].trim();
            String genero = separador2[4].trim();
            String fecha = separador2[5].trim();
            String telefono = separador2[6].trim();
            String direccion = separador2[7].trim();
            Conductor ConductorNuevo = new Conductor(Long.parseLong(dpi), nombres, apellidos, licencia, genero, fecha, Integer.parseInt(telefono), direccion);
            Lista_Conductores.Insertar(ConductorNuevo);
        }
    }

    public static void LeerArchivoVehiculos(String ruta) {
        String texto = "";
        try {
            File archivo = new File(ruta);
            FileReader fr_archivo = new FileReader(archivo);
            BufferedReader br_archivo = new BufferedReader(fr_archivo);

            String linea;
            while ((linea = br_archivo.readLine()) != null) {
                texto = texto + linea;
            }
            fr_archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Texto: "+texto);
        String[] separador = texto.split(";");
        for (int i = 0; i < separador.length; i++) {
            String[] separador2 = separador[i].split(":");
            String placa = separador2[0].trim();
            String marca = separador2[1].trim();
            String modelo = separador2[2].trim();
            String anio = separador2[3].trim();
            String color = separador2[4].trim();
            String precio = separador2[5].trim();
            String transmicion = separador2[6].trim();
            Vehiculo NuevoVehiculo = new Vehiculo(placa, marca, modelo, Integer.parseInt(anio), color, precio, transmicion);
            Arbol_Vehiculos.Insertar(NuevoVehiculo);
        }
    }

    public static void LeerArchivoRutas(String ruta) {
        String texto = "";
        try {
            File archivo = new File(ruta);
            FileReader fr_archivo = new FileReader(archivo);
            BufferedReader br_archivo = new BufferedReader(fr_archivo);

            String linea;
            while ((linea = br_archivo.readLine()) != null) {
                texto = texto + linea;
            }
            fr_archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Texto: "+texto);
        String[] separador = texto.split("%");
        for (int i = 0; i < separador.length; i++) {
            String[] separador2 = separador[i].split("/");
            String origen = separador2[0].trim();
            String destino = separador2[1].trim();
            String tiempo = separador2[2].trim();
            Vertice v1 = new Vertice(origen);
            Vertice v2 = new Vertice(destino);
            Grafo.Insertar_Vertice(v1);
            Grafo.Insertar_Vertice(v2);
            Grafo.Insertar_Arista(origen, destino, Integer.parseInt(tiempo));
        }
    }
}
