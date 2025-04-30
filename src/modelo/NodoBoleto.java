/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author URIEL
 */
public class NodoBoleto {
    
    private Boleto boleto;
    private NodoBoleto Siguiente = null;

    public NodoBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public NodoBoleto getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoBoleto siguiente) {
        Siguiente = siguiente;
    }
    
}
