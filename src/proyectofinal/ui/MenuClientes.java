package proyectofinal.ui;

import proyectofinal.model.Cliente;
import proyectofinal.service.ClienteService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuClientes {

    private ClienteService clienteService;
    private Scanner scanner;

    public MenuClientes() {
        clienteService = new ClienteService();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n=== MENU CLIENTES ===");
            System.out.println("1. Ver clientes");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    verClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 4);
    }

    // Mostrar todos los clientes
    private void verClientes() {
        ArrayList<Cliente> lista = clienteService.listarClientes();

        if (lista.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente c : lista) {
                System.out.println(c);
            }
        }
    }

    // Agregar cliente
    private void agregarCliente() {
        System.out.println("\n--- Agregar Cliente ---");

        System.out.print("Ingrese ID: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese telefono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese saldo pendiente (si hay, de lo contrario colocar 0): ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer

        Cliente nuevo = new Cliente(id, nombre, telefono, correo, saldo);

        boolean agregado = clienteService.agregarCliente(nuevo);

        if (agregado) {
            System.out.println("Cliente agregado correctamente.");
        } else {
            System.out.println("Error: ya existe un cliente con ese ID.");
        }
    }

    // Buscar cliente por ID
    private void buscarCliente() {
        System.out.println("\n--- Buscar Cliente ---");

        System.out.print("Ingrese ID del cliente: ");
        String id = scanner.nextLine();

        Cliente cliente = clienteService.buscarClientePorId(id);

        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}