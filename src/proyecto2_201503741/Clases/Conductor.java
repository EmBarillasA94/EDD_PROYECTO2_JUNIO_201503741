/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_201503741.Clases;

/**
 *
 * @author EDDY
 */
public class Conductor {

    private long dpi;
    private String nombres;
    private String apellidos;
    private String tipo_licencia;
    private String genero;
    private String fecha_nacimiento;
    private int telefono;
    private String direccion;
    private int numero_viajes;
    private Conductor before;
    private Conductor next;

    public Conductor(long dpi, String nombres, String apellidos, String tipo_licencia, String genero, String fecha_nacimiento, int telefono, String direccion) {
        this.dpi = dpi;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_licencia = tipo_licencia;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numero_viajes = 0;
        this.before = null;
        this.next = null;
    }

    public long getDpi() {
        return dpi;
    }

    public void setDpi(long dpi) {
        this.dpi = dpi;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Conductor getBefore() {
        return before;
    }

    public void setBefore(Conductor before) {
        this.before = before;
    }

    public Conductor getNext() {
        return next;
    }

    public void setNext(Conductor next) {
        this.next = next;
    }

    public int getNumero_viajes() {
        return numero_viajes;
    }

    public void setNumero_viajes(int numero_viajes) {
        this.numero_viajes = numero_viajes;
    }
    
    public void AumentarViajes() {
        this.numero_viajes += 1;
    }
}
