package com.spring.e1w1u2;

import org.springframework.boot.SpringApplication;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring.menu_configuration.MenuConfiguration;
import com.spring.component.Consumation;
import com.spring.concrete_component.ConcreteDrink;
import com.spring.concrete_component.ConcretePizza;
import com.spring.concrete_component.E_ConcreteDrink;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class E1W1U2_JavaApplication {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(E1W1U2_JavaApplication.class, args);
		
		// exercise 1
		System.out.println("Hello World!");
	
		// exercise 2
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		System.out.println("Welcome to GodFather's Pizza, what would you like to order?");
		System.out.println("1 - Pizza & Drink \n"
							+ "2 - Only Pizza \n"
							+ "3 - Only Drink \n");
	
		int orderPick = askForInteger(1, 3);
		
		switch (orderPick) {
		case 1 -> {
			System.out.println("\nOkay, let's order a drink");
			String[] drinksArray = {"Still Water", "Sparkling Water", "CocaCola", "The", "Beer"};
			
			for (int i = 0; i < drinksArray.length; i++) {
				System.out.println((i+1) + " - " + drinksArray[i]);
			}
			
			System.out.println("\nSelect a drink by his own code");
			int drinkChoice = askForInteger(1, 5);
			
			Consumation drink = null;
			switch (drinkChoice) {
				case 1 -> drink = (Consumation) appContext.getBean("still_water");
				case 2 -> drink = (Consumation) appContext.getBean("sparkling_water");
				case 3 -> drink = (Consumation) appContext.getBean("coca_cola");
				case 4 -> drink = (Consumation) appContext.getBean("the");
				case 5 -> drink = (Consumation) appContext.getBean("beer");
			}
			
			System.out.println("\nWould you like to order a normal pizza or a large one?");
			String pizzaSize = askLetters("l", "n");
			
			System.out.println("\nOkay then, what pizza would you like to order?");
			String[] pizzasArray = {"Margherita", "With ham", "Ham & Mushrooms", "Hawaiian", "Double Ham", "Custom"};
			
			for (int i = 0; i < pizzasArray.length; i++) {
				System.out.println((i+1) + " - " + pizzasArray[i]);
			}
			
			System.out.println("\nSelect a pizza by his own code");
			int pizzaChoice = askForInteger(1, 6);
			
			Consumation pizza = null;
			switch (pizzaChoice) {
				case 1 -> pizza = (Consumation) appContext.getBean("margherita");
				case 2 -> pizza = (Consumation) appContext.getBean("ham", new ConcretePizza());
				case 3 -> pizza = (Consumation) appContext.getBean("mushrooms", (Consumation) appContext.getBean("ham", new ConcretePizza()));
				case 4 -> pizza = (Consumation) appContext.getBean("ham", (Consumation) appContext.getBean("ananas", new ConcretePizza()));
				case 5 -> pizza = (Consumation) appContext.getBean("doubleHam", new ConcretePizza());
				case 6 -> {
					System.out.println("\nOkay, what toppings would you like to add?");
					
					List<Integer> customerToppingsList = new ArrayList<Integer>();
					boolean otherTopping = true;
					do {
						String[] toppingsArray = {"Ham", "Mushrooms", "DoubleHam", "Ananas"};
						for (int i = 0; i < toppingsArray.length; i++) {
							System.out.println((i+1) + " - " + toppingsArray[i]);
						}
						
						int toppingPicked = askForInteger(1, 4);
						customerToppingsList.add(toppingPicked);
						
						System.out.println("\nwould you like to add others toppings?");
						String others = askLetters("y", "n");
						if (others.equals("n")) {
							otherTopping = false;
						} 
					} while (otherTopping);
					
					pizza = (Consumation) appContext.getBean("margherita");
					for (Integer i : customerToppingsList) {
						switch (i) {
							case 1 -> pizza = (Consumation) appContext.getBean("ham", pizza); 
							case 2 -> pizza = (Consumation) appContext.getBean("mushrooms", pizza); 
							case 3 -> pizza = (Consumation) appContext.getBean("doubleHam", pizza); 
							case 4 -> pizza = (Consumation) appContext.getBean("ananas", pizza); 
						}
					}
				}
				
			}
			
			if (pizzaSize.equals("l")) {
				pizza = (Consumation) appContext.getBean("large", pizza);
			}
			
			System.out.println("\n\n"
					+ "Order report: \n");
			System.out.println(pizza);
			System.out.println(drink);
			System.out.println("\ntotal amount --> " + String.format("%.2f", pizza.getPrice() + drink.getPrice()) + "€");
		}
		
			case 2 -> {
				System.out.println("\nWould you like to order a normal pizza or a large one?");
				String pizzaSize = askLetters("l", "n");
				
				System.out.println("\nOkay then, what pizza would you like to order?");
				String[] pizzasArray = {"Margherita", "With ham", "Ham & Mushrooms", "Hawaiian", "Double Ham", "Custom"};
				
				for (int i = 0; i < pizzasArray.length; i++) {
					System.out.println((i+1) + " - " + pizzasArray[i]);
				}
				
				System.out.println("\nSelect a pizza by his own code");
				int pizzaChoice = askForInteger(1, 6);
				
				Consumation pizza = null;
				switch (pizzaChoice) {
					case 1 -> pizza = (Consumation) appContext.getBean("margherita");
					case 2 -> pizza = (Consumation) appContext.getBean("ham", new ConcretePizza());
					case 3 -> pizza = (Consumation) appContext.getBean("mushrooms", (Consumation) appContext.getBean("ham", new ConcretePizza()));
					case 4 -> pizza = (Consumation) appContext.getBean("ham", (Consumation) appContext.getBean("ananas", new ConcretePizza()));
					case 5 -> pizza = (Consumation) appContext.getBean("doubleHam", new ConcretePizza());
					case 6 -> {
						System.out.println("\nOkay, what toppings would you like to add?");
						
						List<Integer> customerToppingsList = new ArrayList<Integer>();
						boolean otherTopping = true;
						do {
							String[] toppingsArray = {"Ham", "Mushrooms", "DoubleHam", "Ananas"};
							for (int i = 0; i < toppingsArray.length; i++) {
								System.out.println((i+1) + " - " + toppingsArray[i]);
							}
							
							int toppingPicked = askForInteger(1, 4);
							customerToppingsList.add(toppingPicked);
							
							System.out.println("\nwould you like to add others toppings?");
							String others = askLetters("y", "n");
							if (others.equals("n")) {
								otherTopping = false;
							} 
						} while (otherTopping);
						
						pizza = (Consumation) appContext.getBean("margherita");
						for (Integer i : customerToppingsList) {
							switch (i) {
								case 1 -> pizza = (Consumation) appContext.getBean("ham", pizza); 
								case 2 -> pizza = (Consumation) appContext.getBean("mushrooms", pizza); 
								case 3 -> pizza = (Consumation) appContext.getBean("doubleHam", pizza); 
								case 4 -> pizza = (Consumation) appContext.getBean("ananas", pizza); 
							}
						}
					}
				}
				
				if (pizzaSize.equals("l")) {
					pizza = (Consumation) appContext.getBean("large", pizza);
				}
				
				System.out.println("\n\n"
						+ "Order report: \n");
				System.out.println(pizza);
				System.out.println("\ntotal amount --> " + String.format("%.2f", pizza.getPrice()) + "€");
			}
			
			case 3 -> {
				
				System.out.println("\nOkay, let's order a drink");
				String[] drinksArray = {"Still Water", "Sparkling Water", "CocaCola", "The", "Beer"};
				
				for (int i = 0; i < drinksArray.length; i++) {
					System.out.println((i+1) + " - " + drinksArray[i]);
				}
				
				System.out.println("\nSelect a drink by his own code");
				int drinkChoice = askForInteger(1, 5);
				
				Consumation drink = null;
				switch (drinkChoice) {
					case 1 -> drink = (Consumation) appContext.getBean("still_water");
					case 2 -> drink = (Consumation) appContext.getBean("sparkling_water");
					case 3 -> drink = (Consumation) appContext.getBean("coca_cola");
					case 4 -> drink = (Consumation) appContext.getBean("the");
					case 5 -> drink = (Consumation) appContext.getBean("beer");
				}
				
				System.out.println("\n\n"
						+ "Order report: \n");
				System.out.println(drink);
				System.out.println("\ntotal amount --> " + String.format("%.2f", drink.getPrice()) + "€");
				
			}
			
		}
	}	
	
	public static int askForInteger(int s, int f) {
		boolean isRunning = true;
		int pick = 10;
		while (isRunning) {
			System.out.println("\nSelect an option between the available");
			pick = sc.nextInt();
			if(pick >= s && pick <= f) {
				break;
			} else {
				System.out.println("invalid value, try again\n");
				continue;
			}		
		}
		return pick;
	}
	
	public static String askLetters(String uno, String due) {
		boolean isRunning = true;
		String pick = "";
		while (isRunning) {
			System.out.print (uno + " / " + due + "\n");
			pick = sc.next();
			String[] pickArray = pick.split("");
			pick = pickArray[0].toLowerCase();
			if(pick.equals(uno) || pick.equals(due)) {
				break;
			} else {
				System.out.println("invalid char, try again\n");
				continue;
			}
		}
		return pick;
	}
}
