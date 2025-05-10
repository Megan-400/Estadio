package modelo;

/**
 *
 * @author URIEL
 */
public class NodoCateg {

    private String Categoria;
    private NodoBoleto Primerboleto;
    private NodoCateg Adelante;

    public NodoCateg(String categoria) {
        Categoria = categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public NodoBoleto getPrimerboleto() {
        return Primerboleto;
    }

    public void setPrimerboleto(NodoBoleto Primerboleto) {
        this.Primerboleto = Primerboleto;
    }

    public NodoCateg getAdelante() {
        return Adelante;
    }

    public void setAdelante(NodoCateg adelante) {
        Adelante = adelante;
    }

}
