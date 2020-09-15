package miniSephora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
	
	private static Shop instance;
	
	public static Shop getInstance() {
		if(instance == null) {
			instance = new Shop();
		}
		return instance;
	}
	
	final private Map<String, Product> products;
	private List<Order> orders;
	private Map<String, User> users;
	
	private Shop() {
		this.products = new HashMap<>();
		this.orders = new ArrayList<>();
		this.users = new HashMap<>();
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
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	public void addUser(User u) {
		users.put(u.username, u);
	}

}
