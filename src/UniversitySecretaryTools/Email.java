package UniversitySecretaryTools;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    //METHOD FOR THE CREATION OF THE MESSAGE (The email will be sent only to the ones who have completed a successful booking)
    static Message prepareMessage(Session session, String myAccountEmail, String email, String date, String note){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Booking successful");
            message.setText("Hey there your booking for the date: "+date+" with the note: "+note+" has been successful");  //default message for everyone, but changes the data (date and note)
            return message;
        }catch (Exception ex){
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE , null, ex);
        }
        return null;
    }

    //METHOD TO SEND THE MESSAGE
    public static void Send(String email, String date, String note) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true"); //set authentication
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp-mail.outlook.com"); //set host
        properties.put("mail.smtp.port", "587"); //set port

        String myAccountEmail = "francescograuso@hotmail.com"; //Account of Francesco Grauso (we could create one for it)
        String password = "ErCrasher"; //He doesn't mind to show this account, but we need to put all of that not visible

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, email, date, note); //call to the method to create the message
        Transport.send(message);
    }

}
