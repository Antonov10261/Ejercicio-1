package Ejercicios.Ejercicio1;

import java.time.LocalDate;

public class Ticket {
    private String numero;
    private LocalDate fechaCompra;
    private Comprador comprador;
    private Localidad localidad;
    private double precio;

    public Ticket(String numero, LocalDate fechaCompra, Comprador comprador, Localidad localidad, double precio) {
        this.numero = numero;
        this.fechaCompra = fechaCompra;
        this.comprador = comprador;
        this.localidad = localidad;
        this.precio = precio;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public double getPrecio() {
        return precio;
    }
}

