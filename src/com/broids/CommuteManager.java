package com.broids;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.json.JSONJAXBContext.JSONNotation;

public class CommuteManager {
	Connection con=null;
	public CommuteManager() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		this.con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@broids.cfirgz1jw56c.us-east-1.rds.amazonaws.com:1521:ORCL","broids","applehunter");  
		
	}


	
	public void insertCommute(JSONObject commute) throws SQLException, JSONException{
		
		System.out.println("Commute "+commute.toString());
		 Statement stmt = con.createStatement();
	      
	      String sql = "INSERT INTO Commutes " +
	                   "VALUES ("
	                   + commute.get("commuteId") +"  , " 
	                   + "'"+commute.get("commuteStart")+"' , " 
	                   + "'"+commute.get("commuteDest")+"' , " 
	                   + "'"+commute.get("city")+"'"
	                  + ")";
	      System.out.println("SQL "+sql);
	      stmt.executeUpdate(sql);
		
	}
	
	public JSONArray getAllCommutes() throws SQLException, JSONException{
		JSONArray array = new JSONArray();
		
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from commutes");  
		while(rs.next())  
		{JSONObject commute =new JSONObject();
			int commuteId=rs.getInt("commuteId");
			String commuteStart=rs.getString("commuteStart");
			String commuteDest=rs.getString("commuteDest");
			String city=rs.getString("city");
			commute.put("commuteId", commuteId);
			commute.put("commuteStart", commuteStart);
			commute.put("commuteDest", commuteDest);
			commute.put("city", city);
			
			array.put(commute);
		}
		  
		//step5 close the connection object  
	
		return array;
		
		
	}
	
	public static void main(String[] args) throws SQLException  {
		CommuteManager commuteManager = null;
		try {
			commuteManager = new CommuteManager();
	
		JSONObject commute=new JSONObject();
		commute.put("commuteId", 123);
		commute.put("commuteStart", "BTM");
		commute.put("commuteDest", "Marathalli");
		commute.put("city", "Bangalore");
		commuteManager.insertCommute(commute);
		
		System.out.println(commuteManager.getAllCommutes().toString());
		} catch (ClassNotFoundException | SQLException e) {
			commuteManager.con.close();
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}