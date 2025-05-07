/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.LinkedList;
import java.util.Queue;
import modelo.Boleto;

/**
 *
 * @author chemo
 */
public class ColaBoletos
{

    private Queue<Boleto> cola;

    public ColaBoletos()
    {
        cola = new LinkedList<>();
    }

    public void encolar(Boleto boleto)
    {
        cola.offer(boleto);
    }

    public boolean estaVacia()
    {
        return cola.isEmpty();
    }

    public Queue<Boleto> obtenerBoletosVendidos()
    {
        return cola;
    }

    public void vaciar()
    {
        cola.clear();
    }
}
