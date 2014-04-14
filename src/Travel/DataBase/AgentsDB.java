package Travel.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Travel.Entity.Agents;


/**
 * @author 		George Chacko & Sharmaine
 * Date			13 March 2014
 * Course		CMPP 264 Java workshop
 * DB class		Class to handle data base operations (select,insert,update and delete) 
 * 				on Agents table 
 *
 */
public class AgentsDB 
{

	// empty constructor
	public AgentsDB()
	{
		
	}
		
	
	/* Data base methods */
	// SELECT - Get get specific agent information
	public static Agents getAgent(Integer agentId)
	{
		try 
		{
			Agents agt = new Agents();
			
			// get connection
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			ResultSet rs;
			StringBuilder qry = new StringBuilder();
			qry.append("select agentid,agtfirstname,agtmiddleinitial,agtlastname ");
			qry.append(",agtbusphone,agtemail,agtposition,agencyid ");
			qry.append(" from agents where agentid=");
			qry.append(agentId);
			
			rs = stmt.executeQuery(qry.toString());
		
			while (rs.next())
			{
				agt.setAgentId(Integer.valueOf(rs.getString("agentid")));
				agt.setAgentFName(rs.getString("agtfirstname"));
				agt.setAgentMName(rs.getString("agtmiddleinitial"));
				agt.setAgentLName(rs.getString("agtlastname"));
				agt.setAgentBusPhone(rs.getString("agtbusphone"));
				agt.setAgentEmail(rs.getString("agtemail"));
				agt.setAgentPosn(rs.getString("agtposition"));
				agt.setAgentAgencyId(Integer.valueOf(rs.getString("agencyid")));
			}

			// close all data base objects to release memory
			DBase.closeDBase(conn, rs, stmt);
			
			return agt;
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
	public static Vector<Agents> getAllAgents() 
	{
		try 
		{
			Vector<Agents> agts = new Vector<Agents>();
			
			// get oracle connection
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			ResultSet rs;
			
			StringBuilder qry = new StringBuilder();
			qry.append("select agentid,agtfirstname,agtmiddleinitial,agtlastname ");
			qry.append(" from agents where LOWER(agtposition)  not like  'inactive'");
			qry.append(" and agtfirstname not like 'null' ");
			
			rs = stmt.executeQuery(qry.toString());
			
			while (rs.next())
			{
				Agents agt = new Agents();
				agt.setAgentId(Integer.valueOf(rs.getString("agentid")));
				agt.setAgentFName(rs.getString("agtfirstname"));
				agt.setAgentMName(rs.getString("agtmiddleinitial"));
				agt.setAgentLName(rs.getString("agtlastname"));
				
				agts.add(agt);
				agt=null;
			}
			// close all data base objects 
			DBase.closeDBase(conn, rs, stmt);
						
			return agts;
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
	// overloaded method call for search condition
	// get all agents from agent table for first name
	// search condition
	public static Vector<Agents> getAllAgents(String searchCdn) 
	{
		try 
		{
			Vector<Agents> agts = new Vector<Agents>();
			
			// get oracle connection
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			ResultSet rs;
			
			StringBuilder qry = new StringBuilder();
			qry.append("select agentid,agtfirstname,agtmiddleinitial,agtlastname ");
			qry.append(" from agents where LOWER(agtposition)  not like  'inactive'");
			qry.append(" and agtfirstname like '");
			qry.append(searchCdn);
			qry.append("'");
			 
			rs = stmt.executeQuery(qry.toString());
			
			while (rs.next())
			{
				Agents agt = new Agents();
				agt.setAgentId(Integer.valueOf(rs.getString("agentid")));
				agt.setAgentFName(rs.getString("agtfirstname"));
				agt.setAgentMName(rs.getString("agtmiddleinitial"));
				agt.setAgentLName(rs.getString("agtlastname"));
				
				agts.add(agt);
				agt=null;
			}
			// close all data base objects 
			DBase.closeDBase(conn, rs, stmt);
						
			return agts;
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
	// update agent information entered in text fields
	
	/**
	 * @param agt
	 * @return number of rows updated - 0 means update failed
	 */
	public static Integer updateAgent(Agents agt)
	{
		Integer numRows =0; 
		try
		{
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			StringBuilder qry = new StringBuilder();
			qry.append("update agents set agtfirstname ='");
			qry.append(agt.getAgentFName());
			qry.append("',");
			qry.append(" agtmiddleinitial ='");
			qry.append(agt.getAgentMName());
			qry.append("',");
			qry.append(" agtlastname ='");
			qry.append(agt.getAgentLName());
			qry.append("',");
			qry.append(" agtbusphone ='");
			qry.append(agt.getAgentBusPhone());
			qry.append("',");
			qry.append(" agtemail ='");
			qry.append(agt.getAgentEmail());
			qry.append("',");
			qry.append(" agtposition ='");
			qry.append(agt.getAgentPosn());
			qry.append("', agencyid =");
			qry.append(agt.getAgentAgencyId());
			qry.append(" where agentid =");
			qry.append(agt.getAgentId());
			
			numRows = stmt.executeUpdate(qry.toString());
			
			DBase.closeDBase(conn, null, stmt);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return numRows;
	}
	// -----------------------------------------
	// Insert agent info to agents table
	public static Integer insertAgent(Agents agt)
	{
		Integer numRows =0; 
		try
		{
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			StringBuilder qry = new StringBuilder();
			qry.append("insert into agents (agentid,agtfirstname,agtmiddleinitial,agtlastname");
			qry.append(",agtbusphone,agtemail,agtposition,agencyid) values (");
			qry.append(DBase.getNextvalAgentsSeq());
			qry.append(",'");
			qry.append(agt.getAgentFName());
			qry.append("','");
			qry.append(agt.getAgentMName());
			qry.append("','");
			qry.append(agt.getAgentLName());
			qry.append("','");
			qry.append(agt.getAgentBusPhone());
			qry.append("','");
			qry.append(agt.getAgentEmail());
			qry.append("','");
			qry.append(agt.getAgentPosn());
			qry.append("',");
			qry.append(agt.getAgentAgencyId());
			qry.append(") ");
			
			numRows = stmt.executeUpdate(qry.toString());
			DBase.closeDBase(conn, null, stmt);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return numRows;
	}
	// -----------------------------------------
	// Delete agent info - not actual deletion from table but updating 
	// "agtposition" column as inactive so that it will not displayed 
	// while searching for agent info
	public static Integer deleteAgent(Integer agentId)
	{
		Integer numRows =0; 
		try
		{
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			StringBuilder qry = new StringBuilder();
			qry.append("update agents set agtposition='inactive' ");
			qry.append(" where agentid=");
			qry.append(agentId);
			
			numRows = stmt.executeUpdate(qry.toString());
			
			DBase.closeDBase(conn, null, stmt);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return numRows;
	}
	// -----------------------------------------
	public static Vector<Agents> getAllAgentsX(String agentID) 
	{
		try 
		{
			Vector<Agents> agts = new Vector<Agents>();
			
			// get oracle connection
			Connection conn = DBase.getOracleConnection();
			
			Statement stmt;
			stmt = conn.createStatement();
			
			ResultSet rs;
			
			StringBuilder qry = new StringBuilder();
			qry.append("select agentid, agtfirstname, agtmiddleinitial, agtlastname ");
			qry.append(" from agents");
			qry.append(" where agtposition != 'inactive'");
			qry.append(" and agentid != ");
			qry.append(agentID);
			
			rs = stmt.executeQuery(qry.toString());
			
			while (rs.next())
			{
				Agents agt = new Agents();
				agt.setAgentId(Integer.valueOf(rs.getString("agentid")));
				agt.setAgentFName(rs.getString("agtfirstname"));
				agt.setAgentMName(rs.getString("agtmiddleinitial"));
				agt.setAgentLName(rs.getString("agtlastname"));
				
				agts.add(agt);
				agt=null;
			}
			// close all data base objects 
			DBase.closeDBase(conn, rs, stmt);
						
			return agts;
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
	//-------------------------------------------
}
