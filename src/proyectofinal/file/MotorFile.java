package proyectofinal.file;

import java.util.*;
import proyectofinal.model.Motor;

public class MotorFile {
    private String ruta = "datos/inventario.csv";

    public List<Motor> leerMotores() {
        List<Motor> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                Motor m = new Motor(
                    datos[0],
                    datos[1],
                    datos[2],
                    Double.parseDouble(datos[3]),
                    Integer.parseInt(datos[4]),
                    Integer.parseInt(datos[5])
                );

                lista.add(m);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }

        return lista;
    }

    public void guardarMotores(List<Motor> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Motor m : lista) {
                bw.write(m.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error guardando archivo");
        }
    }}
