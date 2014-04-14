package Travel.Entity;

/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */

public class Customer 
{

	private long customerid;
	private java.math.BigDecimal agentid;
	private String custaddress;
	private String custbusphone;
	private String custcity;
	private String custcountry;
	private String custemail;
	private String custfirstname;
	private String custhomephone;
	private String custlastname;
	private String custpostal;
	private String custprov;

	public Customer() {
	}


	
	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}


	public java.math.BigDecimal getAgentid() {
		return this.agentid;
	}

	public void setAgentid(java.math.BigDecimal agentid) {
		this.agentid = agentid;
	}


	public String getCustaddress() {
		return this.custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}


	public String getCustbusphone() {
		return this.custbusphone;
	}

	public void setCustbusphone(String custbusphone) {
		this.custbusphone = custbusphone;
	}


	public String getCustcity() {
		return this.custcity;
	}

	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}


	public String getCustcountry() {
		return this.custcountry;
	}

	public void setCustcountry(String custcountry) {
		this.custcountry = custcountry;
	}


	public String getCustemail() {
		return this.custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}


	public String getCustfirstname() {
		return this.custfirstname;
	}

	public void setCustfirstname(String custfirstname) {
		this.custfirstname = custfirstname;
	}


	public String getCusthomephone() {
		return this.custhomephone;
	}

	public void setCusthomephone(String custhomephone) {
		this.custhomephone = custhomephone;
	}


	public String getCustlastname() {
		return this.custlastname;
	}

	public void setCustlastname(String custlastname) {
		this.custlastname = custlastname;
	}


	public String getCustpostal() {
		return this.custpostal;
	}

	public void setCustpostal(String custpostal) {
		this.custpostal = custpostal;
	}


	public String getCustprov() {
		return this.custprov;
	}

	public void setCustprov(String custprov) {
		this.custprov = custprov;
	}

}