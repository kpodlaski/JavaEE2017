package model;

public class Stanowisko {

	private int id;
	private String nazwa;
	
	
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
	public Stanowisko(int id, String nazwa) {
		super();
		this.id = id;
		this.nazwa = nazwa;
	}
	
	
}
