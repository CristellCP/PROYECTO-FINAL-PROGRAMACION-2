package proyectofinal.main;

import proyectofinal.ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        sistema.iniciarMonitoreoAutomatico(); 

        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }
}
