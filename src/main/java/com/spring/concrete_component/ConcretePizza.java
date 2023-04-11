package com.spring.concrete_component;

import com.spring.component.Consumation;

public class ConcretePizza extends Consumation {
	
	public ConcretePizza() {
		name = "Pizza ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 6.50;
	}

	@Override
	public String toString() {
		return "ConcretePizza [name=" + name + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}

	
}
