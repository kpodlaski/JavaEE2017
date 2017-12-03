package dao;
import model.Jednostka;
import model.Osoba;

import java.util.List;

public interface DAO {
	
	public List<Jednostka> getAllJednostka();
	public Jednostka getJednostkaById(int id);
	public Osoba getOsobaById(int id);
	
}
