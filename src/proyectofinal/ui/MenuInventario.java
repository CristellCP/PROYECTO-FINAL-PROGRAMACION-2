package proyectofinal.ui;

import proyectofinal.service.InventarioService;
import proyectofinal.model.Motor;
import java.util.*;

public class MenuInventario {

    private static Scanner sc = new Scanner(System.in);
    private static InventarioService service = new InventarioService();

    public static void mostrarMenu() {
        int op;

        do {
            System.out.println("\n--- INVENTARIO ---");
            System.out.println("1. Ver motores");
            System.out.println("2. Agregar motor");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> verInventario();
                case 2 -> agregarMotor();
            }

        } while (op != 0);
    }

    public static void verInventario() {
        List<Motor> lista = service.listarMotores();

        if (lista.isEmpty()) {
            System.out.println("No hay motores registrados.");
            return;
        }

        for (Motor m : lista) {
            System.out.println(m);
        }
    }

    public static void agregarMotor() {

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        System.out.print("Stock mínimo: ");
        int minimo = Integer.parseInt(sc.nextLine());

        Motor m = new Motor(codigo, marca, modelo, precio, cantidad, minimo);
        service.agregarMotor(m);

        System.out.println("✔ Motor agregado");
    }
}
