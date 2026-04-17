package proyectofinal.model;
// Esta clase es la base para el manejo de los clientes
public class Cliente {
    // Atributos que colocamos en privado para proteger los datos
    private String idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    private double saldoPendiente;

    // Metodo constructor que recibe parametros con los datos del cliente
    public Cliente(String idCliente, String nombre, String telefono, String correo, double saldoPendiente) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.saldoPendiente = saldoPendiente;
    }

    // Getters (para cuando necesitemos un dato en especifico para una funcion)
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
    // Setters (para cuando necesitemos escribir un dato en especifico)
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

    // Metodo para convertir los datos a formato csv
    public String toCsv() {
        return idCliente + "," + nombre + "," + telefono + "," + correo + "," + saldoPendiente;
    }
    /* Metodo para imprimir los datos de cada cliente
    Aqui usamos sobreescritura de un metodo que ya esta incluido en Java */
    @Override
    public String toString() {
        return "ID: " + idCliente +
        " | Nombre: " + nombre +
        " | Telefono: " + telefono +
        " | Correo: " + correo +
        " | Saldo pendiente: " + String.format("%.2f", saldoPendiente);
    }
}