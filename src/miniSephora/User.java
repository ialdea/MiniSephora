package miniSephora;

public class User {
	
	String name;
	String surname;
	String username;
	String password;
	String email;
	String phoneNumber;
	String adress;
	String city;
	ShoppingBasket basket;
	
	public User(String name, String surname, String username, String password, String email, String phoneNumber, String adress, String city) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.city = city;
		
		this.basket = new ShoppingBasket();
	}
	
	public void addToMyBasket(Item i) {
		this.basket.addAnItem(i);
	}
	
	public Order pay() {
		return this.basket.pay(this);
	}
	
	public void listShopingBasket() {
		float total = basket.getTotal(); 
		basket.listAllItems();
		System.out.println("Total: "+ total);
	}
}
