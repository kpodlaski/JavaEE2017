package model;

public class Contact {

	private String name;
	private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Contact(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	
	public Contact(){
		this.name="";
		this.tel="";
	}
}
