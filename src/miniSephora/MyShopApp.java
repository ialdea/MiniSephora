package miniSephora;

import java.util.HashMap;
import java.util.Map;

public class MyShopApp {
	
	public static void main(String[] args) {
		
		Product p2 = new Product("Pat Stik Foundation", "Max Factor", 33.00f, 30);
		Product p3 = new Product("Healthy Skin Harmony Miracle Foundation", "Max Factor", 67.00f, 30);
		Product p4 = new Product("Waterproof Foundation Concelar", "Tom Ford", 405.00f, 30);
		
		System.out.println("-------");
		
		Shop s = Shop.getInstance();
		s.addProduct("Dior Forever Summer Skin", "Dior", 229.9f, 30);
		s.addProduct(p2);
		s.addProduct(p3);
		s.addProduct(p4);
		s.listAllProducts();
		
		System.out.println("--------");
		
		s.addProduct("Reeboot Foundation", "Make up Forever", 187.00f, 30);
		s.listAllProducts();
	}

}
