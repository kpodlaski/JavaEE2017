package model;

import java.util.Date;

public class Osoba {
	private int id;
	private String imie;
	private String nazwisko;
	private String fotka;
	private Date wiek;
	private Stanowisko stanowisko;
	private static int lastId=0;
	public Osoba(String imie, String nazwisko, String fotka, Date wiek, Stanowisko stanowisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.fotka = fotka;
		this.wiek = wiek;
		this.stanowisko = stanowisko;
		this.id=lastId++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getFotka() {
		return fotka;
	}
	public void setFotka(String fotka) {
		this.fotka = fotka;
	}
	public Date getWiek() {
		return wiek;
	}
	public void setWiek(Date wiek) {
		this.wiek = wiek;
	}
	public Stanowisko getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(Stanowisko stanowisko) {
		this.stanowisko = stanowisko;
	}
	
	
}
