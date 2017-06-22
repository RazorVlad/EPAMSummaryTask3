package ua.nure.kramarenko.SummaryTask3.entity.plane;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.entity.plane.Ammo;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Chars;

public class CharsTest {

	@Test
	public void getAmmoValueTest() {
		Chars chars = new Chars();
		chars.setAmmo(new Ammo());
		assertEquals(chars.getAmmo().getValue(), null);
	}

	@Test
	public void getPlacesValueTest() {
		Chars chars = new Chars();
		chars.setPlaces((byte) 1);
		assertEquals((int) chars.getPlaces(), 1);
	}

	@Test
	public void getRadarValueTest() {
		Chars chars = new Chars();
		chars.setRadar(true);
		assertEquals(chars.getRadar(), true);
	}

	@Test
	public void getTypeValueTest() {
		Chars chars = new Chars();
		chars.setType("Fighter");
		assertEquals(chars.getType(), "Fighter");
	}

	@Test
	public void toStringTest() {
		Chars chars = new Chars();
		chars.setAmmo(new Ammo());
		Byte places=1;
		chars.setPlaces(places);
		boolean radar=true;
		chars.setRadar(radar);
		String type="Fighter";
		chars.setType(type);
		String expected = new String("Chars:\n\tType:\t" + type+"\n\tPlaces:\t" + places+"\n\t" +""+"\n\tRadar:\t" + radar);
		assertEquals(chars.toString(),expected);
	}
	
	@Test
	public void toStringNullRadarTest() {
		Chars chars = new Chars();
		chars.setAmmo(new Ammo());
		Byte places=1;
		chars.setPlaces(places);
		String type="Fighter";
		chars.setType(type);
		String expected = new String("Chars:\n\tType:\t" + type+"\n\tPlaces:\t" + places+"\n\t" +"");
		assertEquals(chars.toString(),expected);
	}
	
	@Test
	public void toStringBullAmmoTest() {
		Chars chars = new Chars();
		Byte places=1;
		chars.setPlaces(places);
		boolean radar=true;
		chars.setRadar(radar);
		String type="Fighter";
		chars.setType(type);
		String expected = new String("Chars:\n\tType:\t" + type+"\n\tPlaces:\t" + places +"\n\tRadar:\t" + radar);
		assertEquals(chars.toString(),expected);
	}
	
	@Test
	public void toStringNullTypeTest() {
		Chars chars = new Chars();
		chars.setAmmo(new Ammo());
		Byte places=1;
		chars.setPlaces(places);
		boolean radar=true;
		chars.setRadar(radar);
		String expected = new String("Chars:"+"\n\tPlaces:\t" + places+"\n\t" +""+"\n\tRadar:\t" + radar);
		assertEquals(chars.toString(),expected);
	}
	

	@Test
	public void toStringNullPlacesTest() {
		Chars chars = new Chars();
		chars.setAmmo(new Ammo());
		boolean radar=true;
		chars.setRadar(radar);
		String type="Fighter";
		chars.setType(type);
		String expected = new String("Chars:\n\tType:\t" + type+"\n\t" +""+"\n\tRadar:\t" + radar);
		assertEquals(chars.toString(),expected);
	}

}
