package model;

public class Stanowisko {
	private int id;
	private String nazwa;
	private static int lastId =0;
	
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
	public Stanowisko(String nazwa) {
		super();
		this.id = lastId++;
		this.nazwa = nazwa;
	}
	
	private Stanowisko(int id, String nazwa) {
		super();
		this.id = id;
		this.nazwa = nazwa;
	}

	
}
