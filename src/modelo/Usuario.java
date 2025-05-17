/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chemo
 */
public class Usuario implements Serializable
{

    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Boleto> boletosComprados;

    public Usuario(String nombre, String apellido, String correo, String contraseña)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.boletosComprados = new ArrayList<>();
    }

    public void agregarBoleto(Boleto boleto)
    {
        boletosComprados.add(boleto);
    }

    public List<Boleto> getBoletosComprados()
    {
        return boletosComprados;
    }

    public String getCorreo()
    {
        return correo;
    }

    public String getContraseña()
    {
        return contraseña;
    }

}
