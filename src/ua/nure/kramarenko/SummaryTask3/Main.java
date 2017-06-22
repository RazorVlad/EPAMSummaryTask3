package ua.nure.kramarenko.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ua.nure.kramarenko.SummaryTask3.entity.PlaneSorter;
import ua.nure.kramarenko.SummaryTask3.entity.Planes;
import ua.nure.kramarenko.SummaryTask3.parcer.DOMController;
import ua.nure.kramarenko.SummaryTask3.parcer.DOMSaveController;
import ua.nure.kramarenko.SummaryTask3.parcer.SAXParser;
import ua.nure.kramarenko.SummaryTask3.parcer.StAXParser;
import ua.nure.kramarenko.SummaryTask3.parcer.XSLParser;

/**
 * Main programm class
 * 
 * @author Vlad Kramarenko
 *
 */
public class Main {
	/**
	 * This function show the DOM controller functionality.
	 * 
	 * @param fileName
	 *            name of the inputed XML file
	 * @throws IOException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws SAXException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws ParserConfigurationException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws TransformerException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * 
	 */
	public static void domTask(String fileName)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerException {
		DOMController domController = new DOMController(fileName);
		boolean useNameSpace = true;
		boolean validate = true;
		domController.parce(useNameSpace, validate);
		Planes planes = domController.getPlanes();
		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_LENGTH);

		String outputXmlFile = "output.dom.xml";
		save(outputXmlFile, planes);
	}

	/**
	 * 
	 * @param fileName
	 *            name of the inputed XML file
	 * @throws TransformerException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws ParserConfigurationException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws IOException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws SAXException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 */
	public static void saxTask(String fileName)
			throws ParserConfigurationException, TransformerException,
			SAXException, IOException {
		SAXParser saxController = new SAXParser(fileName);
		boolean useNameSpace = true;
		boolean validate = true;
		saxController.parse(validate, useNameSpace);
		Planes planes = saxController.getPlanes();

		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_ORIGIN);

		String outputXmlFile = "output.sax.xml";
		save(outputXmlFile, planes);
	}

	/**
	 * @param fileName
	 *            name of the inputed XML file
	 * @throws TransformerException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws ParserConfigurationException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws XMLStreamException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 */
	public static void staxTask(String fileName)
			throws ParserConfigurationException, TransformerException,
			XMLStreamException {
		StAXParser staxController = new StAXParser(fileName);
		boolean useNameSpace = true;
		staxController.parse(useNameSpace);
		Planes planes = staxController.getPlanes();
		PlaneSorter.sortPlanes(planes, PlaneSorter.SORT_PLANES_BY_MODEL);

		String outputXmlFile = "output.stax.xml";
		save(outputXmlFile, planes);

	}

	/**
	 * Save output XML file
	 * 
	 * @param outputXmlFile
	 *            String output XML file name
	 * @param planes
	 *            list of Plane
	 * @throws TransformerException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 * @throws ParserConfigurationException
	 *             throws an exception if there are problems with the processing
	 *             of the input data
	 */
	public static void save(String outputXmlFile, Planes planes)
			throws ParserConfigurationException, TransformerException {
		DOMSaveController.saveToXML(planes, outputXmlFile);
		System.out.println("Output:\t" + outputXmlFile);
	}

	/**
	 * Convert XML file to HTML file with xsl file
	 * 
	 * @param outputHTMLFile
	 *            String output HTML file name
	 */
	public static void xslTask(String outputHTMLFile) {
		String outputHtmlFile = "output.html";
		String inputXslFile = "input.xsl";
		XSLParser.parse(outputHTMLFile, inputXslFile, outputHtmlFile);
		System.out.println("Output:\t" + outputHtmlFile);
	}

	/**
	 * Main class method. Start program.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		if (args.length != 1 || args[0].length() == 0) {
			System.out.println("incorrect command line arguments");
		} else {
			String xmlFileName = args[0];
			System.out.println("Input:\t" + xmlFileName);
			try {
				saxTask(xmlFileName);
				staxTask(xmlFileName);
				domTask(xmlFileName);
				xslTask(xmlFileName);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			xmlFileName = "input.xml";
		}
	}
}
