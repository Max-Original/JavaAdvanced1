package javacore24;

public class Movie extends Time {

	protected String title;
	private Time duration;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Movie(int min, int hour, String title) throws Exception {
		super(min, hour);
		this.title = title;
		this.duration = new Time(min, hour);
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + " duration= " + duration + "]";
	}

}
