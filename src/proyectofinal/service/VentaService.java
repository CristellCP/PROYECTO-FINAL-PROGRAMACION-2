package proyectofinal.service;

import proyectofinal.model.Venta;
import proyectofinal.file.VentaFile;

import java.time.LocalDate;
import java.util.List;

public class VentaService {

    private List<Venta> ventas;
    private VentaFile file;

    public VentaService() {
        file = new VentaFile();
        ventas = file.leerVentas();
    }

    public void registrarVenta(String idCliente, String codigoMotor, int cantidad, double precio) {
        String idVenta = "V" + (ventas.size() + 1);
        double total = cantidad * precio;
        String fecha = LocalDate.now().toString();

        Venta v = new Venta(idVenta, idCliente, codigoMotor, cantidad, precio, total, fecha, true);

        ventas.add(v);
        file.guardarVentas(ventas);

        System.out.println("Venta registrada correctamente");
    }

    public void listarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas");
            return;
        }

        for (Venta v : ventas) {
            System.out.println(v);
        }
    }
}