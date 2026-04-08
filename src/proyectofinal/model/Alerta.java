package proyectofinal.model;
public class Alerta {
    String tipo;
    String mensaje;
    String fecha;

    public Alerta(String tipo, String mensaje, String fecha) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public String mostrarAlerta() {
        return "[" + fecha + "] " + tipo + " - " + mensaje;
    }
}