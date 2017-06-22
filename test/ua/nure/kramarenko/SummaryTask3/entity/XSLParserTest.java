package ua.nure.kramarenko.SummaryTask3.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.nure.kramarenko.SummaryTask3.parcer.XSLParser;

public class XSLParserTest {

	@Test
	public void CreateClassTest() {
		XSLParser xslParser = new XSLParser();
		assertNotNull(xslParser);
	}

	@Test
	public void parseNulltest() {
		String outputHtmlFile = "test/output.html";
		String inputXslFile = "input.xsl";
		String inputXmlFile = "";
		XSLParser.parse(inputXmlFile, inputXslFile, outputHtmlFile);
	}

	@Test
	public void parseTest() {
		String outputHtmlFile = "test/output.html";
		String inputXslFile = "input.xsl";
		String inputXmlFile = "input.xml";
		XSLParser.parse(inputXmlFile, inputXslFile, outputHtmlFile);
	}

}
