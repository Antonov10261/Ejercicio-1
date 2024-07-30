package Ejercicios.Ejercicio1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static SistemaVentaBoletos sistema;

    public static void main(String[] args) {
        sistema = new SistemaVentaBoletos(LocalDate.now());
        mostrarMenu();
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar comprador");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Generar reporte de caja");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    solicitarDatosComprador(scanner);
                    break;
                case 2:
                    comprarBoletos(scanner);
                    break;
                case 3:
                    sistema.consultarDisponibilidadTotal();
                    break;
                case 4:
                    consultarDisponibilidadIndividual(scanner);
                    break;
                case 5:
                    sistema.generarReporteCaja();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void solicitarDatosComprador(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cantidad de boletos: ");
        int boletosDeseados = scanner.nextInt();
        System.out.print("Presupuesto máximo: ");
        double presupuestoMaximo = scanner.nextDouble();
        scanner.nextLine();

        sistema.agregarComprador(nombre, email, boletosDeseados, presupuestoMaximo);
    }

    private static void comprarBoletos(Scanner scanner) {
        System.out.print("Email del comprador: ");
        String email = scanner.nextLine();
        Comprador comprador = null;

        for (Comprador c : sistema.getCompradores()) {  // Utilizamos el método público getCompradores
            if (c.getEmail().equals(email)) {
                comprador = c;
                break;
            }
        }

        if (comprador == null) {
            System.out.println("Comprador no encontrado.");
            return;
        }

        System.out.print("Nombre de la localidad: ");
        String nombreLocalidad = scanner.nextLine();

        sistema.comprarBoletos(comprador, nombreLocalidad);
    }

    private static void consultarDisponibilidadIndividual(Scanner scanner) {
        System.out.print("Nombre de la localidad: ");
        String nombreLocalidad = scanner.nextLine();

        sistema.consultarDisponibilidadIndividual(nombreLocalidad);
    }
}
