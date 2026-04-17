package proyectofinal.service;

import proyectofinal.model.Motor;
import proyectofinal.file.MotorFile;
import java.util.*;

public class InventarioService {

    private Motor mt = new Motor();
    private MotorFile motorFile = new MotorFile();

    public List<Motor> listarMotores() {
        return motorFile.leerMotores();
    }

    public void agregarMotor(Motor nuevo) {
        List<Motor> lista = motorFile.leerMotores();
        lista.add(nuevo);
        motorFile.guardarMotores(lista);
    }

    public Motor buscarMotor(String codigo) {
        for (Motor m : motorFile.leerMotores()) {
            if (m.getCodigoMotor().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public void descontarStock(String codigo, int cantidad) {
        List<Motor> lista = motorFile.leerMotores();

        for (Motor m : lista) {
            if (m.getCodigoMotor().equalsIgnoreCase(codigo)) {
                m.setCantidadDisponible(m.getCantidadDisponible() - cantidad);
            }
        }

        motorFile.guardarMotores(lista);
    }

    public void verificarStockBajo() {
        for (Motor m : motorFile.leerMotores()) {
            if (m.getCantidadDisponible() <= m.getStockMinimo()) {
                System.out.println("⚠ Stock bajo: " + m.getCodigoMotor());
            }
        }
    }
}
