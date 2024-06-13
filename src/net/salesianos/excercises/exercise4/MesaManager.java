package net.salesianos.excercises.exercise4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaManager {
    private static final String FILE_NAME = "src\\net\\salesianos\\excercises\\exercise4\\mesas.txt";

    public static void guardarMesa(Mesa mesa) {
        List<Mesa> mesas = obtenerTodasLasMesas();
        mesas.add(mesa);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(mesas);
        } catch (IOException e) {
            System.out.println("no se pudo guardar");
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Mesa> obtenerTodasLasMesas() {
        List<Mesa> mesas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            mesas = (List<Mesa>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe todavía.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error al obtener las mesas");
        }
        return mesas;
    }
}
