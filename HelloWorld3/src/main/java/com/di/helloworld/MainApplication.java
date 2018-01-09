package com.di.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String args[]) {

		@SuppressWarnings("resource")
		//ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		HelloSpring hello = (HelloSpring) context.getBean(HelloSpring.class);
		System.out.println(hello.getGreeting());
		System.out.println(hello.getName());
	}
}
