package com.ji.my_project.controller;


import com.ji.my_project.bean.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @GetMapping("/teacher")
    public String teacher() {
        return "project/teacher";
    }

    @GetMapping("/cboss")
    public String cboss() {
        return "project/cboss";
    }

    @GetMapping("/query")
    public String query() {
        return "project/query";
    }

    @GetMapping("/send")
    public String send() {
        return "project/send";
    }


    @PostMapping( value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if(username.equals("admin") && password.equals("admin")) {
            return "dashboard";
        } else {
            return "login";
        }
    }

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @PostMapping( value = "/sendEmail")
    public String sendEmail(@RequestParam("email") String email,
                            Map<String,Object> map){



        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject("我的项目经历");
            mimeMessageHelper.setText("<b style='color:red'>见下面的文件</b>", true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom("1418964647@qq.com");

//            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("static/SpringLearning.md");

            InputStream stream = getClass().getClassLoader().getResourceAsStream("static/experience.md");
            File targetFile = new File("experience.md");
            FileUtils.copyInputStreamToFile(stream, targetFile);

            mimeMessageHelper.addAttachment("experience.md", targetFile);
            javaMailSender.send(mimeMessage);

            map.put("msg", "发送成功");
        } catch (MessagingException | IOException e) {
            map.put("msg", "发送失败");
        }


//        if (email.equals("1@1")) {
//
//        } else {
//
//        }
        return "project/send";
    }



//    @Test
//    void test02() throws Exception {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//
//        mimeMessageHelper.setSubject("通知今晚开会");
//        mimeMessageHelper.setText("<b style='color:red'>7:30</b>", true);
//        mimeMessageHelper.setTo("2568635780@qq.com");
//        mimeMessageHelper.setFrom("1418964647@qq.com");
//
//        mimeMessageHelper.addAttachment("SpringLearning.md", new File(this.getClass().getResource("/static/SpringLearning.md").getPath()));
//
//        javaMailSender.send(mimeMessage);

    @Autowired
    JdbcTemplate jdbcTemplate;


//    @ResponseBody
//    @GetMapping("/select")
//    public Map<String,Object> map(){
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM users");
//        return list.get(0);
//    }
}
