import org.junit.Test;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
//test were calling tests: changed some test to helper methods
public class ConfigurationTest{

	@Test
	public void testGoodInput() throws IOException {
		String data = "interval = 10\nduration = 100\ndeparture = 200\n";

		Properties input = loadInput(data);

		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			fail();
			return;
		}

		assertEquals(props.interval, 10);
		assertEquals(props.duration, 100);
		assertEquals(props.departure, 200);
	}
	@Test
	public void testNegativeValues() throws IOException {
		assertTrue(processBadInput("interval = -10\nduration = 100\ndeparture = 200\n"));
		assertTrue(processBadInput("interval = 10\nduration = -100\ndeparture = 200\n"));
		assertTrue(processBadInput("interval = 10\nduration = 100\ndeparture = -200\n"));
	}
	@Test
	public void testInvalidDuration() throws IOException {
		assertTrue(processBadInput("interval = 10\nduration = 99\ndeparture = 200\n"));
	}
	@Test
	public void testInvalidDeparture() throws IOException {
		assertTrue(processBadInput("interval = 10\nduration = 100\ndeparture = 199\n"));
	}
//	@Test
	private boolean processBadInput(String data) throws IOException {
		Properties input = loadInput(data);

		boolean failed = false;
		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			failed = true;
		}
		return failed;
//		assertTrue(failed);
	}
//	@Test
	private Properties loadInput(String data) throws IOException {
		InputStream is = new StringBufferInputStream(data);

		Properties input = new Properties();
		input.load(is);
		is.close();

		return input;
	}
}
