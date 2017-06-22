package ua.nure.kramarenko.SummaryTask3.entity.plane;

/**
 * This class describes ammo characteristics of the plane
 * 
 * @author Vlad Kramarenko
 *
 */
public class Ammo {
	/**
	 * Boolean value describes has plane ammo or not
	 */
	private Boolean value;
	/**
	 * Describes how many rockets has the plane
	 */
	private Byte rocket;

	/**
	 * Empty class constructor
	 */
	public Ammo() {

	}

	/**
	 * Class constructor
	 * 
	 * @param value
	 *            Boolean ammo describes has plane ammo or not
	 * @param rocket
	 *            Rockets count
	 */
	public Ammo(Boolean value, byte rocket) {
		this.value = value;
		this.rocket = rocket;
	}

	/**
	 * Class constructor
	 * 
	 * @param value
	 *            Boolean ammo describes has plane ammo or not
	 */
	public Ammo(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Byte getRocket() {
		return rocket;
	}

	public void setRocket(Byte value) {
		this.rocket = value;
	}

	/**
	 * Override toString() method to determine text output of the ammo
	 */
	@Override
	public String toString() {
		if (value != null) {
			if (value) {
				return "Ammo:\t" + rocket + "(rocket)";
			} else {
				return "Ammo:\tno ammo";
			}
		} else {
			return "";
		}
	}

}