package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Stanowisko;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:hr:hr@//10.16.80.11/orcl", 
				"sys AS SYSDBA", 
				"oracle");
		
		Statement stm = con.createStatement();
		String _par="Iwona";
		String query= "SELECT * FROM OSOBA, JEDNOSTKA, OS_JEDN_LNK "
				+ "where id_jedn=osoba.id AND id_jedn=jednostka.id "
				+ "AND imie LIKE '"+_par+"'";
		ResultSet result= stm.executeQuery(query);
		while(result.next()){
			String imie = result.getString("imie");
			int stanId = result.getInt("stanowisko");
			int i = result.getInt(1);
			System.out.println(i+" "+imie+" "+stanId);
		}
		result.close();
		stm.close();
		//PREPARED STATEMENT
		String pquery="SELECT * FROM OSOBA, JEDNOSTKA, OS_JEDN_LNK "
				+ "where id_jedn=osoba.id AND id_jedn=jednostka.id "
				+ "AND imie LIKE ?";
		PreparedStatement pstm = con.prepareStatement(pquery);
		
		pstm.setString(1, _par);
		result= pstm.executeQuery();
		while(result.next()){
			String imie = result.getString("imie");
			int stanId = result.getInt("stanowisko");
			int i = result.getInt(1);
			System.out.println(i+" "+imie+" "+stanId);
		}
		result.close();
		System.out.println("==================================");
		pquery="SELECT * FROM STANOWISKA "
				+ "where id = ?";
		pstm = con.prepareStatement(pquery);
		pstm.setInt(1, 1);
		result= pstm.executeQuery();
		while(result.next()){
			Stanowisko s =createStanowiskoFromResultSet(result);
			System.out.println(s.getId()+" "+s.getNazwa());
		}
		
		con.close();
	}

	private static Stanowisko createStanowiskoFromResultSet(ResultSet result) throws SQLException {
		String nazwa = result.getString("nazwa");
		int id = result.getInt("id");
		Stanowisko r = new Stanowisko(nazwa);
		r.setId(id);
		return r;
	}

}
