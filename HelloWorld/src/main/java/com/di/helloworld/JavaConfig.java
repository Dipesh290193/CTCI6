package com.di.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public HelloSpring hello(){
		HelloSpring bean = new HelloSpringBean();
		bean.setName("Dipesh");
		return bean;
	}
}
