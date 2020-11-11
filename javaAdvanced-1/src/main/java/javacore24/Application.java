package javacore24;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws Exception {

		Cinema cinema = new Cinema();

		while (true) {
			menu();

			Scanner scanner = new Scanner(System.in);
			switch (scanner.next()) {
			case "1":
				System.out.println("enter movie min");
				scanner = new Scanner(System.in);
				int min = scanner.nextInt();
				System.out.println("enter movie hour");
				scanner = new Scanner(System.in);
				int hour = scanner.nextInt();
				System.out.println("enter movie name");
				scanner = new Scanner(System.in);
				String title = scanner.next();
				Movie movie = new Movie(min, hour, title);
				cinema.addMovie(movie);
				break;

			case "2":
				System.out.println("enter movie min");
				scanner = new Scanner(System.in);
				int min2 = scanner.nextInt();
				System.out.println("enter movie hour");
				scanner = new Scanner(System.in);
				int hour2 = scanner.nextInt();
				System.out.println("enter movie name");
				scanner = new Scanner(System.in);
				String title2 = scanner.next();
				System.out.println("enter movie start min");
				scanner = new Scanner(System.in);
				int startsMovieMin = scanner.nextInt();
				System.out.println("enter movie start hour");
				scanner = new Scanner(System.in);
				int startsMovieHour = scanner.nextInt();
				Seance seance = new Seance(min2, hour2, title2, startsMovieMin, startsMovieHour);
				System.out.println("enter day");
				scanner = new Scanner(System.in);
				String day = scanner.next();
				cinema.addSeance(seance, day);
				break;

			case "3":
				System.out.println("enter movie name");
				scanner = new Scanner(System.in);
				String removeMovie = scanner.next();
				cinema.removeMovie(removeMovie);
				break;
			case "4":
				cinema.clean();
				break;
			case "5":
				cinema.showScedule();
				break;
			case "6":
				System.exit(0);
				break;
			}
		}

	}

	public static void menu() {
		System.out.println("press 1 to addMovie");
		System.out.println("press 2 to addSeance");
		System.out.println("press 3 to removeMovie");
		System.out.println("press 4 to clearAllSchedule");
		System.out.println("press 5 to show Schedule");
		System.out.println("press 6 to Exit the program");
	}
}
