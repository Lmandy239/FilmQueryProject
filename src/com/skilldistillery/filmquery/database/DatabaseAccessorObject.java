package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String USER = "student";
	private static final String PWD = "student";

	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;

		String sql = "SELECT film.*, language.id, language.name FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PWD);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film();
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setRating(filmResult.getString("rating"));
			film.setDescription(filmResult.getString("description"));
			film.setLanguage(filmResult.getString("language.name"));

			
		}

		filmResult.close();
		stmt.close();
		conn.close();

		return film;
	}

	public List<Actor> findListOfActorsByFilmId(int filmId) throws SQLException {
		List<Actor> actors = new ArrayList<>();

		String sql = "SELECT actor.*, film.*\n" + "FROM actor\n" + "JOIN film_actor fa ON actor.id = fa.actor_id\n"
				+ "JOIN film ON film.id = fa.film_id WHERE film.id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PWD);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet actorResult = stmt.executeQuery();

		while (actorResult.next()) {
			Actor actor = new Actor();
			actor = new Actor();
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));

			actors.add(actor);

		}
		// ...

		actorResult.close();
		stmt.close();
		conn.close();

		return actors;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmKeyword) throws SQLException {

		List<Film> films = new ArrayList<>();

		String sql = "SELECT film.*, language.id, language.name FROM film JOIN language ON film.language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
		Connection conn = DriverManager.getConnection(URL, USER, PWD);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + filmKeyword + "%");
		stmt.setString(2, "%" + filmKeyword + "%");

		ResultSet filmResult = stmt.executeQuery();

		while (filmResult.next()) {
			Film film = new Film();
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setRating(filmResult.getString("rating"));
			film.setDescription(filmResult.getString("description"));
			film.setLanguage(filmResult.getString("language.name"));

			films.add(film);

		}

		filmResult.close();
		stmt.close();
		conn.close();

		return films;
	}

//
//	@Override
//	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
