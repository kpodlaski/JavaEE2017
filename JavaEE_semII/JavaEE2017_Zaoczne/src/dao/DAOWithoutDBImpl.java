package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Jednostka;
import model.Osoba;
import model.Stanowisko;

public class DAOWithoutDBImpl implements DAO{

	private Map<Integer,Jednostka> jednostki;
	private Map<Integer,Osoba> osoby;
	
	@Override
	public List<Jednostka> getAllJednostka() {
		return new ArrayList<Jednostka>(jednostki.values());
	}
	@Override
	public Jednostka getJednostkaById(int id) {
		return jednostki.get(id);
	}
	@Override
	public Osoba getOsobaById(int id) {
		// TODO Auto-generated method stub
		return osoby.get(id);
	}
	
	public DAOWithoutDBImpl(){
		jednostki = new HashMap<>();
		osoby = new HashMap<>();
		Stanowisko kierownik = new Stanowisko(1,"Kierownik");
		Stanowisko asystent = new Stanowisko(2,"Asystent");
		Jednostka j = new Jednostka(1,"Ksiêgowoœæ");
		jednostki.put(j.getId(), j);
		Osoba o = new Osoba(1,"Gra¿yna","Bonowska","1.jpg",new Date(),kierownik);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
		o = new Osoba(2,"Tomasz","Œmig³y","2.jpg",new Date(),asystent);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
		
		j = new Jednostka(2,"Labolatorium");
		jednostki.put(j.getId(), j);
		o = new Osoba(3,"Adam","Górka","3.jpg",new Date(),kierownik);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
		o = new Osoba(4,"Iwona","Blada","4.jpg",new Date(),asystent);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
		
		j = new Jednostka(3,"Spedycja");
		jednostki.put(j.getId(), j);
		o = new Osoba(5,"Tamara","Mokra","5.jpg",new Date(),kierownik);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
		o = new Osoba(6,"Joanna","Œwita","6.jpg",new Date(),asystent);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
		o = new Osoba(7,"Marian","Opasy","7.jpg",new Date(),asystent);
		osoby.put(o.getId(), o);
		j.getPracownicy().add(o);
	}

}
