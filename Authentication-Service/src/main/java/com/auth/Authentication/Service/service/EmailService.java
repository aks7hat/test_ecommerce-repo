package com.auth.Authentication.Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.model.UserModel;

import jakarta.mail.internet.MimeMessage;


@Service
class EmailService {
	
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.senderEmail}")
    private String sender;

    public String sendMail(UserModel user){
        String subject = "Verify your email";
        String senderName = "AmCart";
//        String mailContent = "Hello " + user.getFirstName() + ",\n";
//        mailContent += "Your verification code is: " + user.getVerificationCode() + "\n";
//        mailContent += "Please enter this code to verify your email.";
//        mailContent +="\n";
//        mailContent+= "Regards, \n " ;
//        mailContent+= senderName;
        String mailContent = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "    <style>"
                + "        body {"
                + "            font-family: Arial, sans-serif;"
                + "            line-height: 1.6;"
                + "            color: #333;"
                + "            background-color: #f9f9f9;"
                + "            padding: 20px;"
                + "        }"
                + "        .container {"
                + "            max-width: 600px;"
                + "            margin: 0 auto;"
                + "            padding: 20px;"
                + "            border: 1px solid #ddd;"
                + "            border-radius: 10px;"
                + "            background-color: #ffffff;"
                + "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);"
                + "        }"
                + "        h1 {"
                + "            color: #3B829A;"
                + "        }"
                + "        .verification-code {"
                + "            font-size: 24px;"
                + "            font-weight: bold;"
                + "            color: #3B829A;"
                + "            background-color: #f0f8ff;"
                + "            padding: 10px 20px;"
                + "            margin: 20px 0;"
                + "            display: inline-block;"
                + "            border-radius: 5px;"
                + "        }"
                + "        .footer {"
                + "            margin-top: 30px;"
                + "            font-size: 16px;"
                + "            color: #888;"
                + "            text-align: center;"
                + "        }"
                + "    </style>"
                + "</head>"
                + "<body>"
                + "    <div class='container'>"
                + "        <h1>Hello, " + user.getFirstName() + "!</h1>"
                + "        <p>Thank you for registering with <strong>AmCart</strong>. Please use the verification code below to verify your email address:</p>"
                + "        <div class='verification-code'>" + user.getVerificationCode() + "</div>"
                + "        <p>If you did not register with AmCart, you can safely ignore this email.</p>"
                + "        <div class='footer'>"
                + "            Regards,<br>"
                + "            <strong>" + senderName + "</strong>"
                + "        </div>"
                + "    </div>"
                + "</body>"
                + "</html>";

        try{
//            SimpleMailMessage mailMessage
//                    = new SimpleMailMessage();
//            mailMessage.setFrom(sender);
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setText(mailContent);
//            mailMessage.setSubject(subject);
//            javaMailSender.send(mailMessage);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(sender);
            helper.setTo(user.getEmail());
            helper.setSubject(subject);
            helper.setText(mailContent, true); // true indicates HTML content

            javaMailSender.send(mimeMessage);
        }
        catch (Exception e){
        	System.out.println("error while sending email = " + e);
            return "Error while Sending Mail";
        }
        System.out.println("email sent succesfully!!!");
        return "Email sent";
    }
    
    public String sendPasswordResetEmail(UserModel user, String url) {
        String subject = "Password Reset Request";
        String senderName = "AmCart";
//        String mailContent = "Hello " + user.getFirstName() + ",\n";
//        mailContent += "Click on the link below to reset the password: \n" + url;
//        mailContent +="\n";
//        mailContent+= "Regards, \n " ;
//        mailContent+= senderName;
        String mailContent = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "    <style>"
                + "        body {"
                + "            font-family: Arial, sans-serif;"
                + "            line-height: 1.6;"
                + "            color: #333;"
                + "        }"
                + "        .container {"
                + "            width: 90%;"
                + "            margin: 0 auto;"
                + "            padding: 20px;"
                + "            border: 1px solid #ddd;"
                + "            border-radius: 5px;"
                + "            background-color: #f9f9f9;"
                + "        }"
                + "        h1 {"
                + "            color: #3B829A;"
                + "        }"
                + "        .button {"
                + "            display: inline-block;"
                + "            margin-top: 20px;"
                + "            padding: 10px 20px;"
                + "            font-size: 16px;"
                + "            color: #fff;"
                + "            background-color: #3B829A;"
                + "            text-decoration: none;"
                + "            border-radius: 5px;"
                + "        }"
                + "        .fallback {"
                + "            margin-top: 20px;"
                + "        }"
                + "        .footer {"
                + "            margin-top: 30px;"
                + "            font-size: 16px;"
                + "            color: #888;"
                + "        }"
                + "    </style>"
                + "</head>"
                + "<body>"
                + "    <div class='container'>"
                + "        <h1>Hello, " + user.getFirstName() + "!</h1>"
                + "        <p>You requested to reset your password for your AmCart account. "
                + "        Click the button below to reset your password:</p>"
                + "        <a href='" + url + "' class='button'>Reset Password</a>"
                + "        <p class='fallback'>If the button does not work, copy and paste the following link into your browser:</p>"
                + "        <p><a href='" + url + "'>" + url + "</a></p>"
                + "        <p>If you did not request this change, you can safely ignore this email.</p>"
                + "        <div class='footer'>"
                + "            Regards,<br>"
                + "            <strong>" + senderName + "</strong>"
                + "        </div>"
                + "    </div>"
                + "</body>"
                + "</html>";

        try{
//            SimpleMailMessage mailMessage
//                    = new SimpleMailMessage();
//            mailMessage.setFrom(sender);
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setText(mailContent);
//            mailMessage.setSubject(subject);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(sender);
            helper.setTo(user.getEmail());
            helper.setSubject(subject);
            helper.setText(mailContent, true); // true indicates HTML content

            javaMailSender.send(mimeMessage);
        }
        catch (Exception e){
        	System.out.println("error while pass reset sending email = " + e);
            return "Error while Sending Mail";
        }
        System.out.println("password reset email sent ");
        return "Email sent";
    }
}
