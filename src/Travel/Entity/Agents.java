package Travel.Entity;

public class Agents 
{
	// member variables
	private Integer agentId;
	private String agentFName;
	private String agentMName;
	private String agentLName;
	private String agentBusPhone;
	private String agentEmail;
	private String agentPosn;
	private Integer agentAgencyId;
	
	//--------------------------------------
	// Empty constructor
	public Agents()
	{
		
	}
	//--------------------------------------
	// getter and setter methods for 
	// member variables
	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentFName() {
		return agentFName;
	}

	public void setAgentFName(String agentFName) {
		this.agentFName = agentFName;
	}
	//--------------------------------------
	public String getAgentMName() {
		return agentMName;
	}
	public void setAgentMName(String agentMName) {
		this.agentMName = agentMName;
	}
	public String getAgentLName() {
		return agentLName;
	}
	public void setAgentLName(String agentLName) {
		this.agentLName = agentLName;
	}
	public String getAgentBusPhone() {
		return agentBusPhone;
	}
	public void setAgentBusPhone(String agentBusPhone) {
		this.agentBusPhone = agentBusPhone;
	}
	public String getAgentEmail() {
		return agentEmail;
	}
	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}
	public String getAgentPosn() {
		return agentPosn;
	}
	public void setAgentPosn(String agentPosn) {
		this.agentPosn = agentPosn;
	}
	public Integer getAgentAgencyId() {
		return agentAgencyId;
	}
	public void setAgentAgencyId(Integer agentAgencyId) {
		this.agentAgencyId = agentAgencyId;
	}
	// over ride to string to display in combo box
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String midl ="";
		String lstName ="";
		
		if(this.agentMName != null)
		{
			midl=this.agentMName;
		}
		/*if(!this.agentLName.isEmpty())
		{
			lstName=this.agentLName;
		}*/
		
		return this.agentFName + " " + midl + " " + this.agentLName;
	}
	
	
	
}
