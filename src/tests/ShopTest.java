package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import miniSephora.Order;
import miniSephora.Product;
import miniSephora.Shop;
import miniSephora.User;

public class ShopTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void test2() {
//		fail("Not yet implemented");
		Shop s = Shop.getInstance();
		s.readProducts();
		
		Map<String, Product> map = s.getProducts();
		assertTrue(map.size() == 6);
//		for(Map.Entry<String, Product> entry : map.entrySet()) {
//			
//		}
		Product p = map.get("Pat Stik Foundation");
		assertNotNull(p);
		assertEquals("Max Factor", p.getBrand());
		
		Product p2 = map.get("Dior Forever Summer Skin");
		assertNotNull(p2);
		assertEquals("Dior Forever Summer Skin", p2.getName());
		
		Product p3 = map.get("Waterproof Foundation Concelar");
		assertNotNull(p3);
		assertEquals(405.0, p3.getPrice(), 1 );
	}
	
	@Test
	public void test3() {
		Shop s = Shop.getInstance();
		s.readUsers();
		
		Map<String, User> map = s.getUsers();
		assertTrue(map.size() == 1);
		
		User u = map.get("airina");
		assertNotNull(u);
		assertEquals("airina", u.getUsername());
		assertEquals("irinaaldea56@yahoo.ro", u.getEmail());
	}
	
	@Test
	public void test4() {
		Shop s = Shop.getInstance();
		s.readProducts();
		Map<String, Product> products = s.getProducts();
		s.readUsers();
		Map<String, User> users = s.getUsers(); 

		s.readOrders();
		List<Order> orders = s.getOrders();
		Order o = orders.get(0);
		assertEquals(0, o.getOrderID());
		assertEquals(537.0, o.getTotal(), 0);
		assertEquals("veteranilor nr. 20", o.getAdress());
	}

}
