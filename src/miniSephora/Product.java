package miniSephora;

public class Product {
	
	String name;
	String brand;
	float price;
	int quantityInMl;
	
	public String getName() {return this.name;}
	public String getBrand() {return this.brand;}
	public float getPrice() {return this.price;}
	public int getQuantityInMl() {return this.quantityInMl;}
	
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
