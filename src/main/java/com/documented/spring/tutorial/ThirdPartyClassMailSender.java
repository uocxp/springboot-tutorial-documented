package com.documented.spring.tutorial;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;


/**
 * this Class is not annotated so Spring treats it as a third party class
 *
 * If the mail sender classes were not written by us, but were part of some third party JAR, we’ll
 * not be able to annotate those with @Component, because we’ll not have access to their source code.
 * In such case, we could use Java configuration classes with @Bean of a method that returns an instance 
 * of the 3rd Party Class.
 */
public class ThirdPartyClassMailSender implements MailSender {
    private static final Log log = LogFactory.getLog(SmtpMailSender.class);

    @Override
    public void send(String to, String subject, String body) {
        log.info("@@@ Sending 3rd party mail to " + to);
        log.info("@@@ Subject: " + subject);
        log.info("@@@ Body: " + body);
    }
}