package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {

	public static void main(String[] a) throws JAXBException {
		TelephoneBook book = new TelephoneBook();
		Person p = new Person(1,"Ada","Mokra","698986698","Tajny adres");
		book.getPersons().add(p);
		book.getPersons().add(
				new Person(1,"Adam","Mokry","898986698","Bardzo tajny adres"));
		JAXBContext context = JAXBContext.newInstance(TelephoneBook.class);
		Marshaller marshaller=  context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(book, System.out);
		marshaller.marshal(book, new File("tbook.xml"));
		
		Unmarshaller uMarshaller = context.createUnmarshaller();
		TelephoneBook book2;
		book2 = (TelephoneBook) uMarshaller.unmarshal(new File("tbook.xml"));
		System.out.println(book2.getPersons().get(1).getTelephone());
	}
}
