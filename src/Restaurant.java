import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Restaurant {

	/*
	 * to store object of a selected burger
	 */
	static Burger burger;

	/*
	 * list of burgers
	 */
	private static String[][] burgers = { { "Basic", "Chicken", "White","10.5", "4" }, { "Healthy", "Beef", "White","8.5", "6" },
			{ "Deluxe", "Pork", "White","14.7", "2" } };
	static ArrayList<Toppings> selectedToppings = new ArrayList<>();
	/*
	 * displaying burgers to the customer
	 */
	public void displayBurgers() {

		for (int i = 0; i < burgers.length; i++) {
			System.out.println(i + 1 + ":");
			for (int j = 0; j < burgers[i].length; j++) {

				if (j == 0)
					System.out.println("Name :" + burgers[i][j]);
				if (j == 1)
					System.out.println("Meat :" + burgers[i][j]);
				if (j == 2)
					System.out.println("Roll :" + burgers[i][j]);
				if (j == 3)
					System.out.println("Burger Price :" + burgers[i][j]);
				if (j == 4)
					System.out.println("Max Topping Count :" + burgers[i][j]);
			}
			System.out.println("---------------------------");
		}
		System.out.println("Enter 0 to exit");
		
	}

	/*
	 * reading user input
	 */
	public void readBurgerInput() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int i;
		String burgerType;
		String meat;
		String roll;
		int maxToppings;
		ArrayList<Toppings> availableToppings = new ArrayList<Toppings>();
		switch (input) {
		case 1:
			i = 0;
			/*
			 * according to the used choice creating burger object
			 */
			availableToppings = prepareToppings(i);
			burger = new Burger(burgers[i][0], burgers[i][1], burgers[i][2],Double.parseDouble(burgers[i][3]), Integer.parseInt(burgers[i][4]),
					availableToppings);

			break;
		case 2:
			i = 1;
			availableToppings = prepareToppings(i);
			burger = new Burger(burgers[i][0], burgers[i][1], burgers[i][2],Double.parseDouble(burgers[i][3]), Integer.parseInt(burgers[i][4]),
					availableToppings);
			break;
		case 3:
			i = 2;
			availableToppings = prepareToppings(i);
			burger = new Burger(burgers[i][0], burgers[i][1], burgers[i][2],Double.parseDouble(burgers[i][3]), Integer.parseInt(burgers[i][4]),
					availableToppings);
			break;
		case 0:
			System.exit(0);

		}

	}

	private ArrayList<Toppings> prepareToppings(int burgerID) {
		ArrayList<Toppings> basicToppings = new ArrayList<Toppings>();
		ArrayList<Toppings> healthyToppings = new ArrayList<Toppings>();
		ArrayList<Toppings> deluxeToppings = new ArrayList<Toppings>();

		Toppings tomato = new Toppings("Tomato", 0.27);
		Toppings lettuce = new Toppings("lettuce", 0.27);
		Toppings cheese = new Toppings("cheese", 0.27);
		Toppings carrot = new Toppings("carrot", 0.27);
		Toppings egg = new Toppings("egg", 0.27);
		Toppings lentils = new Toppings("lentils", 0.27);
		Toppings panner = new Toppings("panner", 0.27);
		Toppings corn = new Toppings("corn", 0.27);

		basicToppings.add(tomato);
		basicToppings.add(lettuce);
		basicToppings.add(cheese);
		basicToppings.add(carrot);

		healthyToppings.addAll(basicToppings);
		healthyToppings.add(egg);
		healthyToppings.add(lentils);

		deluxeToppings.add(panner);
		deluxeToppings.add(corn);

		switch (burgerID) {
		case 0:
			return basicToppings;
		case 1:
			return healthyToppings;
		case 2:
			return deluxeToppings;
		}
		return deluxeToppings;
	}

	public ArrayList<Toppings> displayToppings() {
		ArrayList<Toppings> toppings = burger.getAvailableToppings();
		Scanner sc = new Scanner(System.in);
		int toppingSelection;
		System.out.println("Please choose toppings or Enter 0 to exit");

		int i = 0;
		for (Toppings toppings2 : toppings) {
			System.out.print(++i + " : ");
			System.out.println("Name : " + toppings2.getName());
			System.out.println("    Price : " + toppings2.getPrice());
			System.out.println("-------------------");
		}
		for (int j = 0; j < toppings.size(); j++) {
			try {
				toppingSelection = sc.nextInt();
				if (toppingSelection > 0 && toppingSelection < 7) {
					selectedToppings.add(toppings.get(toppingSelection - 1));
				}
				else if (toppingSelection==0) {
					j=7;
				}
			    }
			catch (InputMismatchException exception) {
				System.out.println("This is not an integer");
			}

		}
		return selectedToppings;
	}
	public void prepareBill() {
		new Bill(Restaurant.burger,selectedToppings );
		
	}

}
