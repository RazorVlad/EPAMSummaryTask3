package ua.nure.kramarenko.SummaryTask3.parcer;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.kramarenko.SummaryTask3.entity.Planes;
import ua.nure.kramarenko.SummaryTask3.entity.XML;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Ammo;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Chars;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Parameters;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Plane;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Price;

/**
 * This class describes SAX parser functionality
 * 
 * @author Vlad Kramarenko
 *
 */
public class SAXParser extends DefaultHandler {

	private String currElement = "";
	private Planes planes;
	private Plane plane;
	private Chars chars;
	private Parameters parameters;
	private Ammo ammo;
	private Price price;
	private String fileName;

	/**
	 * Class constructor
	 * 
	 * @param fileName
	 *            input xml file name
	 */
	public SAXParser(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema. With
	 *            this parameter it is possible make parser validating.
	 *
	 * @param useNamespace
	 *            If true set nameSpaceAware
	 * @throws ParserConfigurationException
	 * @throws IOException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws SAXException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 */
	public void parse(boolean validate, boolean useNamespace)
			throws ParserConfigurationException, SAXException, IOException {

		// obtain sax parser factory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// XML document contains namespaces
		factory.setNamespaceAware(useNamespace);

		// set validation
		if (validate) {
			factory.setFeature("http://xml.org/sax/features/validation", true);
			factory.setFeature(
					"http://apache.org/xml/features/validation/schema", true);
		}

		javax.xml.parsers.SAXParser parser = factory.newSAXParser();
		parser.parse(fileName, this);
	}

	@Override
	public void startElement(String uri, String elementName, String qName,
			Attributes attributes) throws SAXException {
		currElement = elementName;

		if (XML.PLANES.equalsTo(currElement)) {
			planes = new Planes();
			return;
		}

		if (XML.PLANE.equalsTo(currElement)) {
			plane = new Plane();
			return;
		}

		if (XML.CHARS.equalsTo(currElement)) {
			chars = new Chars();
			return;
		}

		if (XML.AMMO.equalsTo(currElement)) {
			ammo = new Ammo();
			if (attributes.getLength() > 0) {
				ammo.setRocket(Byte.parseByte(attributes.getValue(uri,
						XML.ROCKET.getValue())));
			}
			return;
		}

		if (XML.PARAMETERS.equalsTo(currElement)) {
			parameters = new Parameters();
			if (attributes.getLength() > 0) {
				parameters
						.setUnit(attributes.getValue(uri, XML.UNIT.getValue()));
			}
			return;
		}

		if (XML.PRICE.equalsTo(currElement)) {
			price = new Price();
			if (attributes.getLength() > 0) {
				price.setUnit(attributes.getValue(uri, XML.UNIT.getValue()));
			}
			return;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String elementText = new String(ch, start, length).trim();

		if (elementText.isEmpty()) {
			return;
		}

		if (XML.MODEL.equalsTo(currElement)) {
			plane.setModel(elementText);
			return;
		}

		if (XML.ORIGIN.equalsTo(currElement)) {
			plane.setOrigin(elementText);
			return;
		}

		if (XML.PRICE.equalsTo(currElement)) {
			double priceValue = Double.parseDouble(elementText);
			price.setValue(priceValue);
			return;
		}

		charsCharacter(elementText);
		parametersCharacter(elementText);
	}

	/**
	 * Set Plane Chars data
	 * 
	 * @param elementText
	 *            String text of the element
	 */
	public void charsCharacter(String elementText) {
		if (XML.RADAR.equalsTo(currElement)) {
			boolean radar = Boolean.parseBoolean(elementText);
			chars.setRadar(radar);
			return;
		}

		if (XML.TYPE.equalsTo(currElement)) {
			chars.setType(elementText);
			return;
		}

		if (XML.PLACES.equalsTo(currElement)) {
			byte places = Byte.parseByte(elementText);
			chars.setPlaces(places);
			return;
		}

		if (XML.AMMO.equalsTo(currElement)) {
			boolean ammoValue = Boolean.parseBoolean(elementText);
			if (!ammoValue) {
				ammo.setRocket((byte) 0);
			}
			ammo.setValue(ammoValue);
			return;
		}
	}

	/**
	 * Set Plane parameters data
	 * 
	 * @param elementText
	 *            String text of the element
	 */
	public void parametersCharacter(String elementText) {
		if (XML.LENGTH.equalsTo(currElement)) {
			parameters.setPlaneLength(Double.parseDouble(elementText));
			return;
		}

		if (XML.WIDTH.equalsTo(currElement)) {
			parameters.setPlaneWidth(Double.parseDouble(elementText));
			return;
		}

		if (XML.HEIGHT.equalsTo(currElement)) {
			parameters.setPlaneHeight(Double.parseDouble(elementText));
			return;
		}
	}

	@Override
	public void endElement(String uri, String elementName, String qName)
			throws SAXException {
		if (XML.PLANE.equalsTo(elementName)) {
			planes.add(plane);
			return;
		}

		if (XML.CHARS.equalsTo(elementName)) {
			plane.setChars(chars);
			return;
		}

		if (XML.PARAMETERS.equalsTo(elementName)) {
			plane.setParameters(parameters);
			return;
		}

		if (XML.PRICE.equalsTo(elementName)) {
			plane.setPrice(price);
			return;
		}

		if (XML.AMMO.equalsTo(elementName)) {
			chars.setAmmo(ammo);
			return;
		}
	}

	/**
	 * Return current Planes object
	 * 
	 * @return Planes object
	 */
	public Planes getPlanes() {
		return planes;
	}

	/**
	 * Show the SAX parser functionality
	 * 
	 * @param args
	 *            command line arguments
	 * @throws IOException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws SAXException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws ParserConfigurationException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		String fileName = "";
		if (args.length == 1) {
			fileName = args[0];
		} else {
			fileName = "input.xml";
		}
		SAXParser saxParcer = new SAXParser(fileName);
		boolean validate = true;
		boolean useNamespace = true;
		saxParcer.parse(validate, useNamespace);
		System.out.println(saxParcer.getPlanes());
	}
}
