import java.util.ArrayList;

public class Burger {
	
	private String burgerType;
	private String meat;
	private String roll;
	private double price;
	private int maxToppings;
	
	private ArrayList<Toppings> availableToppings=new ArrayList<>();
	
	public Burger(String burgerType,String meat,String roll,double price,int maxToppings,ArrayList<Toppings> availableToppings)
	{
	this.burgerType=burgerType;
	this.meat=meat;
	this.roll=roll;
	this.price=price;
	this.maxToppings=maxToppings;
	this.availableToppings=availableToppings;
	}


	public String getBurgerType() {
		return burgerType;
	}


	public String getMeat() {
		return meat;
	}


	public String getRoll() {
		return roll;
	}

	public double getPrice() {
		return price;
	}

	public ArrayList<Toppings> getAvailableToppings() {
		return availableToppings;
	}


	public  void setAvailableToppings(ArrayList<Toppings> availableToppings) {
		this.availableToppings = availableToppings;
	}


	public int getMaxToppings() {
		return maxToppings;
	}
	
	
	
	
	
	

}
