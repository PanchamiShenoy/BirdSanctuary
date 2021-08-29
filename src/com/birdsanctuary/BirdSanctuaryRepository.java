package com.birdsanctuary;

import  java.util.Set;
import java.util.HashSet;

public class BirdSanctuaryRepository {

	Set<Bird> birdlist=new HashSet<>();
	private static BirdSanctuaryRepository instance;
	private BirdSanctuaryRepository() {
		
	}
	
	static synchronized BirdSanctuaryRepository getInstance() {
	if(instance==null) {
		instance=new BirdSanctuaryRepository();
	}
		return instance;
	}
	
	public void add(Bird b) {
		birdlist.add(b);
	}
	
	public void print() {
		for(Object items: birdlist) {
			System.out.println(items);
		}
	}
	
	public void remove(Bird bird) {
		birdlist.remove(bird);
	}
	
	public Bird getBird(String name) {
		for(Bird b:birdlist) {
			if(b.name.equals(name)) {
				return b;
			}
			
		}
		return null;
	}
	
	public Set<Bird> getAllBirds() {
		return birdlist;
	}
}
