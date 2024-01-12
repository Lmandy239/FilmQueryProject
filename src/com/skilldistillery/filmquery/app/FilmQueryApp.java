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
//    Film film = db.findFilmById(48);
//    System.out.println(film);
//
//  }

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);
		
		startUserInterface(input);
		
		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		int choice;
		System.out.println("Hello what would you like to do?: ");
		System.out.println("Choose your next move!");
		System.out.println("1. Look up Film by Id");
		System.out.println("2. Look up film by search keyword");
		System.out.println("3. Exit Application");
		System.out.println("Enter the number of your choice:");
		choice = input.nextInt();
		
		switch(choice){
		case 1:			
			System.out.println("Please enter film id:\n");
			choice = input.nextInt();
			Film film = db.findFilmById(choice);
			System.out.println("Your film is:\n" + film);
			break;
		case 2:
			System.out.println("stub");
			break;
		case 3:
			System.out.println("Goodbye!!!");
			break;
		default:
			System.out.println("Wrong option going back to menu!\n");
			startUserInterface(input);
		}
//		System.out.println("Please enter actor id:\n");
//		choice = input.nextInt();
//		Actor actor = db.findActorById(choice);
//
//		System.out.println("Your actor is:\n" + actor);
//
//		System.out.println("");


	}
	
	

}
