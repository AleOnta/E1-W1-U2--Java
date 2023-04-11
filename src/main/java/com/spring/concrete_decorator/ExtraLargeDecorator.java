package com.spring.concrete_decorator;

import com.spring.component.Consumation;
import com.spring.decorator.ExtraAdditionDecorator;

public class ExtraLargeDecorator extends ExtraAdditionDecorator {
	
	public ExtraLargeDecorator(Consumation consumation) {
		this.consumation = consumation;
	}

	@Override
	public String getName() {
		return consumation.getName() + "+ Large ";
	}

	@Override
	public double getPrice() {
		return consumation.getPrice() + 2.00;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
