package javacore24;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {

	private Schedule schedule;

	public TestWatcher testWatcher = new TestWatcher() {

		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Failed -->" + description.getMethodName());
		};

		protected void successful(org.junit.runner.Description description) {
			System.out.println("successful" + description.getMethodName());
		};

	};

	@Before
	public void beforeTest() {
		schedule = new Schedule();
	}

	@After
	public void afterTest() {
		schedule = null;
	}

	@Test
	public void addSeanceTest() throws Exception {

		Seance seancess = new Seance(10, 2, "Name", 0, 1);

		schedule.addSeance(seancess);

		Iterator<Seance> iterator = schedule.getSeances().iterator();

		while (iterator.hasNext()) {
			Seance seance = (Seance) iterator.next();
			boolean equals = seance.equals(seancess);

			Assert.assertTrue(equals);
		}
	}

	@Test
	public void removeSeanceTest() throws Exception {

		Seance seancess = new Seance(10, 2, "Name", 0, 1);

		schedule.addSeance(seancess);

		schedule.removeSeance(seancess);

		Iterator<Seance> iterator = schedule.getSeances().iterator();

		while (iterator.hasNext()) {
			Seance seance = (Seance) iterator.next();
			boolean equals = seance.equals(seancess);

			Assert.assertFalse(equals);
		}

	}
}
