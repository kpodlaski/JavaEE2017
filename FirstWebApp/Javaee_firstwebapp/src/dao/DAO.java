package dao;

import model.Jednostka;
import model.Osoba;
import java.util.List;

public interface DAO {
	
	List<Osoba> getAllOsoba();
	Osoba getOsobaById(int id);
	Osoba getOsobaByNazwisko(String nazwisko);
	Osoba getOsobaByImie(String imie);	
	
	List<Jednostka> getAllJednostki();
	Jednostka getJednostkaById(int id);
	Jednostka getJednostkaByNazwa(String nazwa);

}
