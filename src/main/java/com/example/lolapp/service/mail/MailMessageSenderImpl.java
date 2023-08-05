package com.example.lolapp.service.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailMessageSenderImpl implements MessageSender {
    private final JavaMailSender javaMailSender;

    public MailMessageSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public boolean sendMessage(String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);
        message.setSubject("YO!!!");
        message.setText("YO!!!! welcome");
        javaMailSender.send(message);
        return true;
    }
}
