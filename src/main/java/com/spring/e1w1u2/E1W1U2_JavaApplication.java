package com.spring.e1w1u2;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring.menu_configuration.MenuConfiguration;
import com.spring.component.Consumation;
import com.spring.concrete_component.ConcretePizza;

@SpringBootApplication
public class E1W1U2_JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(E1W1U2_JavaApplication.class, args);
		
		// exercise 1
		System.out.println("Hello World!");
	
		// exercise 2
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		
		Consumation d1 = (Consumation) appContext.getBean("still_water");
		System.out.println(d1.toString() + " Price -> " + String.format("%.2f", d1.getPrice()) + "€");
		// Create margherita
		Consumation p1 = (Consumation) appContext.getBean("margherita");
		System.out.println(p1);
		System.out.println("Total amount: " + String.format("%.2f", (d1.getPrice() + p1.getPrice())) + "€ \n");
		
		Consumation d2 = (Consumation) appContext.getBean("sparkling_water");
		System.out.println(d2.toString() + " Price -> " + String.format("%.2f", d2.getPrice()) + "€");
		// Create double Ham
		Consumation p2 = (Consumation) appContext.getBean("doubleHam", new ConcretePizza());
		System.out.println(p2);
		System.out.println("Total amount: " + String.format("%.2f", (d2.getPrice() + p2.getPrice())) + "€ \n");	
		
		Consumation d3 = (Consumation) appContext.getBean("coca_cola");
		System.out.println(d3.toString() + " Price -> " + String.format("%.2f", d3.getPrice()) + "€");
		// Create hawaiian pizza
		Consumation p3a = (Consumation) appContext.getBean("ham", new ConcretePizza());
		Consumation p3b = (Consumation) appContext.getBean("ananas", p3a);
		System.out.println(p3b);
		System.out.println("Total amount: " + String.format("%.2f", (d3.getPrice() + p3b.getPrice())) + "€ \n");
		
		Consumation d4 = (Consumation) appContext.getBean("beer");
		System.out.println(d4.toString() + " Price -> " + String.format("%.2f", d4.getPrice()) + "€");
		// Create ham & mushrooms
		Consumation p4a = (Consumation) appContext.getBean("ham", new ConcretePizza());
		Consumation p4b = (Consumation) appContext.getBean("mushrooms", p4a);
		System.out.println(p4b);
		System.out.println("Total amount: " + String.format("%.2f", (d4.getPrice() + p4b.getPrice())) + "€ \n");
		
	}	
}
