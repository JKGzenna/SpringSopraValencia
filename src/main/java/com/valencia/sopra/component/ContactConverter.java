package com.valencia.sopra.component;

import org.springframework.stereotype.Component;

import com.valencia.sopra.entity.Contact;
import com.valencia.sopra.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public Contact convertContactModel2Contact(ContactModel contactModel) {
		Contact contact= new Contact();
				contact.setCity(contactModel.getCity());
				contact.setFirstname(contactModel.getFirstname());
				contact.setId(contactModel.getId());
				contact.setLastname(contactModel.getLastname());
				contact.setTelephone(contactModel.getTelephone());
		return contact;
	}
	public ContactModel convertContact2ContactModel (Contact contact) {
			ContactModel contactModel = new ContactModel();
			contactModel.setCity(contact.getCity());
			contactModel.setFirstname(contact.getFirstname());
			contactModel.setId(contact.getId());
			contactModel.setLastname(contact.getLastname());
			contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}
}
