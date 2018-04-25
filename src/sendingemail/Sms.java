/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendingemail;

/**
 *
 * @author andrewnagyeb
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Sms {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

     public static void sendSMS(String recipient) throws UnsupportedEncodingException, MalformedURLException, IOException {
	//This variable is the sender id        
	String senderID = "TrainRSys";
	//API credentials 
        String username = "6EFYWHZY";//username
        String password = "2VZHY5";//password
        String recipientNumber = recipient;//phone number to which sms is going to be sent (i.e. 01127211150)
        String message = "Thank's for using TrainRSys ";//The message that is going to be sent
        
        HttpURLConnection uc;//establisher for HTTP connection
        URL url ;//establisher for URL connection
        String requestUrl = "https://www.smsmisr.com/api/send/?"
                + "username=" + username
                + "&password=" + password
                + "&language=1"
                + "&sender=" + senderID
                + "&mobile=2" + recipientNumber //if you want to add more numbers just uncomment the next line
		//+ "," + "2" + secondNumber + "," + "2" + thirdnumber .. and so on
                + "&message=" + URLEncoder.encode(message, "UTF-8");//This is how I construct the URL of which I am going to sent HTTP Request
	//Above URL should not be changed this is how the API works. 
        url = new URL(requestUrl);//Intialize an object of URL
        uc = (HttpURLConnection) url.openConnection(); //HTTP requesting and casting it into HTTPURLConnection is order to get its response.
         System.out.println(uc.getResponseMessage());
        if (uc.getResponseMessage().equals("OK")){
            //do something for example:         
             System.out.println("SMS was sent successfully");
        } else {
          //do something else for example:
            System.out.println("There was an error while sending your SMS please try again.");
        }
        
        uc.disconnect();//closing connection.

    }
    
}