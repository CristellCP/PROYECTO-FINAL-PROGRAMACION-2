package proyectofinal.ui;

import java.util.Scanner;

public class MenuPrincipal {

    public void mostrarMenu() {
    
    SistemaAlertas sa = new SistemaAlertas();
    MenuClientes mc = new MenuClientes(); 
    MenuInventario mi = new MenuInventario();
    
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("    | MENU PRINCIPAL |    ");
    System.out.println("1. Clientes");
    System.out.println("2. Inventario");
    System.out.println("3. Ventas");
    System.out.println("4. Alertas");
    System.out.println("5. Salida");
    opcion = scanner.nextInt();

    switch (opcion) {
        case 1:
            mc.MenuClientes();
            break;
            
        case 2:
            mi.MenuInventario();
            break;
            
        case 3:

            break;
            
        case 4:
            sa.SistemaAlertas();
            break;
            
        case 5:
            System.out.println("Cerrando el programa...");
            break;
    }
    } while (opcion != 5);
sc.close();
}
}
