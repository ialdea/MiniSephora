package miniSephora;

public class Item {
	
	Product product;
	int quantity;

	public Item(Product p, int q) {
		this.product = p;
		this.quantity = q;
	}
	
	public String toString() {
		return product.name + " "+ quantity;
	}
}
