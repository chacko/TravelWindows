package Travel.Entity;


/**
 * The persistent class for the PACKAGES_PRODUCTS_SUPPLIERS database table.
 * 
 */

public class PackagesProductsSupplier 
{
	
	private long id;
	private long productsSupplrId;
	
	public PackagesProductsSupplier() 
	{
	}

	
	public  long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public  long getProductsSupplrId() {
		return this.productsSupplrId;
	}

	public void setProductsSupplrId(long id) {
		this.productsSupplrId = id;
	}


	
}