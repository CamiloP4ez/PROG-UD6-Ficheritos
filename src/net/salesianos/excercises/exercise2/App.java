package net.salesianos.excercises.exercise2;

import java.io.FileReader;
import java.io.IOException;

public class App {
  public static void main(String[] args) {
        String filePath = "src\\net\\salesianos\\excercises\\exercise2\\texto.txt";

        try (FileReader reader = new FileReader(filePath)) {
            int caracter;
            boolean first = true;

            while ((caracter = reader.read()) != -1) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print((char) caracter + "_" + caracter);
                first = false;
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el fichero");
        }
    }
}
