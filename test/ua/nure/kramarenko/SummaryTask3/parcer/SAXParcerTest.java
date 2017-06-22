package ua.nure.kramarenko.SummaryTask3.parcer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SAXParcerTest {

	@Test
	public void SAXControllerCreateClassTest() {
		SAXParser sax = new SAXParser("");
		assertNotNull(sax);
	}

	@Test
	public void SAXControllerTest() throws Exception {
		SAXParser.main(new String[] { "input.xml" });
	}

	@Test
	public void SAXControllerNullTest() throws Exception {
		SAXParser.main(new String[] {});
	}

	@Test
	public void SAXControllerWrongTest() throws Exception {
		SAXParser.main(new String[] { "test/wrongInputTest.xml" });
	}

}
