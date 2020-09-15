package miniSephora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Order extends ShoppingBasket {
	
	int orderID;
	String nameAndSurname;
	String phoneNo;
	String adress;		
	String city;
	Date orderDate;
	float total;
	User user;
	
	public static int nextID;
	
	public Order( String nameAndSurname, String phoneNo, String adress, String city, List<Item> itemList, String orderDate, 
			User user, float total) {
		super.itemList = itemList;
		this.orderID = nextID;
		nextID++;
		this.nameAndSurname = nameAndSurname;
		this.phoneNo = phoneNo;
		this.adress = adress;
		this.city = city;
		this.user = user;
		this.total = total;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		try {
			this.orderDate = format.parse(orderDate);
			//System.out.println(format.format(this.orderDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
