package org.example.pollyversebackend.Mail;

import java.util.Properties;

public class EmailSender {
    public boolean sendEmail(String from, String to, String subject, String body) {
        boolean flag = false;

        //
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "jeetcodes127.0.1@gmail.com");

        //Session
         Session

        return true;
    }
}
