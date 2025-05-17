/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author chemo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class DialogoCodigoConTiempo extends JDialog
{

    private JTextField txtCodigo;
    private JLabel lblContador;
    private boolean confirmado = false;
    private String codigoIngresado = "";
    private Timer timer;
    private int segundos = 59;

    public DialogoCodigoConTiempo(Frame parent)
    {
        super(parent, "Verificación de Código", true);
        setLayout(new BorderLayout());
        setSize(400, 200);
        setLocationRelativeTo(parent);

        JLabel lblMensaje = new JLabel("Se ha enviado un código a tu correo.");
        lblMensaje.setFont(new Font("Arial", Font.PLAIN, 14));
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);

        txtCodigo = new JTextField();
        txtCodigo.setFont(new Font("Consolas", Font.BOLD, 22));
        txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);

        lblContador = new JLabel("Tiempo restante: 59 segundos", SwingConstants.CENTER);
        lblContador.setFont(new Font("Arial", Font.ITALIC, 12));
        lblContador.setForeground(Color.RED);

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.setBackground(new Color(0, 128, 0));
        btnVerificar.setForeground(Color.WHITE);

        btnVerificar.addActionListener(e ->
        {
            codigoIngresado = txtCodigo.getText().trim();
            confirmado = true;
            detenerTimer();
            dispose();
        });

        JPanel panelCentro = new JPanel(new GridLayout(3, 1, 5, 5));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        panelCentro.add(lblMensaje);
        panelCentro.add(txtCodigo);
        panelCentro.add(lblContador);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVerificar);

        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        iniciarTimer();
    }

    private void iniciarTimer()
    {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            public void run()
            {
                SwingUtilities.invokeLater(() ->
                {
                    if (segundos <= 0)
                    {
                        detenerTimer();
                        JOptionPane.showMessageDialog(DialogoCodigoConTiempo.this, "Tiempo agotado. Verificación cancelada.");
                        dispose();
                    } else
                    {
                        lblContador.setText("Tiempo restante: " + segundos + " segundos");
                        segundos--;
                    }
                });
            }
        }, 0, 1000);
    }

    private void detenerTimer()
    {
        if (timer != null)
        {
            timer.cancel();
        }
    }

    public boolean fueConfirmado()
    {
        return confirmado;
    }

    public String getCodigoIngresado()
    {
        return codigoIngresado;
    }
}
