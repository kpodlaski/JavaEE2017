package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.jpa.Jednostka;
import model.jpa.Osoba;
import model.jpa.Stanowisko;

public class JPATest {
	
	public static void main(String[] a){
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModel");
	  EntityManager em = emf.createEntityManager();
	  Stanowisko s = em.find(Stanowisko.class, 2L);
	  System.out.println(s.getId()+" "+s.getNazwa());
	  Query nq = em.createNamedQuery("Stanowisko.findAll");
	  List<Stanowisko> stanowiska = nq.getResultList();
	  System.out.println("=======================");
	  for(Stanowisko st : stanowiska){
		  System.out.println(st.getId()+" "+st.getNazwa());
	  }
	  System.out.println("=======================");
	  //@NamedQuery(name="Stanowisko.findByNazwa", 
      // query="SELECT s FROM Stanowisko s WHERE s.nazwa=:nazwa" )
	  nq = em.createNamedQuery("Stanowisko.findByNazwa");
	  nq.setParameter("nazwa", "Asystent");
	  //s = (Stanowisko) nq.getSingleResult();
	  //System.out.println(s.getId()+" "+s.getNazwa());
	  //UPDATE OPERATION
	  /*
	   *em.getTransaction().begin();
	  	s.setNazwa("Asystent G³ówny");
	  	em.getTransaction().commit();
	  */
	  System.out.println("=======================");
	  System.out.println("=======================");
	  Osoba o = (Osoba) em.find(Osoba.class, 5L);
	  System.out.println(o.getNazwisko()+" "+o.getStanowisko().getNazwa());
	  System.out.println("=======================");
	  System.out.println("=======================");
	  Jednostka j = em.find(Jednostka.class, 2L);
	  System.out.println("=======================");
	  System.out.println(j.getNazwa());
	  for(Osoba os : j.getPracownicy()){
		  System.out.println(os.getNazwisko()+" "+os.getStanowisko().getNazwa());
	  }
	  s = new Stanowisko();
	  s.setNazwa("Starszy specjalista");
	  em.getTransaction().begin();
	  em.persist(s);
	  em.getTransaction().commit();
	  System.out.println(s.getId()+" "+s.getNazwa());
	  em.close();
	  emf.close();
	}

}
