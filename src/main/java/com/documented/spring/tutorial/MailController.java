package com.documented.spring.tutorial;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The @RestController annotation will mark your class as a web controller that has a @RequestMapping and a
 *
 *@ResponseBody means is that the returned value of the method will constitute the body of the HTTP response
 */
@RestController
public class MailController {

    /**
     * Hard coding the concrete class SmtpMailSender above tightly coupled it to
     * our MailController class. In other words, MailController is now depending
     * on the concrete class SmtpMailSender. That means, if we ever change our
     * mind to use FooMailSender instead of SmtpMailSender, we’ll need to alter
     * the source code, this way: private MailSender mailSender = new
     * SmtpMailSender(); This kind of tight coupling with concrete classes is
     * evil. Also, it won’t let us switch the implementation based on
     * environments. For example, we’ll not be able to use FooMailSender in
     * development environment, whereas SmtpMailSender in production.This is
     * where dependency injection comes in.
     * 
     *  @Autowired :  With this annotation Spring tries to find a bean
     *  with this type and inject that to the variable. This behavior is called 
     *  dependency injection by name.
     * @Autowired does not take the name parameter.
     * Instead, we need to use @Qualifier along with @Autowired to avoid imbiguity.
     */
    // private MailSender mailSender = new FooMailSender();

  
//    @Autowired
//    @Qualifier("smtpMailSender")
      private MailSender mailSender;

    
    @Autowired
    public void setMailSender(@Qualifier("smtpMailSender") MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
   
    
//    @Autowired
//    
//    public MailController(@Qualifier("smtpMailSender") MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
    
    @RequestMapping("mail")
    @ResponseBody
    public String sendMail() {
        mailSender.send("abc@example.com", "Some subject", "the content");
        return "Mail sent";
    }
}