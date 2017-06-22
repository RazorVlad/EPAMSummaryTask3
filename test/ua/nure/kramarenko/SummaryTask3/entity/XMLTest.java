package ua.nure.kramarenko.SummaryTask3.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class XMLTest {

	@Test
	public void EqualsToTrueTest() {
		String ammo = "ammo";
		assertTrue(XML.AMMO.equalsTo(ammo));
	}

	@Test
	public void EqualsToFalseTest() {
		String notAmmo = "type";
		assertFalse(XML.AMMO.equalsTo(notAmmo));
	}

	@Test
	public void stringValueTest() {
		String ammo = "ammo";
		assertEquals(XML.AMMO.getValue(), ammo);
	}

	@Test
	public void verifyXMLEnumStatics() throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		Class e = getCoffeeTypeEnumUnderTest();
		Method valuesMethod = e.getMethod("values");
		Object[] values = (Object[]) valuesMethod.invoke(null);
		Method valueOfMethod = e.getMethod("valueOf", String.class);
		assertEquals(values[0],
				valueOfMethod.invoke(null, ((Enum) values[0]).name()));
	}

	protected Class getCoffeeTypeEnumUnderTest() {
		return XML.class;
	}

}
