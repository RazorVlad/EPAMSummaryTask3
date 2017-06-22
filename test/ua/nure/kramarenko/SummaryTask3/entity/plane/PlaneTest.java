package ua.nure.kramarenko.SummaryTask3.entity.plane;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Ammo;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Chars;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Parameters;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Plane;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Price;

public class PlaneTest {

	@Test
	public void getModelTest() {
		Plane plane = new Plane();
		String model = "qw-123";
		plane.setModel(model);
		assertEquals(plane.getModel(), model);
	}

	@Test
	public void getOriginTest() {
		Plane plane = new Plane();
		String origin = "UA";
		plane.setOrigin(origin);
		assertEquals(plane.getOrigin(), origin);
	}

	@Test
	public void getParametersTest() {
		Plane plane = new Plane();
		Parameters parameters = new Parameters("metres", 100, 150, 200);
		plane.setParameters(parameters);
		assertEquals(plane.getParameters(), parameters);
	}

	@Test
	public void getPriceTest() {
		Plane plane = new Plane();
		Price price = new Price(100, "taller");
		plane.setPrice(price);
		assertEquals(plane.getPrice(), price);
	}

	@Test
	public void getCharsTest() {
		Plane plane = new Plane();
		Chars chars = new Chars();
		chars.setPlaces((byte) 2);
		chars.setRadar(true);
		plane.setChars(chars);
		assertEquals(plane.getChars(), chars);
	}

	@Test
	public void toStringTest() {
		Plane plane = new Plane();
		Chars chars = new Chars();
		chars.setPlaces((byte) 2);
		chars.setRadar(true);
		Ammo ammo = new Ammo(false);
		chars.setAmmo(ammo);
		chars.setType("Fighter");
		plane.setChars(chars);
		Price price = new Price(100, "taller");
		plane.setPrice(price);
		Parameters parameters = new Parameters("metres", 100, 150, 200);
		plane.setParameters(parameters);
		String origin = "UA";
		plane.setOrigin(origin);
		String model = "qw-123";
		plane.setModel(model);
		String expected = "Model:\t" + model + "\nOrigin:\t" + origin + "\n"
				+ price.toString() + "\n" + chars.toString() + "\n"
				+ parameters.toString();
		assertEquals(plane.toString(), expected);
	}

}
