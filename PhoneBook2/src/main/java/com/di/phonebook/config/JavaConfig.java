package com.di.phonebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.di.phonebook.repository.ContactRepository;
import com.di.phonebook.repository.ContactTable;
import com.di.phonebook.service.PhoneService;
import com.di.phonebook.service.PhoneServiceBean;

@Configuration
public class JavaConfig {

	@Bean(initMethod="postConstruct", destroyMethod="preDestroy")
	public PhoneService phone(){
		return new PhoneServiceBean(contact());
	}
	
	@Bean
	public ContactRepository contact(){
		return new ContactTable();
	}
}
