package com.spring.concrete_decorator;

import com.spring.component.Consumation;
import com.spring.decorator.ExtraAdditionDecorator;

public class ExtraHamDecorator extends ExtraAdditionDecorator {

	public ExtraHamDecorator(Consumation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ Ham ";
	}

	@Override
	public double getPrice() {
		return consumation.getPrice() + 1.20;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
