package proyectofinal.model;

public class Venta {

    private String idVenta, idCliente, codigoMotor, fecha;
    private int cantidad;
    private double precioUnitario, total;
    private boolean pagado;

    public Venta(String idVenta, String idCliente, String codigoMotor,
                 int cantidad, double precioUnitario, double total,
                 String fecha, boolean pagado) {

        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.codigoMotor = codigoMotor;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.fecha = fecha;
        this.pagado = pagado;
    }

    public String getIdVenta() { return idVenta; }
    public String getIdCliente() { return idCliente; }
    public String getCodigoMotor() { return codigoMotor; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getTotal() { return total; }
    public String getFecha() { return fecha; }
    public boolean isPagado() { return pagado; }

    @Override
    public String toString() {
        return idVenta + " | " + idCliente + " | " + codigoMotor +
               " | " + cantidad + " | " + total;
    }
}