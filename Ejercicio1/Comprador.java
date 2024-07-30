package Ejercicios.Ejercicio1;

public class Comprador {
    private String nombre;
    private String email;
    private int boletosDeseados;
    private double presupuestoMaximo;

    public Comprador(String nombre, String email, int boletosDeseados, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.boletosDeseados = boletosDeseados;
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getBoletosDeseados() {
        return boletosDeseados;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
}
