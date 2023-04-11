package com.spring.component;

import lombok.Getter;

public abstract class Consumation {
	@Getter
	protected String name = "";
	
	public abstract double getPrice();
	
	public static void checkPizza(Consumation consumation) {
		if (consumation.getName().contains("ham") && consumation.getName().contains("mushrooms")) {
			System.out.println("prosciutto e funghi");
		} else if (consumation.getName().contains("ham") && consumation.getName().contains("ananas")) {
			System.out.println("hawaiian");
		}
	}
}
