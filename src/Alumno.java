public class Alumno {

    // Atributos
    private String nombre;
    private double[] calificaciones;

    // Constructor
    public Alumno(String nombre, double[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    // Método para calcular el promedio
    public double calcularPromedio(double[] calificaciones) {
        double suma = 0;

        for (int i = 0; i < calificaciones.length; i++) {
            suma = suma + calificaciones[i];
        }

        return suma / calificaciones.length;
    }

    // Método para obtener la calificación final
    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Método para imprimir resultados
    public void imprimirResultados(String nombre, double promedio, char calificacion) {
        System.out.println("Nombre del estudiante: " + nombre);
        System.out.println("Calificación 1: " + calificaciones[0]);
        System.out.println("Calificación 2: " + calificaciones[1]);
        System.out.println("Calificación 3: " + calificaciones[2]);
        System.out.println("Calificación 4: " + calificaciones[3]);
        System.out.println("Calificación 5: " + calificaciones[4]);
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + calificacion);
    }

    // Método main (para ejecutar)
    public static void main(String[] args) {

        double[] califs = {85, 90, 78, 88, 92};
        Alumno alumno = new Alumno("Tu Nombre", califs);

        double promedio = alumno.calcularPromedio(califs);
        char calFinal = alumno.obtenerCalificacionFinal(promedio);

        alumno.imprimirResultados(alumno.nombre, promedio, calFinal);
    }
}

