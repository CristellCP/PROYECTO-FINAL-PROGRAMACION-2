package proyectofinal.file;

import java.util.*;
import java.io.*;
import proyectofinal.model.Motor;

public class MotorFile {
    private String ruta = "datos/inventario.csv";

    public List<Motor> leerMotores() {
        List<Motor> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                // Ignorar encabezado si existe
                if (linea.startsWith("codigoMotor")) continue;

                String[] datos = linea.split(",");
                if (datos.length != 6) {
                     System.out.println("Línea incorrecta: " + linea);
                    continue;
                }   
                
                try {
                    Motor m = new Motor(
                        datos[0],
                        datos[1],
                        datos[2],
                        Double.parseDouble(datos[3]),
                        Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5])
                    );

                    lista.add(m);

                } catch (Exception e) {
                    System.out.println("Línea inválida: " + linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }

        return lista;
    }

    public void guardarMotores(List<Motor> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

            // (Opcional) escribir encabezado
            bw.write("codigoMotor,marca,modelo,precio,cantidadDisponible,stockMinimo");
            bw.newLine();

            for (Motor m : lista) {
                bw.write(m.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error guardando archivo");
        }
    }
}
