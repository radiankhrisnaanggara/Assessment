/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ILoginRegisterController;
import daos.LoginRegisterDAO;
import idaos.ILoginRegisterDAO;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.Account;
import org.hibernate.SessionFactory;
import tools.BCrypt;
import tools.Token;

/**
 *
 * @author Lenovo
 */
public class LoginRegisterController implements ILoginRegisterController {

    private SessionFactory factory;
    private ILoginRegisterDAO ilrdao;

    public LoginRegisterController(SessionFactory factory) {
        ilrdao = new LoginRegisterDAO(factory);
    }

    @Override
    public String login(String email, String password) {
        String result = "";
            Account account = ilrdao.getByEmail(email);
            boolean isTrue = BCrypt.checkpw(password, account.getPassword());
            if (isTrue) {
                result = "Login Berhasil";
            } else {
                result = "Login Gagal";
            }
        return result;
    }
    
    public String sendForgotPassword(String email) {
        String result;
        Account account = ilrdao.getByEmail(email);
        account.setToken(Token.generateToken());
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mii.bootcamp29@gmail.com", "bootcampbatch29");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Verikasi Akun "+account.getEmployee().getFirstName()+" "+account.getEmployee().getLastName());
            message.setText("Silahkan klik link reset password dibawah ini untuk mengubah password akun kamu "
                    + "http://localhost:8084/UserManagement/sendemail?action=resetpassword&&v="+account.getToken());
            Transport.send(message);
            result = "Silahkan Cek Email Anda!";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
