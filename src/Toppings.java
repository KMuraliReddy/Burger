
public class Toppings {
	private String name;
	private double price;
	public Toppings(String name,double price ) {
		// TODO Auto-generated constructor stub
		
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return this.name + " : "+this.price;
	}

}
