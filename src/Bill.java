import java.util.ArrayList;

public class Bill {
	private double total = 0;
	private double tax = 0;
	private double netTotal=0;

	public Bill(Burger burger, ArrayList<Toppings> toppings) {
		prepareBill(burger, toppings);
		this.tax = this.total * 0.15;
		this.netTotal=this.total+this.tax;
		printReceipt(burger, toppings);
	}

	private void prepareBill(Burger burger, ArrayList<Toppings> toppings) {
		this.total = total + burger.getPrice();
		for (Toppings toppings2 : toppings) {
			this.total = total + toppings2.getPrice();
		}

	}
	private void printReceipt(Burger burger, ArrayList<Toppings> toppings)
	{
		System.out.println("\n\tReceipt");
		System.out.println("\n\t````````");
		System.out.println("1. "+burger.getBurgerType() + " - "+burger.getPrice());
		if(toppings.size() > 0)
		{
			System.out.println("\n\tExtras: ");
			System.out.println("\n``````````");
			int i=0;
			for (Toppings toppings2 : toppings) {
				System.out.println(i +". "+toppings2);
				i++;
			}
			
		}
		else 
		{
			System.out.println("\n No Extra toppings");
		}
		System.out.println("\n-----------------------");
		
		System.out.println("Amount :"+String.format("%.2f", this.total));
		System.out.println("TAX :"+String.format("%.2f", this.tax));
		System.out.println("TAX :"+String.format("%.2f", this.netTotal));
	}
	

}
