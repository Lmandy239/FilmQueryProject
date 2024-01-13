package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//  private void test() throws SQLException {
//    List<Actor> actor = db.findActorById(0);
//   for (Actor actor2 : actor) {
//	System.out.println(actor);
//}
//  }

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		int choice;
		System.out.println("\n" + "Hello what would you like to do?: ");
		System.out.println("1. Look up Film by Id");
		System.out.println("2. Look up film by search keyword");
		System.out.println("3. Exit Application");
		System.out.println("Enter the number of your choice:");
		choice = input.nextInt();
		input.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Please enter film id:\n");
			choice = input.nextInt();
			input.nextLine();
			Film film = db.findFilmById(choice);
			List<Actor> listActors = db.findListOfActorsByFilmId(choice);
			if (film == null) {
				System.out.println("No film found, please try again!");
			} else {
				System.out.println("Your film is: " + film + "\n");
				System.out.println("Actors who worked in this move: ");
				displayActors(listActors);
			}
			subMenu(input);
			break;

		case 2:

			String answer;
			System.out.println("Please enter keyword: ");
			answer = input.next();

			List<Film> filmKeyword = db.findFilmByKeyword(answer);
			List<Actor> listActors2 = db.findListOfActorsByFilmId(choice);

			if (filmKeyword.isEmpty()) {
				System.out.println("No films found, please try again!");
			} else {
				System.out.println("Your film(s) is/are: " + filmKeyword + "\n");
				System.out.println("Actors who worked in this film: ");

				displayActors(listActors2);

			}
			subMenu(input);
			break;

		case 3:

			System.out.println("Goodbye!!!");

			break;

		default:
			System.out.println("");
			System.out.println("Wrong option going back to menu!\n");
			startUserInterface(input);
		}

	}

	public void displayActors(List<Actor> actors) {

		for (Actor actor : actors) {
			System.out.println(actor);
		}

	}

	public void subMenu(Scanner input) throws SQLException {
		int choice;
		System.out.println("1. Return to Main menu");
		System.out.println("2. Display all details");
		choice = input.nextInt();
		input.nextLine();

		switch (choice) {
		case 1:
			startUserInterface(input);
			break;
		case 2:
			System.out.println("displaying info... beep beep");
			break;
		default:
			System.out.println("");
			System.out.println("Wrong option, try again\n");
			subMenu(input);
			;
		}

	}
}
