package ua.nure.kramarenko.SummaryTask3.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Chars;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Parameters;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Plane;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Price;

public class PlanesTest {

	@Test
	public void getPlaneTest() {
		Planes planes = new Planes();
		Plane plane = new Plane();
		planes.add(plane);
		assertEquals(planes.getPlane(0), plane);
	}

	@Test
	public void getPlanesTest() {
		Planes planes = new Planes();
		ArrayList<Plane> expected = new ArrayList<Plane>();
		Plane plane = new Plane();
		planes.add(plane);
		expected.add(plane);
		assertEquals(planes.getPlanes(), expected);
	}

	@Test
	public void setPlaneTest() {
		Planes planes = new Planes();
		Plane plane1 = new Plane();
		plane1.setModel("qwe-123");
		Plane plane2 = new Plane();
		plane2.setModel("qwerty-123");
		Plane plane3 = new Plane();
		plane1.setModel("qwe-12345");
		planes.add(plane1);
		planes.add(plane2);
		planes.setPlane(0, plane3);
		Plane expected = plane3;
		assertEquals(planes.getPlane(0), expected);
	}

	@Test
	public void toStringTest() {
		Planes planes = new Planes();
		Plane plane1 = new Plane();
		plane1.setModel("qwe-123");
		plane1.setOrigin("UA");
		plane1.setPrice(new Price(100, "taller"));
		plane1.setChars(new Chars());
		plane1.setParameters(new Parameters("metres", 123, 1000, 10000));
		Plane plane2 = new Plane();
		plane2.setModel("qwerty-123");
		plane2.setOrigin("UK");
		plane2.setPrice(new Price(1000, "taller"));
		plane2.setChars(new Chars());
		plane2.setParameters(new Parameters("metres", 1, 10, 10));
		Plane plane3 = new Plane();
		plane3.setModel("qwe-12345");
		plane3.setOrigin("US");
		plane3.setPrice(new Price(10000, "taller"));
		plane3.setChars(new Chars());
		plane3.setParameters(new Parameters("metres", 12, 100, 1000));
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
		String expected = plane1 + "\n\n" + plane2 + "\n\n" + plane3 + "\n\n";
		assertEquals(planes.toString(), expected);
	}

	@Test
	public void toStringNullTest() {
		Planes planes = new Planes();
		Plane plane = new Plane();
		planes.add(plane);
		String expected = "planes not found";
		assertEquals(planes.toString(), expected);
	}

	@Test
	public void planesSizeTest() {
		Planes planes = new Planes();
		Plane plane = new Plane();
		planes.add(plane);
		int expected = 1;
		assertEquals(planes.size(), expected);
	}

}
