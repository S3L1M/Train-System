package opnsrc.fcih.trainrsys.backend;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Sms {
    public static void sendSMS(String recipient, String code) throws UnsupportedEncodingException, MalformedURLException, IOException {
        // Sends a SMS to a phone number

        String senderID = "FLSystem";
	//API credentials
        String username = "";	//username
        String password = "";	//password
        String recipientNumber = recipient;	//phone number which SMS is going to be sent to
        String message = "YOUR MESSAGE";	//The message that is going to be sent
        
        HttpURLConnection uc;	//establisher for HTTP connection
        URL url ;	//establisher for URL connection
        String requestUrl = "http://smsmisr.com/api/send.aspx?"
                + "username=" + username
                + "&password=" + password
                + "&language=1"
                + "&sender=" + senderID
                + "&mobile=2" + recipientNumber
                + "&message=" + URLEncoder.encode(message, "UTF-8");
	
        url = new URL(requestUrl);
        uc = (HttpURLConnection) url.openConnection();

        System.out.println(uc.getResponseMessage());
        uc.disconnect();
    }
}
