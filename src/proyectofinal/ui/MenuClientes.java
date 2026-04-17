package proyectofinal.ui;
// Imports
import proyectofinal.model.Cliente; // Clase Cliente
import proyectofinal.service.ClienteService; // Clase ClienteService
import java.util.ArrayList; // ArrayList para manejar la lista de clientes
import java.util.Scanner; // Scanner para recibir input del usuario

public class MenuClientes {
    // Instancias privadas
    private ClienteService clienteService;
    private Scanner scanner;
    // Metodo Constructor que inicializa las instancias de ClienteService y Scanner
    public MenuClientes() {
        clienteService = new ClienteService();
        scanner = new Scanner(System.in);
    }
    // Metodo que tiene la logica del menu
    public void mostrarMenu() {
        int opcion; // Variable entera vacia que almacenara la opcion que elija el usuario
        /* Con un bucle do-while, le mostramos las opciones del menu al usuario
        Hasta que escoja volver al menu principal */
        do {
            System.out.println("\n=== MENU CLIENTES ===");
            System.out.println("1. Ver clientes");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar el saldo de un cliente");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt(); // Guardamos la opcion que escogio con Scanner
            scanner.nextLine(); // limpiamos el buffer que deja nextInt()
            // Abrimos un switch para que dependiendo de la opcion escogida se muestre la funcion que queramos
            switch (opcion) {
                case 1:
                    verClientes(); // Si es 1, usamos el metodo verClientes para mostrar toda la lista
                    break;
                case 2:
                    agregarCliente(); // Si es 2, usamos el metodo agregarCliente para agregar un cliente nuevo
                    break;
                case 3:
                    buscarCliente(); // Si es 3, usamos buscarCliente para encontrar al cliente por su ID
                    break;
                case 4:
                    actualizarSaldoCliente();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);
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

    private void actualizarSaldoCliente() {
        System.out.println("--- Actualizar Saldo del Cliente ---");
        System.out.print("Ingrese ID del cliente: ");
        String id = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            System.out.println("Saldo actual: " + cliente.getSaldoPendiente());
            System.out.print("Ingrese nuevo saldo pendiente: ");
            double nuevoSaldo = scanner.nextDouble();
            scanner.nextLine(); // limpiar buffer
            cliente.setSaldoPendiente(nuevoSaldo);
            boolean actualizado = clienteService.actualizarSaldo(cliente, nuevoSaldo);
            if (actualizado) {
                System.out.println("Saldo actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar el saldo.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}