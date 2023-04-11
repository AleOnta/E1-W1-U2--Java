package com.spring.concrete_decorator;

import com.spring.component.Consumation;
import com.spring.decorator.ExtraAdditionDecorator;

public class ExtraAnanasDecorator extends ExtraAdditionDecorator {

	public ExtraAnanasDecorator(Consumation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ ananas ";
	}

	@Override
	public double getPrice() {
		return consumation.getPrice() + 0.90;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
}
