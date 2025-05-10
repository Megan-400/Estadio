/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;

/**
 *
 * @author chemo
 */
public class ManipulacionArchivos
{

    public static void guarda(JFrame jf, Object obj, String s)
    {
        try
        {
            File dir = new File("Datos");
            if (!dir.exists())
            {
                dir.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("Datos/" + s);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception ex)
        {
            System.out.println("Error..." + ex.toString());
        }
    }

    public static void guarda(Object obj, String s)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("../Datos/" + s);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception ex)

        {
            System.out.println("Error..." + ex.toString());
        }
    }

    public static void guardaArr(JFrame jf, Object obj[], String s)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("../Datos/" + s);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception ex)

        {
            System.out.println("Error..." + ex.toString());
        }
    }

    public static Object carga(JFrame jf, String s)
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream("Datos/" + s); 
            ObjectInputStream arch = new ObjectInputStream(fis);
            obj = arch.readObject();
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado: " + s); 
        } catch (Exception ex)
        {
            System.out.println("Error al cargar archivo: " + ex.toString());
        }
        return obj;
    }

    public static Object carga(String s)
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream("../Datos/" + s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            obj = arch.readObject();
            arch.close();

        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception ex)
        {
            System.out.println("Error..." + ex.toString());
        }
        return obj;
    }

    public static Object cargaArr(JFrame jf, String s)
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream("../Datos/" + s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            obj = (Object[]) arch.readObject();
            arch.close();

        } catch (FileNotFoundException ex)
        {
            System.out.println("No se encontro el archivo");
        } catch (Exception ex)
        {
            System.out.println("Error..." + ex.toString());
        }
        return obj;
    }
}
