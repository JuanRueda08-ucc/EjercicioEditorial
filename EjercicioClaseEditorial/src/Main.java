import Model.Idioma;
import Model.Video;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Titulo del video: ");
        String titulo = input.nextLine();

        double precio = leerDouble(input, "Precio del video: ");

        int opcionIdioma = leerEntero(input, "Idioma (1: ESPANOL, 2: INGLES, 3: PORTUGUES): ");

        float duracionHoras = (float) leerDouble(input, "Duracion en horas: ");

        Idioma idioma = switch (opcionIdioma) {
            case 1 -> Idioma.ESPANOL;
            case 2 -> Idioma.INGLES;
            case 3 -> Idioma.PORTUGUES;
            default -> throw new IllegalArgumentException("Opcion de idioma invalida");
        };

        Video video = new Video(titulo, precio, idioma, duracionHoras);
        System.out.println("\nDatos ingresados:");
        System.out.println(video);
    }

    private static double leerDouble(Scanner input, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = input.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Ingresa un numero (ejemplo: 25.5).");
            }
        }
    }

    private static int leerEntero(Scanner input, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = input.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Ingresa un numero entero.");
            }
        }
    }
}
