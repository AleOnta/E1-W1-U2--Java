package com.spring.menu_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.spring.component.Consumation;
import com.spring.concrete_component.*;
import com.spring.concrete_decorator.*;

public class MenuConfiguration {
	
	// pizza beans
	
	@Bean
	@Scope("prototype")
	public Consumation margherita() {
		return new ConcretePizza();
	}
	
	@Bean
	@Scope("prototype")
	public Consumation large(Consumation consumation) {
		return new ExtraLargeDecorator(consumation);
	}
		
	@Bean
	@Scope("prototype")
	public Consumation ham(Consumation consumation) {
		return new ExtraHamDecorator(consumation);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation doubleHam(Consumation consumation) {
		return new ExtraDoubleHamDecorator(consumation);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation mushrooms(Consumation consumation) {
		return new ExtraMushroomsDecorator(consumation);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation ananas(Consumation consumation) {
		return new ExtraAnanasDecorator(consumation);
	}
	
	// drink beans
	
	@Bean
	@Scope("prototype")
	public Consumation still_water() {
		return new ConcreteDrink(E_ConcreteDrink.STILL_WATER);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation sparkling_water() {
		return new ConcreteDrink(E_ConcreteDrink.SPARKLING_WATER);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation coca_cola() {
		return new ConcreteDrink(E_ConcreteDrink.COCA_COLA);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation the() {
		return new ConcreteDrink(E_ConcreteDrink.THE);
	}
	
	@Bean
	@Scope("prototype")
	public Consumation beer() {
		return new ConcreteDrink(E_ConcreteDrink.BEER);
	}
	
}
