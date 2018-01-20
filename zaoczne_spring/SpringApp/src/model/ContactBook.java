package model;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
	private List<Contact> contacts = new ArrayList<>();

	public ContactBook(){
		contacts.add(new Contact("Anna", "7654321"));
		contacts.add(new Contact("Stefan", "1276543"));
	}
	
	public boolean add(Contact arg0) {
		return contacts.add(arg0);
	}

	public boolean remove(Object arg0) {
		return contacts.remove(arg0);
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
