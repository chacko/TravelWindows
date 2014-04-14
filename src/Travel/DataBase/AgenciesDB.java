/**
 * 
 */
package Travel.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Travel.Entity.Agencies;

/**
 * @author user1
 *
 */
public class AgenciesDB 
{
	//empty constructor
	public AgenciesDB()
	{
		
	}
	// -----------------------------------------
	// get all agents from agent table
	public static Vector<Agencies> getAllAgencies() 
	{
		try 
		{
			Vector<Agencies> agncs = new Vector<Agencies>();
			
			// get oracle connection
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			ResultSet rs;
			
			StringBuilder qry = new StringBuilder();
			qry.append("select agencyid,agncycity from agencies order by agncycity");
			 
			rs = stmt.executeQuery(qry.toString());
			
			while (rs.next())
			{
				Agencies agcy = new Agencies();
				agcy.setAgencyId(Integer.valueOf(rs.getString("agencyid")));
				agcy.setAgncyCity(rs.getString("agncycity"));
				
				agncs.add(agcy);
				agcy=null;
			}
			// close all data base objects 
			DBase.closeDBase(conn, rs, stmt);
						
			return agncs;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	// -----------------------------------------
	// get all agents from agent table
		public static Agencies getAgency(Integer agencyId) 
		{
			try 
			{
				
				Agencies agncy = new Agencies();
				// get oracle connection
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				
				ResultSet rs;
				
				StringBuilder qry = new StringBuilder();
				qry.append("select agencyid,agncycity from agencies where agencyid =" + agencyId.toString());
				 
				rs = stmt.executeQuery(qry.toString());
				
				while (rs.next())
				{
					agncy.setAgencyId(Integer.valueOf(rs.getString("agencyid")));
					agncy.setAgncyCity(rs.getString("agncycity"));
				}
				// close all data base objects 
				DBase.closeDBase(conn, rs, stmt);
							
				return agncy;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			return null;
			
		}
	//------------------------------------------
}
