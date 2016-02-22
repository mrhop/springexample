package com.hopever.springexample.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Donghui Huo on 2016/2/22.
 */
@Component
public class MailBean implements CommandLineRunner {

//    @Autowired
//    private JavaMailSender javaMailSender;

    @Override
    public void run(String... args) throws Exception {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom("15309861499@163.com");
//        msg.setTo("233402923@qq.com");
//        msg.setSubject("用来测试");
//        msg.setText("测试内容");
//        javaMailSender.send(msg);
    }
}
