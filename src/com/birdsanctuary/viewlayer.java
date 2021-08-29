package com.birdsanctuary;

public class viewlayer {

	public void print() {
		BirdSanctuaryRepository birdSanctuaryRepository =BirdSanctuaryRepository.getInstance();
		for(Bird items:birdSanctuaryRepository.getAllBirds()) {
			System.out.println(items);
		}
	}
	
	public void printflyable() {
		BirdSanctuaryRepository birdSanctuaryRepository =BirdSanctuaryRepository.getInstance();
		for(Bird items:birdSanctuaryRepository.getAllBirds()) {
			if(items.canFly) {
				items.fly();
			}
			
		}
	}
	
	public void printswimable() {
		BirdSanctuaryRepository birdSanctuaryRepository =BirdSanctuaryRepository.getInstance();
		for(Bird items:birdSanctuaryRepository.getAllBirds()) {
			if(items.canSwim) {
				items.swim();
			}
		}	
	}
	
	public void printeatble() {
		BirdSanctuaryRepository birdSanctuaryRepository =BirdSanctuaryRepository.getInstance();
		for(Bird items:birdSanctuaryRepository.getAllBirds()) {
			
				items.eat();
			
		}
	}

}
