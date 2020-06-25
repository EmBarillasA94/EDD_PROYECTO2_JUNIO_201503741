/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import proyecto2_201503741.Clases.Cliente;
import proyecto2_201503741.EDD.Tabla_Hash;

/**
 *
 * @author EDDY
 */
public class Proyecto2_201503741 {

    /**
     * @param args the command line arguments
     */
    public static Tabla_Hash Tabla = new Tabla_Hash();

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
        for (int i = 0; i <= 111; i++) {
            Cliente cli = new Cliente(i, "cliente"+i, "apellidos", "genero", "fecha nacimiento", 12345, "direccion");
            Tabla.Insertar(cli);
        }
        Tabla.Graph();
    }

    public static void LeerArchivoClientes(String ruta) {

        String texto = "";
        try {
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                texto = texto + linea;
            }
            fr.close();
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
}
