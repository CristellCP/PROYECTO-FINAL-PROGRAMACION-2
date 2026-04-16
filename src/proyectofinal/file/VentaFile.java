package proyectofinal.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import proyectofinal.model.Venta;

public class VentaFile {

    private final String ruta = "datos/ventas.csv";

    public List<Venta> leerVentas() {
        List<Venta> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");

                if (d.length == 8) {
                    Venta v = new Venta(
                        d[0],
                        d[1],
                        d[2],
                        Integer.parseInt(d[3]),
                        Double.parseDouble(d[4]),
                        Double.parseDouble(d[5]),
                        d[6],
                        Boolean.parseBoolean(d[7])
                    );

                    lista.add(v);
                }
            }

        } catch (Exception e) {
            System.out.println("Archivo vacio o no existe");
        }

        return lista;
    }

    public void guardarVentas(List<Venta> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

            for (Venta v : lista) {
                bw.write(
                    v.getIdVenta() + "," +
                    v.getIdCliente() + "," +
                    v.getCodigoMotor() + "," +
                    v.getCantidad() + "," +
                    v.getPrecioUnitario() + "," +
                    v.getTotal() + "," +
                    v.getFecha() + "," +
                    v.isPagado()
                );
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error guardando ventas");
        }
    }
}