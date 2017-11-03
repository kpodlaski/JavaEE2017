package zaj2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>() ;
		persons.add(new Person("Adam", "Mickiewicz",75122307654L));
		persons.add(new Person("Eliza", "Orzeszkowa",05301517654L));
		persons.add(new Person("Cyprian Kamil", "Norwid",65022507655L));
		persons.add(new Person("Cyprian Kamil", "Norwid",65022507655L));
		for (int i=0; i<persons.size(); i++)
			System.out.println(persons.get(i));
		System.out.println(persons);
		Collections.sort(persons);
		for (int i=0; i<persons.size(); i++)
			System.out.println(persons.get(i));
		System.out.println("===============================");
		Collections.sort(persons,new PersonCompareByName());
		for (Person p : persons)
			System.out.println(p);
		Set<Person> personSet = new HashSet<>();
		personSet.addAll(persons);
		System.out.println(personSet);
		personSet.add(persons.get(1));
		System.out.println(personSet);
		Iterator<Person> it = personSet.iterator();
		while(it.hasNext()){
			Person p = it.next();
			System.out.println(p);
		}
		Map<Person,String> books = new HashMap<>();
		books.put(persons.get(3), "Pan Tadeusz");
		books.put(persons.get(0), "Nad Niemnem");
		books.put(persons.get(2), "Fortepian Szopena");
		System.out.println(books);
		System.out.println(books.get(persons.get(0)));
		for (Person p : books.keySet()){
			System.out.println(p + "=>"+books.get(p));
		}

	}

}
