package proyectofinal.file;

import proyectofinal.model.Cliente;

import java.io.*;
import java.util.ArrayList;

public class ClienteFile {

    private final String RUTA = "datos/clientes.csv";

    // Leer todos los clientes del archivo CSV
    public ArrayList<Cliente> leerClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;

            // Saltar encabezado
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String id = datos[0];
                String nombre = datos[1];
                String telefono = datos[2];
                String correo = datos[3];
                double saldo = Double.parseDouble(datos[4]);

                Cliente cliente = new Cliente(id, nombre, telefono, correo, saldo);
                listaClientes.add(cliente);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de clientes.");
        }

        return listaClientes;
    }

    // Agregar un cliente nuevo
    public boolean agregarClienteNuevo(Cliente cliente) {

        // Ponemos la funcion dentro de un bloque try-catch para manejar posibles errores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            // Agregar el cliente al final del archivo
            bw.write(cliente.toCsv());
            bw.newLine();
            return true;

        } catch (IOException e) {
            System.out.println("Error al agregar el cliente al archivo.");
            return false;
        }
    }
}