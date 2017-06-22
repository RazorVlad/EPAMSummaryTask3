package ua.nure.kramarenko.SummaryTask3.entity.plane;

/**
 * This class describes plane price entity
 * 
 * @author Vlad Kramarenko
 *
 */
public class Price {
	/**
	 * Plane price value
	 */
	private double value;
	/**
	 * Units of measurement
	 */
	private String unit;

	/**
	 * Empty class constructor
	 */
	public Price() {

	}

	/**
	 * Class constructor
	 * 
	 * @param value
	 *            Plane price value
	 * @param unit
	 *            Units of measurement
	 */
	public Price(double value, String unit) {
		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String value) {
		this.unit = value;
	}

	/**
	 * Override toString() method to determine text output of the plane price
	 */
	@Override
	public String toString() {
		if (value != 0) {
			return "Price:\t" + value + "(" + unit + ")";
		} else {
			return "";
		}
	}
}
