package proyectofinal.ui;

import java.util.Scanner;
import proyectofinal.service.SistemaAlertas;

    //Esta clase permite al usuario seleccionar una opcion 
    //mediante teclado y redirige al menu correspondiente segun la opcion escogida

public class MenuPrincipal {

    public void mostrarMenu() {

        //Creacion de objetos
    MenuClientes mc = new MenuClientes();
    MenuVentas mv = new MenuVentas();
    SistemaAlertas sa = new SistemaAlertas();

        //Scanner para capturar la entrada
    Scanner sc = new Scanner(System.in);
    int opcion;

        //Bucle que mantiene el menu activo hasta que el usuario decida salir
    do {
        System.out.println("\n=====| MENU PRINCIPAL |=====");
    System.out.println("1. Clientes");
    System.out.println("2. Inventario");
    System.out.println("3. Ventas");
    System.out.println("4. Alertas");
    System.out.println("5. Salir");

        System.out.println("Seleccione una opción: ");
    opcion = sc.nextInt();
        sc.nextLine();

        //Estructura de control para manejar las opciones del menu
    switch (opcion) {
        case 1:
            mc.mostrarMenu();
            break;
            
        case 2:
            MenuInventario.mostrarMenu();
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
