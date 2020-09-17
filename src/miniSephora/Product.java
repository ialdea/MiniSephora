package miniSephora;

public class Product {
	
	String name;
	String brand;
	float price;
	int quantityInMl;
	
	public Product(String name, String brand, float price, int quantityMl) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantityInMl = quantityMl;
	}
	
	public String toString() {
		return name+", "+brand+", "+price+", "+quantityInMl;
	}

}
