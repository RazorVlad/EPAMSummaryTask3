package ua.nure.kramarenko.SummaryTask3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nure.kramarenko.SummaryTask3.entity.PlaneSorterTest;
import ua.nure.kramarenko.SummaryTask3.entity.PlanesTest;
import ua.nure.kramarenko.SummaryTask3.entity.XMLTest;
import ua.nure.kramarenko.SummaryTask3.entity.XSLParserTest;
import ua.nure.kramarenko.SummaryTask3.entity.plane.AmmoTest;
import ua.nure.kramarenko.SummaryTask3.entity.plane.CharsTest;
import ua.nure.kramarenko.SummaryTask3.entity.plane.ParametersTest;
import ua.nure.kramarenko.SummaryTask3.entity.plane.PlaneTest;
import ua.nure.kramarenko.SummaryTask3.entity.plane.PriceTest;
import ua.nure.kramarenko.SummaryTask3.parcer.DOMControllerTest;
import ua.nure.kramarenko.SummaryTask3.parcer.SAXParcerTest;
import ua.nure.kramarenko.SummaryTask3.parcer.StAXParcerTest;

@RunWith(Suite.class)
@SuiteClasses({ DemoTest.class, MainTest.class, DOMControllerTest.class,
		SAXParcerTest.class, StAXParcerTest.class, XMLTest.class,
		PlanesTest.class, PlaneSorterTest.class, PlaneTest.class,
		PriceTest.class, ParametersTest.class, CharsTest.class, AmmoTest.class,
		XSLParserTest.class })
public class AllTests {

}
