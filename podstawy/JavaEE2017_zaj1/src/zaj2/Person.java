package zaj2;

import java.util.Comparator;

public class Person implements Comparable{
	private String name;
	private String surname;
	private long pesel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getPesel() {
		return pesel;
	}
	public void setPesel(long pesel) {
		this.pesel = pesel;
	}
	public Person(String name, String surname, long pesel) {
		super();
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name +" "+surname;
	}
	@Override
	public int compareTo(Object arg0) {
		if( arg0 instanceof Person){
			Person p = (Person) arg0;
			return surname.compareTo(p.surname);//(int) Math.signum(pesel-p.pesel);
		}
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (pesel ^ (pesel >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (pesel != other.pesel)
			return false;
		return true;
	}
}

class PersonCompareByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return -o1.getName().compareTo(o2.getName());
	}
	
	
}
