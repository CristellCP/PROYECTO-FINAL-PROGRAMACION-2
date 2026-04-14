package proyectofinal.model;

public class Cliente {
    // Atributos
    private String idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    private double saldoPendiente;

    // Metodo constructor
    public Cliente(String idCliente, String nombre, String telefono, String correo, double saldoPendiente) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.saldoPendiente = saldoPendiente;
    }

    // Getters
    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }
    // Setters
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    // Metodo para convertir los datos en formato csv
    public String toCsv() {
        return idCliente + "," + nombre + "," + telefono + "," + correo + "," + saldoPendiente;
    }
    
    // Metodo para imprimir los datos de cada cliente
    @Override
    public String toString() {
        return "ID: " + idCliente +
        " | Nombre: " + nombre +
        " | Telefono: " + telefono +
        " | Correo: " + correo +
        " | Saldo pendiente: " + String.format("%.2f", saldoPendiente);
    }
}