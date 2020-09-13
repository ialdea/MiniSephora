package miniSephora;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Shop {
	
	private static Shop instance;
	
	public static Shop getInstance() {
		if(instance == null) {
			instance = new Shop();
		}
		return instance;
	}
	
	final private Map<String, Product> products;
	
	private Shop() {
		this.products = new HashMap<>();
	}
	
	public Product searchProductByName(String nameOfProduct) {
		return products.get(nameOfProduct);
	}
	
	public void listAllProducts() {
		for(Map.Entry<String, Product> entry : products.entrySet()) {
			System.out.println(entry.getKey() + " "+ entry.getValue().toString());
		}
	}
	
	public void addProduct(String name, String brand, float price, int quantity) {
		Product p = new Product(name, brand, price, quantity);
		this.addProduct(p);
	}
	
	public void addProduct(Product p) {
		products.put(p.name, p);
	}

}
