package ua.nure.kramarenko.SummaryTask3.entity;

/**
 * Holds entities declared in XSD document.
 * 
 * @author Vlad Kramarenko
 *
 */
public enum XML {
	// elements names
	PLANES("Planes"),

	PLANE("Plane"),

	MODEL("model"), ORIGIN("origin"), CHARS("chars"),
	// chars elements names
	AMMO("ammo"), PLACES("places"), TYPE("type"), RADAR("radar"),

	PARAMETERS("parameters"),
	// parameters elements names
	WIDTH("width"), HEIGHT("height"), LENGTH("length"),

	PRICE("price"),

	// attribute names
	UNIT("unit"), ROCKET("rocket");
	/**
	 * Enum value
	 */
	private String value;

	/**
	 * Class constructor
	 * 
	 * @param value
	 *            defines enum value
	 */
	XML(String value) {
		this.value = value;
	}

	/**
	 * Compare input string with element value
	 * 
	 * @param name
	 *            string to compare with value.
	 * @return value.equals(name)
	 */
	public boolean equalsTo(String name) {
		return value.equals(name);
	}

	/**
	 * return enum value
	 * 
	 * @return String enum value
	 */
	public String getValue() {
		return value;
	}
}
