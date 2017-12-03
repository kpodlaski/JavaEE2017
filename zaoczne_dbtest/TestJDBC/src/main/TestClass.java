package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Osoba;
import model.Stanowisko;

public class TestClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		
		Connection con = DriverManager.getConnection(
		"jdbc:oracle:thin:hr:hr@//10.16.80.11/orcl","sys AS SYSDBA","oracle");
		
		Statement stm = con.createStatement();
		String query = "SELECT nazwa,id FROM JEDNOSTKA";
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()){
			int id = rs.getInt(2);
			String nazwa = rs.getString("NAZWA");
			System.out.println(id+ " "+ nazwa);
			Statement stm2 = con.createStatement();
			query="SELECT imie, nazwisko, jednostka.id as jid, osoba.id as oid FROM OSOBA, JEDNOSTKA, OS_JEDN_LNK "
					+ "WHERE osoba.id=id_osoba AND jednostka.id=id_jedn "
					+ "AND id_jedn="+id;
			ResultSet rs2 = stm2.executeQuery(query);
			while(rs2.next()){
				int oid = rs2.getInt("oid");
				String imie = rs2.getString("IMIE");
				String nazwisko = rs2.getString("NAZWISKO");
				System.out.println("\t "+ +oid+" "+imie+" "+nazwisko);
			}
			rs2.close();
			stm2.close();
		}
		System.out.println("=====================");
		query = "SELECT * FROM STANOWISKA";
		rs = stm.executeQuery(query);
		List<Stanowisko> stanowiska = new ArrayList<>(); 
		while(rs.next()){
			stanowiska.add(getStanowiskoFromResultSet(rs));
		}
		for(Stanowisko s : stanowiska){
			System.out.println(s.getId()+" "+s.getNazwa()+" "+s);
		}
		System.out.println("=====================");
		query = "SELECT * FROM OSOBA";
		rs = stm.executeQuery(query);
		List<Osoba> osoby = new ArrayList<>(); 
		while(rs.next()){
			osoby.add(getOsobaFromResultSet(rs));
		}
		for(Osoba o : osoby){
			System.out.println(
				o.getId()+" "
			   +o.getImie()+" "
			   +o.getNazwisko()+" "
			   +o.getWiek()+" "
			   +o.getFotka()+" "
			   +o.getStanowisko().getNazwa());
		}
		
		rs.close();
		stm.close();
		con.close();
	}
	
	static Stanowisko getStanowiskoFromResultSet(ResultSet rs) throws SQLException{
		String nazwa = rs.getString("NAZWA");
		int id = rs.getInt("ID");
		return new Stanowisko(id,nazwa);
	}
	
	static Osoba getOsobaFromResultSet(ResultSet rs) throws SQLException{
		int stanId= rs.getInt("STANOWISKO");
		Statement stm = rs.getStatement().getConnection().createStatement();
		ResultSet rs2 = stm.executeQuery("SELECT * FROM STANOWISKA WHERE ID="+stanId);
		rs2.next();
		Stanowisko stanowisko = getStanowiskoFromResultSet(rs2);
		rs2.close();
		stm.close();
		Osoba o = new Osoba(
				rs.getInt("ID"),
				rs.getString("IMIE"),
				rs.getString("NAZWISKO"),
				rs.getString("FOTKA"),
				rs.getDate("WIEK"),
				stanowisko
				);
		return o;
	}

}
