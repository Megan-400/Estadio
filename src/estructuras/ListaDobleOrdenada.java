package estructuras;

import modelo.Boleto;

public class ListaDobleOrdenada
{

    private NodoDoble cabeza;

    public void insertarOrdenado(Boleto boleto)
    {
        NodoDoble nuevo = new NodoDoble(boleto);
        if (cabeza == null)
        {
            cabeza = nuevo;
            return;
        }

        NodoDoble actual = cabeza;
        while (actual != null && compararPrioridad(boleto.getCategoria(), actual.getBoleto().getCategoria()) > 0)
        {
            actual = actual.getSiguiente();
        }

        if (actual == cabeza)
        {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        } else if (actual == null)
        {
            NodoDoble temp = cabeza;
            while (temp.getSiguiente() != null)
            {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
            nuevo.setAnterior(temp);
        } else
        {
            NodoDoble anterior = actual.getAnterior();
            anterior.setSiguiente(nuevo);
            nuevo.setAnterior(anterior);
            nuevo.setSiguiente(actual);
            actual.setAnterior(nuevo);
        }
    }

    private int compararPrioridad(String cat1, String cat2)
    {
        return obtenerPrioridad(cat1) - obtenerPrioridad(cat2);
    }

    private int obtenerPrioridad(String categoria)
    {
        return switch (categoria.toUpperCase())
        {
            case "VIP" ->
                1;
            case "PREFERENCIAL" ->
                2;
            case "GENERAL" ->
                3;
            default ->
                4;
        };
    }

    public void generarReporteTXT()
    {
        try
        {
            String nombreArchivo = "boletos_ordenados_" + java.time.LocalDateTime.now().toString().replace(":", "-") + ".txt";
            java.io.PrintWriter writer = new java.io.PrintWriter(nombreArchivo, "UTF-8");

            NodoDoble actual = cabeza;
            writer.println("Boletos vendidos ordenados por prioridad:");
            writer.println("-------------------------------------------------");

            while (actual != null)
            {
                Boleto b = actual.getBoleto();
                writer.println("ID: " + b.getId() + " | " + b.getCategoria() + " | $" + b.getPrecio());
                actual = actual.getSiguiente();
            }

            writer.close();
            System.out.println("Archivo generado: " + nombreArchivo);

        } catch (Exception e)
        {
            System.err.println("Error al generar archivo: " + e.getMessage());
        }
    }
}
