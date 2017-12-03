package model;

import java.util.ArrayList;
import java.util.List;

public class Jednostka {
	private int id;
	private String nazwa;
	private List<Osoba> pracownicy;
	
	public Jednostka(int id, String nazwa) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		pracownicy = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public List<Osoba> getPracownicy() {
		return pracownicy;
	}
	public void setPracownicy(List<Osoba> pracownicy) {
		this.pracownicy = pracownicy;
	}
	
}
