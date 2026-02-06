package agenda;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Agenda {

    private HashMap<String, String> contactos;
    private final String archivo = "contacts.csv";

    public Agenda() {
        contactos = new HashMap<>();
        load();
    }

    // Cargar contactos desde archivo
    public void load() {
        File file = new File(archivo);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                contactos.put(datos[0], datos[1]);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar contactos");
        }
    }

    // Guardar contactos en archivo
    public void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> contacto : contactos.entrySet()) {
                pw.println(contacto.getKey() + "," + contacto.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar contactos");
        }
    }

    // Listar contactos
    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> contacto : contactos.entrySet()) {
            System.out.println(contacto.getKey() + " : " + contacto.getValue());
        }
    }

    // Crear contacto
    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        save();
        System.out.println("Contacto agregado.");
    }

    // Eliminar contacto
    public void delete(String numero) {
        contactos.remove(numero);
        save();
        System.out.println("Contacto eliminado.");
    }
}
