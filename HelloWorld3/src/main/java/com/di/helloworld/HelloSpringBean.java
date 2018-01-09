package com.di.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloSpringBean implements HelloSpring {

	@Value("${greeting}")
	private String greeting;
	
	@Value("Dipesh")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getGreeting(){
		return this.greeting;
	}

}
