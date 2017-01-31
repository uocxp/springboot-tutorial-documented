package com.documented.spring.tutorial;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The @Controller annotation will mark your class as a web controller that has a @RequestMapping and a
 * @ResponseBody. All this means is that when your web application is running, it will accept requests from the 
 * http://localhost:8080/ URL and you should get some response back.
 *
 */
@RestController
public class MailController {

    /**
     * Hard coding the concrete class MockMailSender above tightly coupled it to
     * our MailController class. In other words, MailController is now depending
     * on the concrete class MockMailSender. That means, if we ever change our
     * mind to use SmtpMailSender instead of MockMailSender, we’ll need to alter
     * the source code, this way: private MailSender mailSender = new
     * SmtpMailSender(); This kind of tight coupling with concrete classes is
     * evil. Also, it won’t let us switch the implementation based on
     * environments. For example, we’ll not be able to use MockMailSender in
     * development environment, whereas SmtpMailSender in production.This is
     * where dependency injection comes in.
     */
    // private MailSender mailSender = new MockMailSender();

    // @Resource(name="mockMailSender")
    // @Resource(name="smtpMailSender")
    private MailSender mailSender;

    
//    @Resource(name = "mockMailSender")
//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
    
    /**
     * Similar to @Resource, we also have @Autowired. It’s more powerful – 
     * it not only works on setters, but on any method, including the constructors.
     * For example, using @Autowired, we can replace our setter injection with constructor 
     * injection.
     * 
     * @Autowired does not take the name parameter.
     * Instead, we need to use @Qualifier along with @Autowired.
     */
    @Autowired
    public MailController(@Qualifier("thirdPartyClassMailSender") MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    @RequestMapping("mail")
    public String sendMail() {
        mailSender.send("abc@example.com", "Some subject", "the content");
        return "Mail sent";
    }
}