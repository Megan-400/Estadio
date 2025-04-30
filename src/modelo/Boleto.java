package modelo;

public class Boleto
{

    private String id;
    private String categoria; 
    private double precio;
    private String numeroAsiento;
    private boolean vendido;

    public Boleto(String id, String categoria, double precio, String numeroAsiento)
    {
        this.id = id;
        this.categoria = categoria;
        this.precio = precio;
        this.numeroAsiento = numeroAsiento;
        this.vendido = false;
    }

    public String getId()
    {
        return id;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public double getPrecio()
    {
        return precio;
    }

    public String getNumeroAsiento()
    {
        return numeroAsiento;
    }

    public boolean isVendido()
    {
        return vendido;
    }

    public void marcarComoVendido()
    {
        this.vendido = true;
    }
    

    @Override
    public String toString()
    {
        return "Boleto{"
                + "id='" + id + '\''
                + ", categoria='" + categoria + '\''
                + ", precio=" + precio
                + ", numeroAsiento='" + numeroAsiento + '\''
                + ", vendido=" + vendido
                + '}';
    }
}
