package com.medics.viewResolver;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages ={"com.medics.*"})
public class MedicsConfig  {
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		System.out.println("---view resolver is started-----");
		
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver.setViewClass(JstlView.class);
		viewresolver.setPrefix("/WEB-INF/views/");
		viewresolver.setSuffix(".jsp");
		
		return viewresolver;
	}
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSorce=new DriverManagerDataSource();
		dataSorce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSorce.setUrl("jdbc:mysql://localhost:3306/myhotel");
		dataSorce.setUsername("root");
		dataSorce.setPassword("root");
		return dataSorce;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds)
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		sessionFactory.setPackagesToScan("com.medics.*");
		Properties props=new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		sessionFactory.setHibernateProperties(props);
        return sessionFactory;		
	}
	
	
	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sf)
	{
		HibernateTemplate htemp=new HibernateTemplate(sf);
		return htemp;
	}
	
	@Bean
	public HibernateTransactionManager trancationManager(SessionFactory sf)
	{
		
		HibernateTransactionManager trancatonManager=new HibernateTransactionManager(sf);
		
		return trancatonManager;
	}
	
	 @Bean
	   public MultipartResolver multipartResolver() {
	      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	      multipartResolver.setMaxUploadSize(10485760); // 10MB
	      multipartResolver.setMaxUploadSizePerFile(1048576); // 1MB
	      return multipartResolver;
	
	 }
	 
	 @Bean
	 public JavaMailSender javaMailSenderImpl()
	 {
	        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();	
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
            //set gmail id
	        mailSender.setUsername("mknishad21@gmail.com");
	        //set gmail password
	        mailSender.setPassword("@m9709649124");
	         Properties prop=mailSender.getJavaMailProperties();
	         prop.put("mail.smtp.host","smtp.gmail.com");
	         //prop.put("mail.smtp.port", "465");
	         prop.put("mail.smtp.socketFactory.port","465");
	         prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	         prop.put("mail.smtp.auth","true");
	         prop.put("mail.smtp.startssl.enable","true");
	         //prop.put("mail.smtp.EnableSSL.enable","true");

	        return mailSender;
	        		
	 }
	 
	 
}
