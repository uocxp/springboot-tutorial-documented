package com.documented.spring.tutorial;

public interface MailSender {
    void send(String to, String subject, String body);
}