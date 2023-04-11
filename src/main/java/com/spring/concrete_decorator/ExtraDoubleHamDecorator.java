package com.spring.concrete_decorator;

import com.spring.component.Consumation;
import com.spring.decorator.ExtraAdditionDecorator;

public class ExtraDoubleHamDecorator extends ExtraAdditionDecorator {

	public ExtraDoubleHamDecorator(Consumation consumation) {
		this.consumation = consumation;
	}
	
	@Override
	public String getName() {
		return consumation.getName() + "+ double Ham ";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return consumation.getPrice() + 1.90;
	}

	public String toString() {
		return "Pizza [name=" + this.getName() + ", Price=" + String.format("%.2f", this.getPrice()) + "€ ]";
	}
	
}
