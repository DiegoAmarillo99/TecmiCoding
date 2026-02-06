import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> contacts = new HashMap<>();
    private final String fileName = "contacts.csv";

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                contacts.put(data[0], data[1]);
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        }
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void create(String number, String name) {
        contacts.put(number, name);
        save();
    }

    public void delete(String number) {
        contacts.remove(number);
        save();
    }
}
