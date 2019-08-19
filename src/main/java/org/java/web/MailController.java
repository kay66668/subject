package org.java.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class MailController {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String fromUser;

    @PostMapping("/mailsend")
    public String mailSend(String toUser, String title, String msg, @RequestParam("myfile")MultipartFile myfile) throws MessagingException {
      //  System.out.println("**************************");
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        String[] to=toUser.split(";");
        helper.setFrom(fromUser);
        helper.setSubject(title);
        helper.setText(msg);
        helper.setTo(to);
        if(!StringUtils.isEmpty(myfile.getOriginalFilename())){
            String fname=myfile.getOriginalFilename();
            helper.addAttachment(fname,myfile);
        }
        mailSender.send(mimeMessage);
        return "邮件发送成功。。。。。。<a href='/forward/book01'>返回首页</a>";
    }
}
