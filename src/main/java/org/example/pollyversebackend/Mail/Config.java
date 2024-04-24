package org.example.pollyversebackend.Mail;

public class Config {
    public static void main(String[] args) {

        EmailSender emailSender = new EmailSender();

        String to="sandeep090304@gmail.com";
        String from="jeetcodes127.0.1@gmail.com";
        String subject="Polly verse backend";
        String text="This is an Example of email and using java program";
        boolean b = emailSender.sendEmail(from,to, subject, text);
        if(b){
            System.out.println("Email sent successfully");
        }else{
            System.out.println("Email not sent");
        }
    }
}
