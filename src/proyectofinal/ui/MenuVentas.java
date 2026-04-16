package proyectofinal.ui;

import java.util.Scanner;
import proyectofinal.service.VentaService;

public class MenuVentas {

    private VentaService service = new VentaService();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int op;

        do {
            System.out.println("\n--- MENU VENTAS ---");
            System.out.println("1. Registrar venta");
            System.out.println("2. Ver ventas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    service.listarVentas();
                    break;
            }

        } while (op != 0);
    }

    private void registrarVenta() {
        sc.nextLine();

        System.out.print("ID Cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Codigo Motor: ");
        String motor = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        System.out.print("Precio unitario: ");
        double precio = sc.nextDouble();

        service.registrarVenta(cliente, motor, cantidad, precio);
    }
}