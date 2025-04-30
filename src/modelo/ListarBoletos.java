/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.*;

/**
 *
 * @author URIEL
 */
public class ListarBoletos {

    private NodoCateg primera;

    public NodoCateg getPrimero() {
        return primera;
    }

    public void setPrimero(NodoCateg primera) {
        this.primera = primera;
    }

    public void agregarCategoria(NodoCateg nueva) {
        if (primera == null) {
            primera = nueva;
            System.out.println("Se agrego 1ER cat");
        } else {
            NodoCateg auxCateg = primera;
            while (auxCateg.getAdelante() != null) {
                auxCateg = auxCateg.getAdelante();
            }
            auxCateg.setAdelante(nueva);
            System.out.println("Se agrego cat");
        }
    }

    public void cambiarEstadoBoleto(Boleto boleto) {

        if (primera == null) {
            System.out.println("Categoria vacia");
            return;
        }

        NodoCateg aux = primera;
        boolean encontrado = false;

        while (aux.getAdelante() != null) {
            NodoBoleto aux1 = aux.getPrimerboleto();
            while (aux1.getSiguiente() != null) {
                if (aux1.getBoleto().getId().equals(boleto.getId())) {
                    aux1.getBoleto().marcarComoVendido();
                    encontrado = true;
                    break; // salimos del ciclo de boletos
                }
                aux1 = aux1.getSiguiente();
            }
            if (encontrado) {
                break; // salimos del ciclo de categorías también
            }
            aux = aux.getAdelante();
        }
        System.out.println("No se encontro el boleto");

    }

    //Posible utilizacion
    /*public NodoCateg mostrarCategoria(String categoria) {
        NodoCateg aux = primera;
        while (aux != null) {
            if (aux.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println("Hecho");
                return aux;
            }
            aux = aux.getAdelante();
        }
        System.out.println("Fallo");
        return null;
    }*/
    
    public void agregarBoleto(Boleto boleto) {
    if (primera == null) {
        System.out.println("Categoria vacia");
        return;
    }

    NodoCateg actual = primera;
    boolean encontrado = false;

    while (actual != null) {
        if (actual.getCategoria().equalsIgnoreCase(boleto.getCategoria())) {
            NodoBoleto nuevo = new NodoBoleto(boleto);

            if (actual.getPrimerboleto() == null) {
                actual.setPrimerboleto(nuevo);
            } else {
                NodoBoleto aux = actual.getPrimerboleto();
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
            }

            System.out.println("Boleto agregado a la categoría: " + actual.getCategoria());
            encontrado = true;
            break;
        }
        actual = actual.getAdelante();
    }

    if (!encontrado) {
        System.out.println("No se encontró la categoría para el boleto: " + boleto.getCategoria());
    }
}


    public List<Boleto> obtenerTodosLosBoletos() {
        List<Boleto> boletos = new ArrayList<>();  // Crear una lista para almacenar los boletos

        NodoCateg aux = primera;

        while (aux != null) {

            NodoBoleto aux1 = aux.getPrimerboleto();

            while (aux1 != null) {
                boletos.add(aux1.getBoleto());  // Agregar el boleto a la lista
                aux1 = aux1.getSiguiente();     // Avanzar al siguiente nodo   
            }
            aux = aux.getAdelante();
        }

        return boletos;  // Retornar la lista de boletos
    }

    public void MostrarBoletos() {
        NodoCateg CategoriaActual = primera;
        while (CategoriaActual.getAdelante() != null) {
            System.out.println("Categoria:" + CategoriaActual.getCategoria());
            NodoBoleto BoletoActual = CategoriaActual.getPrimerboleto();
            while (BoletoActual != null) {
                Boleto b = BoletoActual.getBoleto();
                System.out.println("ID:" + b.getId() + " Categoria:" + b.getCategoria() + " Precio:" + b.getPrecio() + " NoAsiento:" + b.getCategoria());
            }
        }
    }

    /*public boolean insertar(NodoBoleto nodo) {

        if (nodo == null) {
            System.out.println("No se puede insertar un nodo vacio");
            return false;
        }

        if (primero == null) {
            primero = nodo;
            return true;
        }

        NodoBoleto aux = primero;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nodo);
        return true;
    }

    public void CambiarEstadoBoleto(Boleto boleto) {

        if (primero == null) {
            System.out.println("Lista vacia");
            return;
        }

        NodoBoleto aux = primero;

        while (aux != null) {
            if (primero.getBoleto().getId().equals(boleto.getId())) {
                primero.getBoleto().desmarcarComoVendido();
                return;
            }
            aux = aux.getSiguiente();

        }
        System.out.println("No se encontro el boleto");

    }

public Boleto getBoletoSiguiente() {
    NodoBoleto aux = primero;

    // Verifica si la lista está vacía
    if (aux == null) {
        return null; // No hay boletos
    }

    // Recorre la lista y devuelve el siguiente boleto
    if (aux != null) {
        primero = aux.getSiguiente(); // Avanza al siguiente nodo
        return aux.getBoleto(); // Devuelve el boleto actual
    }

    return null;
}
     */
}
