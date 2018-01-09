package com.di.phonebook.service;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.di.phonebook.domain.Contact;
import com.di.phonebook.repository.ContactRepository;

public class PhoneServiceBean implements PhoneService {

	@Autowired
	private ContactRepository contactRepo;
	
	public PhoneServiceBean(ContactRepository contectRepo)
	{
		this.contactRepo = contectRepo;
	}
	
	public Map<String, Contact> getAllContacts() {
		return contactRepo.getAllContacts();
	}

	public Contact findContact(String id) {
		return contactRepo.findContact(id);
	} 

	public void deleteContact(String id) {
		contactRepo.deleteContact(id);
		
	}

	public Contact addContact(String id, String name, String phone) {
		return contactRepo.addContact(id, name, phone);
	}

	public Contact updateContact(Contact c) {
		return contactRepo.updateContact(c);
	}
	
	public void postConstruct(){
		System.out.println("in PhoneServiceBean postConstruct method");
	}
	
	public void preDestroy(){
		System.out.println("in PhoneServiceBean preDestroy method");
	}

	
}
