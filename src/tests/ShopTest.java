package tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import miniSephora.Product;
import miniSephora.Shop;

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
		
	}

}
