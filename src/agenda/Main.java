package agenda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agenda.list();
                    break;

                case 2:
                    System.out.print("Número: ");
                    String numero = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    agenda.create(numero, nombre);
                    break;

                case 3:
                    System.out.print("Número a eliminar: ");
                    String numEliminar = scanner.nextLine();
                    agenda.delete(numEliminar);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 4);
    }
}
