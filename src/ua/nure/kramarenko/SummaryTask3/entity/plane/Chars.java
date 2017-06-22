package ua.nure.kramarenko.SummaryTask3.entity.plane;

/**
 * This class describes chars of the plane
 * 
 * @author Vlad Kramarenko
 *
 */
public class Chars {
	/**
	 * Plane type
	 */
	private String type = "";
	/**
	 * Place quantity
	 */
	private Byte places;
	/**
	 * Ammo value
	 */
	private Ammo ammo;
	/**
	 * Presence of a radar
	 */
	private Boolean radar;

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public Byte getPlaces() {
		return places;
	}

	public void setPlaces(Byte value) {
		this.places = value;
	}

	public Ammo getAmmo() {
		return ammo;
	}

	public void setAmmo(Ammo value) {
		this.ammo = value;
	}

	public Boolean getRadar() {
		return radar;
	}

	public void setRadar(Boolean value) {
		this.radar = value;
	}

	/**
	 * Override toString() method to determine text output of the
	 * plane chars
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Chars:");
		if (!type.isEmpty()) {
			result.append("\n\tType:\t" + type);
		}
		if (places != null) {
			result.append("\n\tPlaces:\t" + places);
		}
		if (ammo != null) {
			result.append("\n\t" + ammo.toString());
		}
		if (radar != null) {
			result.append("\n\tRadar:\t" + radar);
		}
		return result.toString();
	}
}