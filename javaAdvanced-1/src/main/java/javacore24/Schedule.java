package javacore24;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	private Set<Seance> seances = new TreeSet<>(new SortByMovieName());

	public Schedule() {
		super();
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public void addSeance(Seance seance) {
		seances.add(seance);
	}

	public void showSeance() {
		System.out.println(seances);
	}

	public void clean() {
		seances.clear();
	}

	public void removeSeance(Seance seanceRemove) {
		seances.remove(seanceRemove);
	}

	public void removeMovie(String removeMovie) {
		showSeance();
		seances.removeIf(run -> run.getTitle().toLowerCase().equals(removeMovie.toLowerCase()));
	}
}

class SortByMovieName implements Comparator<Movie> {

	@Override
	public int compare(Movie movie1, Movie movie2) {
		String nameOne = movie1.getTitle();
		String nameTwo = movie2.getTitle();
		return nameOne.compareTo(nameTwo);
	}

}