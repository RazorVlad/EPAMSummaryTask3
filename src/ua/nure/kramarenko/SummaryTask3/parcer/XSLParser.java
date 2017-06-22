package ua.nure.kramarenko.SummaryTask3.parcer;

import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * This class describes XSL parced functionality
 * 
 * @author Vlad Kramarenko
 *
 */
public class XSLParser {
	/**
	 * Parse XML file to HTML file
	 * 
	 * @param inputXmlFile
	 *            input XML file name
	 * @param inputXslFile
	 *            input XSL file name
	 * @param outputHtmlFile
	 *            output HTML file name
	 */
	public static void parse(String inputXmlFile, String inputXslFile,
			String outputHtmlFile) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory
					.newTransformer(new javax.xml.transform.stream.StreamSource(
							inputXslFile));
			Source xmlSource = new javax.xml.transform.stream.StreamSource(
					inputXmlFile);
			Result outputTarget = new javax.xml.transform.stream.StreamResult(
					new FileOutputStream(outputHtmlFile));
			transformer.transform(xmlSource, outputTarget);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}