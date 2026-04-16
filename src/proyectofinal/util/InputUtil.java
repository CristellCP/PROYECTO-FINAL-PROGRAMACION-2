package proyectofinal.util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner sc = new Scanner(System.in);

    public static int leerInt(String mensaje) {
        System.out.println(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida, vuelva a intentarlo");
            sc.next();
            System.out.println(mensaje);
        }
        return sc.nextInt();
    }

    public static double leeerDouble(String mensaje) {
        Sytem.out.println(mensaje) {
            System.out.println(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida, vuelva a intentarlo");
            sc.next();
            System.out.println(mensaje);
        }
        return sc.nextDouble();
        }
        public static String leerString(String mensaje) {
            System.out.println(mensaje);
        sc.nextLine();
        return sc.nextLine();
        }
    }
