package proyectofinal.service;

import proyectofinal.model.Cliente;
import proyectofinal.file.ClienteFile;

import java.util.ArrayList;

public class ClienteService {

    private ClienteFile clienteFile;

    public ClienteService() {
        clienteFile = new ClienteFile();
    }

    // Obtener todos los clientes
    public ArrayList<Cliente> listarClientes() {
        return clienteFile.leerClientes();
    }

    // Agregar un nuevo cliente
    public boolean agregarCliente(Cliente nuevoCliente) {
        ArrayList<Cliente> lista = clienteFile.leerClientes();

        // Verificar que no exista el ID
        for (Cliente c : lista) {
            if (c.getIdCliente().equalsIgnoreCase(nuevoCliente.getIdCliente())) {
                return false; // ya existe
            }
        }

        lista.add(nuevoCliente);
        clienteFile.guardarClientes(lista);
        return true;
    }

    // Buscar cliente por ID
    public Cliente buscarClientePorId(String idCliente) {
        ArrayList<Cliente> lista = clienteFile.leerClientes();

        for (Cliente c : lista) {
            if (c.getIdCliente().equalsIgnoreCase(idCliente)) {
                return c;
            }
        }

        return null; // no encontrado
    }

    // Actualizar saldo pendiente de un cliente
    public boolean actualizarSaldo(String idCliente, double nuevoSaldo) {
        ArrayList<Cliente> lista = clienteFile.leerClientes();

        for (Cliente c : lista) {
            if (c.getIdCliente().equalsIgnoreCase(idCliente)) {
                c.setSaldoPendiente(nuevoSaldo);
                clienteFile.guardarClientes(lista);
                return true;
            }
        }

        return false; // no encontrado
    }
}