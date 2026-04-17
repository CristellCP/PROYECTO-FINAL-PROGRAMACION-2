package proyectofinal.service;
// Imports
import proyectofinal.model.Cliente; // Importamos la clase Cliente
import proyectofinal.file.ClienteFile; // Importamos la clase ClienteFile para manejar el archivo CSV
import java.util.ArrayList; // Importamos ArrayList para manejar listas de clientes

public class ClienteService {
    private ClienteFile clienteFile; // Creamos una instancia privada de ClienteFile para manejar las operaciones

    public ClienteService() {
        clienteFile = new ClienteFile(); // Inicializamos la instancia de ClienteFile en el constructor
    }
    // Metodo para listar todos los clientes
    public ArrayList<Cliente> listarClientes() {
        return clienteFile.leerClientes(); // Llamamos al método leerClientes de ClienteFile
    }
    // Metodo para  agregar un nuevo cliente
    public boolean agregarCliente(Cliente nuevoCliente) {
        ArrayList<Cliente> lista = clienteFile.leerClientes(); // Llamamos al método leerClientes para obtener la lista actual de clientes
        // Verificamos que no exista el ID que queremos guardar con un bucle for-each
        for (Cliente c : lista) {
            if (c.getIdCliente().equalsIgnoreCase(nuevoCliente.getIdCliente())) {
                /* Usamos el metodo getIdCliente y el metodo equalsIgnoreCase (comparador que ignora mayusculas
                y minusculas) para comparar el ID del nuevo cliente con los existentes,
                y si encontramos una coincidencia, retornamos false*/
                return false; // ya existe
            }
        }
        // Agregamos el cliente al archivo CSV con el metodo agregarClienteNuevo
        return clienteFile.agregarClienteNuevo(nuevoCliente);
    }

    // Metodo para buscar un cliente por su ID
    public Cliente buscarClientePorId(String idCliente) {
        ArrayList<Cliente> lista = clienteFile.leerClientes(); // Usamos leerClientes para obtener la lista de clientes
        /* Con un bucle for-each, recorremos la lista de clientes,
        y comparamos el ID que puso el usuario con los IDs ya existentes */
        for (Cliente c : lista) {
            if (c.getIdCliente().equalsIgnoreCase(idCliente)) {
                return c; // Si encontramos una coincidencia, retornamos el cliente encontrado
            }
        }
        return null; // Si no encontramos nada, retornamos null
    }

    // Metodo para actualizar el saldo pendiente de un cliente
    public boolean actualizarSaldo(Cliente cliente, double nuevoSaldo) {
        ArrayList<Cliente> lista = clienteFile.leerClientes();
        /* Recorremos la lista de clientes, comparamos el ID,
        y si coincide con uno existente damos la opcion de actualizar su saldo */
        for (Cliente c : lista) {
            if (c.getIdCliente().equalsIgnoreCase(cliente.getIdCliente())) {
                c.setSaldoPendiente(nuevoSaldo);
                clienteFile.guardarClientes(lista);
                return true;
            }
        }
        return false; // Si no encontramos el cliente, retornamos false
    }
}