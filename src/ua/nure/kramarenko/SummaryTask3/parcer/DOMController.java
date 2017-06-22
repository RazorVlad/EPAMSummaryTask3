package ua.nure.kramarenko.SummaryTask3.parcer;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ua.nure.kramarenko.SummaryTask3.entity.Planes;
import ua.nure.kramarenko.SummaryTask3.entity.XML;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Ammo;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Chars;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Parameters;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Plane;
import ua.nure.kramarenko.SummaryTask3.entity.plane.Price;

/**
 * This class describes DOM controller functionality
 * 
 * @author Vlad Kramarenko
 *
 */
public class DOMController {
	/**
	 * XML document
	 */
	private Document doc = null;
	/**
	 * List with planes
	 */
	private Planes planes = null;
	/**
	 * Input XML file name
	 */
	private String fileName;

	/**
	 * Class constructor
	 * 
	 * @param fileName
	 *            input XML file name
	 */
	public DOMController(String fileName) {
		this.fileName = fileName;

	}

	/**
	 * Start XMl file parsing and create Planes object from it/
	 * 
	 * @param useNameSpace
	 *            Need for use NameSpace
	 * @param validate
	 *            Need for data validation
	 * @throws IOException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws SAXException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws ParserConfigurationException
	 *             Throws an exception if there are problems with parsing input
	 *             data
	 */
	public void parce(boolean useNameSpace, boolean validate)
			throws ParserConfigurationException, SAXException, IOException {
		doc = parserXML(new File(fileName), useNameSpace, validate);
		planes = createPlanes(doc);
	}

	/**
	 * Return Planes object from the parsed XML document
	 * 
	 * @param doc
	 *            Parsed XML document
	 * @return Planes object
	 */
	public Planes createPlanes(Document doc) {
		Element root = doc.getDocumentElement();

		Planes newPlanes = new Planes();

		NodeList planeNodes = root.getElementsByTagName(XML.PLANE.getValue());

		for (int j = 0; j < planeNodes.getLength(); j++) {
			Plane plane = getPlane(planeNodes.item(j));
			newPlanes.add(plane);
		}

		return newPlanes;
	}

	/**
	 * Return Plane object from the XML Plane node
	 * 
	 * @param planeNode
	 *            XML plane node
	 * @return Plane object from XML node
	 */
	public Plane getPlane(Node planeNode) {
		Plane plane = new Plane();
		Element planeElement = (Element) planeNode;

		Node modelNode = planeElement
				.getElementsByTagName(XML.MODEL.getValue()).item(0);
		plane.setModel(modelNode.getTextContent());

		Node originNode = planeElement.getElementsByTagName(
				XML.ORIGIN.getValue()).item(0);
		plane.setOrigin(originNode.getTextContent());

		Node charsNode = planeElement
				.getElementsByTagName(XML.CHARS.getValue()).item(0);
		plane.setChars(getChars(charsNode));

		Node parametersNode = planeElement.getElementsByTagName(
				XML.PARAMETERS.getValue()).item(0);
		plane.setParameters(getParameters(parametersNode));

		Node priceNode = planeElement
				.getElementsByTagName(XML.PRICE.getValue()).item(0);
		plane.setPrice(getPrice(priceNode));

		return plane;
	}

	/**
	 * Return Plane price from the XML price node
	 * 
	 * @param priceNode
	 *            XML price node
	 * @return Price object from the XML node
	 */
	public Price getPrice(Node priceNode) {
		Element priceElement = (Element) priceNode;
		Price price = new Price();
		price.setValue(Double.parseDouble(priceElement.getTextContent()));
		price.setUnit(priceElement.getAttribute(XML.UNIT.getValue()));
		return price;
	}

	/**
	 * Return Plane chars from the XML chars node
	 * 
	 * @param charsNode
	 *            XML chars node
	 * @return Chars object from the XML node
	 */
	public Chars getChars(Node charsNode) {
		Element charsElement = (Element) charsNode;
		Chars chars = new Chars();

		Node ammoNode = charsElement.getElementsByTagName(XML.AMMO.getValue())
				.item(0);
		chars.setAmmo(getAmmo(ammoNode));

		Node placesNode = charsElement.getElementsByTagName(
				XML.PLACES.getValue()).item(0);
		chars.setPlaces(Byte.parseByte(placesNode.getTextContent()));

		Node radarNode = charsElement
				.getElementsByTagName(XML.RADAR.getValue()).item(0);
		chars.setRadar(Boolean.parseBoolean(radarNode.getTextContent()));

		Node typeNode = charsElement.getElementsByTagName(XML.TYPE.getValue())
				.item(0);
		chars.setType(typeNode.getTextContent());

		return chars;
	}

	/**
	 * Return Plane ammo from the XML ammo node
	 * 
	 * @param ammoNode
	 *            XML ammo node
	 * @return Ammo object from the XML node
	 */
	public Ammo getAmmo(Node ammoNode) {
		Element ammoElement = (Element) ammoNode;
		Ammo ammo = new Ammo();

		Boolean isAmmo = Boolean.parseBoolean(ammoElement.getTextContent());
		ammo.setValue(isAmmo);
		if (isAmmo) {
			Byte rocket = Byte.parseByte(ammoElement.getAttribute(XML.ROCKET
					.getValue()));
			ammo.setRocket(rocket);
		} else {
			ammo.setRocket((byte) 0);
		}
		return ammo;
	}

	/**
	 * Return Plane parameters object from the XML parameters node
	 * 
	 * @param parametersNode
	 *            XML parameters node
	 * @return Parameters object from the XML node
	 */
	public Parameters getParameters(Node parametersNode) {
		Element parametersElement = (Element) parametersNode;
		Parameters parameters = new Parameters();

		Node heightNode = parametersElement.getElementsByTagName(
				XML.HEIGHT.getValue()).item(0);
		double height = Double.parseDouble(heightNode.getTextContent());
		parameters.setPlaneHeight(height);

		Node lengthNode = parametersElement.getElementsByTagName(
				XML.LENGTH.getValue()).item(0);
		double length = Double.parseDouble(lengthNode.getTextContent());
		parameters.setPlaneLength(length);

		Node widthNode = parametersElement.getElementsByTagName(
				XML.WIDTH.getValue()).item(0);
		double width = Double.parseDouble(widthNode.getTextContent());
		parameters.setPlaneWidth(width);

		parameters.setUnit(parametersElement.getAttribute(XML.UNIT.getValue()));
		return parameters;
	}

	/**
	 * 
	 * @param file
	 *            XML file
	 * @param useNameSpace
	 *            Need for use NameSpace
	 * @param validate
	 *            Need for data validation
	 * @return parsed XML document
	 * @throws ParserConfigurationException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws IOException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws SAXException
	 *             Throws an exception if there are problems with the processing
	 *             of the input data
	 */
	public Document parserXML(File file, boolean useNameSpace, boolean validate)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(useNameSpace);
		if (validate) {
			// turn validation on
			dbf.setFeature("http://xml.org/sax/features/validation", true);

			// turn on xsd validation
			dbf.setFeature("http://apache.org/xml/features/validation/schema",
					true);
		}
		return dbf.newDocumentBuilder().parse(file);
	}

	/**
	 * Return parsed List of Plane
	 * 
	 * @return List of PLane objects
	 */
	public Planes getPlanes() {
		return planes;
	}

	/**
	 * Show the DOM controller functionality
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

		DOMController xpars = new DOMController(fileName);
		boolean validate = true;
		boolean useNameSpace = true;
		xpars.parce(validate, useNameSpace);
		System.out.println(xpars.getPlanes());
	}
}
