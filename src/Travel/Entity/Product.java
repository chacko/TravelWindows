package Travel.Entity;

import java.util.List;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */

public class Product {
	
	private long productid;
	private String prodname;
	private List<ProductsSupplier> productsSuppliers;

	public Product() {
	}


	public long getProductid() {
		return this.productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}


	public String getProdname() {
		return this.prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	//bi-directional many-to-one association to ProductsSupplier
	
	public List<ProductsSupplier> getProductsSuppliers() {
		return this.productsSuppliers;
	}

	public void setProductsSuppliers(List<ProductsSupplier> productsSuppliers) {
		this.productsSuppliers = productsSuppliers;
	}

	public ProductsSupplier addProductsSupplier(ProductsSupplier productsSupplier) {
		getProductsSuppliers().add(productsSupplier);
		productsSupplier.setProduct(this);

		return productsSupplier;
	}

	public ProductsSupplier removeProductsSupplier(ProductsSupplier productsSupplier) {
		getProductsSuppliers().remove(productsSupplier);
		productsSupplier.setProduct(null);

		return productsSupplier;
	}

}