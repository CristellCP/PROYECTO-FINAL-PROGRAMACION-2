package proyectofinal.ui;
import java.util.*;
import proyectofinal.model.Motor;
import proyectofinal.service.InventarioService;

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
            op = sc.nextInt();

            switch (op) {
                case 1 -> verInventario();
                case 2 -> agregarMotor();
            }

        } while (op != 0);
    }

    public static void verInventario() {
        for (Motor m : service.listarMotores()) {
            System.out.println(m);
        }
    }

    public static void agregarMotor() {
        sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        System.out.print("Stock mínimo: ");
        int minimo = sc.nextInt();

        Motor m = new Motor(codigo, marca, modelo, precio, cantidad, minimo);
        service.agregarMotor(m);

        System.out.println("✔ Motor agregado");
    }
}
