// The Person class has multiple clients, but all of the clients are in 
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Test;

import java.io.*;
import static org.junit.Assert.*;

public class PersonClientsTest {

	@Test
	public void testClients() throws IOException {
		Person bobSmith = new Person("Smith", "Bob", null);
		Person jennyJJones = new Person("Jones", "Jenny", "J");

		StringWriter out = new StringWriter();
		bobSmith.printPerson(out);
		assertEquals("Bob Smith", out.toString());

		out = new StringWriter();
		jennyJJones.printPerson(out);
		assertEquals("Jenny J Jones", out.toString());

		assertEquals("Smith, Bob", bobSmith.formatPerson(bobSmith));
		assertEquals("Jones, Jenny J", jennyJJones.formatPerson(jennyJJones));

		out = new StringWriter();
		bobSmith.display(out, bobSmith);
		assertEquals("Smith, Bob", out.toString());

		out = new StringWriter();
		jennyJJones.display(out, jennyJJones);
		assertEquals("Jones, Jenny J", out.toString());

		assertEquals("Smith, Bob", bobSmith.toString(bobSmith));
		assertEquals("Jones, Jenny J", jennyJJones.toString(jennyJJones));
	}
}
