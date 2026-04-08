package proyectofinal.model;

public class Cliente {
    // Atributos
    private String idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    private double saldoPendiente;

    public Cliente() {
    }

    public void getCliente() {
        this.idCliente = idCliente;
    }

    public void getNombre() {
        this.nombre = nombre;
    }

    public void getTelefono() {
        this.telefono = telefono;
    }

    public void getCorreo() {
        this.correo = correo;
    }

    public double getSaldoPendiente() {
        this.saldoPendiente = saldoPendiente;
        return saldoPendiente;
    }
}