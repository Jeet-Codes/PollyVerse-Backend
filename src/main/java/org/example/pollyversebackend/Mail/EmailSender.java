package org.example.pollyversebackend.Mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {
    public boolean sendEmail(String from, String to, String subject, String body) {
        boolean flag = false;

        //
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        String username="jeetcodes127.0.1@gmail.com";
        String password="adwbckpydpyedhld";

        //Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
