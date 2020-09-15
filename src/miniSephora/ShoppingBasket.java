package miniSephora;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShoppingBasket {
	
	protected List<Item> itemList;
	
	public ShoppingBasket() {
		this.itemList = new ArrayList<>();
	}
	
	void addAnItem(Item item) {
		Item i = new Item(item.product, item.quantity);
		itemList.add(i);
	}
	

	void removeByProductName(String name) {
		Iterator<Item> itr = itemList.iterator();
		while(itr.hasNext()) {
			Item i =  itr.next();
			if(name.equals(i.product.name)) {
				itr.remove();
			}
		}
	}
	
	public void listAllItems() {
		for(Item i : itemList) {
			System.out.println(i.toString());
		}
	}
	
	public float getTotal() {
		Iterator<Item> itr = itemList.iterator();
		float total = 0.0f;
		while(itr.hasNext()) {
			Item i = itr.next();
			total = total + i.product.price * i.quantity;
		}
		return total;
	}
	
	public Order pay(User u) {
		DateFormat f = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		String s = f.format(new Date());
		String nameAndSurname = u.name+" "+u.surname;
		String phoneNo = u.phoneNumber;
		String adress = u.adress;
		String city = u.city;
		Order o = new Order( nameAndSurname, phoneNo, adress, city, itemList, s, u, this.getTotal());
		this.itemList = new ArrayList<>();
		return o;
	}
	
}
