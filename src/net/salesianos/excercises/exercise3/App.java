package net.salesianos.excercises.exercise3;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) {
        File file = new File("fichero_fusionado.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado: " + file.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el fichero.");
        }

        String filePath1 = "src\\net\\salesianos\\excercises\\exercise1\\texto_formateado.txt"; // Ruta del primer
                                                                                                // fichero
        String filePath2 = "src\\net\\salesianos\\excercises\\exercise2\\texto.txt"; // Ruta del segundo fichero
        String outputFilePath = "fichero_fusionado.txt"; // Fichero fusionado

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write("Contenido del Fichero Uno:\n");
            copyFileContent(filePath1, writer);
            writer.write("\nContenido del Fichero Dos:\n");
            copyFileContent(filePath2, writer);
            writer.write("\neditado por camilo");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero.");
        }
    }

    private static void copyFileContent(String filePath, FileWriter writer) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
        }
    }
}
