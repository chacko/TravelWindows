package Travel.Entity;

/**
 * The persistent class for the PRODUCTS_SUPPLIERS database table.
 * 
 */

public class ProductsSupplier 
{

	private long productsupplierid;
	
	private Product product;
	private Supplier supplier;

	public ProductsSupplier() {
	}


	public long getProductsupplierid() {
		return this.productsupplierid;
	}

	public void setProductsupplierid(long productsupplierid) {
		this.productsupplierid = productsupplierid;
	}


	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}