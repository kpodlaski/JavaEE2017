package model;

import java.util.List;
import java.util.ArrayList;

public class Jednostka {
	private int id;
	private String nazwa;
	private List<Osoba> pracownicy = new ArrayList<Osoba>();
	private static int lastId=0;
	public Jednostka(String nazwa) {
		super();
		this.nazwa = nazwa;
		this.id=lastId++;
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
