package proyectofinal.ui;

import java.util.Scanner;
import proyectofinal.ui.*;
import proyectofinal.service.SistemaAlertas;

public class MenuPrincipal {

    public void mostrarMenu() {

    MenuClientes mc = new MenuClientes();
    MenuVentas mv = new MenuVentas();
    MenuInventario mi = new MenuInventario();
    SistemaAlertas sa = new SistemaAlertas();
    
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\n=====| MENU PRINCIPAL |=====");
    System.out.println("1. Clientes");
    System.out.println("2. Inventario");
    System.out.println("3. Ventas");
    System.out.println("4. Alertas");
    System.out.println("5. Salir");
        
    opcion = InputUtil.leerInt("Seleccione una opción: ");

    switch (opcion) {
        case 1:
            mc.mostrarMenu();
            break;
            
        case 2:
            mi.mostrarMenu();
            break;
            
        case 3:
           mv.mostrarMenu();
            break;
            
        case 4:
            sa.menu();
            break;
            
        case 5:
            System.out.println("Cerrando el programa...");
            break;

        default:
            System.out.println("Opción inválida");
    }
    } while (opcion != 5);
}
}
