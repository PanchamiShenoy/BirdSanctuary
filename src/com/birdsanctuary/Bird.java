package com.birdsanctuary;

import java.util.Objects;

 public class Bird {
	enum Colour {
		RED,BLACK,WHITE,GREY,GREEN
	}
	String id;
	Colour colour;
	String name;
	Boolean canFly,canSwim,canEat;
	
	public String toString() {
		return "Bird [id=" +id+ ",color="+colour+" name ="+name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	public void eat() {
		System.out.println(name + "can eat");
	}
	public void fly() {
		System.out.println(name + "can fly");
	}
	public void swim() {
		System.out.println(name + "can swim");
	}
}
