package proyectofinal.service;

import java.util.ArrayList;
import java.util.Scanner;
import proyectofinal.model.Alerta;

public class SistemaAlertas {
    
    ArrayList<Alerta> listaDeAlertas = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);

    public void generarAlertas() {
        listaDeAlertas.clear(); 
        String fechaActual = "08/04/2026"; 
        
        System.out.println("Revisando el inventario y los clientes...");

        // COMPAÑEROS: Aqui conectamos con la parte de Inventario para ver el stock
        // if (motor.cantidad <= stockMinimo) { ... }

        // COMPAÑEROS: Aqui conectamos con Clientes para ver quien debe dinero
        // if (cliente.saldo > 0) { ... }
        
        System.out.println("Las alertas se generaron correctamente.");
    }

    public void verAlertas() {
        System.out.println("\n--- LISTA DE ALERTAS ---");
        
        if (listaDeAlertas.size() == 0) { 
            System.out.println("No hay alertas en este momento.");
        } else {
            for (int i = 0; i < listaDeAlertas.size(); i++) {
                System.out.println(listaDeAlertas.get(i).mostrarAlerta());
            }
        }
    }

    public void menu() {
        int opcion = 0;
        
        while (opcion != 3) {
            System.out.println("\n*** MODULO DE ALERTAS ***");
            System.out.println("1. Generar alertas");
            System.out.println("2. Mostrar alertas");
            System.out.println("3. Salir");
            System.out.print("Elige una opcion: ");
            
            opcion = entrada.nextInt();
            
            if (opcion == 1) {
                generarAlertas();
            } else if (opcion == 2) {
                verAlertas();
            } else if (opcion == 3) {
                System.out.println("Regresando al menu principal...");
            } else {
                System.out.println("Opcion incorrecta.");
            }
        }
    }
}