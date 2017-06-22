package ua.nure.kramarenko.SummaryTask3.entity.plane;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Parameters;

public class ParametersTest {

	@Test
	public void getUnitTest() {
		Parameters parameters = new Parameters();
		parameters.setUnit("metres");
		String expected = "metres";
		assertEquals(parameters.getUnit(), expected);
	}

	@Test
	public void getLengthTest() {
		Parameters parameters = new Parameters();
		double expected = 100;
		parameters.setPlaneLength(expected);
		assertEquals(parameters.getPlaneLength(), expected,0.0000001);
	}
	
	@Test
	public void getWidthTest() {
		Parameters parameters = new Parameters();
		double expected = 100;
		parameters.setPlaneWidth(expected);
		assertEquals(parameters.getPlaneWidth(), expected,0.0000001);
	}
	
	@Test
	public void getHeightTest() {
		Parameters parameters = new Parameters();
		double expected = 100;
		parameters.setPlaneHeight(expected);
		assertEquals(parameters.getPlaneHeight(), expected,0.0000001);
	}
	
	@Test
	public void toStringTest() {
		
		double height=100;
		double width=150;
		double length=200;
		String unit="metres";
		Parameters parameters = new Parameters(unit,length,width,height);
		String addUnit="(" + unit + ")";
		String expected = "Parameters:\n\tlength\t"+length + addUnit+"\n\twidth\t"+width + addUnit+"\n\theight\t"+height + addUnit;
		assertEquals(parameters.toString(), expected);
	}

}
