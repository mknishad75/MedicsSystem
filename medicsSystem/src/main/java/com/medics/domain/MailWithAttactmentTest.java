package com.medics.domain;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.medics.viewResolver.MedicsConfig;

public class MailWithAttactmentTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.register(MedicsConfig.class);
		ctx.refresh();
		
		JavaMailSenderImpl mailSender=ctx.getBean(JavaMailSenderImpl.class);
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		try
		{
			MimeMessageHelper mailMsg=new MimeMessageHelper(mimeMessage,true);
			mailMsg.setFrom("mknishad21@gmail.com");
			mailMsg.setTo("mknishad75@gmail.com");
			mailMsg.setSubject("this is my test Mail");
			mailMsg.setText("this is test mailfrom spring progrma you can check it this was good or not",true);
           // FileSystemResource file=new FileSystemResource(new File("E:/demo.xlsx"));
            //mailMsg.addAttachment("demo.xlsx",file);
            mailSender.send(mimeMessage);
            
		}catch(Exception ex)
		{
		   ex.printStackTrace();	
		}
		System.out.println("---done---");
		

	}

}
