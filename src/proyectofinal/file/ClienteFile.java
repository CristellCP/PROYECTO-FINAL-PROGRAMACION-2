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

    // Guardar todos los clientes en el archivo CSV
    public void guardarClientes(ArrayList<Cliente> listaClientes) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {

            // Escribir encabezado
            bw.write("idCliente,nombre,telefono,correo,saldoPendiente");
            bw.newLine();

            // Escribir cada cliente
            for (Cliente c : listaClientes) {
                bw.write(c.toCsv());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de clientes.");
        }
    }
}