package miniSephora;

public class MyShopApp {
	
	static {
		Product p1 = new Product("Matte Perfection Stik", "Sephora Collection", 66.00f, 30);
		Product p2 = new Product("Pat Stik Foundation", "Max Factor", 33.00f, 30);
		Product p3 = new Product("Healthy Skin Harmony Miracle Foundation", "Max Factor", 67.00f, 30);
		Product p4 = new Product("Waterproof Foundation Concelar", "Tom Ford", 405.00f, 30);
		
		Shop s = Shop.getInstance();
		s.addProduct("Dior Forever Summer Skin", "Dior", 229.9f, 30);
		s.addProduct(p1);
		s.addProduct(p2);
		s.addProduct(p3);
		s.addProduct(p4);
		s.addProduct("Reeboot Foundation", "Make up Forever", 187.00f, 30);
		s.listAllProducts();
	}
	
	public static void main(String[] args) {
		
		Shop s = Shop.getInstance();
		s.readProducts();
		s.readUsers();
		s.readOrders();
		
		
		System.out.println("--------");
		
		User u1 = new User("Aldea", "Irina", "airina", "abulica", "irinaaldea56@yahoo.ro", "0740378832", "veteranilor nr. 20", "Bucuresti");
		s.addUser(u1);
		
		Item item = new Item(s.searchProductByName("Matte Perfection Stik"), 1);
		u1.addToMyBasket(item);
		
		item = new Item(s.searchProductByName("Pat Stik Foundation"), 2);
		u1.addToMyBasket(item);
		
		item = new Item(s.searchProductByName("Waterproof Foundation Concelar"), 1);
		u1.addToMyBasket(item);
		
		u1.listShopingBasket();
		
		s.addOrder(u1.pay());
		
//		s.listAllOrders();
//		s.listAllUsers();
		
		
		System.out.println("------teste azi------");
		s.writeOrders();
		//s.writeProducts();
		//s.writeUsers();
		
		
	}

}
