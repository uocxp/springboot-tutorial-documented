
package com.documented.spring.tutorial;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * By annotating MockMailSender with @Component, we told Spring 
 * to create an instance of MockMailSender and keep it at some place when the application starts.
 * 
 * If the mail sender classes were not written by us, but were part of some third party JAR, we’ll
 * not be able to annotate those with @Component, because we’ll not have access to their source code.
 * In such case, we could use Java configuration classes.
 */
@Component("mockMailSender")
@Qualifier("mock") // name for autowired
public class MockMailSender implements MailSender {
    private static final Log log = LogFactory.getLog(MockMailSender.class);

    @Override
    public void send(String to, String subject, String body) {
        log.info("@@@ Sending mail to " + to);
        log.info("@@@ Subject: " + subject);
        log.info("@@@ Body: " + body);
    }
}