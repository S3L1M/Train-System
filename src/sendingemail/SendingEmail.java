package sendingemail;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendingEmail {
     public static void Sending(String Email,String Name,String Phone,String NOseat,String Dest){
    final String username = "TrainRSys@gmail.com"; //Our  email
    final String password = "Train12345";//our password

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
/*put properties of protcol*/
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("TrainRSys@gmail.com"));
        //our  email bya5od el email bta3e
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Email));
        //Hena bay5od el Email ely haytb3tlo
        message.setSubject("Subject");    
        message.setText("PFA");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        // String Name,int id,String TimeofArrive,int NumofSeat,String Dest
        Writeinpdf x=new Writeinpdf();
        x.Writeinpdff(Name,Phone,NOseat, Dest);
     
     
    //attached pdf
        String file = Name+".pdf";
        //asm el fie ely hyt3mlo path
        String fileName = "YourTicket.pdf";
        //Asm el file ely hyob2a head ka pdf
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);
    //Hena byro7 ygeeb el file ely htb3to
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    //bya5od asm el body
    multipart.addBodyPart(messageBodyPart);
    
        message.setContent(multipart);
    //hena by7ot kol content fe el message
        
        System.out.println("sending");
        Transport.send(message);
        System.out.println("Done");    
    }
    catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}
    