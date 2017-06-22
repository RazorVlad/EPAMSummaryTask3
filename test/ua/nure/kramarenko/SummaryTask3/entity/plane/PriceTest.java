package ua.nure.kramarenko.SummaryTask3.entity.plane;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Price;

public class PriceTest {

	@Test
	public void getValueTest() {
		Price price=new Price();
		double value=100;
		price.setValue(value);
		assertEquals(price.getValue(),value,0.00001);
	}
	
	@Test
	public void getUnitTest() {
		Price price=new Price();
		String unit="taller";
		price.setUnit(unit);
		assertEquals(price.getUnit(),unit);
	}
	
	@Test
	public void toStringTest(){
		double value=100;
		String unit="metres";
		Price price =new Price(value,unit);
		String expected="Price:\t" + value + "("+unit+")";
		assertEquals(price.toString(),expected);
	}
	
	@Test
	public void toStringNullTest(){
		Price price =new Price();
		String expected="";
		assertEquals(price.toString(),expected);
	}

}
