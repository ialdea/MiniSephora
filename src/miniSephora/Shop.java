package miniSephora;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
	
	public Map getProducts() {return this.products;}
	
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
	
	public void listAllOrders() {
		for(Order o : orders) {
			System.out.println(o.toString());
		}
	}
	
	public void listAllUsers() {
		for(Map.Entry<String, User> entry : users.entrySet()) {
			System.out.println(entry.getKey() + ", "+ entry.getValue().toString());
		}
	}
	
	public void writeOrders() {
		BufferedWriter bWriter = null;
		File file = new File("C:\\Users\\40740\\Desktop\\Work\\Files\\Orders.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Writer writer;
		try {
			writer = new FileWriter(file);
			bWriter = new BufferedWriter(writer);
			for(Order o : orders) {
				bWriter.write(o.toString());
				bWriter.newLine();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bWriter != null) {
				try {
					bWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void writeProducts() {
		BufferedWriter bWriter = null;
		File file = new File("C:\\Users\\40740\\Desktop\\Work\\Files\\Products.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Writer writer;
		try {
			writer = new FileWriter(file);
			bWriter = new BufferedWriter(writer);
			for(Map.Entry<String, Product> entry : products.entrySet()) {
				bWriter.write(entry.getValue().toString());
				bWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bWriter != null) {
				try {
					bWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void writeUsers() {
		BufferedWriter bWriter = null;
		File file = new File("C:\\Users\\40740\\Desktop\\Work\\Files\\Users.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Writer writer = new FileWriter(file);
			bWriter = new BufferedWriter(writer);
			for(Map.Entry<String, User> entry : users.entrySet()) {
				bWriter.write(entry.getValue().toString());
				bWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bWriter != null) {
				try {
					bWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readUsers() {
		File file = new File("C:\\Users\\40740\\Desktop\\Work\\Files\\Users.txt");
		if(!file.exists()) {
			return;
		}
		Reader reader;
		BufferedReader bReader = null;
		try {
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			String line = "";
			while((line = bReader.readLine()) != null) {
				String[] user = line.split(", ");
				String[] nameAndSurname = user[0].split(" ");
				String name = nameAndSurname[0];
				String surname = nameAndSurname[1];
				String username = user[1];
				String password = user[2];
				String email = user[3];
				String phoneNr = user[4];
				String adress = user[5];
				String city = user[6];
				User u = new User(name, surname, username, password, email, phoneNr, adress, city);
				this.users.put(username, u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readProducts() {
		File file = new File("C:\\Users\\40740\\Desktop\\Work\\Files\\Products.txt");
		if(!file.exists()) {
			return ;
		}
		Reader reader;
		BufferedReader bReader = null;
		try {
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			String line = "";
			try {
				while((line = bReader.readLine()) != null) {
					String[] prod = line.split(", ");
					String name = prod[0];
					String brand = prod[1];
					float price = Float.parseFloat(prod[2]);
					int quantity = Integer.parseInt(prod[3]);
					Product p = new Product(name, brand, price, quantity);
					this.products.put(name, p);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readOrders() throws Exception {
		File file = new File("C:\\Users\\40740\\Desktop\\Work\\Files\\Orders.txt");
		if(! file.exists()) {
			return;
		}
		Reader reader;
		BufferedReader bReader = null;
		
		try {
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			String line = "";
			while((line = bReader.readLine()) != null) {
				String[] orderArr = line.split("/ ");
				int orderID = Integer.parseInt(orderArr[0]);
				String receiver = orderArr[1];
				String phoneNr = orderArr[2];
				String adress = orderArr[3];
				String city = orderArr[4];
				//lista de itemuri orderArr[5]
				
				String[] itemArr = orderArr[5].split(", ");
				List<Item> itemList = new ArrayList<>();
				for(int i = 0; i < itemArr.length; i++) {
					String[] itemArrComponents = itemArr[i].split("# ");
					String product = itemArrComponents[0];
					String quantity = itemArrComponents[1];
					Item item = new Item(products.get(product), Integer.parseInt(quantity));
					itemList.add(item);
				}
				
//				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
//				Date date = formatter.parse(orderArr[6]);
				String date = orderArr[6];
				
				String[] userArr = orderArr[7].split(", ");
				String[] nameAndSurname = userArr[0].split(" ");
				String name = nameAndSurname[0];
				String surname = nameAndSurname[1];
				String username = userArr[1];
				
				User u = users.get(username); 

				float total = Float.parseFloat(orderArr[8]);
				Order o = new Order(receiver, phoneNr, adress, city, itemList, date, u, total);
				this.orders.add(o);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
