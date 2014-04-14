package Travel.DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import Travel.Entity.Agents;
import Travel.Entity.Packages;

public class PackagesDB {

	// empty constructor
		public PackagesDB()
		{
			
		}
		
		public static Packages getPackage(Integer packageId)
		{			
			try 
			{
				Packages pkg = new Packages();
				
				// get connection
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				
				ResultSet rs;
				StringBuilder qry = new StringBuilder();
				qry.append("select packageid,pkgname,pkgstartdate,pkgenddate ");
				qry.append(",pkgdesc,pkgbaseprice,pkgagencycommission");
				qry.append(" from packages where packageid=");
				qry.append(packageId);
				
				rs = stmt.executeQuery(qry.toString());
			
				while (rs.next())
				{
					pkg.setPackageId(Integer.valueOf(rs.getString("packageid")));
					pkg.setPackageName(rs.getString("pkgname"));
					pkg.setPackageStartDate(rs.getDate("pkgstartdate"));
					pkg.setPackageEndDate(rs.getDate("pkgenddate"));
					pkg.setPackageDesc(rs.getString("pkgdesc"));
					pkg.setPackagePrice(Double.valueOf(rs.getString("pkgbaseprice")));
					pkg.setPackageAgencyComm(Double.valueOf(rs.getString("pkgagencycommission")));
				}

				// close all data base objects to release memory
				DBase.closeDBase(conn, rs, stmt);
				
				return pkg;
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
		
		public static Vector<Packages> getAllPackages() 
		{
			try 
			{
				Vector<Packages> pkgs = new Vector<Packages>();
				
				// get oracle connection
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				
				ResultSet rs;
				
				StringBuilder qry = new StringBuilder();
				qry.append("select * from packages");
				 
				rs = stmt.executeQuery(qry.toString());
				
				while (rs.next())
				{
					Packages pkg = new Packages();
					
					pkg.setPackageId(Integer.valueOf(rs.getString("packageid")));
					pkg.setPackageName(rs.getString("pkgname"));
					pkg.setPackageStartDate(rs.getDate("pkgstartdate"));
					pkg.setPackageEndDate(rs.getDate("pkgenddate"));
					pkg.setPackageDesc(rs.getString("pkgdesc"));
					pkg.setPackagePrice(Double.valueOf(rs.getString("pkgbaseprice")));
					pkg.setPackageAgencyComm(Double.valueOf(rs.getString("pkgagencycommission")));
					
					pkgs.add(pkg);
					pkg=null;
				}
				// close all data base objects 
				DBase.closeDBase(conn, rs, stmt);
							
				return pkgs;
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
		/**
		 * @param agt
		 * @return number of rows updated - 0 means update failed
		 */
		public static Integer updatePackage(Packages pkg)
		{
			Integer numRows =0; 
			try
			{
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				String formattedStart = DBase.getddMMMyyFormat(pkg.getPackageStartDate().toString());
				String formattedEnd = DBase.getddMMMyyFormat(pkg.getPackageEndDate().toString());
				
				StringBuilder qry = new StringBuilder();
				qry.append("update packages set pkgname ='");
				qry.append(pkg.getPackageName());
				qry.append("',");
				qry.append(" pkgstartdate ='");
				
				//qry.append(pkg.getPackageStartDate());
				qry.append(formattedStart);
				
				qry.append("',");
				qry.append(" pkgenddate ='");
				
				//qry.append(pkg.getPackageEndDate());
				qry.append(formattedEnd);
				
				qry.append("',");
				qry.append(" pkgdesc ='");
				qry.append(pkg.getPackageDesc());
				qry.append("',");
				qry.append(" pkgbaseprice =");
				qry.append(pkg.getPackagePrice());
				qry.append(",");
				qry.append(" pkgagencycommission =");
				qry.append(pkg.getPackageAgencyComm());
				qry.append(" where packageid =");
				qry.append(pkg.getPackageId());
				
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
		public static Integer insertPackage(Packages pkg) throws ParseException
		{
			Integer numRows =0; 
			try
			{
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				
				StringBuilder qry = new StringBuilder();
				qry.append("insert into packages (packageid,pkgname,pkgstartdate,pkgenddate");
				qry.append(",pkgdesc,pkgbaseprice,pkgagencycommission) values (");
				
				qry.append(getMaxvalPackages());
				qry.append(",'");
				qry.append(pkg.getPackageName());
				qry.append("','");
				
				String formattedStart = DBase.getddMMMyyFormat(pkg.getPackageStartDate().toString());
				String formattedEnd = DBase.getddMMMyyFormat(pkg.getPackageEndDate().toString());
				
				//qry.append(pkg.getPackageStartDate());
				qry.append(formattedStart);
				qry.append("','");
				
				//qry.append(pkg.getPackageEndDate());
				qry.append(formattedEnd);
				qry.append("','");
				
				qry.append(pkg.getPackageDesc());
				qry.append("',");
				
				qry.append(pkg.getPackagePrice());
				qry.append(",");
				
				qry.append(pkg.getPackageAgencyComm());
				qry.append(") ");
				
				//System.out.println(qry.toString());
				
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
		public static Integer deletePackage(Integer packageId)
		{
			Integer numRows =0; 
			try
			{
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				
				StringBuilder qry = new StringBuilder();
				qry.append("Delete packages where packageId=" );
				qry.append(packageId);
				
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
		// get next id (primary key) for packages
		private static Integer getMaxvalPackages()
		{
			try 
			{
				Integer maxVal=1;
				
				// get connection
				Connection conn = DBase.getOracleConnection();
				
				Statement stmt;
				stmt = conn.createStatement();
				
				ResultSet rs;
				String qry = "select max(packageid)+1 from packages ";
				
				
				rs = stmt.executeQuery(qry.toString());
			
				while (rs.next())
				{
					maxVal = Integer.valueOf(rs.getString(1));
				}

				// close all data base objects to release memory
				DBase.closeDBase(conn, rs, stmt);
				
				return maxVal;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			return 1; // error condition
		}
		//------------------------------------------
	}

