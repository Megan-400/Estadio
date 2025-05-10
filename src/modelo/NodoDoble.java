package modelo;

/**
 *
 * @author chemo
 */
public class NodoDoble
{

    private Boleto boleto;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(Boleto boleto)
    {
        this.boleto = boleto;
    }

    public Boleto getBoleto()
    {
        return boleto;
    }

    public NodoDoble getAnterior()
    {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior)
    {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente)
    {
        this.siguiente = siguiente;
    }
}
