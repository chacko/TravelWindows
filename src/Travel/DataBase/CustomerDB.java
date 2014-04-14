package Travel.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Travel.Entity.Agents;
import Travel.Entity.Customers;

public class CustomerDB {
	public CustomerDB(){
		
	}
	
	// retrieving all customer which is assigned to the agent which is about to be deleted
	public static Vector<Customers> getCustomers(Integer agentId){
		try {
			Vector<Customers> customer = new Vector<Customers>();
			
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt = conn.createStatement();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT customerId, custFirstName, custLastName ");
			sql.append(" FROM customers, agents ");
			sql.append(" WHERE agents.agentId = ");
			sql.append(String.valueOf(agentId));
			sql.append(" AND customers.agentId = ");
			sql.append(String.valueOf(agentId));
			
			ResultSet rs = stmt.executeQuery(sql.toString());
			
			while(rs.next()){
				Customers cust = new Customers();
				cust.setCustomerID(Integer.valueOf(rs.getString("customerId")));
				cust.setCustomerFirstName(rs.getString("custFirstName"));
				cust.setCustomerLastName(rs.getString("custLastName"));
				
				customer.add(cust);
				cust = null;
			}
			
			DBase.closeDBase(conn, rs, stmt);
			return customer;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	// if agent is present to a customer
	public static Integer findAgent(Integer agentId){
		int num = 0;
		try {
			Connection conn = DBase.getOracleConnection();
			Statement stmt = conn.createStatement();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT customerId ");
			sql.append("FROM customers ");
			sql.append("WHERE agentId = ");
			sql.append(agentId);
			
			num = stmt.executeUpdate(sql.toString());
			
			DBase.closeDBase(conn, null, stmt);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public static Integer updateCustomer(Integer cust, Integer agentId) {
		int rs = 0;
		try {
			Connection conn = DBase.getOracleConnection();
			Statement stmt = conn.createStatement();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE customers ");
			sql.append("SET agentId = ");
			sql.append(agentId);
			sql.append(" WHERE customerId = ");
			sql.append(cust);
			
			rs = stmt.executeUpdate(sql.toString());
			
			DBase.closeDBase(conn, null, stmt);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
