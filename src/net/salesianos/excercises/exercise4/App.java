package net.salesianos.excercises.exercise4;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    Menú
                    1. Nueva mesa
                    2. Mostrar todas las mesas almacenadas
                    3. Salir
                    Elige una opción:
                    """);
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el color de la mesa: ");
                    String color = scanner.nextLine();
                    System.out.print("Introduce el número de patas: ");
                    int numeroPatas = scanner.nextInt();
                    Mesa nuevaMesa = new Mesa(color, numeroPatas);
                    MesaManager.guardarMesa(nuevaMesa);
                    System.out.println("Mesa guardada correctamente.");
                    break;
                case 2:
                    List<Mesa> mesas = MesaManager.obtenerTodasLasMesas();
                    if (mesas.isEmpty()) {
                        System.out.println("No hay mesas almacenadas.");
                    } else {
                        System.out.println("Listado de mesas almacenadas:");
                        for (Mesa mesa : mesas) {
                            System.out.println(mesa);
                        }
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}
