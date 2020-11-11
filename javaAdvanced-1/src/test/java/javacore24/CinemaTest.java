package javacore24;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {

	private Cinema cinema;

	public TestWatcher testWatcher = new TestWatcher() {

		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Failed -->" + description.getMethodName());
		};

		protected void successful(org.junit.runner.Description description) {
			System.out.println("successful" + description.getMethodName());
		};

	};

	@Before
	public void beforeTest() throws Exception {
		cinema = new Cinema();
	}

	@After
	public void afterTest() {
		cinema = null;
	}

	@Test
	public void addMovieTest() throws Exception {

		Movie movie = new Movie(0, 2, "Name");

		cinema.addMovie(movie);

		Iterator<Movie> iterator = cinema.getMovieLibrary().iterator();

		while (iterator.hasNext()) {
			Movie movieIt = (Movie) iterator.next();
			boolean equals = movieIt.equals(movie);
			Assert.assertTrue(equals);
		}
	}
	
	@Test
	public void removeMovieTest() throws Exception {
		
		Movie movie = new Movie(0, 2, "Name");

		cinema.addMovie(movie);
		
		cinema.removeMovie("Name");
		
		Iterator<Movie> iterator = cinema.getMovieLibrary().iterator();
		
		while (iterator.hasNext()) {
			String movieIt = (String) iterator.next().getTitle();
			boolean equals = movieIt.equals(movie.getTitle());
			
			Assert.assertFalse(equals);
		}
		
		
	}
	
	
}
