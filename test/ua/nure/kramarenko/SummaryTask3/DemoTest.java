package ua.nure.kramarenko.SummaryTask3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest {

	@Test
	public void createClassTest() {
		Demo demo = new Demo();
		assertNotNull(demo);
	}

	@Test
	public void mainTest() {
		try {
			Demo.main(new String[] { "" });

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
