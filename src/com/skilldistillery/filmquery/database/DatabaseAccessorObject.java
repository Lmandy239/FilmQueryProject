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
		
		String sql = "SELECT * FROM film WHERE id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PWD);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
		
		}
		// ...
		return film;
	}

	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		// ...

		String sql = "SELECT * FROM actor WHERE id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PWD);

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);

		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
		}
		// ...
		return actor;
	}



	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
