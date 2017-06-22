package ua.nure.kramarenko.SummaryTask3.parcer;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.parcer.StAXParser;

public class StAXParcerTest {

	@Test
	public void StAXControllerCreateClassTest() {
		StAXParser stax = new StAXParser("");
		assertNotNull(stax);
	}

	@Test
	public void StAXControllerTest() throws Exception {
		StAXParser.main(new String[] { "input.xml" });
	}

	@Test(expected = javax.xml.stream.XMLStreamException.class)
	public void StAXControllerEmptyTest() throws Exception {
		StAXParser.main(new String[] { "" });
	}

	@Test
	public void StAXControllerNullTest() throws Exception {
		StAXParser.main(new String[] {});
	}
}
