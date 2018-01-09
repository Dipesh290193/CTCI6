package com.di.phonebook.service;

import java.util.Map;

import com.di.phonebook.domain.Contact;

public interface PhoneService {
	Map<String, Contact> getAllContacts();

	Contact findContact(String id);

	void deleteContact(String id);

	Contact addContact(String id, String name, String phone);

	Contact updateContact(Contact c);
}
