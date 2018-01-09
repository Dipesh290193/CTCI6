package com.di.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages={"com.di.helloworld"})
@PropertySource(value={"classpath:messages.properties"})
public class JavaConfig {
	
}
