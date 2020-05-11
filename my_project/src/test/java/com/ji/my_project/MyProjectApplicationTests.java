package com.ji.my_project;

import com.jcraft.jsch.ChannelSftp;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.internet.MimeMessage;
import java.io.*;

@SpringBootTest
class MyProjectApplicationTests {



    @Test
    void test03() throws IOException {


        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("static/SpringLearning.md");
        System.out.println(resourceAsStream);

        BufferedReader br=new BufferedReader(new InputStreamReader(resourceAsStream));
        String s="";
        while((s=br.readLine())!=null)
            System.out.println(s);

//        File file = new File(this.getClass().getResource("/static/SpringLearning.md").getPath());
//        System.out.println(file);
    }

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void test02() throws Exception {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//
//        mimeMessageHelper.setSubject("通知今晚开会");
//        mimeMessageHelper.setText("<b style='color:red'>7:30</b>", true);
//        mimeMessageHelper.setTo("2568635780@qq.com");
//        mimeMessageHelper.setFrom("1418964647@qq.com");
//
//        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("static/SpringLearning.md");
//
//        InputStream stream = getClass().getClassLoader().getResourceAsStream("static/SpringLearning.md");
//        File targetFile = new File("SpringLearning.md");
//        FileUtils.copyInputStreamToFile(stream, targetFile);
//
//        mimeMessageHelper.addAttachment("SpringLearning.md", targetFile);

//        mimeMessageHelper.addAttachment("experience.md", new File(this.getClass().getResource("/static/experience.md").getPath()));

//        javaMailSender.send(mimeMessage);
    }

    @Test
    void contextLoads() {
    }

}
