package ua.nure.kramarenko.SummaryTask3.parcer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DOMControllerTest {

	@Test
	public void DOMSaveControllerCreateClassTest() {
		DOMSaveController dom = new DOMSaveController();
		assertNotNull(dom);
	}

	@Test
	public void DOMControllerCreateClassTest() {
		DOMController dom = new DOMController("");
		assertNotNull(dom);
	}

	@Test
	public void DOMControllerTest() throws Exception {
		DOMController.main(new String[] { "input.xml" });
	}

	@Test
	public void DOMControllerNullTest() throws Exception {
		DOMController.main(new String[] {});
	}

	@Test
	public void SAXControllerWrongTest() throws Exception {
		DOMController.main(new String[] { "test/wrongInputTest.xml" });
	}
}
