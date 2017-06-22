package ua.nure.kramarenko.SummaryTask3;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.Planes;

public class MainTest {

	@Test
	public void createClassTest() {
		Main main = new Main();
		assertNotNull(main);
	}

	@Test
	public void mainTest() {
		Main.main(new String[] { "input.xml" });

	}

	@Test
	public void mainSaveTest() throws Exception {
		String outputXmlFile = "output.stax.xml";
		Main.save(outputXmlFile, new Planes());
	}

	@Test
	public void mainNullTest() {
		Main.main(new String[] { "" });
	}

	@Test
	public void mainWrongDataTest() {
		Main.main(new String[] { "wrongXmlInputForTest.xml" });
	}

}
