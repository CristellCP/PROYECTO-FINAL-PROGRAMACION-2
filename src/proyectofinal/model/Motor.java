package proyectofinal.model;

public class Motor {
    private String codigoMotor;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidadDisponible;
    private int stockMinimo;

    public Motor(String codigoMotor, String marca, String modelo,
                 double precio, int cantidadDisponible, int stockMinimo) {
        this.codigoMotor = codigoMotor;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.stockMinimo = stockMinimo;
    }

    // Getters y Setters

    public String getCodigoMotor() { return codigoMotor; }
    public void setCodigoMotor(String codigoMotor) { this.codigoMotor = codigoMotor; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    @Override
    public String toString() {
        return codigoMotor + "," + marca + "," + modelo + "," +
               precio + "," + cantidadDisponible + "," + stockMinimo;
    }
}
