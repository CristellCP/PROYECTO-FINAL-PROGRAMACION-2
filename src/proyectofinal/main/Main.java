package proyectofinal.main;

import proyectofinal.service.SistemaAlertas;
import proyectofinal.ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        // ACTIVACIÓN DEL SISTEMA AUTOMÁTICO
        SistemaAlertas sistema = new SistemaAlertas();
        sistema.iniciarMonitoreoAutomatico(); 

        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }
}
