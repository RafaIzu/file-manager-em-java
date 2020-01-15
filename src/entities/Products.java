package entities;

public class Products {
	
	private String name;
	private double price;
	private int quantity; 
	
	public Products() {
		
	}

	public Products(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public double total() {
		return price*quantity;
	}


	

}
