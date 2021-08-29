package com.birdsanctuary;

import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Main {

	viewlayer view = new viewlayer();
	BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();

	public static void main(String[] args) {
		Main main = new Main();
		main.showUserMenu();
		// TODO Auto-generated method stub
		/*
		 * Parrot parrot1 = new Parrot(); parrot1.id="00p1"; Duck duck1 = new Duck();
		 * duck1.id="00d1"; Ostrich ostrich1 = new Ostrich(); ostrich1.id="001"; Penguin
		 * penguin1 = new Penguin(); penguin1.id="pn001"; Penguin penguin2 = new
		 * Penguin(); penguin2.id="pn002";
		 * 
		 * BirdSanctuaryRepository birdsanctuaryrepository = new
		 * BirdSanctuaryRepository(); birdsanctuaryrepository.add(duck1);
		 * birdsanctuaryrepository.add(parrot1); birdsanctuaryrepository.add(ostrich1);
		 * birdsanctuaryrepository.add(penguin1); birdsanctuaryrepository.add(penguin2);
		 * 
		 * birdsanctuaryrepository.print();
		 * 
		 * birdsanctuaryrepository.remove(penguin1);
		 * 
		 * birdsanctuaryrepository.print();
		 */
	}

	void showUserMenu() {
		int option = 0;
		final int EXIT_VALUE = 8;

		;
		while (option != EXIT_VALUE) {
			System.out.println("enter your option");
			System.out.println(
					"\n 1.add a bird\n 2.remove\n 3.print \n4.print fly \n5.print swim\n 6.print eat\n 7.edit bird 8.quit");

			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();

			switch (option) {
			case 1:

				addTemporaryBird();
				addBird();

				/*
				 * Parrot parrot1 = new Parrot(); parrot1.id = "00p1"; Duck duck1 = new Duck();
				 * duck1.id = "00d1"; Ostrich ostrich1 = new Ostrich(); ostrich1.id = "001";
				 * Penguin penguin1 = new Penguin(); penguin1.id = "pn001"; Penguin penguin2 =
				 * new Penguin(); penguin2.id = "pn001";
				 * 
				 * 
				 * birdsanctuaryrepository.add(duck1); birdsanctuaryrepository.add(parrot1);
				 * birdsanctuaryrepository.add(ostrich1); birdsanctuaryrepository.add(penguin1);
				 * birdsanctuaryrepository.add(penguin2);
				 */

				break;

			case 2:

				System.out.println("enter the bird to be removed");

				String birdname = sc.next();

				Bird removebird = birdsanctuaryrepository.getBird(birdname);
				birdsanctuaryrepository.remove(removebird);

				break;

			case 3:
				view.print();

				break;

			case 4:

				view.printflyable();
				break;

			case 5:
				view.printswimable();

				break;

			case 6:
				view.printeatble();

				break;

			case 7:
				editBird();

				break;
			}
		}

	}

	private void editBird() {

		System.out.println("enter the bird to be edited");
		Scanner sc = new Scanner(System.in);
		String birdname = sc.next();

		Bird editBird = BirdSanctuaryRepository.getInstance().getBird(birdname);
		while (true) {
			System.out.println("edit \n 1.BIRDNAME \n2.EDIT ID \n3. EDIT COLOR\n 4.exit");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("enter the new name");
				sc.nextLine();
				String birdNewName = sc.nextLine();
				editBird.name = birdNewName;

				break;

			case 2:
				System.out.println("enter the new id");
				sc.nextLine();
				String id = sc.nextLine();
				editBird.id = id;

				break;

			case 3:
				System.out.println("enter new color");
				System.out.println("enter the choice");

				int count = 1;
				for (Bird.Colour colour : EnumSet.allOf(Bird.Colour.class)) {
					System.out.println(+count + " " + colour);
					count++;
				}

				int colorchoice = sc.nextInt();
				int count1 = 1;
				for (Bird.Colour colour : EnumSet.allOf(Bird.Colour.class)) {
					if (colorchoice == count1) {
						editBird.colour = colour;
						break;
					}
					count1++;
				}

				break;
			case 4:
				return;
			}
		}
	}

	private void addTemporaryBird() {
		Bird duck = new Bird();
		duck.id = "du001";
		duck.name = "Duck";
		duck.colour = Bird.Colour.GREY;
		duck.canFly = false;
		duck.canSwim = true;
		BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
		birdSanctuaryRepository.add(duck);

		Bird ostrich = new Bird();
		ostrich.id = "os001";
		ostrich.name = "Ostrich";
		ostrich.colour = Bird.Colour.WHITE;
		ostrich.canFly = false;
		ostrich.canSwim = false;
		birdSanctuaryRepository.add(ostrich);

		Bird parrot = new Bird();
		parrot.id = "pa001";
		parrot.name = "Parrot";
		parrot.colour = Bird.Colour.GREEN;
		parrot.canFly = true;
		parrot.canSwim = false;
		birdSanctuaryRepository.add(parrot);

		Bird crow = new Bird();
		crow.id = "cr001";
		crow.name = "Crow";
		crow.colour = Bird.Colour.BLACK;
		crow.canFly = true;
		crow.canSwim = false;
		birdSanctuaryRepository.add(crow);
	}

	private void addBird() {
		Scanner scanner = new Scanner(System.in);
		Bird addBird = new Bird();
		System.out.println("Enter the ID");
		String id = scanner.nextLine();
		addBird.id = id;
		System.out.println("Enter the Name");
		String name = scanner.nextLine();
		addBird.name = name;
		System.out.println("Enter the Color");
		int count = 1;

		for (Bird.Colour color : EnumSet.allOf(Bird.Colour.class)) {
			System.out.println(count + " " + color);
			count++;
		}
		int choice2 = scanner.nextInt();

		int count1 = 1;

		for (Bird.Colour color : EnumSet.allOf(Bird.Colour.class)) {
			if (choice2 == count1) {
				addBird.colour = color;
				break;
			}
			count1++;
		}
		System.out.println("Can the Bird Fly?");
		Boolean canFly = scanner.nextBoolean();
		addBird.canFly = canFly;
		System.out.println("Can the Bird Swim?");
		Boolean canSwim = scanner.nextBoolean();
		addBird.canSwim = canSwim;
		BirdSanctuaryRepository.getInstance().add(addBird);
	}
}
