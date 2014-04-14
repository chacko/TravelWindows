package Travel.Entity;

/**
 * The persistent class for the SUPPLIERS database table.
 * 
 */

public class Supplier 
{
	private long supplierid;
	private String supname;

	public Supplier() {
	}


	public long getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(long supplierid) {
		this.supplierid = supplierid;
	}


	public String getSupname() {
		return this.supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}
	

}