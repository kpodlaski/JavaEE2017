package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.jpa.*;
import java.util.List;

public class ConnectDB {

	public static void main(String[] s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBProject");
		EntityManager em = emf.createEntityManager();
		//Znajdü osobe o kluczu 2
		Osoba o = (Osoba) em.find(Osoba.class, 2L);
		System.out.println(o.getImie()+ " "+ o.getNazwisko());
		System.out.println(o.getStanowisko().getNazwa());
		Jednostka j = (Jednostka) em.find(Jednostka.class, 2L);
		System.out.println(j.getId()+ " "+ j.getNazwa());
		for(Osoba os : j.getPracownicy()){
			System.out.println(os.getImie()+ " "+ os.getNazwisko());
			System.out.println(os.getStanowisko().getNazwa());
		}
		Query q = em.createNamedQuery("Osoba.findAll");
		for(Osoba os : (List<Osoba>) q.getResultList()){
			System.out.println(os.getImie()+ " "+ os.getNazwisko());
		}
	}
}