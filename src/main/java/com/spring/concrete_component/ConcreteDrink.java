package com.spring.concrete_component;

import com.spring.component.Consumation;
import lombok.ToString;

@ToString
public class ConcreteDrink extends Consumation {
	
	protected E_ConcreteDrink name;
	
	public ConcreteDrink(E_ConcreteDrink name) {
		this.name = name;
	}
	
	@Override
	public double getPrice() {
		if (name.equals(E_ConcreteDrink.SPARKLING_WATER) || name.equals(E_ConcreteDrink.SPARKLING_WATER)) {
			return 1.20;
		} else {
			return 2.50;
		}
	}

}
