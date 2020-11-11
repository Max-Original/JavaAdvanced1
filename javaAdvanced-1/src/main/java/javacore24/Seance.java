package javacore24;

public class Seance extends Movie {

	private Movie movie;
	private Time startTime;
	private Time endTime;

	public Seance(int min, int hour, String title, int startsMovieMin, int startsMovieHour) throws Exception {
		super(min, hour, title);
		this.movie = new Movie(min, hour, title);
		this.startTime = new Time(startsMovieMin, startsMovieHour);
		this.endTime = new Time(startsMovieMin + min, startsMovieHour+ hour);
	}

	public Time getEndTime() {
		return endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Seance [movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
