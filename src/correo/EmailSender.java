/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correo;

import java.io.InputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author chemo
 */
public class EmailSender
{

    private static final String EMAIL = "";
    private static final String PASSWORD = "";

    public static void enviarCorreo(String destinatario, String asunto, String mensajeHTML)
    {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });

        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(mensajeHTML, "text/html; charset=utf-8");

            MimeBodyPart imagePart = new MimeBodyPart();
            InputStream is = EmailSender.class.getResourceAsStream("/imagenes/UAEMEX.png");
            if (is == null)
            {
                System.out.println("No se pudo cargar la imagen desde recursos.");
                return;
            }

            ByteArrayDataSource fds = new ByteArrayDataSource(is, "image/png");
            imagePart.setDataHandler(new DataHandler(fds));
            imagePart.setHeader("Content-ID", "<logoUAEMex>");
            imagePart.setDisposition(MimeBodyPart.INLINE);

            MimeMultipart multipart = new MimeMultipart("related");
            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(imagePart);

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Correo con imagen embebida enviado correctamente.");
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error al enviar el correo.");
        }
    }

}
