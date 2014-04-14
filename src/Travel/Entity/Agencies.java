/**
 * 
 */
package Travel.Entity;


/**
 * @author user1
 *
 */
public class Agencies 
{
	// member variables
	private Integer agencyId;
	private String agncyCity;
	
	// constructor
	public Agencies()
	{
		
	}
	
	// getter and setter methods
	public Integer getAgencyId() 
	{
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) 
	{
		this.agencyId = agencyId;
	}

	public String getAgncyCity() 
	{
		return agncyCity;
	}

	public void setAgncyCity(String agncyCity) 
	{
		this.agncyCity = agncyCity;
	}
	
	// over ride to string to display in combo box
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.agncyCity ;
		}
}
