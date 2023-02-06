package product.model.vo;

public class Product {
	private String productName;
	private int productPrice;
	private int productCount;

	public Product() {}

	public Product(String productName, int productPrice, int productCount) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	
}
