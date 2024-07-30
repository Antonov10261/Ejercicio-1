package Ejercicios.Ejercicio1;

public class Localidad {
    private String nombre;
    private int capacidadTotal;
    private int capacidadDisponible;
    private double precio;

    public Localidad(String nombre, int capacidadTotal, double precio) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void venderBoletos(int cantidad) {
        if (cantidad <= capacidadDisponible) {
            capacidadDisponible -= cantidad;
        }
    }
}