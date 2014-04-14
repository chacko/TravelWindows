package Travel.Entity;

public class Customers {
	private String customerFirstName;
	private String customerLastName;
	private Integer customerID;
	private String customerAdrs;
	private String customerCity;
	private String customerProv;
	private String customerPhone;
	private String customerEmail;
	private String customerPostal;
	
	public Customers(){
		
	}
	
	public Customers(String customerFirstName, String customerLastName, Integer customerID) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerID = customerID;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer agentId) {
		this.customerID = agentId;
	}

	/**
	 * @return the customerAdrs
	 */
	public String getCustomerAdrs() {
		return customerAdrs;
	}

	/**
	 * @param customerAdrs the customerAdrs to set
	 */
	public void setCustomerAdrs(String customerAdrs) {
		this.customerAdrs = customerAdrs;
	}

	/**
	 * @return the customerCity
	 */
	public String getCustomerCity() {
		return customerCity;
	}

	/**
	 * @param customerCity the customerCity to set
	 */
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	/**
	 * @return the customerProv
	 */
	public String getCustomerProv() {
		return customerProv;
	}

	/**
	 * @param customerProv the customerProv to set
	 */
	public void setCustomerProv(String customerProv) {
		this.customerProv = customerProv;
	}

	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the customerPostal
	 */
	public String getCustomerPostal() {
		return customerPostal;
	}

	/**
	 * @param customerPostal the customerPostal to set
	 */
	public void setCustomerPostal(String customerPostal) {
		this.customerPostal = customerPostal;
	}

	@Override
	public String toString() {
		//if(this.customerLastName)
		return this.customerFirstName + " " + this.customerLastName;
	}
}
