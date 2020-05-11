# Spring learning

### mail 的使用

###### 1）导入maven依赖

```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
		</dependency>
		<dependency>
			<groupId>com.sun.mail</groupId>
			<artifactId>jakarta.mail</artifactId>
		</dependency>
```

###### 2) 配置application.properties

```pr
spring.mail.username=1418964647@qq.com
spring.mail.password=vezmwunpbwvtbadj
spring.mail.host=smtp.qq.com
```

###### 3) 在test下测试

```java
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void test02() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);


        mimeMessageHelper.setSubject("通知今晚开会");
        mimeMessageHelper.setText("<b style='color:red'>7:30</b>", true);
        mimeMessageHelper.setTo("2568635780@qq.com");
        mimeMessageHelper.setFrom("1418964647@qq.com");

        mimeMessageHelper.addAttachment("1.jpg", new File("E:\\英雄时刻\\1.jpg"));

        javaMailSender.send(mimeMessage);
    }
```

