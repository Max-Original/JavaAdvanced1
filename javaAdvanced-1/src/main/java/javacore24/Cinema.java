package javacore24;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Cinema {

	private TreeMap<Days, Schedule> schedules = new TreeMap<Days, Schedule>();
	private ArrayList<Movie> movieLibrary = new ArrayList<>();
	private Time open = new Time(0, 9);
	private Time close = new Time(0, 24);
	private LocalTime localTime = LocalTime.now();

	public Cinema() throws Exception {
		super();
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(TreeMap<Days, Schedule> schedules) {
		this.schedules = schedules;
	}

	public ArrayList<Movie> getMovieLibrary() {
		return movieLibrary;
	}

	public void setMovieLibrary(ArrayList<Movie> movieLibrary) {
		this.movieLibrary = movieLibrary;
	}

	public Time getOpen() {
		return open;
	}

	public void setOpen(Time open) {
		this.open = open;
	}

	public Time getClose() {
		return close;
	}

	public void setClose(Time close) {
		this.close = close;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}

	public void addMovie(Movie movie) {
		movieLibrary.add(movie);
	}

	public void showMovieLibrary() {
		System.out.println(movieLibrary);
	}

	static Schedule monday = new Schedule();
	static Schedule thuesday = new Schedule();
	static Schedule wednesday = new Schedule();
	static Schedule thursday = new Schedule();
	static Schedule friday = new Schedule();
	static Schedule saturday = new Schedule();
	static Schedule sunday = new Schedule();

	public void addSeance(Seance seance, String day) throws Exception {

		if (localTime.getHour() > open.getHour() && close.getHour() > localTime.getHour()
				&& seance.getEndTime().getHour() < close.getHour()
				&& seance.getStartTime().getHour() > open.getHour() == true) {
			
			if (day.toLowerCase().equals(Days.MONDAY.toString().toLowerCase())) {
				monday.addSeance(seance);
				schedules.put(Days.MONDAY, monday);
			} else if (day.toLowerCase().equals(Days.THUESDAY.toString().toLowerCase())) {
				thuesday.addSeance(seance);
				schedules.put(Days.THUESDAY, thuesday);
			} else if (day.toLowerCase().equals(Days.WEDNESDAY.toString().toLowerCase())) {
				wednesday.addSeance(seance);
				schedules.put(Days.WEDNESDAY, wednesday);
			} else if (day.toLowerCase().equals(Days.THURSDAY.toString().toLowerCase())) {
				thursday.addSeance(seance);
				schedules.put(Days.THURSDAY, thursday);
			} else if (day.toLowerCase().equals(Days.FRIDAY.toString().toLowerCase())) {
				friday.addSeance(seance);
				schedules.put(Days.FRIDAY, friday);
			} else if (day.toLowerCase().equals(Days.SATURDAY.toString().toLowerCase())) {
				saturday.addSeance(seance);
				schedules.put(Days.SATURDAY, saturday);
			} else if (day.toLowerCase().equals(Days.SUNDAY.toString().toLowerCase())) {
				sunday.addSeance(seance);
				schedules.put(Days.SUNDAY, sunday);
			}
		}
		else {
			throw new Exception("wrong time value");
		}
	}

	public void showScedule() {
		for (Map.Entry<Days, Schedule> run : schedules.entrySet()) {
			System.out.print("Key: " + run.getKey() + " Value: ");
			run.getValue().showSeance();
		}
	}

	public void removeMovie(String removeMovie) {
		movieLibrary.removeIf(run -> run.getTitle().toLowerCase().equals(removeMovie.toLowerCase()));

		for (Map.Entry<Days, Schedule> run : schedules.entrySet()) {
			Schedule value = run.getValue();
			value.removeMovie(removeMovie);
		}
	}

	public void clean() {
		schedules.clear();
	}

	public void removeSeance(Seance seanceRemove, String day) {
		for (Map.Entry<Days, Schedule> run : schedules.entrySet()) {
			boolean value = run.getValue().getSeances().contains(seanceRemove);
			String key = run.getKey().toString().toLowerCase();

			if (key.equals(day.toLowerCase())) {
				if (value == true) {
					run.getValue().removeSeance(seanceRemove);
				}
			}
		}
	}

}
