import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendemail {

    public static void Send(String recepient, String date, String note) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "francescograuso@hotmail.com";
        String password = "ErCrasher";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, date, note);
        Transport.send(message);
    }

     static Message prepareMessage(Session session, String myAccountEmail, String recepient, String date, String note){
        try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("Booking successfull");
                message.setText("Hey there your booking for the date: "+date+" with the note: "+note+" has been successfull");
                return message;
        }catch (Exception ex){
            Logger.getLogger(sendemail.class.getName()).log(Level.SEVERE , null, ex);
        }
        return null;
    }
}
