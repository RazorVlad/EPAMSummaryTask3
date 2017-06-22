package ua.nure.kramarenko.SummaryTask3.entity.plane;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Ammo;

public class AmmoTest {

	@Test
	public void test() {
		Ammo ammo = new Ammo();
		ammo.setRocket((byte) 1);
		ammo.setValue(true);
		assertEquals((int) ammo.getRocket(), 1);
		assertEquals(ammo.getValue(), true);
	}

	@Test
	public void toStringTrueTest() {
		Ammo ammo = new Ammo(true, (byte) 1);
		String expected = "Ammo:\t1(rocket)";
		assertEquals(ammo.toString(), expected);
	}

	@Test
	public void toStringFalseTest() {
		Ammo ammo = new Ammo(false);
		String expected = "Ammo:\tno ammo";
		assertEquals(ammo.toString(), expected);
	}

	@Test
	public void toStringNullTest() {
		Ammo ammo = new Ammo();
		String expected = "";
		assertEquals(ammo.toString(), expected);
	}

}
