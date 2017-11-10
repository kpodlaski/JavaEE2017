package dao.mockdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import dao.DAO;
import model.Jednostka;
import model.Osoba;
import model.Stanowisko;

import java.util.Map;

public class MockDAO implements DAO {

	private Map<Integer,Osoba> osoby;
	private Map<Integer,Jednostka> jednostki;
	
	public MockDAO(){
		osoby= new HashMap<>();
		jednostki = new HashMap<>();
		Stanowisko kierownik = new Stanowisko("Kierownik");
		Stanowisko asystent = new Stanowisko("Asystent");
		Jednostka j = new Jednostka("Ksiêgowoœæ");
		jednostki.put(j.getId(), j);
		Osoba o = new Osoba("Hanna","Hannecka","1.jpg",new Date(),kierownik);
		j.getPracownicy().add(o);
		osoby.put(o.getId(), o);
		
		o = new Osoba("Adam","Adamski","2.jpg",new Date(),asystent);
		j.getPracownicy().add(o);
		osoby.put(o.getId(), o);
		
		o = new Osoba("Tomasz","Tomaszewski","3.jpg",new Date(),asystent);
		j.getPracownicy().add(o);
		osoby.put(o.getId(), o);
		
		j = new Jednostka("Kadry");
		jednostki.put(j.getId(), j);
		o = new Osoba("Robert","Roberciak","4.jpg",new Date(),kierownik);
		j.getPracownicy().add(o);
		osoby.put(o.getId(), o);
		
		o = new Osoba("Anna","Annecka","5.jpg",new Date(),asystent);
		j.getPracownicy().add(o);
		osoby.put(o.getId(), o);
		
		
	}
	
	@Override
	public List<Osoba> getAllOsoba() {
		// TODO Auto-generated method stub
		return  new ArrayList<Osoba>(osoby.values());
	}

	@Override
	public Osoba getOsobaById(int id) {
		// TODO Auto-generated method stub
		return osoby.get(id);
	}

	@Override
	public Osoba getOsobaByNazwisko(String nazwisko) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Osoba getOsobaByImie(String imie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jednostka> getAllJednostki() {
		// TODO Auto-generated method stub
		return new ArrayList<Jednostka>(jednostki.values());
	}

	@Override
	public Jednostka getJednostkaById(int id) {
		// TODO Auto-generated method stub
		return jednostki.get(id);
	}

	@Override
	public Jednostka getJednostkaByNazwa(String nazwa) {
		// TODO Auto-generated method stub
		return null;
	}

}
