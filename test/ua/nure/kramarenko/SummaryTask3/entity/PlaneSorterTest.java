package ua.nure.kramarenko.SummaryTask3.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Chars;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Parameters;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Plane;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Price;

public class PlaneSorterTest {

	public Plane createPlane1(){
		Plane plane = new Plane();
		plane.setModel("qwe-123");
		plane.setOrigin("UA");
		plane.setPrice(new Price(100, "taller"));
		plane.setChars(new Chars());
		plane.setParameters(new Parameters("metres", 123, 1000, 10000));
		return plane;
	}
	
	public Plane createPlane2(){
		Plane plane = new Plane();
		plane.setModel("qwerty-123");
		plane.setOrigin("UK");
		plane.setPrice(new Price(1000, "taller"));
		plane.setChars(new Chars());
		plane.setParameters(new Parameters("metres", 1, 10, 10));
		return plane;
	}
	
	public Plane createPlane3(){
		Plane plane = new Plane();
		plane.setModel("qwe-12345");
		plane.setOrigin("US");
		plane.setPrice(new Price(10000, "taller"));
		plane.setChars(new Chars());
		plane.setParameters(new Parameters("metres", 12, 100, 1000));
		return plane;
	}
	
	@Test
	public void lengthSortTest() {
		Planes planes = new Planes();
		Plane plane1=createPlane1();
		Plane plane2=createPlane2();
		Plane plane3=createPlane3();
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_LENGTH);
		assertEquals(planes.getPlane(0), plane2);
		assertEquals(planes.getPlane(1), plane3);
		assertEquals(planes.getPlane(2), plane1);
	}
	
	@Test
	public void modelSortTest() {
		Planes planes = new Planes();
		Plane plane1=createPlane1();
		Plane plane2=createPlane2();
		Plane plane3=createPlane3();
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_MODEL);
		assertEquals(planes.getPlane(0), plane1);
		assertEquals(planes.getPlane(1), plane3);
		assertEquals(planes.getPlane(2), plane2);
	}
	
	@Test
	public void originSortTest() {
		Planes planes = new Planes();
		Plane plane1=createPlane1();
		Plane plane2=createPlane2();
		Plane plane3=createPlane3();
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_ORIGIN);
		assertEquals(planes.getPlane(0), plane1);
		assertEquals(planes.getPlane(1), plane2);
		assertEquals(planes.getPlane(2), plane3);
	}
	
	@Test
	public void priceSortTest() {
		Planes planes = new Planes();
		Plane plane1=createPlane1();
		Plane plane2=createPlane2();
		Plane plane3=createPlane3();
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_PRICE);
		assertEquals(planes.getPlane(0), plane1);
		assertEquals(planes.getPlane(1), plane2);
		assertEquals(planes.getPlane(2), plane3);
	}
	
	@Test
	public void createClassTest(){
		PlaneSorter ps=new PlaneSorter();
		assertNotNull(ps);
	}

}
