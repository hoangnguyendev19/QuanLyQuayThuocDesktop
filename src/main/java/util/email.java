package util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


//email: 
//pass: zmyg uwdt fise aeky
public class email {

    public static void sendMess(String to, String text) {
        try {
            final String from = "tranhuy12072003@gmail.com";
            final String pass = "uzus ytph ourd ubdk";

//            final String to = "conguyetnaduongvulan@gmail.com";

            // Properties configuration
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587"); // Use 587 for TLS
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");

            // Authenticator
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            };

            // Session
            Session session = Session.getInstance(prop, auth);

            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);

            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            message.setFrom();

            // Receiver's email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Email subject
            message.setSubject("KHÔI PHỤC MẬT KHẨU CHO HỆ THỐNG QUẢN LÝ QUẦY THUỐC");

            // Email content
            message.setText("Xin chào quý khách, cảm ơn quý khách đã sử dụng dịch vụ của hệ thống quầy thuốc tây của chúng tôi!");
            message.setText("Mật khẩu mới của quý khách là: " + text);
            // Send the email
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
