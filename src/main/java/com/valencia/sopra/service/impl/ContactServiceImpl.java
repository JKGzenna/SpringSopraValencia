package com.valencia.sopra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.valencia.sopra.component.ContactConverter;
import com.valencia.sopra.entity.Contact;
import com.valencia.sopra.model.ContactModel;
import com.valencia.sopra.repository.ContactRepository;
import com.valencia.sopra.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		
		
		
		return contactConverter.convertContact2ContactModel(contact);
	}

}
