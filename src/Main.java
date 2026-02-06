import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AddressBook agenda = new AddressBook();
        agenda.load();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- AGENDA TELEFÓNICA ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    agenda.list();
                    break;
                case 2:
                    System.out.print("Número: ");
                    String number = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    agenda.create(number, name);
                    break;
                case 3:
                    System.out.print("Número a eliminar: ");
                    String deleteNumber = scanner.nextLine();
                    agenda.delete(deleteNumber);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (option != 4);

        scanner.close();
    }
}
