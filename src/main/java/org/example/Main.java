//java.util.Properties : represents a persistent set of properties .The properties can be saved to stream or loaded from a stream
//path = java
//javax.mail.Messaging : base class for all exceptions thrown by messaging class
//java.mail.Message : Models an email message , To send a msg , subclass od messgae is isntantiated msg is sent using Transport.send method
// message ko compose karne ke liye messsage ka object banana hai aur store karna ha Mime message me
//java.mail.session : session class represents a mail session
package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.NewsAddress;
import java.net.Inet4Address;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws MessagingException {
        System.out.println("Hello world!");
        String to = "vishugoel2812@gmail.com";
        String from = "boseanushree004@gmail.com";
        String host = "smtp.gmail.com";
        Properties props=new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        Session session=Session.getDefaultInstance(props,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("boseanushree004@gmail.com", "cdybcsjedxmiprjf");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is the email subject");

            message.setContent("<h1>This is the email body</h1>", "text/html");
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}