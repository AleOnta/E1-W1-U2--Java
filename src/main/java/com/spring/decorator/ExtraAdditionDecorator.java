package com.spring.decorator;

import com.spring.component.Consumation;

public abstract class ExtraAdditionDecorator extends Consumation {

	protected Consumation consumation;
	
	@Override
	public abstract String getName();

}
