package com.example.lolapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {
    @Value("${spring.mail.username}")
    String mailHost;
    @Value("${spring.mail.port}")
    Integer mailPort;
    @Value("${spring.mail.username}")
    String mailUserName;
    @Value("${spring.mail.password}")
    String mailpass;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(mailPort);
        javaMailSender.setUsername(mailUserName);
        javaMailSender.setPassword(mailpass);
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smptp.starttls.enable", "true");
        return javaMailSender;
    }
}
