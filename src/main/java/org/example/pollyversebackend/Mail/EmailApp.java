package org.example.pollyversebackend.Mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EmailApp {
    public static void main(String[] args) throws FileNotFoundException {

        EmailSender emailSender = new EmailSender();

        String to="sandeep090304@gmail.com";
        String from="jeetcodes127.0.1@gmail.com";
        String subject="Polly verse backend";
        String text="Credential login";
        File file=new File("C:\\Users\\sande\\OneDrive\\Desktop\\API’s Docs.pdf");

        
//        boolean b = emailSender.sendEmail(from,to, subject, text);
//        if(b){
//            System.out.println("Email sent successfully");
//        }else{
//            System.out.println("Email not sent");
//        }

        boolean c= emailSender.sendEmailWithAttachment(from,to,subject,text,file);
        if (c){
            System.out.println("Email sent successfully");
        }else{
            System.out.println("Email not sent");
        }
    }
}
