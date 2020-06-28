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
public class Nodo_B {

    Vehiculo[] vehiculos;
    Nodo_B[] Ramas;
    Nodo_B Padre;
    boolean esPadre;
    int cantidad;

    public Nodo_B() {
        this.vehiculos = new Vehiculo[5];
        this.Ramas = new Nodo_B[6];
        this.Padre = null;
        this.esPadre = false;
        this.cantidad = 0;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Nodo_B[] getRamas() {
        return Ramas;
    }

    public void setRamas(Nodo_B[] Ramas) {
        this.Ramas = Ramas;
    }

    public Nodo_B getPadre() {
        return Padre;
    }

    public void setPadre(Nodo_B Padre) {
        this.Padre = Padre;
    }

    public boolean getEsPadre() {
        return esPadre;
    }

    public void setEsPadre(boolean esPadre) {
        this.esPadre = esPadre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void Insertar(Vehiculo vehiculo) {
        for (int i = 0; i < this.vehiculos.length; i++) {
            if (this.vehiculos[i] == null) {
                this.vehiculos[i] = vehiculo;
                cantidad++;
                break;
            }
        }
        if (this.cantidad > 1) {
            Ordenar_Vehiculos();
        }
    }

    private void Ordenar_Vehiculos() {
        int comparacion;
        for (int i = 0; i < this.cantidad - 1; i++) {
            for (int j = i + 1; j < this.cantidad; j++) {
                comparacion = this.vehiculos[i].getPlaca().compareTo(this.vehiculos[j].getPlaca());
                if (comparacion > 0) {
                    Vehiculo aux = this.vehiculos[i];
                    this.vehiculos[i] = this.vehiculos[j];
                    this.vehiculos[j] = aux;
                }
            }
        }
    }

    public void Insertar_Rama(Nodo_B NuevaRama) {
        for (int i = 0; i < this.Ramas.length; i++) {
            if (this.Ramas[i] == null) {
                this.Ramas[i] = NuevaRama;
                break;
            }
        }
        Ordenar_Ramas();
    }

    private void Ordenar_Ramas() {
        int comparacion;
        for (int i = 0; i < this.Ramas.length - 1; i++) {
            for (int j = i + 1; j < this.Ramas.length; j++) {
                if (this.Ramas[i] != null && this.Ramas[j] != null) {
                    comparacion = this.Ramas[i].getVehiculos()[0].getPlaca().compareTo(this.Ramas[j].getVehiculos()[0].getPlaca());
                    if (comparacion > 0) {
                        Nodo_B aux = this.Ramas[i];
                        this.Ramas[i] = this.Ramas[j];
                        this.Ramas[j] = aux;
                    }
                }
            }
        }
    }

    public void Eliminar_Rama(Vehiculo v) {
        int comparacion;
        for (int i = 0; i < this.Ramas.length; i++) {
            comparacion = v.getPlaca().compareTo(this.Ramas[i].getVehiculos()[0].getPlaca());
            if (comparacion == 0) {
                this.Ramas[i] = null;
                while (i < this.Ramas.length) {//6
                    if (i == 5) {
                        this.Ramas[i] = null;
                    } else {
                        this.Ramas[i] = this.Ramas[i + 1];
                    }
                    i++;
                }
                break;
            }
        }
    }
}
