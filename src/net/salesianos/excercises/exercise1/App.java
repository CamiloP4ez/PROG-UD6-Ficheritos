package net.salesianos.excercises.exercise1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String inputText;

        File file = new File("src\\net\\salesianos\\excercises\\exercise1\\texto_formateado.txt");// creacion del
                                                                                                  // fichero con el try
                                                                                                  // catch en caso de
                                                                                                  // que el fichero
        // ya exista simplemente se va a sobreescribir
        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado: " + file.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el fichero.");
        }

        while (true) {
            System.out.print("Introduce un texto de al menos 30 caracteres: ");
            inputText = kb.nextLine();
            if (inputText.length() >= 30) {
                break;
            } else {
                int charsNeeded = 30 - inputText.length();
                System.out.println("Faltan " + charsNeeded + " caracteres. Inténtalo de nuevo.");
            }
        }

        String formattedText = inputText.toUpperCase().replace(' ', '_');

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(formattedText);
            System.out.println("Texto formateado guardado en el fichero.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero.");
        }
        kb.close();
    }
}
