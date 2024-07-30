package Ejercicios.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaVentaBoletos {
    private LocalDate fechaVenta;
    private List<Localidad> localidades;
    private List<Comprador> compradores;
    private List<Ticket> tickets;
    private int correlativo;

    public SistemaVentaBoletos(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
        this.localidades = new ArrayList<>();
        this.compradores = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.correlativo = 1;
        configurarLocalidades();
    }

    private void configurarLocalidades() {
        localidades.add(new Localidad("Localidad 1", 100, 100));
        localidades.add(new Localidad("Localidad 5", 100, 500));
        localidades.add(new Localidad("Localidad 10", 100, 1000));
    }

    public void agregarComprador(String nombre, String email, int boletosDeseados, double presupuestoMaximo) {
        Comprador comprador = new Comprador(nombre, email, boletosDeseados, presupuestoMaximo);
        compradores.add(comprador);
    }

    public void comprarBoletos(Comprador comprador, String nombreLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNombre().equals(nombreLocalidad)) {
                int boletosDisponibles = localidad.getCapacidadDisponible();
                int boletosAComprar = Math.min(comprador.getBoletosDeseados(), boletosDisponibles);

                if (boletosAComprar > 0 && (boletosAComprar * localidad.getPrecio()) <= comprador.getPresupuestoMaximo()) {
                    localidad.venderBoletos(boletosAComprar);

                    for (int i = 0; i < boletosAComprar; i++) {
                        String numeroTicket = String.format("%d%02d%02d%02d%03d", fechaVenta.getYear(), fechaVenta.getMonthValue(), fechaVenta.getDayOfMonth(), correlativo);
                        Ticket ticket = new Ticket(numeroTicket, fechaVenta, comprador, localidad, localidad.getPrecio());
                        tickets.add(ticket);
                        correlativo++;
                    }

                    System.out.println("Boletos comprados: " + boletosAComprar);
                } else {
                    System.out.println("No se pueden comprar los boletos.");
                }

                return;
            }
        }

        System.out.println("Localidad no encontrada.");
    }

    public void consultarDisponibilidadTotal() {
        for (Localidad localidad : localidades) {
            System.out.println(localidad.getNombre() + ": " + localidad.getCapacidadDisponible() + " boletos disponibles.");
        }
    }

    public void consultarDisponibilidadIndividual(String nombreLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNombre().equals(nombreLocalidad)) {
                System.out.println(localidad.getNombre() + ": " + localidad.getCapacidadDisponible() + " boletos disponibles.");
                return;
            }
        }

        System.out.println("Localidad no encontrada.");
    }

    public void generarReporteCaja() {
        double totalRecaudado = 0;

        for (Ticket ticket : tickets) {
            totalRecaudado += ticket.getPrecio();
        }

        System.out.println("Total recaudado: $" + totalRecaudado);
    }

    // Nuevo método para obtener la lista de compradores
    public List<Comprador> getCompradores() {
        return compradores;
    }
}