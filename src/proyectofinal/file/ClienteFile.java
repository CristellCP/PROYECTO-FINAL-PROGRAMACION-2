package proyectofinal.file;
// Imports
import proyectofinal.model.Cliente; // Importamos la clase Cliente para poder usarla en este archivo
import java.io.*; // Importamos las clases necesarias para el manejo de archivos
import java.util.ArrayList; // Importamos ArrayList para crear la lista de clientes

public class ClienteFile {

    private final String RUTA = "datos/clientes.csv"; // Creamos una variable que continene la ruta al CSV con los datos de clientes

    // Creamos un metodo de tipo ArrayList con el que leemos la lista de clientes del archivo CSV
    public ArrayList<Cliente> leerClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>(); // Creamos una nueva lista de clientes vacia
        /* Usamos un bloque try-catch with resources en el que instanciamos BufferedReader
        para leer el archivo CSV y poder manejar posibles errores en esa lectura */
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) { 
            String linea; // Variable para almacenar cada linea del archivo mientras la leemos
            // Saltamos el encabezado
            br.readLine();
            /* Con un bucle while, leemos cada linea del archivo hasta llegar al final
            (cuando br.readLine() devuelve null (vacio)) */ 
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separamos los datos con la coma y los almacenamos en un array de String
                // Sacamos cada dato del array y los almacenamos en variables para crear el objeto Cliente con sus argumentos
                String id = datos[0];
                String nombre = datos[1];
                String telefono = datos[2];
                String correo = datos[3];
                double saldo = Double.parseDouble(datos[4]);
                // Creamos un nuevo cliente con los datos obtenidos y lo agregamos a la lista de clientes
                Cliente cliente = new Cliente(id, nombre, telefono, correo, saldo);
                listaClientes.add(cliente); // Agregamos el cliente a la lista de clientes con el metodo .add()
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de clientes."); // Si hay un error en la lectura lo mostramos en pantalla
        }

        return listaClientes; // Finalmente devolvemos la lista de clientes obtenida del archivo CSV
    }
    // Metodo para guardar la lista completa de clientes en el archivo CSV
    public void guardarClientes(ArrayList<Cliente> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {
            // Escribimos de nuevo el encabezado
            bw.write("idCliente,nombre,telefono,correo,saldoPendiente");
            bw.newLine();

            // Escribimos cada cliente
            for (Cliente c : lista) {
                bw.write(c.toCsv());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar los clientes en el archivo."); // Manejamos errores al guardar
        }

    }

    // Metodo para agregar un solo cliente nuevo a la lista sin necesidad de leer y escribir todo
    public boolean agregarClienteNuevo(Cliente cliente) {

        // Ponemos la funcion dentro de un bloque try-catch para manejar posibles errores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            // Agregamos el cliente al final del archivo
            bw.write(cliente.toCsv());
            bw.newLine();
            return true;

        } catch (IOException e) {
            System.out.println("Error al agregar el cliente al archivo."); // Manejamos errores al agregar el cliente
            return false;
        }
    }
}