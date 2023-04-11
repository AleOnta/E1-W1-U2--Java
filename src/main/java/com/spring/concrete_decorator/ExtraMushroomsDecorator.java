package com.spring.concrete_decorator;

import com.spring.component.Consumation;
import com.spring.decorator.ExtraAdditionDecorator;

public class ExtraMushroomsDecorator extends ExtraAdditionDecorator {

	public ExtraMushroomsDecorator(Consumation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ mushrooms ";
	}

	@Override
	public double getPrice() {
		return consumation.getPrice() + 1.50;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
